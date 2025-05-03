package keehinmccann.assignment5.adoptme.model.pet.comparators;

import java.util.Comparator;

import keehinmccann.assignment5.adoptme.model.pet.Pet;

/**
 * Age comparator for pets so that they can be compared by age
 */
public class AgeComparator implements Comparator<Pet> {

	/**
	 * Returns the comparison based on the pets ages
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}
