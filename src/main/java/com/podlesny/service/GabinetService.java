package com.podlesny.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.podlesny.domain.Gabinet;
import com.podlesny.repository.BadanieRepository;
import com.podlesny.repository.GabinetRepository;

@Stateless
public class GabinetService {
	
	@EJB
	GabinetRepository gabinetRepository;
	@EJB
	BadanieRepository badanieRepository;
	
	
	public void add(Gabinet object) {
		if (!gabinetRepository.isExistGabinetWithLekarz(object.getLekarz()))
		{
			gabinetRepository.add(object);
		}
	}

	public void update(Gabinet object) {
		gabinetRepository.update(object);
	}
	
	public void delete(long id) {
		gabinetRepository.delete(id);
	}

	public List<Gabinet> getAll() {
		return gabinetRepository.getAll();
	}

	public Gabinet getById(long id) {
		return gabinetRepository.getById(id);
	}
	
	public Gabinet getByLekarz(String lekarz) {
		return gabinetRepository.getByLekarz(lekarz);
	}
	
	public List<Gabinet> getByBadanie(long id)
	{
	return gabinetRepository.getByBadanie(id);
	}

}
