package keehinmccann.assignment5.adoptme.model.pet;

/**
 * Class containing fields and methods relating to the exotic pet defined by the exotic pets json file
 */
public class ExoticPet {
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;
	
	/**
	 * Creates a new exotic pet with the passed parameters
	 * @param uniqueId
	 * @param animalName
	 * @param category
	 * @param subSpecies
	 * @param yearsOld
	 */
	public ExoticPet(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}
	
	/**
	 * Returns the exotic pet's unique id
	 * @return
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Returns the animal's name
	 * @return
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Returns the animal's category
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the animal's subSpecies
	 * @return
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * Returns the animal's yearsOld
	 * @return
	 */
	public int getYearsOld() {
		return yearsOld;
	}
	
}
