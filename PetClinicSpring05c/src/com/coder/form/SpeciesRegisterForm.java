package com.coder.form;

import java.util.List;

import com.coder.model.Species;

public class SpeciesRegisterForm {
private SpeciesForm speciesForm=null;
private List<Species> species;
public SpeciesForm getSpeciesForm() {
	return speciesForm;
}
public void setSpeciesForm(SpeciesForm speciesForm) {
	this.speciesForm = speciesForm;
}
public List<Species> getSpecies() {
	return species;
}
public void setSpecies(List<Species> species) {
	this.species = species;
}
}
