package forms;

import userOperations.Book;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ShoppingCart extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JFrame thisFrame;
	private userOperations.ShoppingCart MyCart;

	/**
	 * Create the frame.
	 */
	public ShoppingCart(JFrame parent, userOperations.ShoppingCart MyCart) {
		this.MyCart = MyCart;
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShoppingCart.class.getResource("/Icon/logo.jpg")));
		setTitle("Shopping Cart");
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 714, 271);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		setTableModel(null);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyCart.Checkout();
			}
		});
		btnCheckout.setBounds(500, 340, 186, 32);
		contentPane.add(btnCheckout);
		
		JLabel lblTotalPrice = new JLabel("Total Price: $"+getTotal());
		lblTotalPrice.setBounds(350, 340, 186, 32);
		contentPane.add(lblTotalPrice);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyCart.getCart().remove(table.getSelectedRow());
			}
		});
		btnRemoveFromCart.setBounds(40, 340, 186, 32);
		contentPane.add(btnRemoveFromCart);
		
		JLabel lblShoppingCart = new JLabel("Shopping Cart");
		lblShoppingCart.setBounds(300, 10, 186, 32);
		contentPane.add(lblShoppingCart);

	}

	private String getTotal()
	{
		long total = 0;
		for(Book book: MyCart.getCart())
			total+=book.getQuantity()*Integer.parseInt(book.getPrice());
		return String.valueOf(total);
	}
	private void setTableModel(ResultSet rs) {
		model.setRowCount(0);
		String[] ids = {"Title", "Publication Year","Category",  "Price", "Quantity", "Total Price"};
		model.setColumnIdentifiers(ids);
		
		for (Book book:MyCart.getCart()) {
			Object[] data = new Object[6];
			data[0] = book.getTitle();
			data[1] = book.getPublicationYear();
			data[2] = book.getCategory();
			data[3] = book.getPrice();
			data[4] = book.getQuantity();
			data[5] = Integer.parseInt(book.getCategory())*book.getQuantity();
			model.addRow(data);
		}
	}
}
