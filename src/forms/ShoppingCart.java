package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCart frame = new ShoppingCart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShoppingCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			}
		});
		btnCheckout.setBounds(500, 340, 186, 32);
		contentPane.add(btnCheckout);
		
		JLabel lblTotalPrice = new JLabel("Total Price: $100");
		lblTotalPrice.setBounds(350, 340, 186, 32);
		contentPane.add(lblTotalPrice);
		
		JButton btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.setBounds(40, 340, 186, 32);
		contentPane.add(btnRemoveFromCart);
		
		JLabel lblShoppingCart = new JLabel("Shopping Cart");
		lblShoppingCart.setBounds(300, 10, 186, 32);
		contentPane.add(lblShoppingCart);
	}
	
	private void setTableModel(ResultSet rs) {
		model.setRowCount(0);
		String[] ids = {"Title", "Publication Year","Category",  "Price", "Quantity", "Total Price"};
		model.setColumnIdentifiers(ids);
		
		for (int i = 0; i < 10; i++) {
			Object[] data = new Object[6];
			data[0] = "Harry Potter";
			data[1] = "2020";
			data[2] = "Novel";
			data[3] = "$20";
			data[4] = "4";
			data[5] = "$80";
			model.addRow(data);
		}
	}
}
