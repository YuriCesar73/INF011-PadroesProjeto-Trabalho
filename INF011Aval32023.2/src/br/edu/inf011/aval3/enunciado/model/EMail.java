package br.edu.inf011.aval3.enunciado.model;

import java.util.regex.Pattern;

import br.edu.inf011.aval3.visitor.Visitor;


//QUESTÃO 2 - CONCRETE ELEMENT em um VISITOR
public class EMail implements Documento{
	
	public static final String REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"; 
	
	public String conta;
	
	public EMail(String conta) {
		super();
		this.conta = conta;
	}


	public static String getRegex() {
		return REGEX;
	}

	public String getConta() {
		return conta;
	}

	@Override
	public Object aceitar(Visitor visitor) {
		return visitor.visitarEmail(this);
	}
	
}
