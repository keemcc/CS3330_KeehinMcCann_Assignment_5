package keehinmccann.assignment5.adoptme.model.pet;

public class StandardPet extends Pet {
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;

	public StandardPet(int id, String name, String type, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
        this.adopted = adopted;
	}

	@Override
	public int compareTo(Pet o) {
		return name.compareTo(o.getName());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getSpecies() {
		return species;
	}

	@Override
	public int getAge() {
		return age;
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
	public String getId() {
		return Integer.toString(id);
	}
	
	@Override
	public boolean idEquals(Pet pet) {
		if (getId() == pet.getId()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
	    return (name + " | Type: " + type + " | Species: " + species + " | Age: " + age + ((adopted) ? " | Adopted!" : ""));
	}

}
