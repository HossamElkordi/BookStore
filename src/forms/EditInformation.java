package forms;

import userOperations.LogIn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EditInformation extends JFrame {

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
	public EditInformation(JFrame parent, LogIn User) {
		
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditInformation.class.getResource("/Icon/logo.jpg")));
		setTitle("Edit Information");
		
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
		lblUserName.setBounds(30, 32, 100, 25);
		contentPane.add(lblUserName);
		
		txtUsername = new JTextField();
		txtUsername.setText("YoussefSherif98");
		txtUsername.setBounds(150, 32, 200, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setEditable(false);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 72, 100, 25);
		contentPane.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setText("********");
		textPassword.setBounds(150, 72, 200, 25);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(30, 112, 100, 25);
		contentPane.add(lblFirstname);
		
		textFirstname = new JTextField();
		textFirstname.setText("Youssef");
		textFirstname.setBounds(150, 112, 200, 25);
		contentPane.add(textFirstname);
		textFirstname.setColumns(10);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setBounds(30, 152, 100, 25);
		contentPane.add(lblLastname);
		
		textLastname = new JTextField();
		textLastname.setText("Kamel");
		textLastname.setBounds(150, 152, 200, 25);
		contentPane.add(textLastname);
		textLastname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(30, 192, 100, 25);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setText("youssef.sherif111998@gmail.com");
		textEmail.setBounds(150, 192, 200, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(30, 232, 100, 25);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setText("01270563512");
		textPhone.setBounds(150, 232, 200, 25);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Shipping Address");
		lblAddress.setBounds(30, 272, 100, 25);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setText("56 ElDobat Buildings, Moustafa Kamel");
		textAddress.setBounds(150, 272, 200, 25);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(164, 327, 186, 32);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
