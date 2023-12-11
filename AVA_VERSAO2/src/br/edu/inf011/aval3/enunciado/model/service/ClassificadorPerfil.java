package br.edu.inf011.aval3.enunciado.model.service;

import java.util.Iterator;

import br.edu.inf011.aval3.enunciado.model.CPF;
import br.edu.inf011.aval3.enunciado.model.CartaoCredito;
import br.edu.inf011.aval3.enunciado.model.Documento;
import br.edu.inf011.aval3.enunciado.model.Perfil;
import br.edu.inf011.aval3.visitor.VisitorPontuar;
import br.edu.inf011.aval3.visitor.VisitorValidar;


public class ClassificadorPerfil implements Classificador{
	
	private Perfil perfil;
	
	public ClassificadorPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	public NivelPerfil nivel(String user, String password) {
		boolean hasCPF = false;
		Integer qtdeCC = 0;
		Integer pontuacao = perfil.documentos()
				                  .filter(doc->doc.validar(new VisitorValidar()))
				                  .mapToInt(doc->doc.pontuar(new VisitorPontuar()))
				                  .sum();
		Iterator<Documento> docs = perfil.documentos().iterator();
		while(docs.hasNext()) {
			Documento doc = docs.next();
			if(doc.getClass().equals(CPF.class))
				hasCPF = true;
			else if(doc.getClass().equals(CartaoCredito.class))
				qtdeCC++;
		}
		
		if(hasCPF && pontuacao >= 5)
			return NivelPerfil.OURO;
		else if(qtdeCC >= 1 && pontuacao >=5)			
			return NivelPerfil.PRATA;
		else if(pontuacao >=3)
			return NivelPerfil.BRONZE;
		return NivelPerfil.NAO_VERIFICADO;
	}




	@Override
	public Perfil getPerfil() {
		return this.perfil ;
	}
	
	

}
