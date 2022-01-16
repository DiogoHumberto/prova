package service;

import java.util.List;

import bean.Prova;

public interface ProvaService {
	
	public abstract void addProva(Prova prova) throws Exception;
	
	public void removerProva(Prova prova) throws Exception;
	
	public Prova getObjectById (Object id) throws Exception;
	
	public List<Prova> getProvas() throws Exception;
	
	public String mediaNotas(List<Prova> provas) throws Exception;
	
	public String maiorNota(List<Prova> provas) throws Exception;
	
	public String menorNota(List<Prova> provas) throws Exception;	
	
	

}
