package keehinmccann.assignment5.adoptme.model.pet.comparators;

import java.util.Comparator;

import keehinmccann.assignment5.adoptme.model.pet.Pet;

/**
 * Species comparator that defines how pets are compared by species
 */
public class SpeciesComparator implements Comparator<Pet>{

	/**
	 * Returns the comparison between both pets species
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}

}
