package com.agt.mantenimientosuperheroes.service.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The {@link SuperHero} class represents the table and records of the superheroes table.
 * @author AGT96
 */
@Entity
@Table(name = "superheroes")
public final class SuperHero extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "powers", nullable = false)
	private String powers;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "Comics")
	private Integer comics;
	
	/**
	 * Creates a new {@link SuperHero} instance.
	 */
	public SuperHero() {}
	
	/**
	 * Creates a new {@link SuperHero} instance with a id, name, powers
	 * company and comics.
	 * @param id the id of this entity, can be null to auto generate it.
	 * @param name the name of the {@link SuperHero}.
	 * @param powers the powers of the {@link SuperHero}
	 * @param company the company of the {@link SuperHero}.
	 * @param comics if the {@link SuperHero} have comics. Can be 1 (true) or false (0).
	 */
	public SuperHero(Integer id, String name, String powers, String company, Integer comics) {
		super();
		this.id = id;
		this.name = name;
		this.powers = powers;
		this.company = company;
		this.comics = comics;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getComics() {
		return comics;
	}

	public void setComics(Integer comics) {
		this.comics = comics;
	}

	@Override
	public String toString() {
		return "SuperHero: name = " + name + ", powers = " + powers + ", company = " + company + ", comics = " + comics;
	}
}
