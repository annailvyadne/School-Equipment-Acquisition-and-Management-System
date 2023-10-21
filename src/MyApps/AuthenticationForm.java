package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AuthenticationForm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_username;
	private JTextField tf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationForm frame = new AuthenticationForm();
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
	public AuthenticationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(32, 22, 404, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(152, 158, 223, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		tf_username = new JTextField();
		tf_username.setBounds(0, 0, 223, 32);
		panel_1.add(tf_username);
		tf_username.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(152, 201, 223, 32);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		tf_password = new JTextField();
		tf_password.setBounds(0, 0, 223, 32);
		panel_1_1.add(tf_password);
		tf_password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setBounds(33, 168, 109, 19);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPassword.setBounds(33, 211, 109, 19);
		panel.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnLogIn.setBounds(152, 259, 89, 23);
		panel.add(btnLogIn);
	
		btnLogIn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Create an instance of the EquipmentRequestForm class
		        EquipmentRequestForm equipmentRequestForm = new EquipmentRequestForm();

		        // Make the EquipmentRequestForm visible
		        equipmentRequestForm.setVisible(true);

		        setVisible(false); // To hide the login form

		    }
		});
		
		JLabel lblNewLabel = new JLabel("Don't have an account?");
		lblNewLabel.setBounds(119, 311, 122, 14);
		panel.add(lblNewLabel);
		
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSignUp.setBounds(239, 311, 62, 14);
		panel.add(lblSignUp);

		lblSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblSignUp.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Create an instance of the SignUpAuthenticationForm class
		        SignUpAuthenticationForm signUpForm = new SignUpAuthenticationForm();

		        // Make the SignUpAuthenticationForm visible
		        signUpForm.setVisible(true);

		        // Close the current AuthenticationForm (optional)
		        setVisible(false); // To hide the login form
		    }
		});

	}
}
