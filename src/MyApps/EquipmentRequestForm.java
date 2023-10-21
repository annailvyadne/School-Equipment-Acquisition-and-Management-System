package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class EquipmentRequestForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtEquipmentName;
	private JTextField txtEquipmentType;
	private JTextField txtCondition;
	private JTextField txtRoom;

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
		
		JTextPane tp_fname = new JTextPane();
		tp_fname.setText("Michelle Dee");
		tp_fname.setBounds(143, 73, 106, 20);
		panel.add(tp_fname);
		
		JTextPane tp_Username = new JTextPane();
		tp_Username.setText("Michelle Dee@example.com");
		tp_Username.setBounds(143, 104, 173, 20);
		panel.add(tp_Username);
		
		JTextPane tp_Role = new JTextPane();
		tp_Role.setText("Student");
		tp_Role.setBounds(143, 135, 173, 20);
		panel.add(tp_Role);
		
		txtEquipmentName = new JTextField();
		txtEquipmentName.setText("Equipment Name:");
		txtEquipmentName.setBounds(36, 199, 99, 20);
		panel.add(txtEquipmentName);
		txtEquipmentName.setColumns(10);
		
		txtEquipmentType = new JTextField();
		txtEquipmentType.setText("Equipment Type:");
		txtEquipmentType.setColumns(10);
		txtEquipmentType.setBounds(36, 246, 99, 20);
		panel.add(txtEquipmentType);
		
		txtCondition = new JTextField();
		txtCondition.setText("Condition:");
		txtCondition.setColumns(10);
		txtCondition.setBounds(36, 292, 99, 20);
		panel.add(txtCondition);
		
		txtRoom = new JTextField();
		txtRoom.setText("Room:");
		txtRoom.setColumns(10);
		txtRoom.setBounds(36, 335, 99, 20);
		panel.add(txtRoom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aircon", "Television", "Monitor", "Table", "Chair"}));
		comboBox.setBounds(185, 198, 153, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Electronics", "Appliances", "Furnitures"}));
		comboBox_1.setBounds(185, 245, 153, 22);
		panel.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Not Working", "Needs Repair"}));
		comboBox_1_1.setBounds(185, 291, 153, 22);
		panel.add(comboBox_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"MPO301", "MPO302", "MPO303"}));
		comboBox_1_1_1.setBounds(185, 334, 153, 22);
		panel.add(comboBox_1_1_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(121, 382, 89, 23);
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
	}
}
