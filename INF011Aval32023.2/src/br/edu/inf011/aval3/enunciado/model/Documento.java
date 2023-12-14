package br.edu.inf011.aval3.enunciado.model;

import br.edu.inf011.aval3.visitor.Visitor;


//QUESTÃO 2 - ELEMENT em um VISITOR
public interface Documento {	
	public Object aceitar(Visitor visitor);
}
