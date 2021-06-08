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

public class SearchForBooks extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public SearchForBooks() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchForBooks.class.getResource("/Icon/logo.jpg")));
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 441);
		getContentPane().setLayout(null);

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

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Art", "Science", "Religion", "History", "Geography"}));
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
			}
		});
		btnNewButton.setBounds(225, 88, 86, 23);
		getContentPane().add(btnNewButton);

		table = new JTable();
		table.setBounds(0, 401, 502, -260);
		getContentPane().add(table);
	}
}
