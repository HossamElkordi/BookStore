package basicInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import forms.AddNewBook;
import forms.SignIn;
import forms.SignUp;

import javax.swing.JButton;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;


	/**
	 * Create the frame.
	 */
	public Homepage() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage.class.getResource("/Icon/logo.jpg")));
		setTitle("Bookstore Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		getContentPane().setLayout(null);
		thisFrame = this;
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new SignIn(thisFrame);
			}
		});
		btnSignIn.setBounds(260, 170, 214, 35);
		getContentPane().add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign Up"); 
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new SignUp(thisFrame);
			}
		});
		btnSignUp.setBounds(260, 230, 214, 35);
		getContentPane().add(btnSignUp);

		JPanel logo=new Logo();
		logo.setLocation(322, 44);
		logo.setSize(89, 88);
		getContentPane().add(logo);
		setVisible(true);
		
		
	}
}
