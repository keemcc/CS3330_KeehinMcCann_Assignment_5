package keehinmccann.assignment5.adoptme.model.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.StandardPet;

public class Shelter<T extends Pet> {
	private ArrayList<T> petList;
	
	public Shelter() {
		petList = new ArrayList<T>();
	}
	
	public boolean addPet(T pet) {
		if (this.contains(pet)) {
			return false;
		}
		petList.add(pet);
		return true;
	}
	
	public boolean removePet(int index) {
		if (petList.size() <= index) {
			return false;
		}
		petList.remove(index);
		return true;
	}
	
	public Pet createPet(int id, String name, String type, String species, int age, boolean adopted) {
		return new StandardPet(id, name, type, species, age, adopted);
	}
	
	public boolean idExists(String id) {
		for (Pet pet : petList) {
			if (pet.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void sortPets() {
		Collections.sort(petList);
	}
	
	public void sortPets(Comparator<Pet> comparator) {
		petList.sort(comparator);
	}
	
	public ArrayList<T> getPets() {
		return petList;
	}
	
	public boolean contains(Pet pet) {
		if (idExists(pet.getId())) {
			return true;
		}
		return false;
	}

	public Pet getPet(int petIndex) {
		if (petIndex >= petList.size()) {
			return null;
		}
		return petList.get(petIndex);
	}
	
	public boolean adoptPet(int petIndex) {
		if (petIndex >= petList.size()) {
			return false;
		}
		return (getPet(petIndex).adopt());
	}
}
