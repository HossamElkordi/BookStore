package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Customer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		setTitle("Customer Operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartShopping = new JButton("Start Shopping");
		btnStartShopping.setBounds(282, 125, 186, 32);
		contentPane.add(btnStartShopping);
		
		JButton btnEditInformation = new JButton("Edit Information");
		btnEditInformation.setBounds(282, 175, 186, 32);
		contentPane.add(btnEditInformation);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(282, 225, 186, 32);
		contentPane.add(btnLogout);
	}
}
