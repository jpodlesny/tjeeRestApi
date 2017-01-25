package com.podlesny.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gabinet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String numer;
	private String pietro;
	@Column(unique=true, nullable=false)
	private String lekarz;
	
	@ManyToOne
	Badanie badanie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getPietro() {
		return pietro;
	}

	public void setPietro(String pietro) {
		this.pietro = pietro;
	}

	public String getLekarz() {
		return lekarz;
	}

	public void setLekarz(String lekarz) {
		this.lekarz = lekarz;
	}

	public Badanie getBadanie() {
		return badanie;
	}

	public void setBadanie(Badanie badanie) {
		this.badanie = badanie;
	}
	
	
	
	
}
