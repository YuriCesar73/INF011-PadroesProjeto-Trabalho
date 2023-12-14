package br.edu.inf011.aval3.proxy;

import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.enunciado.model.service.Classificador;
import br.edu.inf011.aval3.enunciado.model.service.ClassificadorPerfil;
import br.edu.inf011.aval3.enunciado.model.service.NivelPerfil;


//QUESTÃO 3 - PROXY em um PROXY
public class ClassificadorPerfilProxy implements Classificador {
	private ClassificadorPerfil classificadorPerfil;
	private String user;
	private String password;
	
	
	public ClassificadorPerfilProxy(ClassificadorPerfil classificadorPerfil, String user, String password) {
		this.classificadorPerfil = classificadorPerfil;
		this.user = user;
		this.password = password;
	}

	@Override
	public NivelPerfil nivel() {
		if(this.validar(this.user, this.password)) {
			return this.classificadorPerfil.nivel();
		}
		
		return NivelPerfil.DESCONHECIDO;
	}

	@Override
	public Perfil getPerfil() {
		return this.classificadorPerfil.getPerfil();
	}
	
	private boolean validar(String user, String password) {
		if(!(classificadorPerfil.getPerfil().getUser().equals(user)) || !(classificadorPerfil.getPerfil().getPwd().equals(password))) {
			return false;
		}
		return true;
	}

}
