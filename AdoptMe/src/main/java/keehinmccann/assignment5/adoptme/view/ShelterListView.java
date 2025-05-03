package keehinmccann.assignment5.adoptme.view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import keehinmccann.assignment5.adoptme.model.pet.Pet;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.Color;

/**
 * Main view for the shelter application,
 * Displays the list of all pets within the shelter and has buttons for related operations
 */
public class ShelterListView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShelterListView frame = new ShelterListView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JList<Pet> list;
	private DefaultListModel<Pet> shelterListModel = new DefaultListModel<>();
	private JButton addPetButton;
	private JButton adoptPetButton;
	private JButton removePetButton;
	private JButton viewPetButton;
	private JButton savePetListButton;
	private JComboBox<String> sortComboBox = new JComboBox<String>();
	public ShelterListView() {
		setTitle("Pet Shelter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 718, 446);
		contentPane.add(scrollPane);
		
		list = new JList<Pet>(shelterListModel);
		list.setBackground(new Color(255, 255, 255));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(list);
		
		addPetButton = new JButton("Add New Pet");
		addPetButton.setBounds(598, 500, 130, 23);
		contentPane.add(addPetButton);
		
		adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(150, 9, 99, 23);
		contentPane.add(adoptPetButton);
		
		removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(10, 9, 109, 23);
		contentPane.add(removePetButton);
		
		viewPetButton = new JButton("View Pet Details");
		viewPetButton.setBounds(278, 9, 137, 23);
		contentPane.add(viewPetButton);
		
		savePetListButton = new JButton("Save Pet List");
		savePetListButton.setBounds(619, 9, 109, 23);
		contentPane.add(savePetListButton);
		
		sortComboBox = new JComboBox<String>();
		sortComboBox.setBounds(10, 500, 118, 22);
		sortComboBox.setToolTipText("Sort By...");
		sortComboBox.addItem("Name");
		sortComboBox.addItem("Age");
		sortComboBox.addItem("Species");
		contentPane.add(sortComboBox);
	}
	
	/**
	 * Updates the view with the passed pets arraylist
	 * @param pets
	 */
	public void updateView(ArrayList<Pet> pets) {
		shelterListModel.clear();
		for (Pet pet : pets) {
			shelterListModel.addElement(pet);
		}
	}
	/**
	 * Returns the index of the pet that is currently highlighted
	 * @return
	 */
	public int getSelectedPet() {
		return list.getSelectedIndex();
	}
	/**
	 * Returns the index of the sorting option that is currently selected in the combobox
	 * @return
	 */
	public int getSelectedSortingOption() {
		return sortComboBox.getSelectedIndex();
	}
	
	/**
	 * Adds the passed listener to the add pets button
	 * @param listener
	 */
	public void addAddPetListener(ActionListener listener) {
		addPetButton.addActionListener(listener);
	}
	/**
	 * Adds the passed listener to the adopt pet button
	 * @param listener
	 */
	public void addAdoptPetListener(ActionListener listener) {
		adoptPetButton.addActionListener(listener);
	}
	/**
	 * Adds the passed listener to the remove pet button
	 * @param listener
	 */
	public void addRemovePetListener(ActionListener listener) {
		removePetButton.addActionListener(listener);
	}
	/**
	 * Adds the passed listener to the view pet details button
	 * @param listener
	 */
	public void addViewPetListener(ActionListener listener) {
		viewPetButton.addActionListener(listener);
	}
	/**
	 * Adds the passed listener to the save pets button
	 * @param listener
	 */
	public void addSavePetListListener(ActionListener listener) {
		savePetListButton.addActionListener(listener);
	}
	/**
	 * Adds the passed listener to the sorting combo box
	 * @param listener
	 */
	public void addSortComboBoxListener(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}
	
}
