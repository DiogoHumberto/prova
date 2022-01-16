package dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.Prova;
import dao.ProvaDao;

@Stateless
public class ProvaDaoImpl implements ProvaDao {
	
	@PersistenceContext(unitName = "ProvaPU")
	protected EntityManager em;
	

	public ProvaDaoImpl () {
		
	}
	
	public EntityManager getEm() {
		return em;
	}
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void addProva(Prova prova) throws Exception {
		em.merge(prova);
		
	}
	
	public Prova getObjectById(Object id) throws Exception {
		return em.find(Prova.class, id);
		
	}
	
	public Prova getProva(Prova prova) throws Exception{
		
		return em.find(Prova.class, prova);
	}
	
	@Override
	public void setProva(Prova prova) throws Exception {
		em.merge(prova);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prova> getProvas() {
		String jpql = "from "+ Prova.class.getName();		
		return em.createQuery(jpql).getResultList();
	}
	
	@Override
	public void removerProva(Prova prova) throws Exception {
		em.merge(prova);
		em.remove(em.getReference(Prova.class, prova.getId()));
		
	}
	
	


}
