package br.edu.inf011.aval3.visitor;

import java.time.LocalDate;
import java.util.regex.Pattern;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;



//QUESTÃO 2 - CONCRETE VISITOR em um VISITOR
public class VisitorValidar implements Visitor {

	@Override
	public Object visitarCartaoCredito(CartaoCredito cartao) {
		cartao.numero.replace(" ", "");
		return cartao.verificaLuhn() && cartao.vencimento.isAfter(LocalDate.now());
	}

	@Override
	public Object visitarCpf(CPF cpf) {
		cpf.numero.replace(".", "");
		cpf.numero.replace("-", "");
		return cpf.numeroValido();
	}

	@Override
	public Object visitarEmail(EMail email) {
	    return Pattern.compile(EMail.REGEX)
	    	      .matcher(email.conta)
	    	      .matches();
	}

	@Override
	public Object visitarRg(RG rg) {
		return rg.validade.isAfter(LocalDate.now());
	}

}
