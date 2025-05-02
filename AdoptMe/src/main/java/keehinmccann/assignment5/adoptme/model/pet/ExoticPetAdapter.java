package keehinmccann.assignment5.adoptme.model.pet;

public class ExoticPetAdapter extends Pet {
	private boolean adopted;
	private ExoticPet exoticPet;
	
	public ExoticPetAdapter(ExoticPet exoticPet) {
		adopted = false;
		this.exoticPet = exoticPet;
	}

	@Override
	public int compareTo(Pet o) {
		return exoticPet.getAnimalName().compareTo(o.getName());
	}

	@Override
	public String getName() {
		return exoticPet.getAnimalName();
	}

	@Override
	public String getType() {
		return exoticPet.getCategory();
	}

	@Override
	public String getSpecies() {
		return exoticPet.getSubSpecies();
	}

	@Override
	public int getAge() {
		return exoticPet.getYearsOld();
	}

	@Override
	public boolean isAdopted() {
		return adopted;
	}
	
	@Override
	public boolean adopt() {
		if (adopted == true) {
			return false;
		}
		adopted = true;
		return true;
	}
	
	@Override
	public String toString() {
		return ("ID: " + exoticPet.getUniqueId() + " | Name: " + exoticPet.getAnimalName() +
				" | Type: " + exoticPet.getCategory() +" | Species: " + exoticPet.getSubSpecies() + " | Adopted: " + adopted);
	}

}
