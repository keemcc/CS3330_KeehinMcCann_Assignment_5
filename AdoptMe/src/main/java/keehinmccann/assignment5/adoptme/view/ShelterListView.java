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
	public ShelterListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 884, 509);
		contentPane.add(scrollPane);
		
		list = new JList<Pet>(shelterListModel);
		
		scrollPane.setViewportView(list);
	}
	
	public void updateView(ArrayList<Pet> pets) {
		shelterListModel.clear();
		for (Pet pet : pets) {
			shelterListModel.addElement(pet);
		}
	}
}
