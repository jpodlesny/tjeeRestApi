package com.podlesny.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.podlesny.domain.Gabinet;


@Stateless
public class GabinetRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public void add(Gabinet object) {
		entityManager.persist(object);
		entityManager.flush();
	}
	
	public void update(Gabinet object) {
		entityManager.merge(object);
	}
	
	
	public void delete(long id) {
		entityManager.remove(entityManager.find(Gabinet.class, id));
	}

	@SuppressWarnings("unchecked")
	public List<Gabinet> getAll() {
		Query query = entityManager.createQuery("SELECT g FROM Gabinet g");
		List<Gabinet> websites = query.getResultList();
		return websites;
	}
	
	public Gabinet getById(long id) {
		return entityManager.find(Gabinet.class, id);
	}
	
	public Gabinet getByLekarz(String lekarz) {
		return (Gabinet) entityManager.createQuery("SELECT g FROM Gabinet g WHERE g.lekarz = :lekarz")
				.setParameter("lekarz", lekarz).getSingleResult();
	}
	
	public List<Gabinet> getByBadanie(long id){
		
		List<Gabinet> listByBadanie = new ArrayList<Gabinet>();
		List<Gabinet> list = getAll();
		
		for(Gabinet gabinet:list){
			if(gabinet.getBadanie().getId() == id)
			listByBadanie.add(gabinet);
		}
		
		return listByBadanie;
	
	}
	
	public boolean isExistGabinetWithLekarz(String lekarz) {
		int result = Integer.parseInt(entityManager.createQuery("SELECT COUNT(w.id) FROM Gabinet g where g.lekarz=:lekarz")
				.setParameter("lekarz", lekarz).getResultList().get(0).toString());
		if (result != 0)
			return true;

		return false;
	}
	
}
