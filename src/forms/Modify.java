package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modify extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private Controller control;
	private JFrame parent;
	private JFrame thisFrame;

	/**
	 * Create the frame.
	 */
	public Modify(JFrame parent) {
		this.parent = parent;
		control = Controller.getControl();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modify.class.getResource("/Icon/logo.jpg")));
		setTitle("Modify");
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

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 168, 86, 20);
		getContentPane().add(textField_3);

		JLabel lblNewLabel = new JLabel("Please Secelct Filters");
		lblNewLabel.setBounds(194, 11, 114, 14);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setTable("Book");
				if(chckbxNewCheckBox.isSelected()) control.setCondition("ISBN='" + textField.getText() + "'");
				if(chckbxTitle.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Title='" + textField_1.getText() + "'");
					else control.setCondition(control.getCondition() + " and Title='" + textField_1.getText() + "'");
				}
				ResultSet rs = control.executeQuerry("search");
				try {
					rs.next();
					textField_3.setText("" + Integer.parseInt(rs.getString("Quantity")));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(222, 88, 86, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setBounds(30, 174, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setTable("Book");
				control.addAtribute("Quantity=" + textField_3.getText());
				if(chckbxNewCheckBox.isSelected()) control.setCondition("ISBN='" + textField.getText() + "'");
				if(chckbxTitle.isSelected()) {
					if(control.getCondition().isEmpty()) control.setCondition("Title='" + textField_1.getText() + "'");
					else control.setCondition(control.getCondition() + " and Title='" + textField_1.getText() + "'");
				}
				control.executeQuerry("update");
			}
		});
		btnSave.setBounds(222, 167, 86, 23);
		getContentPane().add(btnSave);
		setVisible(true);
	}
}
