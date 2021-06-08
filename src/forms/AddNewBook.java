package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewBook extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;



	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddNewBook() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewBook.class.getResource("/Icon/logo.jpg")));
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 441);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(133, 26, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(133, 72, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(133, 118, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(52, 32, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(52, 78, 46, 14);
		getContentPane().add(lblTitle);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(52, 124, 46, 14);
		getContentPane().add(lblPublisher);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 164, 86, 20);
		getContentPane().add(textField_3);

		JLabel lblPublicationYear = new JLabel("Publication Year");
		lblPublicationYear.setBounds(52, 170, 86, 14);
		getContentPane().add(lblPublicationYear);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 210, 86, 20);
		getContentPane().add(textField_4);

		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setBounds(52, 216, 71, 14);
		getContentPane().add(lblSellingPrice);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(133, 256, 86, 20);
		getContentPane().add(textField_5);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(52, 262, 71, 14);
		getContentPane().add(lblQuantity);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(133, 302, 86, 20);
		getContentPane().add(textField_6);

		JLabel lblMinQuantity = new JLabel("Min Quantity");
		lblMinQuantity.setBounds(52, 308, 71, 14);
		getContentPane().add(lblMinQuantity);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(52, 354, 71, 14);
		getContentPane().add(lblCategory);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Art", "Science", "Religion", "History", "Geography"}));
		comboBox.setBounds(133, 348, 86, 22);
		getContentPane().add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Authors");
		lblNewLabel_1.setBounds(286, 29, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(342, 29, 150, 109);
		getContentPane().add(lblNewLabel_2);

		textField_7 = new JTextField();
		textField_7.setBounds(375, 151, 86, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Add Author");
		lblNewLabel_1_1.setBounds(286, 154, 71, 14);
		getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(375, 182, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Insert Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(403, 368, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
}
