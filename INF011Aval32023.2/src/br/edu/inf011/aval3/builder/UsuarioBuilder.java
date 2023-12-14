package br.edu.inf011.aval3.builder;

import java.util.LinkedList;
import java.util.List;

import br.edu.inf011.aval3.builder.exception.NomeInvalidoException;
import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.Documento;
import br.edu.inf011.aval3.enunciado.model.EMail;
import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.RG;

//QUESTÃO 1 - CONCRETE BUILDER em um BUILDER
public class UsuarioBuilder implements Builder{
	
	
	private Integer qtdeCartao;
	private Integer qtdeCpf;
	private Integer qtdeEmail;
	private Integer qtdeRg;
	
	private String nome;
	private String user;
	private String pwd;
	private List<Documento> documentos;
	
	public UsuarioBuilder() {
		this.documentos = new LinkedList<Documento>();
		this.init();
	}
		
	private void init() {
		this.qtdeCartao = 0;
		this.qtdeCpf = 0;
		this.qtdeEmail = 0;
		this.qtdeRg = 0;
	}
	
	
	@Override
	public void reset() {
		this.qtdeCartao = 0;
		this.qtdeCpf = 0;
		this.qtdeEmail = 0;
		this.qtdeRg = 0;
		this.nome = null;
		this.pwd = null;
		this.user = null;
		this.documentos = new LinkedList<Documento>(); 
	}

	@Override
	public void addCartaoCredito(CartaoCredito cartao) {
		if(this.qtdeCartao < 3)
			this.documentos.add(cartao);
			this.qtdeCartao++;
	}

	@Override
	public void addCpf(CPF cpf) {
		if(this.qtdeCpf < 1)
			this.documentos.add(cpf);
			this.qtdeCpf++;
	}

	@Override
	public void addEmail(EMail email) {
		if(this.qtdeEmail < 2)
			this.documentos.add(email);
			this.qtdeEmail++;
	}

	@Override
	public void addRg(RG rg) {
		if(this.qtdeRg < 1)
			this.documentos.add(rg);
			this.qtdeRg++;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String pwd) {
		this.pwd = pwd;
	}

	
	public Perfil get() throws NomeInvalidoException {
		if(this.nome == null) {
			throw new NomeInvalidoException();
		}
		
		this.pwd = (this.pwd == null) ? this.nome : this.pwd;
		this.user = (this.user == null) ? this.nome : this.user;
		
		return new Perfil(this.nome, this.user, this.pwd, this.documentos);
	}
}
