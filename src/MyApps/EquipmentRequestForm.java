package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyLibs.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class EquipmentRequestForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentRequestForm frame = new EquipmentRequestForm();
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
	public EquipmentRequestForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(10, 25, 397, 429);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipment Request Form");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(36, 0, 262, 62);
		panel.add(lblNewLabel);
		
		String[] eqName = fetchEquipmentName();
		JComboBox<String> cb_equipmentName = new JComboBox<>(eqName);
//		JComboBox<String> roomComboBox = new JComboBox<>(putRoomItems);
		
		cb_equipmentName.setBounds(185, 198, 153, 22);
		panel.add(cb_equipmentName);
		
		JComboBox cb_condition = new JComboBox();
		cb_condition.setModel(new DefaultComboBoxModel(new String[] {"Not Working", "Needs Repair" , "Good Condition"}));
		cb_condition.insertItemAt("Select a Condition", 0);
		cb_condition.setSelectedIndex(0);
		cb_condition.setBounds(185, 248, 153, 22);
		panel.add(cb_condition);
		
		JComboBox cb_room = new JComboBox();
		cb_room.setModel(new DefaultComboBoxModel(new String[] {"MPO301", "MPO302", "MPO303"}));
		cb_room.insertItemAt("Select a Room", 0);
		cb_room.setSelectedIndex(0);
		cb_room.setBounds(185, 297, 153, 22);
		panel.add(cb_room);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(120, 338, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(73, 73, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setBounds(73, 104, 60, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Role:");
		lblNewLabel_1_1_1.setBounds(73, 135, 60, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lbl_name = new JLabel(getuserInfo());
		lbl_name.setBounds(143, 73, 67, 14);
		panel.add(lbl_name);
		
		JLabel lbl_username = new JLabel("lbl_username");
		lbl_username.setBounds(143, 104, 67, 14);
		panel.add(lbl_username);
		
		JLabel lbl_role = new JLabel("lbl_role");
		lbl_role.setBounds(143, 135, 67, 14);
		panel.add(lbl_role);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(261, 249, 1, 1);
		panel.add(desktopPane);
		
		JLabel lblNewLabel_2 = new JLabel("Equipment Name:");
		lblNewLabel_2.setBounds(36, 202, 103, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Condition:");
		lblNewLabel_3.setBounds(36, 252, 83, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Room:");
		lblNewLabel_3_1.setBounds(36, 301, 83, 14);
		panel.add(lblNewLabel_3_1);
	}

	    public String [] fetchEquipmentName() {
		String url = "jdbc:mysql://localhost:3306/equipment_management_db";
	    String username = "root";
	    String password = "09242003Believeitcovered.";
	    String equipmentName[] = new String[5];
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT equipmentName FROM equipment WHERE eqStatus != 'In Storage'";
			PreparedStatement stmt = connection.prepareStatement(query);	
			ResultSet rs = stmt.executeQuery();
			
			int counter = 0;
			while(rs.next()) {
				equipmentName[counter] = rs.getString("equipmentName");
				System.out.println(equipmentName[counter]);
				counter++;
			}
		} catch (SQLException e1) {
	        e1.printStackTrace();
	    }
		
		
		return equipmentName;
		
	}
	public void setUserData(String firstName, String lastName, String username, String role) {
		// TODO Auto-generated method stub
		
	}
	
	public String getuserInfo() {
		AuthenticationForm authForm = new AuthenticationForm();
		
		return authForm.getName();
	}
}
