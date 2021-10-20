package com.coder.form;

import java.util.Date;

import com.coder.model.Owner;
import com.coder.model.Species;

public class PetForm {
	private String petId;
	private String ownerId;
	private String speciesId;
	private String petName;
	private String petSex;
	private String petBirth;
	private String petDeath;
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetSex() {
		return petSex;
	}
	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}
	public String getPetBirth() {
		return petBirth;
	}
	public void setPetBirth(String petBirth) {
		this.petBirth = petBirth;
	}
	public String getPetDeath() {
		return petDeath;
	}
	public void setPetDeath(String petDeath) {
		this.petDeath = petDeath;
	}
}
