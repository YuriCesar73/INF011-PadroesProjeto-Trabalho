package br.edu.inf011.aval3.enunciado.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.inf011.aval3.visitor.Visitor;


//QUESTÃO 2 - CONCRETE ELEMENT em um VISITOR
public class CartaoCredito implements Documento{
	public String nome;
	public String numero;	
	public String cvc;
	public LocalDate vencimento;
	
	public CartaoCredito(String nome, String numero, String cvc, LocalDate vencimento) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.cvc = cvc;
		this.vencimento = vencimento;
	}
	
	public CartaoCredito(String nome, String numero, String cvc, String vencimento) {
		this(nome, numero, cvc, LocalDate.parse(vencimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}	
		
	public boolean verificaLuhn() {
		int sum = 0;
		boolean shouldDouble = false;
		for (int iCont = this.numero.length() - 1; iCont >= 0; iCont--) {
			int digit = this.numero.charAt(iCont) - '0';
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }
		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		  return (sum % 10) == 0;		
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getCvc() {
		return cvc;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	@Override
	public Object aceitar(Visitor visitor) {
		return visitor.visitarCartaoCredito(this);
	}
	
}

