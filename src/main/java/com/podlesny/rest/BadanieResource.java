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

import com.podlesny.domain.Badanie;
import com.podlesny.service.BadanieService;

@Stateless
@Path("/badanie")
public class BadanieResource {
	
	@EJB
	BadanieService badanieService;
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Badanie> getBadanie() {
		return badanieService.getAll();
	}
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Badanie add(
			@FormParam("nazwa") String nazwa,
			@FormParam("opis") String opis,
			@FormParam("koszt") String koszt
			){

		Badanie badanie = new Badanie();
		badanie.setNazwa(nazwa);
		badanie.setOpis(opis);
		badanie.setKoszt(koszt);
		badanieService.add(badanie);

		return badanie;
	}

	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Badanie edit(@PathParam("id") long id,
			@FormParam("nazwa") String nazwa,
			@FormParam("opis") String opis,
			@FormParam("koszt") String koszt
			){

		Badanie badanie = badanieService.getById(id);
		badanie.setNazwa(nazwa);
		badanie.setOpis(opis);
		badanie.setKoszt(koszt);
		badanieService.update(badanie);

		return badanie;
	}
	
	@GET
	@Path("/view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Badanie view(
			@PathParam("id") long id){

		return badanieService.getById(id);
	}
	
	
	@GET
	@Path("/name/{nazwa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Badanie viewByNazwa(
			@PathParam("nazwa") String nazwa){

		return badanieService.getByNazwa(nazwa);
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(
			@PathParam("id") long id){

		badanieService.delete(id);
	}
	
}
