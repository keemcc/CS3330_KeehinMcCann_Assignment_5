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
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.Color;

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
	private JList list;
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
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 884, 446);
		contentPane.add(scrollPane);
		
		list = new JList<Pet>(shelterListModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(list);
		
		addPetButton = new JButton("Add New Pet");
		addPetButton.setBounds(764, 497, 130, 23);
		contentPane.add(addPetButton);
		
		adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(150, 9, 99, 23);
		contentPane.add(adoptPetButton);
		
		removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(10, 9, 109, 23);
		contentPane.add(removePetButton);
		
		viewPetButton = new JButton("View Pet Details");
		viewPetButton.setBounds(278, 9, 119, 23);
		contentPane.add(viewPetButton);
		
		savePetListButton = new JButton("Save Pet List");
		savePetListButton.setBounds(785, 9, 109, 23);
		contentPane.add(savePetListButton);
		
		sortComboBox = new JComboBox<String>();
		sortComboBox.setToolTipText("Sort By...");
		sortComboBox.addItem("Default");
		sortComboBox.addItem("Age");
		sortComboBox.addItem("Species");
		sortComboBox.setBounds(20, 500, 99, 22);
		contentPane.add(sortComboBox);
	}
	
	public void updateView(ArrayList<Pet> pets) {
		shelterListModel.clear();
		for (Pet pet : pets) {
			shelterListModel.addElement(pet);
		}
	}
	
	public void addAddPetListener(ActionListener listener) {
		addPetButton.addActionListener(listener);
	}
	public void addAdoptPetListener(ActionListener listener) {
		adoptPetButton.addActionListener(listener);
	}
	public void addRemovePetListener(ActionListener listener) {
		removePetButton.addActionListener(listener);
	}
	public void addViewPetListener(ActionListener listener) {
		viewPetButton.addActionListener(listener);
	}
	public void addSavePetListListener(ActionListener listener) {
		savePetListButton.addActionListener(listener);
	}
	public void addSortComboBoxListener(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}
	
	public int getSelectedPet() {
		return list.getSelectedIndex();
	}
	public int getSelectedSortingOption() {
		return sortComboBox.getSelectedIndex();
	}
}
