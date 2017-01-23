package com.podlesny.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.podlesny.domain.Badanie;
import com.podlesny.repository.BadanieRepository;

@Stateless
public class BadanieService {
	
	@EJB
	BadanieRepository badanieRepository;

	
	public void add(Badanie object) {
		if(!badanieRepository.isExistBadanieWithNazwa(object.getNazwa()))
			badanieRepository.add(object);
	}
	
	public void update(Badanie object) {
		badanieRepository.update(object);
	}

	
	public void delete(long id) {
		badanieRepository.delete(id);
	}

	public List<Badanie> getAll() {
		return badanieRepository.getAll();
	}

	public Badanie getById(long id) {
		return badanieRepository.getById(id);
	}
	
	public Badanie getByNazwa(String nazwa)
	{
		return badanieRepository.getByNazwa(nazwa);
	}
	
}
