package forms;

import userOperations.Book;
import userOperations.LogIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Shopping extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel model;
	private JFrame thisFrame;
	private Controller control;



	/**
	 * Create the frame.
	 */
	public Shopping(JFrame parent, userOperations.ShoppingCart MyCart,LogIn User) {
		
		thisFrame = this;
		control = Controller.getControl();
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Shopping.class.getResource("/Icon/logo.jpg")));
		setTitle("Shopping");
		
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				parent.setVisible(true); thisFrame.dispose();
			}
		});
		
		setTitle("Shopping");
		setBounds(100, 100, 750, 441);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 33, 207, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("ISBN");
		chckbxNewCheckBox.setBounds(223, 33, 97, 23);
		getContentPane().add(chckbxNewCheckBox);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 61, 207, 20);
		getContentPane().add(textField_1);

		JCheckBox chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setBounds(223, 61, 97, 23);
		getContentPane().add(chckbxTitle);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 89, 207, 20);
		getContentPane().add(textField_2);

		JCheckBox chckbxPublisher = new JCheckBox("Publisher");
		chckbxPublisher.setBounds(223, 89, 97, 23);
		getContentPane().add(chckbxPublisher);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(370, 34, 186, 20);
		getContentPane().add(textField_3);

		JCheckBox chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setBounds(569, 33, 97, 23);
		getContentPane().add(chckbxAuthor);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Art", "Science", "Religion", "History", "Geography"}));
		comboBox.setBounds(370, 61, 186, 22);
		getContentPane().add(comboBox);

		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("Category");
		chckbxNewCheckBox_3_1.setBounds(569, 61, 97, 23);
		getContentPane().add(chckbxNewCheckBox_3_1);

		JLabel lblNewLabel = new JLabel("Please Select Filters");
		lblNewLabel.setBounds(273, 3, 126, 23);
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
				try {
					rs = control.executeQuerry("search");
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				setTableModel(rs);
			}
		});
		btnNewButton.setBounds(370, 88, 186, 23);
		getContentPane().add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(0, 141, 734, 207);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		setTableModel(null);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantity=JOptionPane.showInputDialog(parent,
						"Enter the quantity", null);
				try
				{
					int NumberOfBooks =Integer.parseInt(quantity);
					int Row= table.getSelectedRow();
					MyCart.AddToCart(new Book(model.getValueAt(Row,0).toString(),NumberOfBooks,model.getValueAt(Row,1).toString(),model.getValueAt(Row,2).toString(),model.getValueAt(Row,3).toString(),model.getValueAt(Row,4).toString(),model.getValueAt(Row,5).toString()));
				}catch (Exception E)
				{
					E.printStackTrace();
				}

			}
		});
		btnAddToCart.setBounds(370, 359, 186, 32);
		getContentPane().add(btnAddToCart);
		
		JButton btnViewCart = new JButton("View Cart");
		btnViewCart.setBounds(130, 359, 186, 32);
		btnViewCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ShoppingCart(thisFrame,MyCart,User);
			}
		});
		getContentPane().add(btnViewCart);
		setVisible(true);
		
	}

	private void setTableModel(ResultSet rs){
		if(rs != null) {
			model.setRowCount(0);
			String[] ids = {"ISBN", "Title", "Publisher", "Publication Year","Category",  "Selling Price", "Available Quantity"};
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
					model.addRow(data);
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
}
