package keehinmccann.assignment5.adoptme.view.errors;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

/**
 * View for any alert that needs to be displayed to the user
 */
public class PetAlertDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private final JLabel errorMessageLabel = new JLabel("Default error message text");


	/**
	 * Create the dialog with the passed message
	 */
	public PetAlertDialog(String message) {
		setTitle("Alert");
		setBounds(100, 100, 450, 233);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			errorMessageLabel.setBounds(67, 56, 280, 50);
			errorMessageLabel.setText(message);
			contentPanel.add(errorMessageLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 161, 434, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(event -> dispose());
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
