package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchForBooks extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel model;
	private Controller control;
	private JFrame parent;
	private JFrame thisFrame;

	/**
	 * Create the frame.
	 */
	public SearchForBooks(JFrame parent) {
		this.parent = parent;
		control = Controller.getControl();
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchForBooks.class.getResource("/Icon/logo.jpg")));
		setTitle("Search");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				parent.setVisible(true); thisFrame.dispose();
			}
		});
		setBounds(100, 100, 518, 441);
		getContentPane().setLayout(null);
		thisFrame = this;

		textField = new JTextField();
		textField.setBounds(10, 33, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("ISBN");
		chckbxNewCheckBox.setBounds(109, 32, 97, 23);
		getContentPane().add(chckbxNewCheckBox);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 61, 86, 20);
		getContentPane().add(textField_1);

		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setBounds(109, 60, 97, 23);
		getContentPane().add(chckbxTitle);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 89, 86, 20);
		getContentPane().add(textField_2);

		JCheckBox chckbxPublisher = new JCheckBox("Publisher");
		chckbxPublisher.setBounds(109, 88, 97, 23);
		getContentPane().add(chckbxPublisher);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 34, 86, 20);
		getContentPane().add(textField_3);

		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setBounds(324, 33, 97, 23);
		getContentPane().add(chckbxAuthor);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Art", "Science", "Religion", "History", "Geography"}));
		comboBox.setBounds(225, 61, 86, 22);
		getContentPane().add(comboBox);

		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("Category");
		chckbxNewCheckBox_3_1.setBounds(324, 61, 97, 23);
		getContentPane().add(chckbxNewCheckBox_3_1);

		JLabel lblNewLabel = new JLabel("Please Secelct Filters");
		lblNewLabel.setBounds(194, 11, 114, 14);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				control.setTable("Book");
				control.addAtribute("*");
				if(chckbxNewCheckBox.isSelected()) control.setCondition("ISBN='" + textField.getText() + "'");
				if(chckbxTitle.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Title='" + textField_1.getText() + "'");
					else control.setCondition(control.getCondition() + " and Title='" + textField_1.getText() + "'");
				}
				if(chckbxPublisher.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Publisher='" + textField_2.getText() + "'");
					else control.setCondition(control.getCondition() + " and Publisher='" + textField_2.getText() + "'");
				}
				if(chckbxAuthor.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Author='" + textField_3.getText() + "'");
					else control.setCondition(control.getCondition() + " and Author='" + textField_3.getText() + "'");
				}
				if(chckbxNewCheckBox_3_1.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Category='" + comboBox.getItemAt(comboBox.getSelectedIndex()) + "'");
					else control.setCondition(control.getCondition() + " and Category='" + comboBox.getItemAt(comboBox.getSelectedIndex()) + "'");
				}
				rs = control.executeQuerry("search");
				setTableModel(rs);
			}
		});
		btnNewButton.setBounds(225, 88, 86, 23);
		getContentPane().add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 141, 502, 260);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		setTableModel(null);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);

//		table = new JTable();
//		table.setBounds(0, 401, 502, -260);
//		getContentPane().add(table);
		setVisible(true);
	}

	private void setTableModel(ResultSet rs){
		if(rs != null) {
			model.setRowCount(0);
			String[] ids = {"ISBN", "Title", "Publisher", "Publication Year","Category",  "Selling Price", "Quantity", "Min Quantity"};
			model.setColumnIdentifiers(ids);
			int size =0;
			try {
				while(rs.next()){
					Object[] data = new Object[8];
					data[0] = rs.getString("ISBN");
					data[1] = rs.getString("Title");
					data[2] = rs.getString("Publisher");
					data[3] = rs.getString("Publication Year");
					data[4] = rs.getString("Category");
					data[5] = rs.getString("Selling Price");
					data[6] = rs.getString("Quantity");
					data[7] = rs.getString("Threshold");
					model.addRow(data);
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
}
