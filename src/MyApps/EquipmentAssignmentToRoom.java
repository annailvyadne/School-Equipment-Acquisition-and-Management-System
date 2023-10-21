package MyApps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EquipmentAssignmentToRoom extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EquipmentAssignmentToRoom frame = new EquipmentAssignmentToRoom();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EquipmentAssignmentToRoom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Use a layout manager or adjust the layout as needed
        
        // Equipment list 
        String[] putEquipmentItems = fetchEquipment();
        JComboBox<String> equipmentComboBox = new JComboBox<>(putEquipmentItems);
        equipmentComboBox.insertItemAt("Select an equipment", 0);
        equipmentComboBox.setSelectedIndex(0);
        equipmentComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedOption = (String) equipmentComboBox.getSelectedItem();
        	}
        });
        
        equipmentComboBox.setBounds(140, 50, 150, 30);
        contentPane.add(equipmentComboBox);
        String putRoomItems[] = fetchRoom();
        
        JComboBox<String> roomComboBox = new JComboBox<>(putRoomItems);
        roomComboBox.insertItemAt("Select an item",0);
        roomComboBox.setSelectedIndex(0);
        roomComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selectedRoom = (String) roomComboBox.getSelectedItem();
        	}
        });
        
        roomComboBox.setBounds(140, 100, 150, 30);
        contentPane.add(roomComboBox);

        JButton assignButton = new JButton("Assign Equipment");
        assignButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                
        		EquipmentControlSystem EquipmentSystem = new EquipmentControlSystem();
        		EquipmentSystem.setVisible(true);
        		dispose();
        		
        	}
        });
        assignButton.setBounds(140, 150, 150, 30);
        contentPane.add(assignButton);

        JLabel equipmentLabel = new JLabel("Select Equipment:");
        equipmentLabel.setBounds(30, 50, 100, 30);
        contentPane.add(equipmentLabel);

        JLabel roomLabel = new JLabel("Select Room:");
        roomLabel.setBounds(30, 100, 100, 30);
        contentPane.add(roomLabel);
        
        JLabel lblNewLabel = new JLabel("Equipment Assignment to Room");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 11, 269, 14);
        contentPane.add(lblNewLabel);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(equipmentComboBox.getSelectedIndex() == 0) {
                	JOptionPane.showMessageDialog(null, "Please select an equipment");
                	
                } else if(roomComboBox.getSelectedIndex() == 0) {
                	JOptionPane.showMessageDialog(null, "Please select a room");
                }
                
                
                
                String url = "jdbc:mysql://localhost:3306/equipment_management_db";
        	    String username = "root";
        	    String password = "09242003Believeitcovered.";

        	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	    	
        	    	String selectedEquipment = (String) equipmentComboBox.getSelectedItem();
        	    	System.out.println(selectedEquipment);
                    String query = "SELECT idEquipmentID FROM equipment WHERE equipmentName = '" + selectedEquipment + "';";
        	    	
        	    	 PreparedStatement statement = connection.prepareStatement(query);
        	    	 System.out.println(query);
         	         ResultSet resultSet = statement.executeQuery();
         	         int equipmentID = resultSet.getInt("idEquipmentID");
         	         System.out.println(equipmentID);
         	         String selectedRoom = (String) roomComboBox.getSelectedItem();
         	         query = "SELECT roomID FROM Room WHERE roomName = '" + selectedRoom + "';";
         	        statement = connection.prepareStatement(query);
         	        resultSet = statement.executeQuery();
         	        int roomID = resultSet.getInt("roomID");
         	        
         	        query = "INSERT INTO Equipment_has_Room(idEquipmentID,Room_RoomID) VALUES("+ equipmentID + "," + roomID + ")";
         	        statement = connection.prepareStatement(query);
         	        resultSet = statement.executeQuery();
         	        System.out.println(equipmentID);
         	        System.out.println(roomID);
         	         
        	    } catch (SQLException e1) {
        	        e1.printStackTrace();
        	    }
        	    
              
               
        
            }
        });
    }
 
    
    private String[] fetchEquipment() {
	    // Database connection details

	    String url = "jdbc:mysql://localhost:3306/equipment_management_db";
	    String username = "root";
	    String password = "09242003Believeitcovered.";
	    String EquipmentName[] = new String[5];
	   
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT equipmentName FROM Equipment";
	        System.out.println("Connected Successfully");
	        
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        int counter = 0;
	        while (resultSet.next()) {
	        	System.out.println("Success");
	            String equipmentName = resultSet.getString("equipmentName");
	            EquipmentName[counter] = equipmentName;
	        
	            counter++;
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return EquipmentName;
	}
    
    //FUNCTION FOR ROOMS
    private String[] fetchRoom() {
	    // Database connection details

	    String url = "jdbc:mysql://localhost:3306/equipment_management_db";
	    String username = "root";
	    String password = "09242003Believeitcovered.";
	    String RoomName[] = new String[3];
	   
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT RoomName FROM Room";
	        System.out.println("Connected Successfully");
	        
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        int counter = 0;
	
	        while (resultSet.next()) {
	        	System.out.println("Success");
	            String AssignedRoomName = resultSet.getString("RoomName");
	            RoomName[counter] = AssignedRoomName;
	        
	            counter++;
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return RoomName;
	}
}
