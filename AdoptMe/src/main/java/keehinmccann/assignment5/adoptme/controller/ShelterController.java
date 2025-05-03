package keehinmccann.assignment5.adoptme.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import keehinmccann.assignment5.adoptme.controller.inputvalidation.ValidateUserInput;
import keehinmccann.assignment5.adoptme.model.filehandling.PetLoader;
import keehinmccann.assignment5.adoptme.model.filehandling.PetSaver;
import keehinmccann.assignment5.adoptme.model.pet.Pet;
import keehinmccann.assignment5.adoptme.model.pet.comparators.AgeComparator;
import keehinmccann.assignment5.adoptme.model.pet.comparators.SpeciesComparator;
import keehinmccann.assignment5.adoptme.model.shelter.Shelter;
import keehinmccann.assignment5.adoptme.view.AddPetView;
import keehinmccann.assignment5.adoptme.view.PetDetailsView;
import keehinmccann.assignment5.adoptme.view.ShelterListView;
import keehinmccann.assignment5.adoptme.view.errors.PetErrorDialog;

/**
 * Controller class for following MVC Architecture,
 * Handles Creation of view and contact between view and model
 * Also handles logic behind view button presses
 */
public class ShelterController {
	private Shelter<Pet> shelterModel;
	private ShelterListView shelterListView;
	private AddPetView addPetView;
	
	/**
	 * Creates the shelterController with the passed model and view
	 * @param model shelter model
	 * @param view shelter list view
	 */
	public ShelterController(Shelter<Pet> model, ShelterListView view) {
		shelterModel = model;
		shelterListView = view;
	}
	
	/**
	 * Initializes the shelter by
	 * loading all pets
	 * Adding listeners to buttons and combo box in view
	 * updating the pets to be sorted by default combo box option
	 * updating list view to display sorted pets
	 * setting view to be visible
	 */
	public void initiate() {
		PetLoader.loadStandardPets(shelterModel);
		PetLoader.loadExoticPets(shelterModel);
		shelterListView.addAdoptPetListener(new AdoptPetListener());
		shelterListView.addRemovePetListener(new RemovePetListener());
		shelterListView.addSortComboBoxListener(new SortComboBoxListener());
		shelterListView.addAddPetListener(new AddPetListener());
		shelterListView.addViewPetListener(new ViewPetListener());
		shelterListView.addSavePetListListener(new SavePetListListener());
		updatePetSorting();
		updateView();
		shelterListView.setVisible(true);
	}
	
	/**
	 * Method to update the shelter view using the shelter model
	 */
	public void updateView() {
		shelterListView.updateView(shelterModel.getPets());
	}
	
	/**
	 * Updates the pet sorting based on the selected combo box option
	 * Does not update the view
	 */
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
	
	/**
	 * Action Listener for the adopt pet button
	 * Provides an error dialog if no pet is selected,
	 * Provides an error if the pet is already adopted,
	 * or adopts the pet and updates the view to display it
	 */
	private class AdoptPetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = shelterListView.getSelectedPet();
			if (selectedPetIndex == -1) {
				new PetErrorDialog("You must select a pet").setVisible(true);
				return;
			}
			if (!shelterModel.adoptPet(selectedPetIndex)) {
				new PetErrorDialog("This pet has already been adopted.").setVisible(true);
				return;
			}
			updateView();
		}
		
	}
	
	/**
	 * Action Listener for the remove pet button
	 * Provides an error dialog if no pet is selected or
	 * removes pet from shelter and updates view
	 */
	private class RemovePetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = shelterListView.getSelectedPet();
			if (selectedPetIndex == -1) {
				new PetErrorDialog("You must select a pet").setVisible(true);
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
				new PetErrorDialog("Pet ID Integer provided was invalid or empty").setVisible(true);
				return;
			}
			int id = Integer.parseInt(addPetView.getIdText());
			if (!ValidateUserInput.validateInputNotNull(addPetView.getNameText())) {
				new PetErrorDialog("Name field was empty").setVisible(true);
				return;
			}
			String name = addPetView.getNameText();
			if (!ValidateUserInput.validateInputNotNull(addPetView.getTypeText())) {
				new PetErrorDialog("Type field was empty").setVisible(true);
				return;
			}
			String type = addPetView.getTypeText();
			if (!ValidateUserInput.validateInputNotNull(addPetView.getSpeciesText())) {
				new PetErrorDialog("Species field was empty").setVisible(true);
				return;
			}
			String species = addPetView.getSpeciesText();
			if (!ValidateUserInput.validateInputInteger(addPetView.getAgeText())) {
				new PetErrorDialog("Age integer provided was invalid or empty").setVisible(true);
				return;
			}
			int age = Integer.parseInt(addPetView.getAgeText());
			boolean adopted = addPetView.getAdoptedCheckBox();
			Pet pet = shelterModel.createPet(id, name, type, species, age, adopted);
			if (!shelterModel.addPet(pet)) {
				new PetErrorDialog("Pet with given ID already exists").setVisible(true);
				return;
			}
			addPetView.dispose();
			updatePetSorting();
			shelterListView.updateView(shelterModel.getPets());
		}
		
	}
	
	private class ViewPetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = shelterListView.getSelectedPet();
			if (selectedPetIndex < 0) {
				new PetErrorDialog("You must select a pet").setVisible(true);
				return;
			}
			Pet pet = shelterModel.getPet(selectedPetIndex);
			String id = pet.getId();
			String name = pet.getName();
			String type = pet.getType();
			String species = pet.getSpecies();
			String age = Integer.toString(pet.getAge());
			String adopted = (pet.isAdopted()) ? "Yes" : "No";
			PetDetailsView view = new PetDetailsView();
			view.setPetTextFields(id, name, type, species, age, adopted);
			view.setVisible(true);
		}
		
	}
	
	private class SavePetListListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean success = PetSaver.saveShelter(shelterModel);
			if (success) {
				new PetErrorDialog("Success").setVisible(true);
			} else {
				new PetErrorDialog("Error While Saving").setVisible(true);
			}
			return;
		}
		
	}

}
