package forms;

import userOperations.LogIn;
import userOperations.ShoppingCart;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField textPassword;
	private JTextField textFirstname;
	private JTextField textLastname;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textAddress;
	private JButton btnSave;
	private JFrame thisFrame;


	/**
	 * Create the frame.
	 */
	public SignUp(JFrame parent) {
		
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Icon/logo.jpg")));
		setTitle("Sign Up");
		
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
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(140, 32, 100, 25);
		contentPane.add(lblUserName);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(250, 32, 200, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 72, 100, 25);
		contentPane.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(250, 72, 200, 25);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(140, 112, 100, 25);
		contentPane.add(lblFirstname);
		
		textFirstname = new JTextField();
		textFirstname.setBounds(250, 112, 200, 25);
		contentPane.add(textFirstname);
		textFirstname.setColumns(10);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setBounds(140, 152, 100, 25);
		contentPane.add(lblLastname);
		
		textLastname = new JTextField();
		textLastname.setBounds(250, 152, 200, 25);
		contentPane.add(textLastname);
		textLastname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(140, 192, 100, 25);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(250, 192, 200, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(140, 232, 100, 25);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(250, 232, 200, 25);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Shipping Address");
		lblAddress.setBounds(140, 272, 100, 25);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(250, 272, 200, 25);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		btnSave = new JButton("Sign Up");
		btnSave.setBounds(250, 327, 200, 30);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LogIn Person = new LogIn();
				try {
					Person.Register(txtUsername.getText(),textPassword.getText(),textFirstname.getText(),textLastname.getText(),textEmail.getText(),textPhone.getText(),textAddress.getText());
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				try {
					if(Person.CheckCredentials(txtUsername.getText(),textPassword.getText()))
						new Customer(Person,new ShoppingCart());
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
	}


}
