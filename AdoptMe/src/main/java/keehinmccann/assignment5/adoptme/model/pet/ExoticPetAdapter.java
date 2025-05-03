package keehinmccann.assignment5.adoptme.model.pet;

/**
 * Adapter Class for converting an exotic pet to follow methods needed by the Pet abstract class
 */
public class ExoticPetAdapter extends Pet {
	private boolean adopted;
	private ExoticPet exoticPet;
	
	/**
	 * Creates a new exotic pet adapter with the passed exotic pet
	 * @param exoticPet
	 */
	public ExoticPetAdapter(ExoticPet exoticPet) {
		//Sets adopted to false by default as exoticPets do not have this field
		adopted = false;
		this.exoticPet = exoticPet;
	}

	/**
	 * Compare to function for exotic pets to be compared to other pets by name
	 */
	@Override
	public int compareTo(Pet o) {
		return exoticPet.getAnimalName().compareToIgnoreCase(o.getName());
	}

	/**
	 * Returns the exotic pet's name
	 */
	@Override
	public String getName() {
		return exoticPet.getAnimalName();
	}

	/**
	 * Returns the exotic pet's category (type)
	 */
	@Override
	public String getType() {
		return exoticPet.getCategory();
	}

	/**
	 * Returns the exotic pet's subSpecies (species)
	 */
	@Override
	public String getSpecies() {
		return exoticPet.getSubSpecies();
	}

	/**
	 * Returns the exotic pet's yearsOld (age)
	 */
	@Override
	public int getAge() {
		return exoticPet.getYearsOld();
	}

	/**
	 * Returns if the exotic pet has been adopted
	 */
	@Override
	public boolean isAdopted() {
		return adopted;
	}
	
	/**
	 * Checks if the pet has been adopted, if it has, return false, otherwise, set adopted to true, and return true
	 */
	@Override
	public boolean adopt() {
		if (adopted == true) {
			return false;
		}
		adopted = true;
		return true;
	}
	
	/**
	 * Returns the string of the exotic pet's unique id
	 */
	@Override
	public String getId() {
		return exoticPet.getUniqueId();
	}
	
	/**
	 * Returns true if the ids are equivalent
	 */
	@Override
	public boolean idEquals(Pet pet) {
		if (getId().equals(pet.getId())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Overridden tostring method to properly display exotic pet's information
	 */
	@Override
	public String toString() {
		return (exoticPet.getAnimalName() + 
				" | Type: " + exoticPet.getCategory() + 
				" | Species: " + exoticPet.getSubSpecies() + 
				" | Age: " + exoticPet.getYearsOld() + ((adopted) ? 
				" | Adopted!" : ""));
	}

}
