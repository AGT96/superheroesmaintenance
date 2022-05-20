package com.agt.mantenimientosuperheroes.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The {@link SuperHeroe} class represents the table and records of the superheroes table.
 * @author AGT96
 */
@Entity
@Table(name = "superheroes")
public final class SuperHeroe extends BaseEntity {
	
	//TODO: Complete this class
	
	@Column(name = "name", nullable = false)
	private String name;
	
	public SuperHeroe() {}

}
