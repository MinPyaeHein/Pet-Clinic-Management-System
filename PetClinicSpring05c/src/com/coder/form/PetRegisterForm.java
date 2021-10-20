package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Pet;

public class PetRegisterForm {
private PetForm petForm;
private String ownerId;
private List<Pet> pets;
private Map<String,String> mapSpecies=new HashedMap<String,String>();

public PetForm getPetForm() {
	return petForm;
}
public void setPetForm(PetForm petForm) {
	this.petForm = petForm;
}
public String getOwnerId() {
	return ownerId;
}
public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
}
public Map<String, String> getMapSpecies() {
	return mapSpecies;
}
public void setMapSpecies(Map<String, String> mapSpecies) {
	this.mapSpecies = mapSpecies;
}
public List<Pet> getPets() {
	return pets;
}
public void setPets(List<Pet> pets) {
	this.pets = pets;
}
}
