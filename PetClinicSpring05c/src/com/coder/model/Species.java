package com.coder.model;
// Generated Jul 17, 2020 9:43:20 PM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Species generated by hbm2java
 */
@Entity
@Table(name = "species", catalog = "pet_clinic1")
public class Species implements java.io.Serializable {

	private Integer speciesId;
	private String speciesName;
	private Set<Pet> pets = new HashSet<Pet>(0);

	public Species() {
	}

	public Species(String speciesName, Set<Pet> pets) {
		this.speciesName = speciesName;
		this.pets = pets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "species_id", unique = true, nullable = false)
	public Integer getSpeciesId() {
		return this.speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	@Column(name = "species_name", length = 30)
	public String getSpeciesName() {
		return this.speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
	public Set<Pet> getPets() {
		return this.pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
