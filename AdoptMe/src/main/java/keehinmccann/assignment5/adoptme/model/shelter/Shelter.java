package keehinmccann.assignment5.adoptme.model.shelter;

import java.util.ArrayList;
import java.util.Collections;

import keehinmccann.assignment5.adoptme.model.pet.Pet;

public class Shelter<T extends Pet> {
	private ArrayList<T> petList;
	
	public Shelter() {
		petList = new ArrayList<T>();
	}
	
	public void addPet(T pet) {
		petList.add(pet);
	}
	
	public void printPets() {
		for (Pet pet: petList) {
			System.out.println(pet);
		}
	}
	
	public void sortPets() {
		Collections.sort(petList);
	}
}
