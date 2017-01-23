package com.podlesny.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.podlesny.domain.Badanie;

@Stateless
public class BadanieRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void add(Badanie object) {
		if(!isExistBadanieWithNazwa(object.getNazwa())){
		entityManager.persist(object);
		entityManager.flush();
		}
		else
		{
			System.out.println("Taki obiekt już istnieje.");
		}

	}
	
	
	public void update(Badanie object) {
		entityManager.merge(object);

	}

	
	public void delete(long id) {
		entityManager.remove(entityManager.find(Badanie.class, id));

	}
	
	@SuppressWarnings("unchecked")
	public List<Badanie> getAll() {
		Query query = entityManager.createQuery("SELECT b FROM Badanie b");
		List<Badanie> categories = query.getResultList();
		return categories;
	}

	public Badanie getById(long id) {

		return entityManager.find(Badanie.class, id);
	}
	
	public Badanie getByNazwa(String nazwa) {

		return (Badanie) entityManager.createQuery("SELECT b FROM Badanie b WHERE b.nazwa = :nazwa")
				.setParameter("nazwa", nazwa).getSingleResult();
	}
	
	public boolean isExistBadanieWithNazwa(String nazwa) {
		
		int result = Integer.parseInt(entityManager.createQuery("SELECT COUNT(b.id) FROM Badanie b where b.nazwa=:nazwa").setParameter("nazwa", nazwa).getResultList().get(0).toString());
		
		if(result==0)
			return false;
		
		return true;
	}
	
	
	
}
