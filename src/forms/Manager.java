package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicInterfaces.Homepage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		
		thisFrame = this;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manager.class.getResource("/Icon/logo.jpg")));
		setTitle("Manager Operations");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBooks = new JButton("Add new books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddNewBook(thisFrame);
			}
		});
		btnAddBooks.setBounds(267, 50, 214, 23);
		contentPane.add(btnAddBooks);
		
		JButton btnModifyBooks = new JButton("Modify existing books");
		btnModifyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Modify(thisFrame);
			}
		});
		btnModifyBooks.setBounds(267, 80, 214, 23);
		contentPane.add(btnModifyBooks);
		
		JButton btnPlaceOrders = new JButton("Place orders for books");
		btnPlaceOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PlaceOrder(thisFrame);
			}
		});
		btnPlaceOrders.setBounds(267, 110, 214, 23);
		contentPane.add(btnPlaceOrders);
		
		JButton btnConfirmOrders = new JButton("Confirm orders");
		btnConfirmOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Confirm(thisFrame);
			}
		});
		btnConfirmOrders.setBounds(267, 140, 214, 23);
		contentPane.add(btnConfirmOrders);
		
		JButton btnPromote = new JButton("Promote Customers");
		btnPromote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PromoteCustomers(thisFrame);
			}
		});
		btnPromote.setBounds(267, 170, 214, 23);
		contentPane.add(btnPromote);
		
		JButton btnViewReports = new JButton("View Reports");
		btnViewReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ViewReports(thisFrame);
			}
		});
		btnViewReports.setBounds(267, 200, 214, 23);
		contentPane.add(btnViewReports);
		
		
		JButton btnStartShopping = new JButton("Start Shopping");
		btnStartShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Shopping(thisFrame);
			}
		});
		btnStartShopping.setBounds(267, 240, 214, 23);
		contentPane.add(btnStartShopping);
		
		JButton btnEditInformation = new JButton("Edit Information");
		btnEditInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EditInformation(thisFrame);
			}
		});
		btnEditInformation.setBounds(267, 270, 214, 23);
		contentPane.add(btnEditInformation);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		btnLogout.setBounds(267, 300, 214, 23);
		contentPane.add(btnLogout);
	}

}
