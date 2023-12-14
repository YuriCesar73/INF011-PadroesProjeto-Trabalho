package br.edu.inf011.aval3.visitor;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;

//QUESTÃO 2 - VISITOR em um VISITOR	
public interface Visitor {
	
	public Object visitarCartaoCredito(CartaoCredito cartao);
	public Object visitarCpf(CPF cpf);
	public Object visitarEmail(EMail email);
	public Object visitarRg(RG rg);
}
