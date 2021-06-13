package forms;

import userOperations.LogIn;
import userOperations.ShoppingCart;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFrame thisFrame;

	/**
	 * Create the frame.
	 */
	public SignIn(JFrame parent) {
		
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignIn.class.getResource("/Icon/logo.jpg")));
		setTitle("Sign In");
		
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
		textField.setBounds(250, 80, 200, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 130, 200, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(168, 80, 150, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(168, 130, 150, 14);
		contentPane.add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(250, 190, 200, 30);
		contentPane.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LogIn Person = new LogIn();
				try {
					if(Person.CheckCredentials(textField.getText(),textField_1.getText()))
					{
						if(Person.getUserType().equals("Customer"))
							new Customer(Person,new ShoppingCart());
						else
							new Manager(Person,new ShoppingCart());
					}
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		
		
	}
}
