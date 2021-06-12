package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PromoteCustomers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel model;
	private JFrame thisFrame;

	/**
	 * Create the frame.
	 */
	public PromoteCustomers(JFrame parent) {
		
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PromoteCustomers.class.getResource("/Icon/logo.jpg")));
		setTitle("Promote Customers");
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				parent.setVisible(true); thisFrame.dispose();
			}
		});
		
		setBounds(100, 100, 750, 441);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 33, 207, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Username");
		chckbxNewCheckBox.setBounds(223, 33, 97, 23);
		getContentPane().add(chckbxNewCheckBox);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 61, 207, 20);
		getContentPane().add(textField_1);

		JCheckBox chckbxTitle = new JCheckBox("First Name");
		chckbxTitle.setBounds(223, 61, 97, 23);
		getContentPane().add(chckbxTitle);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 89, 207, 20);
		getContentPane().add(textField_2);

		JCheckBox chckbxPublisher = new JCheckBox("Last Name");
		chckbxPublisher.setBounds(223, 89, 97, 23);
		getContentPane().add(chckbxPublisher);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(370, 34, 186, 20);
		getContentPane().add(textField_3);

		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("Email Address");
		chckbxNewCheckBox_3_1.setBounds(569, 34, 180, 23);
		getContentPane().add(chckbxNewCheckBox_3_1);

		JLabel lblNewLabel = new JLabel("Search for Customer");
		lblNewLabel.setBounds(273, 3, 126, 23);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				
			}
		});
		btnNewButton.setBounds(370, 88, 186, 23);
		getContentPane().add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 141, 734, 203);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		setTableModel(null);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);
		
		JButton btnPromote = new JButton("Promote");
		btnPromote.setBounds(273, 355, 126, 23);
		getContentPane().add(btnPromote);

		setVisible(true);
	}
	
	private void setTableModel(ResultSet rs) {
			model.setRowCount(0);
			String[] ids = {"Username", "First Name", "Last Name", "Email Address","Phone Number",  "Address"};
			model.setColumnIdentifiers(ids);
			for (int i = 0; i < 50; i++) {
				Object[] data = new Object[6];
				data[0] = "YoussefSherif98";
				data[1] = "Youssef";
				data[2] = "Kamel";
				data[3] = "youssef.sherif111998@gmail.com";
				data[4] = "01270563512";
				data[5] = "56 ElDobat Buildings, Mostafa Kamel";
				model.addRow(data);
			}
	}

}
