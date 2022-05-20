package com.agt.mantenimientosuperheroes.service.data.dto;

/**
 * The {@link SuperHeroDto} data transfer dto, used to show and create their SuperHero entities to save, update, delete in
 * the database.
 * @author AGT96
 */
public final class SuperHeroDto extends BaseDto {
	
	private String name;
	
	private String powers;
	
	private String company;
	
	private Integer comics;
	
	/**
	 * Creates a new {@link SuperHeroDto} instance.
	 */
	public SuperHeroDto() {}
	
	/**
	 * Creates a new {@link SuperHeroDto} instance with a id, name, powers
	 * company and comics.
	 * @param id the id of this entity, can be null to auto generate it.
	 * @param name the name of the {@link SuperHeroDto}.
	 * @param powers the powers of the {@link SuperHeroDto}
	 * @param company the company of the {@link SuperHeroDto}.
	 * @param comics if the {@link SuperHeroDto} have comics. Can be 1 (true) or false (0).
	 */
	public SuperHeroDto(Integer id, String name, String powers, String company, Integer comics) {
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
		return "SuperHeroDto: name = " + name + ", powers = " + powers + ", company = " + company + ", comics = " + comics;
	}
}
