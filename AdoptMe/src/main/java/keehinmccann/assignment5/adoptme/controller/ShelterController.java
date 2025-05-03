package keehinmccann.assignment5.adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import keehinmccann.assignment5.adoptme.controller.inputvalidation.ValidateUserInput;
import keehinmccann.assignment5.adoptme.model.filehandling.PetLoader;
import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.comparators.AgeComparator;
import keehinmccann.assignment5.adoptme.model.pet.comparators.SpeciesComparator;
import keehinmccann.assignment5.adoptme.model.shelter.Shelter;
import keehinmccann.assignment5.adoptme.view.AddPetView;
import keehinmccann.assignment5.adoptme.view.ShelterListView;
import keehinmccann.assignment5.adoptme.view.errors.AddPetErrorDialog;
import keehinmccann.assignment5.adoptme.view.errors.PetAlreadyAdoptedDialog;

public class ShelterController {
	private Shelter<Pet> shelterModel;
	private ShelterListView shelterListView;
	private AddPetView addPetView;
	
	public ShelterController(Shelter<Pet> model, ShelterListView view) {
		shelterModel = model;
		shelterListView = view;
	}
	
	public void initiate() {
		PetLoader.loadStandardPets(shelterModel);
		PetLoader.loadExoticPets(shelterModel);
		shelterListView.addAdoptPetListener(new AdoptPetListener());
		shelterListView.addRemovePetListener(new RemovePetListener());
		shelterListView.addSortComboBoxListener(new SortComboBoxListener());
		shelterListView.addAddPetListener(new AddPetListener());
		updatePetSorting();
		updateView();
		shelterListView.setVisible(true);
	}
	
	public void updateView() {
		shelterListView.updateView(shelterModel.getPets());
	}
	
	private void updatePetSorting() {
		switch (shelterListView.getSelectedSortingOption()) {
		case 0:
			shelterModel.sortPets();
			break;
		case 1:
			shelterModel.sortPets(new AgeComparator());
			break;
		case 2:
			shelterModel.sortPets(new SpeciesComparator());
			break;
		default:
			break;
		}
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
	
	private class RemovePetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = shelterListView.getSelectedPet();
			if (selectedPetIndex == -1) {
				return;
			}
			shelterModel.removePet(selectedPetIndex);
			shelterListView.updateView(shelterModel.getPets());
		}
		
	}
	
	private class SortComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(shelterListView.getSelectedSortingOption());
			updatePetSorting();
			shelterListView.updateView(shelterModel.getPets());
		}
		
	}
	
	private class AddPetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			addPetView = new AddPetView();
			addPetView.setVisible(true);
			addPetView.addSubmitButtonListener(new SubmitListener());
		}
		
	}
	
	private class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!ValidateUserInput.validateInputInteger(addPetView.getIdText())) {
				new AddPetErrorDialog("Pet ID Integer provided was invalid or empty").setVisible(true);
				return;
			}
			int id = Integer.parseInt(addPetView.getIdText());
			if (!ValidateUserInput.validateInputNotNull(addPetView.getNameText())) {
				new AddPetErrorDialog("Name field was empty").setVisible(true);
				return;
			}
			String name = addPetView.getNameText();
			if (!ValidateUserInput.validateInputNotNull(addPetView.getTypeText())) {
				new AddPetErrorDialog("Type field was empty").setVisible(true);
				return;
			}
			String type = addPetView.getTypeText();
			if (!ValidateUserInput.validateInputNotNull(addPetView.getSpeciesText())) {
				new AddPetErrorDialog("Species field was empty").setVisible(true);
				return;
			}
			String species = addPetView.getSpeciesText();
			if (!ValidateUserInput.validateInputInteger(addPetView.getAgeText())) {
				new AddPetErrorDialog("Age integer provided was invalid or empty").setVisible(true);
				return;
			}
			int age = Integer.parseInt(addPetView.getAgeText());
			boolean adopted = addPetView.getAdoptedCheckBox();
			Pet pet = shelterModel.createPet(id, name, type, species, age, adopted);
			if (!shelterModel.addPet(pet)) {
				new AddPetErrorDialog("Pet with given ID already exists").setVisible(true);
				return;
			}
			addPetView.dispose();
			updatePetSorting();
			shelterListView.updateView(shelterModel.getPets());
		}
		
	}

}
