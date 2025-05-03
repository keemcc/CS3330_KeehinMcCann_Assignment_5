package keehinmccann.assignment5.adoptme.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPetView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField petIdTextField;
	private JTextField petNameTextField;
	private JTextField petTypeTextField;
	private JTextField petSpeciesTextField;
	private JTextField petAgeTextField;
	private JLabel petIdLabel;
	private JLabel petNameLabel;
	private JLabel petTypeLabel;
	private JLabel petSpeciesLabel;
	private JLabel petAgeLabel;
	private JButton submitButton;
	private JCheckBox adoptedCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPetView frame = new AddPetView();
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
	public AddPetView() {
		setTitle("Add Pet Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		petIdTextField = new JTextField();
		petIdTextField.setBounds(301, 41, 241, 20);
		contentPane.add(petIdTextField);
		petIdTextField.setColumns(10);
		
		petNameTextField = new JTextField();
		petNameTextField.setColumns(10);
		petNameTextField.setBounds(301, 102, 241, 20);
		contentPane.add(petNameTextField);
		
		petTypeTextField = new JTextField();
		petTypeTextField.setColumns(10);
		petTypeTextField.setBounds(301, 163, 241, 20);
		contentPane.add(petTypeTextField);
		
		petSpeciesTextField = new JTextField();
		petSpeciesTextField.setColumns(10);
		petSpeciesTextField.setBounds(301, 224, 241, 20);
		contentPane.add(petSpeciesTextField);
		
		petAgeTextField = new JTextField();
		petAgeTextField.setColumns(10);
		petAgeTextField.setBounds(301, 285, 241, 20);
		contentPane.add(petAgeTextField);
		
		adoptedCheckBox = new JCheckBox("Pet is adopted?");
		adoptedCheckBox.setBounds(367, 323, 125, 23);
		contentPane.add(adoptedCheckBox);
		
		petIdLabel = new JLabel("Pet ID Integer:");
		petIdLabel.setBounds(212, 44, 84, 14);
		contentPane.add(petIdLabel);
		
		petNameLabel = new JLabel("Name:");
		petNameLabel.setBounds(255, 105, 41, 14);
		contentPane.add(petNameLabel);
		
		petTypeLabel = new JLabel("Type:");
		petTypeLabel.setBounds(255, 166, 41, 14);
		contentPane.add(petTypeLabel);
		
		petSpeciesLabel = new JLabel("Species:");
		petSpeciesLabel.setBounds(242, 227, 54, 14);
		contentPane.add(petSpeciesLabel);
		
		petAgeLabel = new JLabel("Age:");
		petAgeLabel.setBounds(255, 288, 41, 14);
		contentPane.add(petAgeLabel);
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitButton.setBounds(377, 365, 89, 23);
		contentPane.add(submitButton);
	}
	
	public void addSubmitButtonListener(ActionListener listener) {
		submitButton.addActionListener(listener);
	}
	public String getIdText() {
		try {
			String text = petIdTextField.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}
	public String getNameText() {
		try {
			String text = petNameTextField.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}
	public String getTypeText() {
		try {
			String text = petTypeTextField.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}
	public String getAgeText() {
		try {
			String text = petAgeTextField.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}
	public String getSpeciesText() {
		try {
			String text = petSpeciesTextField.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean getAdoptedCheckBox() {
		return adoptedCheckBox.isSelected();
	}
}
