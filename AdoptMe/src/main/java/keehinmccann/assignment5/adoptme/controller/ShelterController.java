package keehinmccann.assignment5.adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import keehinmccann.assignment5.adoptme.model.filehandling.PetLoader;
import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.comparators.AgeComparator;
import keehinmccann.assignment5.adoptme.model.pet.comparators.SpeciesComparator;
import keehinmccann.assignment5.adoptme.model.shelter.Shelter;
import keehinmccann.assignment5.adoptme.view.PetAlreadyAdoptedDialog;
import keehinmccann.assignment5.adoptme.view.ShelterListView;

public class ShelterController {
	private Shelter<Pet> shelterModel;
	private ShelterListView shelterListView;
	
	public ShelterController(Shelter<Pet> model, ShelterListView view) {
		shelterModel = model;
		shelterListView = view;
	}
	
	public void initiate() {
		PetLoader.loadStandardPets(shelterModel);
		PetLoader.loadExoticPets(shelterModel);
		shelterListView.addAdoptPetListener(new AdoptPetListener());
		updateView();
		shelterListView.setVisible(true);
	}
	
	public void updateView() {
		shelterListView.updateView(shelterModel.getPets());
	}
	
	private class AdoptPetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = shelterListView.getSelectedPet();
			if (selectedPetIndex == -1) {
				return;
			}
			ArrayList<Pet> petList = shelterModel.getPets();
			Pet pet = petList.get(selectedPetIndex);
			if (!pet.adopt()) {
				new PetAlreadyAdoptedDialog().setVisible(true);
				return;
			}
			System.out.println(pet);
			shelterListView.updateView(petList);
		}
		
	}

}
