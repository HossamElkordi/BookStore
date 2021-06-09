package forms;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Confirm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private Controller control;
	private JFrame parent;
	private JFrame thisFrame;

	public Confirm(JFrame parent) {
		this.parent = parent;
		control = Controller.getControl();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewBook.class.getResource("/Icon/logo.jpg")));
		setTitle("Confirm Orders");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				parent.setVisible(true); thisFrame.dispose();
			}
		});
		setBounds(100, 100, 750, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		thisFrame = this;

		textField = new JTextField();
		textField.setBounds(39, 58, 233, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(39, 35, 86, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setTable("Orders");
				control.setCondition("ISBN = '" + textField.getText() + "'");
				ResultSet rs = control.executeQuerry("search");
				setTableModel(rs);
			}
		});
		btnNewButton.setBounds(417, 35, 111, 32);
		contentPane.add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(10, 115, 714, 43);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		setTableModel(null);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);

//		table = new JTable();
//		table.setBounds(10, 115, 482, 43);
//		contentPane.add(table);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setTable("Orders");
				control.setCondition("ISBN = '" + textField.getText() + "'");
				ResultSet rs = control.executeQuerry("delete");
			}
		});
		btnNewButton_1.setBounds(180, 197, 134, 32);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}

	private void setTableModel(ResultSet rs){
		if(rs != null) {
			model.setRowCount(0);
			String[] ids = {"ISBN", "Quantity"};
			model.setColumnIdentifiers(ids);
			try {
				while(rs.next()){
					Object[] data = new Object[2];
					data[0] = rs.getString("ISBN");
					data[1] = rs.getString("Quantity");
					model.addRow(data);
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
}
