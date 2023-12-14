package br.edu.inf011.aval3.builder;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.RG;


//QUESTÃO 1 - BUILDER em um BUILDER
public interface Builder {
	public void reset();
	public void addCartaoCredito(CartaoCredito cartao);
	public void addCpf(CPF cpf);
	public void addEmail(EMail email);
	public void addRg(RG rg);
}
