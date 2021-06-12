package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basicInterfaces.Homepage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;

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
		
		thisFrame = this;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Icon/logo.jpg")));
		setTitle("Customer Operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartShopping = new JButton("Start Shopping");
		btnStartShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Shopping(thisFrame);
			}
		});
		btnStartShopping.setBounds(282, 125, 186, 32);
		contentPane.add(btnStartShopping);
		
		JButton btnEditInformation = new JButton("Edit Information");
		btnEditInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EditInformation(thisFrame);
			}
		});
		btnEditInformation.setBounds(282, 175, 186, 32);
		contentPane.add(btnEditInformation);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Homepage();
			}
		});
		btnLogout.setBounds(282, 225, 186, 32);
		contentPane.add(btnLogout);
	}
}
