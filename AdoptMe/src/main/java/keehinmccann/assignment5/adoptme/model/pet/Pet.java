package keehinmccann.assignment5.adoptme.model.pet;

/**
 * Abstract class defining behavior needed by a pet
 */
public abstract class Pet implements Comparable<Pet>{
	/**
	 * Returns the name of the pet
	 * @return
	 */
	public abstract String getName();
	/**
	 * Returns the type of the pet
	 * @return
	 */
	public abstract String getType();
	/**
	 * Returns the species of the pet
	 * @return
	 */
	public abstract String getSpecies();
	/**
	 * Returns the age of the pet
	 * @return
	 */
	public abstract int getAge();
	/**
	 * Returns if the pet is adopted or not
	 * @return
	 */
	public abstract boolean isAdopted();
	/**
	 * Adopts the pet, setting it to be adopted
	 * Returns true if the pet was successfully adopted, or false otherwise
	 * @return
	 */
	public abstract boolean adopt();
	/**
	 * Returns a string representation of the pet's id
	 * @return
	 */
	public abstract String getId();
	/**
	 * Returns true if the ids are equivalent
	 * @param pet
	 * @return
	 */
	public abstract boolean idEquals(Pet pet);
}
