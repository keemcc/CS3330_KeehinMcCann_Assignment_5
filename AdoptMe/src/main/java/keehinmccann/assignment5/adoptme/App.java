package keehinmccann.assignment5.adoptme;

import keehinmccann.assignment5.adoptme.controller.ShelterController;
import keehinmccann.assignment5.adoptme.model.filehandling.PetLoader;
import keehinmccann.assignment5.adoptme.model.pet.ExoticPet;
import keehinmccann.assignment5.adoptme.model.pet.ExoticPetAdapter;
import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.StandardPet;
import keehinmccann.assignment5.adoptme.model.pet.comparators.AgeComparator;
import keehinmccann.assignment5.adoptme.model.shelter.Shelter;
import keehinmccann.assignment5.adoptme.view.ShelterListView;

public class App {
  public static void main(String[] args) {
//	  StandardPet pet1 = new StandardPet(1, "Bean", "Cat", "Diluted Calico", 3, true);
//	  StandardPet pet2 = new StandardPet(2, "Czar", "Dog", "Great Dane", 6, true);
//	  ExoticPet exoticPet1 = new ExoticPet("40005", "Bean's Mom", "Large Cat", "Tiger", 200);
//	  ExoticPetAdapter pet5 = new ExoticPetAdapter(exoticPet1);
//	  StandardPet pet3 = new StandardPet(3, "Onyx", "Dog", "Great Dane", 1, true);
//	  StandardPet pet4 = new StandardPet(4, "Floppy", "Bunny", "Floppy Eared", 5, false);
//	  Shelter<Pet> shelter = new Shelter<Pet>();
//	  shelter.addPet(pet1);
//	  shelter.addPet(pet2);
//	  shelter.addPet(pet5);
//	  shelter.addPet(pet3);
//	  shelter.addPet(pet4);
//	  shelter.printPets();
//	  shelter.sortPets(new AgeComparator());
//	  shelter.printPets();
	  ShelterController controller = new ShelterController(new Shelter<Pet>(), new ShelterListView());
	  controller.initiate();
  }
}
