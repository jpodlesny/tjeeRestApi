package com.podlesny.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.podlesny.domain.Gabinet;
import com.podlesny.service.BadanieService;
import com.podlesny.service.GabinetService;

@Stateless
@Path("/gabinet")
public class GabinetResource {

	@EJB
	GabinetService gabinetService;
	@EJB
	BadanieService badanieService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gabinet> getType() {
		return gabinetService.getAll();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Gabinet add(@FormParam("numer") String numer,
			@FormParam("pietro") String pietro,
			@FormParam("lekarz") String lekarz,
			@FormParam("badanie_id") int badanieId
			){
		
		Gabinet gabinet = new Gabinet();
		gabinet.setNumer(numer);
		gabinet.setPietro(pietro);
		gabinet.setLekarz(lekarz);
		gabinet.setBadanie(badanieService.getById(badanieId));
		gabinetService.add(gabinet);

		return gabinet;

	}
	
	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gabinet edit(@PathParam("id") long id,
			@FormParam("numer") String numer2,
			@FormParam("pietro") String pietro2,
			@FormParam("lekarz") String lekarz2,
			@FormParam("badanie_id") int badanieId2
			){
		
		Gabinet gabinet = gabinetService.getById(id);
		gabinet.setNumer(numer2);
		gabinet.setPietro(pietro2);
		gabinet.setLekarz(lekarz2);
		gabinet.setBadanie(badanieService.getById(badanieId2));
		gabinetService.update(gabinet);

		return gabinet;

	}
	
	
	@GET
	@Path("/view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gabinet view(
			@PathParam("id") long id){

		return gabinetService.getById(id);
	}
	
	
	@GET
	@Path("/lekarz/{lekarz}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gabinet viewByLekarz(
			@PathParam("lekarz") String lekarz){

		return gabinetService.getByLekarz(lekarz);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(
			@PathParam("id") long id){

		gabinetService.delete(id);
	}
	
	@GET
	@Path("/all/{badanie}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gabinet> getAllByBadanie(
			@PathParam("badanie") int id){
		
		return gabinetService.getByBadanie(id);
	}
}
