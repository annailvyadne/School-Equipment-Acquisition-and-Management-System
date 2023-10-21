package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SignUpAuthenticationForm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_fname;
	private JTextField tf_lname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpAuthenticationForm frame = new SignUpAuthenticationForm();
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
	public SignUpAuthenticationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setForeground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(22, 43, 462, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_fname = new JPanel();
		panel_fname.setBackground(new Color(255, 255, 255));
		panel_fname.setBounds(162, 86, 223, 32);
		panel.add(panel_fname);
		panel_fname.setLayout(null);
		
		tf_fname = new JTextField();
		tf_fname.setBounds(0, 0, 223, 32);
		panel_fname.add(tf_fname);
		tf_fname.setColumns(10);
		
		JPanel panel_lname = new JPanel();
		panel_lname.setBackground(new Color(255, 255, 255));
		panel_lname.setBounds(162, 151, 223, 32);
		panel.add(panel_lname);
		panel_lname.setLayout(null);
		
		tf_lname = new JTextField();
		tf_lname.setColumns(10);
		tf_lname.setBounds(0, 0, 223, 32);
		panel_lname.add(tf_lname);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFirstName.setBounds(61, 86, 103, 32);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLastName.setBounds(61, 151, 103, 32);
		panel.add(lblLastName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Faculty", "Non Teaching Staff"}));
		comboBox.setBounds(162, 206, 223, 22);
		panel.add(comboBox);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSignUp.setBounds(162, 250, 89, 23);
		panel.add(btnSignUp);
		
	
		btnSignUp.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Create an instance of the AuthenticationForm class
		        AuthenticationForm authForm = new AuthenticationForm();

		        // Make the AuthenticationForm visible
		        authForm.setVisible(true);

		        // Close the current SignUpAuthenticationForm
		        dispose(); // To completely close the sign-up form
		    }
		});

		JLabel lblRole = new JLabel("Role:");
		lblRole.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblRole.setBounds(61, 201, 103, 32);
		panel.add(lblRole);
	}
}
