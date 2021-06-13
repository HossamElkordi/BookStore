package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

import userOperations.PromoteUser;

public class PromoteCustomers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel model;
	private JFrame thisFrame;
	private Controller control;
	private ResultSet rs;
	private ArrayList<String> Usernames;
	private PromoteUser pu;

	/**
	 * Create the frame.
	 */
	public PromoteCustomers(JFrame parent) {
		
		thisFrame = this;
		setVisible(true);

		control = Controller.getControl();
		rs = null;
		Usernames = new ArrayList<>();

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
				control.setTable("User");
				if(chckbxNewCheckBox.isSelected()) control.setCondition("UserName='" + textField.getText() + "'");
				if(chckbxTitle.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("FName='" + textField_1.getText() + "'");
					else control.setCondition(control.getCondition() + " and FName='" + textField_1.getText() + "'");
				}
				if(chckbxPublisher.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("LName='" + textField_2.getText() + "'");
					else control.setCondition(control.getCondition() + " and LName='" + textField_2.getText() + "'");
				}
				if(chckbxNewCheckBox_3_1.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Email='" + textField_3.getText() + "'");
					else control.setCondition(control.getCondition() + " and Email='" + textField_3.getText() + "'");
				}
				try {
					rs = control.executeQuerry("search");
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				assert rs != null;
				try {
					setTableModel(rs);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(370, 88, 186, 23);
		getContentPane().add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 141, 734, 203);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		//setTableModel(null);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);
		
		JButton btnPromote = new JButton("Promote");
		btnPromote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				assert(rs != null);
				pu = new PromoteUser();
				pu.execute(Usernames);
			}
		}
		);
		btnPromote.setBounds(273, 355, 126, 23);
		getContentPane().add(btnPromote);

		setVisible(true);
	}
	
	private void setTableModel(ResultSet rs) throws SQLException {
		assert(rs != null);
		model.setRowCount(0);
		String[] ids = {"Username", "FName", "LName", "Email","Phone Number", "Shipping Address"};
		model.setColumnIdentifiers(ids);
		while(rs.next()){
			Object[] data = new Object[6];
			for (int i = 0; i < 6; i++) {
				data[0] = rs.getString("UserName");
				data[1] = rs.getString(ids[1]);
				data[2] = rs.getString(ids[2]);
				data[3] = rs.getString(ids[3]);
				data[4] = rs.getString(ids[4]);
				data[5] = rs.getString(ids[5]);
			}
			model.addRow(data);
			Usernames.add(rs.getString("UserName"));
		}
	}

}
