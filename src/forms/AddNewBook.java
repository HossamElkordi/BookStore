package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddNewBook extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private Controller control;
	private JFrame parent;
	private JFrame thisFrame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddNewBook(JFrame parent) {
		this.parent = parent;
		control = Controller.getControl();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewBook.class.getResource("/Icon/logo.jpg")));
		setTitle("Add Book");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				parent.setVisible(true); thisFrame.dispose();
			}
		});
		setBounds(100, 100, 750, 441);
		getContentPane().setLayout(null);
		thisFrame = this;

		textField = new JTextField();
		textField.setBounds(170, 32, 210, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(170, 78, 210, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(170, 124, 210, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(27, 32, 120, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(27, 78, 120, 14);
		getContentPane().add(lblTitle);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(27, 124, 120, 14);
		getContentPane().add(lblPublisher);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 170, 210, 20);
		getContentPane().add(textField_3);

		JLabel lblPublicationYear = new JLabel("Publication Year");
		lblPublicationYear.setBounds(27, 170, 120, 14);
		getContentPane().add(lblPublicationYear);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(170, 216, 210, 20);
		getContentPane().add(textField_4);

		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setBounds(27, 216, 120, 14);
		getContentPane().add(lblSellingPrice);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(170, 262, 210, 20);
		getContentPane().add(textField_5);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(27, 262, 120, 14);
		getContentPane().add(lblQuantity);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(170, 308, 210, 20);
		getContentPane().add(textField_6);

		JLabel lblMinQuantity = new JLabel("Min Quantity");
		lblMinQuantity.setBounds(27, 308, 120, 14);
		getContentPane().add(lblMinQuantity);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(27, 354, 120, 14);
		getContentPane().add(lblCategory);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Art", "Science", "Religion", "History", "Geography"}));
		comboBox.setBounds(170, 354, 210, 22);
		getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Authors");
		lblNewLabel_1.setBounds(436, 26, 101, 14);
		getContentPane().add(lblNewLabel_1);

		JTextArea lblNewLabel_2 = new JTextArea();
		lblNewLabel_2.setBounds(522, 26, 191, 109);
		lblNewLabel_2.setEditable(false);
		getContentPane().add(lblNewLabel_2);


		textField_7 = new JTextField();
		textField_7.setBounds(555, 148, 158, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Add Author");
		lblNewLabel_1_1.setBounds(436, 151, 101, 14);
		getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.addAuthor("'" + textField_7.getText() + "'");
				lblNewLabel_2.setText(lblNewLabel_2.getText() + textField_7.getText()+"\n");
				textField_7.setText("");
			}
		});
		btnNewButton.setBounds(555, 179, 158, 32);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Insert Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.setTable("Book");
				control.addAtribute("'" + textField.getText() + "'");
				control.addAtribute("'" + textField_1.getText() + "'");
				control.addAtribute("'" + textField_2.getText() + "'");
				control.addAtribute(textField_3.getText());
				control.addAtribute("'" + comboBox.getItemAt(comboBox.getSelectedIndex()) + "'");
				control.addAtribute("'" + textField_4.getText() + "'");
				control.addAtribute(textField_5.getText());
				control.addAtribute(textField_6.getText());
				try {
					control.executeQuerry("insert");
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(555, 356, 158, 32);
		getContentPane().add(btnNewButton_1);
		setVisible(true);
	}
}
