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

public class Shopping extends JFrame {

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
	public Shopping(JFrame parent) {
		
		thisFrame = this;
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
		btnAddToCart.setBounds(370, 359, 186, 32);
		getContentPane().add(btnAddToCart);
		
		JButton btnViewCart = new JButton("View Cart");
		btnViewCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ShoppingCart(thisFrame);
			}
		});
		btnViewCart.setBounds(130, 359, 186, 32);
		getContentPane().add(btnViewCart);
		setVisible(true);
		
	}

	private void setTableModel(ResultSet rs) {
		
		model.setRowCount(0);
		String[] ids = {"ISBN", "Title", "Publisher", "Publication Year","Category",  "Selling Price", "Quantity", "Min Quantity"};
		model.setColumnIdentifiers(ids);
		for (int i = 0; i < 50; i++) {
			Object[] data = new Object[8];
			data[0] = "1234";
			data[1] = "Harry Potter";
			data[2] = "Publisher";
			data[3] = "1998";
			data[4] = "Novel";
			data[5] = "$100";
			data[6] = "10";
			data[7] = "50";
			model.addRow(data);
		}
	}
}
