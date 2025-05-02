package keehinmccann.assignment5.adoptme.model.filehandling;

import java.io.FileReader;

import com.google.gson.Gson;

import keehinmccann.assignment5.adoptme.model.pet.ExoticPet;
import keehinmccann.assignment5.adoptme.model.pet.ExoticPetAdapter;
import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.StandardPet;
import keehinmccann.assignment5.adoptme.model.shelter.Shelter;

public class PetLoader {
	public static boolean loadStandardPets(Shelter<Pet> shelter) {
		try (FileReader fileReader = new FileReader("src/main/resources/pets.json")) {
			StandardPet[] standardPets = new Gson().fromJson(fileReader, StandardPet[].class);
			for (StandardPet pet: standardPets) {
				shelter.addPet(pet);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean loadExoticPets(Shelter<Pet> shelter) {
		try (FileReader fileReader = new FileReader("src/main/resources/exotic_animals.json")) {
			ExoticPet[] exoticAnimals = new Gson().fromJson(fileReader, ExoticPet[].class);
			for (ExoticPet exoticAnimal: exoticAnimals) {
				ExoticPetAdapter pet = new ExoticPetAdapter(exoticAnimal);
				shelter.addPet(pet);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
