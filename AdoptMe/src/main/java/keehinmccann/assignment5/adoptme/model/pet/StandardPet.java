package keehinmccann.assignment5.adoptme.model.pet;

/**
 * Standard pet class defining fields related to pets.json and implementing methods defined by Pet
 */
public class StandardPet extends Pet {
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;

	/**
	 * Creates a new pet with the passed parameters
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public StandardPet(int id, String name, String type, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
        this.adopted = adopted;
	}

	/**
	 * Compares the pet's name to other pet's name
	 */
	@Override
	public int compareTo(Pet o) {
		return name.compareToIgnoreCase(o.getName());
	}

	/**
	 * Returns the pet's name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Returns the pet's type
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * Returns the pet's species
	 */
	@Override
	public String getSpecies() {
		return species;
	}

	/**
	 * Returns the pet's age
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Returns true if the pet is adopted, false if not
	 */
	@Override
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * Returns true if the pet is successfully adopted, false if it is already adopted
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
	 * Returns the pet's id as a string
	 */
	@Override
	public String getId() {
		return Integer.toString(id);
	}
	
	/**
	 * Returns true if the pet ids are equivalent
	 */
	@Override
	public boolean idEquals(Pet pet) {
		if (getId().equals(pet.getId())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tostring that displays relevant information about the pet
	 */
	@Override
	public String toString() {
	    return (name + " | Type: " + type + " | Species: " + species + " | Age: " + age + ((adopted) ? " | Adopted!" : ""));
	}

}
