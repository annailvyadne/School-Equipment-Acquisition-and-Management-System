package MyApps;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipmentControlSystem extends JFrame {

    private JPanel contentPane;
    private JTable equipmentTable;
    private DefaultTableModel tableModel;
    
    //LAUNCH THE APPLICATION
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentControlSystem frame = new EquipmentControlSystem();
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
	public EquipmentControlSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create the table model
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Equipment Name");
		tableModel.addColumn("Equipment Type");
		tableModel.addColumn("Condition");
		tableModel.addColumn("Room");
		
		equipmentTable = new JTable(tableModel);
		
		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(equipmentTable);
		scrollPane.setBounds(28, 196, 466, 100);
		contentPane.add(scrollPane);

		// Fetch and populate data from the database
		fetchAndPopulateData();

		// "Equipment Condition Report" button
		JButton btnReports = new JButton("Equipment Condition Report");
		btnReports.setBounds(28, 74, 190, 23);
		contentPane.add(btnReports);

        addWindowListener((WindowListener) new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            	fetchAndPopulateData();
                System.out.println("Frame is loaded.");
            }
        });

	
		JButton btnNewButton = new JButton("Acquire from Suppliers");
		btnNewButton.setBounds(28, 40, 190, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReports1 = new JButton("Equipment Condition Report");
		btnReports1.setBounds(28, 74, 190, 23);
		contentPane.add(btnReports1);
		
		JButton btnTransactionReport = new JButton("Transaction Report");
		btnTransactionReport.setBounds(263, 40, 190, 23);
		contentPane.add(btnTransactionReport);
		
		JButton btnEquipmentAssignmentTo = new JButton("Equipment Assignment to Room");
		btnEquipmentAssignmentTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EquipmentAssignmentToRoom equipmentToRoom = new EquipmentAssignmentToRoom();
				
				equipmentToRoom.setVisible(true);
				dispose();
			}
		});
		
		/*
		 * 		    public void actionPerformed(ActionEvent e) {
		        // Create an instance of the AuthenticationForm class
		        AuthenticationForm authForm = new AuthenticationForm();

		        // Make the AuthenticationForm visible
		        authForm.setVisible(true);

		        // Close the current SignUpAuthenticationForm
		        dispose(); // To completely close the sign-up form
		    }
		 */
		
		
		btnEquipmentAssignmentTo.setBounds(28, 172, 190, 23);
		contentPane.add(btnEquipmentAssignmentTo);
		
		JButton btnViewUsersAccounts = new JButton("View Users Accounts");
		btnViewUsersAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewUsersAccounts.setBounds(28, 110, 190, 23);
		contentPane.add(btnViewUsersAccounts);
		
		JButton btnEquipmentAssignmentTo_1_1 = new JButton("Audit Trails");
		btnEquipmentAssignmentTo_1_1.setBounds(263, 110, 190, 23);
		contentPane.add(btnEquipmentAssignmentTo_1_1);
	}


	private void fetchAndPopulateData() {
	    // Database connection details

	    String url = "jdbc:mysql://localhost:3306/equipment_management_db";
	    String username = "root";
	    String password = "09242003Believeitcovered.";

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT * FROM Equipment";
	        System.out.println("Connected Successfully");
	        
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        // Clear any existing data from the table
	        tableModel.setRowCount(0);

	        while (resultSet.next()) {
	        	System.out.println("Success");
	
	            String equipmentName = resultSet.getString("equipmentName");
	            String equipmentType = resultSet.getString("equipmentType");
	            String condition = resultSet.getString("equipmentCondition");

	            // Add the retrieved data to the JTable
	            tableModel.addRow(new Object[]{equipmentName, equipmentType, condition});
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
