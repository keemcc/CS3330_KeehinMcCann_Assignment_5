package keehinmccann.assignment5.adoptme.model.pet;

public abstract class Pet implements Comparable<Pet>{
	public abstract String getName();
	public abstract String getType();
	public abstract String getSpecies();
	public abstract int getAge();
	public abstract boolean isAdopted();
	public abstract boolean adopt();
	public abstract String getId();
	public abstract boolean idEquals(Pet pet);
}
