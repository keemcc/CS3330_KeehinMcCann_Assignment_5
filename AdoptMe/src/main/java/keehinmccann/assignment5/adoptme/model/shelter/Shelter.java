package keehinmccann.assignment5.adoptme.model.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import keehinmccann.assignment5.adoptme.model.pet.Pet;

public class Shelter<T extends Pet> {
	private ArrayList<T> petList;
	
	public Shelter() {
		petList = new ArrayList<T>();
	}
	
	public boolean addPet(T pet) {
		petList.add(pet);
		return true;
	}
	
	public void printPets() {
		for (Pet pet: petList) {
			System.out.println(pet);
		}
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
		for (int i = 0; i < petList.size(); i++) {
			if (petList.get(i).idEquals(pet)) {
				return true;
			}
		}
		return false;
	}
}
