package br.edu.inf011.aval3.visitor;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

//QUESTÃO 2 - CONCRETE VISITOR em um VISITOR
public class VisitorPontuar implements Visitor {

	@Override
	public Object visitarCartaoCredito(CartaoCredito cartao) {
		Visitor visitor = new VisitorValidar();
		return (boolean) cartao.aceitar(visitor) ? 2 : 0;
	}

	@Override
	public Object visitarCpf(CPF cpf) {
		return 3;
	}

	@Override
	public Object visitarEmail(EMail email) {
		Visitor visitor = new VisitorValidar();
		return (boolean) email.aceitar(visitor) ? 1 : 0;
	}

	@Override
	public Object visitarRg(RG rg) {
		Visitor visitor = new VisitorValidar();
		return (boolean) rg.aceitar(visitor) ? 1 : 0;
	}

}
