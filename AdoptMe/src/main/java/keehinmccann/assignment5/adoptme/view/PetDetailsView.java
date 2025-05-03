package keehinmccann.assignment5.adoptme.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Pet Details View shows the details of a pet
 * it will be set with text in the fields after it is created
 */
public class PetDetailsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField typeTextField;
	private JTextField speciesTextField;
	private JTextField ageTextField;
	private JTextField adoptedTextField;

	/**
	 * Create the frame.
	 */
	public PetDetailsView() {
		setTitle("Pet Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton closeButton = new JButton("Close");
		closeButton.setBounds(335, 377, 89, 23);
		closeButton.addActionListener(event -> dispose());
		contentPane.add(closeButton);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(41, 33, 352, 20);
		contentPane.add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(0, 3, 73, 14);
		namePanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setText("placeholder");
		nameTextField.setEditable(false);
		nameTextField.setBounds(79, 0, 273, 20);
		namePanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(null);
		idPanel.setBounds(41, 86, 352, 20);
		contentPane.add(idPanel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(0, 3, 73, 14);
		idPanel.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setText("placeholder");
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		idTextField.setBounds(79, 0, 273, 20);
		idPanel.add(idTextField);
		
		JPanel typePanel = new JPanel();
		typePanel.setLayout(null);
		typePanel.setBounds(41, 139, 352, 20);
		contentPane.add(typePanel);
		
		JLabel typeLabel = new JLabel("Type:");
		typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		typeLabel.setBounds(0, 3, 73, 14);
		typePanel.add(typeLabel);
		
		typeTextField = new JTextField();
		typeTextField.setText("placeholder");
		typeTextField.setEditable(false);
		typeTextField.setColumns(10);
		typeTextField.setBounds(79, 0, 273, 20);
		typePanel.add(typeTextField);
		
		JPanel speciesPanel = new JPanel();
		speciesPanel.setLayout(null);
		speciesPanel.setBounds(41, 192, 352, 20);
		contentPane.add(speciesPanel);
		
		JLabel speciesLabel = new JLabel("Species:");
		speciesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		speciesLabel.setBounds(0, 3, 73, 14);
		speciesPanel.add(speciesLabel);
		
		speciesTextField = new JTextField();
		speciesTextField.setText("placeholder");
		speciesTextField.setEditable(false);
		speciesTextField.setColumns(10);
		speciesTextField.setBounds(79, 0, 273, 20);
		speciesPanel.add(speciesTextField);
		
		JPanel agePanel = new JPanel();
		agePanel.setLayout(null);
		agePanel.setBounds(41, 245, 352, 20);
		contentPane.add(agePanel);
		
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ageLabel.setBounds(0, 3, 73, 14);
		agePanel.add(ageLabel);
		
		ageTextField = new JTextField();
		ageTextField.setText("placeholder");
		ageTextField.setEditable(false);
		ageTextField.setColumns(10);
		ageTextField.setBounds(79, 0, 273, 20);
		agePanel.add(ageTextField);
		
		JPanel adoptedPanel = new JPanel();
		adoptedPanel.setLayout(null);
		adoptedPanel.setBounds(41, 298, 352, 20);
		contentPane.add(adoptedPanel);
		
		JLabel adoptedLabel = new JLabel("Adopted:");
		adoptedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		adoptedLabel.setBounds(0, 3, 73, 14);
		adoptedPanel.add(adoptedLabel);
		
		adoptedTextField = new JTextField();
		adoptedTextField.setText("placeholder");
		adoptedTextField.setEditable(false);
		adoptedTextField.setColumns(10);
		adoptedTextField.setBounds(79, 0, 273, 20);
		adoptedPanel.add(adoptedTextField);
	}
	
	/**
	 * Sets the related text fields to hold the passed text for each field
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public void setPetTextFields(String id, String name, String type, String species, String age, String adopted) {
		idTextField.setText(id);
		nameTextField.setText(name);
		typeTextField.setText(type);
		speciesTextField.setText(species);
		ageTextField.setText(age);
		adoptedTextField.setText(adopted);
	}
}
