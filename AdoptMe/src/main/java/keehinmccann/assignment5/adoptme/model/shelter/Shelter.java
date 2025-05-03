package keehinmccann.assignment5.adoptme.model.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.StandardPet;

/**
 * Shelter class that contains pets
 * @param <T>
 */
public class Shelter<T extends Pet> {
	/**
	 * ArrayList containing the pets
	 */
	private ArrayList<T> petList;
	
	/**
	 * Initializes the shelter and petList
	 */
	public Shelter() {
		petList = new ArrayList<T>();
	}
	
	/**
	 * Adds a pet to the petList if it isn't already in it
	 * @param pet
	 * @return true if it is successfully added, false otherwise
	 */
	public boolean addPet(T pet) {
		if (this.contains(pet)) {
			return false;
		}
		petList.add(pet);
		return true;
	}
	
	/**
	 * Removes a pet from the petList at the given index
	 * @param index
	 * @return true if successful, false if out of bounds
	 */
	public boolean removePet(int index) {
		if (petList.size() <= index) {
			return false;
		}
		petList.remove(index);
		return true;
	}
	
	/**
	 * Creates a new pet with the standardPet constructor and the passed values
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 * @return
	 */
	public Pet createPet(int id, String name, String type, String species, int age, boolean adopted) {
		return new StandardPet(id, name, type, species, age, adopted);
	}
	
	/**
	 * Scans the petList to find if the given id exists within it
	 * @param id
	 * @return true if the id does exist, false otherwise
	 */
	public boolean idExists(String id) {
		for (Pet pet : petList) {
			if (pet.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sorts the pets based on their compareTo method
	 */
	public void sortPets() {
		Collections.sort(petList);
	}
	
	/**
	 * Sorts the pets based on the passed comparator
	 * @param comparator
	 */
	public void sortPets(Comparator<Pet> comparator) {
		petList.sort(comparator);
	}
	
	/**
	 * Returns the petList
	 * @return
	 */
	public ArrayList<T> getPets() {
		return petList;
	}
	
	/**
	 * Scans the petlist to see if it contains the passed pet
	 * @param pet
	 * @return true if the pet exists, false otherwise
	 */
	public boolean contains(Pet pet) {
		if (idExists(pet.getId())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the pet at the passed index
	 * @param petIndex
	 * @return null if index out of bounds, false otherwise
	 */
	public Pet getPet(int petIndex) {
		if (petIndex >= petList.size()) {
			return null;
		}
		return petList.get(petIndex);
	}
	
	/**
	 * Adopts the pet at the given index
	 * @param petIndex
	 * @return false if out of bounds, then true if pet is successfully adopted or false if it is already adopted
	 */
	public boolean adoptPet(int petIndex) {
		if (petIndex >= petList.size()) {
			return false;
		}
		return (getPet(petIndex).adopt());
	}
}
