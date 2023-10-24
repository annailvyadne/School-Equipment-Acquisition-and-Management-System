package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class PurchaseRequestForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseRequestForm frame = new PurchaseRequestForm();
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
	public PurchaseRequestForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 23, 511, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Purchase Request Form");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 11, 213, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Supplier Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(28, 54, 111, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Address:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(28, 79, 90, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Acquire equipment");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(28, 130, 127, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Check out");
		btnNewButton.setBounds(28, 234, 89, 23);
		panel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Airconditioner");
		chckbxNewCheckBox.setBounds(28, 151, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxMonitor = new JCheckBox("Monitor");
		chckbxMonitor.setBounds(28, 184, 97, 23);
		panel.add(chckbxMonitor);
		
		JCheckBox chckbxKeyboard = new JCheckBox("Keyboard");
		chckbxKeyboard.setBounds(152, 151, 97, 23);
		panel.add(chckbxKeyboard);
		
		JCheckBox chckbxTable = new JCheckBox("Table");
		chckbxTable.setBounds(152, 184, 97, 23);
		panel.add(chckbxTable);
		
		JCheckBox chckbxChair = new JCheckBox("Chair");
		chckbxChair.setBounds(285, 151, 97, 23);
		panel.add(chckbxChair);
		
		JLabel lblNewLabel_3 = new JLabel("TechVerse Shop");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(124, 53, 98, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("Makati City, Philippines");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(124, 78, 130, 14);
		panel.add(lblNewLabel_3_2);
	}
	
		//CHECK BOX PROCESS
	//FIELDS
	    private JCheckBox airconCheckBox;
	    private JCheckBox keyboardCheckBox;
	    private JCheckBox monitorCheckBox;
	    private JButton generateReportButton;
		private JCheckBox chairCheckBox;
		private JCheckBox tableCheckBox;
		private JButton checkOutBtn;
	    
	    public void EquipmentAcquisition() {
	    	airconCheckBox = new JCheckBox("Aircon");
	    	keyboardCheckBox = new JCheckBox("Keyboard");
	        monitorCheckBox = new JCheckBox("Monitor");
	        tableCheckBox = new JCheckBox("table");
	        chairCheckBox = new JCheckBox("chair");
	        
	        checkOutBtn = new JButton("Check Out");
	        checkOutBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                CheckOut();
	            }

				private void CheckOut() {
					 boolean isAirconSelected = airconCheckBox.isSelected();
				        boolean isKeyboardSelected = keyboardCheckBox.isSelected();
				        boolean isMonitorSelected = monitorCheckBox.isSelected();
				        boolean isTableSelected = tableCheckBox.isSelected();
				        boolean isChairSelected = chairCheckBox.isSelected();
				        
				        // Generate the report based on selected checkboxes
				        if (isAirconSelected) {
				            // Include Aircon in the report
				        }
				        if (isKeyboardSelected) {
				            // Include Keyboard in the report
				        }
				        if (isMonitorSelected) {
				            // Include Monitor in the report
				        }
				}
	            
	        });
	        
	        add(airconCheckBox);
	        add(keyboardCheckBox);
	        add(monitorCheckBox);
	        add(tableCheckBox);
	        add(chairCheckBox);
	        add(generateReportButton);
	        
	        pack();
	        setLocationRelativeTo(null);	

	    }
	    
	    
	    
}
