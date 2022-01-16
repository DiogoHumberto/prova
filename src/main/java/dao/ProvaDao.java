package dao;

import java.util.List;

import bean.Prova;

public interface ProvaDao {
	
	public void addProva (Prova prova) throws Exception;
	
	public Prova getObjectById (Object id) throws Exception;
	
	public Prova getProva(Prova prova) throws Exception;
	
	public void setProva(Prova prova) throws Exception;
	
	public void removerProva(Prova prova) throws Exception;
		
	public List<Prova> getProvas() throws Exception;
	
}
