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

/**
 * Main file for application to run
 */
public class App {
  public static void main(String[] args) {
	  ShelterController controller = new ShelterController(new Shelter<Pet>(), new ShelterListView());
	  controller.initiate();
  }
}
