package com.agt.mantenimientosuperheroes.data.dto;

import com.agt.mantenimientosuperheroes.data.entities.SuperHeroe;

/**
 * The {@link SuperHeroeDto} data transfer dto, used to show and create their {@link SuperHeroe} entities to save, update, delete in
 * the database.
 * @author AGT96
 */
public final class SuperHeroeDto extends BaseDto {
	
	private String name;
	
	private String powers;
	
	private String company;
	
	private Integer comics;
	
	/**
	 * Creates a new {@link SuperHeroeDto} instance.
	 */
	public SuperHeroeDto() {}
	
	/**
	 * Creates a new {@link SuperHeroeDto} instance with a id, name, powers
	 * company and comics.
	 * @param id the id of this entity, can be null to auto generate it.
	 * @param name the name of the {@link SuperHeroeDto}.
	 * @param powers the powers of the {@link SuperHeroeDto}
	 * @param company the company of the {@link SuperHeroeDto}.
	 * @param comics if the {@link SuperHeroeDto} have comics. Can be 1 (true) or false (0).
	 */
	public SuperHeroeDto(Integer id, String name, String powers, String company, Integer comics) {
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
		return "SuperHeroeDto: name = " + name + ", powers = " + powers + ", company = " + company + ", comics = " + comics;
	}
}
