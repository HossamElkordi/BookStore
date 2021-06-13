package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import userOperations.SearchForBooks;
import userOperations.BookOrder;

import basicInterfaces.UserOperationInterface;

public class PlaceOrder extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField_1;
	private SearchForBooks sb;
	private ResultSet rs;
	private String ISBN_fromInput;
	private BookOrder bo;
	private int numOfBooks;

	/**
	 * Create the frame.
	 */
	public PlaceOrder(JFrame parent) {
		thisFrame = this;
		setVisible(true);

		numOfBooks = 0;
		ISBN_fromInput = "";

		setIconImage(Toolkit.getDefaultToolkit().getImage(PlaceOrder.class.getResource("/Icon/logo.jpg")));
		setTitle("Place Order");
		
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
		
		textField = new JTextField();
		textField.setBounds(39, 58, 233, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(39, 33, 86, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb = new SearchForBooks();
				ArrayList<String> list = new ArrayList<>();
				list.add("*");
				list.add("Book");
				list.add("ISBN = "+textField.getText());
				ISBN_fromInput = textField.getText();
				rs = sb.execute(list);
				try {
					numOfBooks = Integer.parseInt(rs.getString("Quantity"));
					setTableModel(rs);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(417, 48, 134, 32);
		contentPane.add(btnNewButton);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(10, 115, 714, 43);
		getContentPane().add(tableScrollPane);

		model = new DefaultTableModel();
		//setTableModel(rs);
		table = new JTable();
		table.setModel(model);
		tableScrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numOfBooks < Integer.parseInt(textField_1.getText())){
					throw new IllegalArgumentException("Invalid Quantity");
				}
				bo = new BookOrder();
				ArrayList<String> list = new ArrayList<>();
				list.add(ISBN_fromInput);
				list.add(textField_1.getText());
				bo.execute(list);
			}
		});
		btnNewButton_1.setBounds(417, 239, 134, 32);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(39, 251, 233, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(39, 226, 101, 14);
		contentPane.add(lblQuantity);
		setVisible(true);
	}
	
	// SHOULD BE CHANGED
	private void setTableModel(ResultSet r) throws SQLException {
		if(r == null){
			System.out.println("r is null");
			return;
		}
		model.setRowCount(0);
		String[] ids = {"ISBN", "Title", "Publisher", "Publication Year","Category",  "Selling Price", "Quantity", "Min Quantity"};
		model.setColumnIdentifiers(ids);
		Object[] data = new Object[8];
		if(r.next()){
			for(int i = 0; i < 8; i++){
				data[i] = r.getString(ids[i]);
			}
		}
		model.addRow(data);
	}

}
