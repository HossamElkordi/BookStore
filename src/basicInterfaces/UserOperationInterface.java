package basicInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UserOperationInterface extends JFrame {

	/**
	 * Create the frame.
	 */
	public UserOperationInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserOperationInterface.class.getResource("/Icon/logo.jpg")));
		setTitle("User Operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 441);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Add New Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(187, 174, 128, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(187, 208, 128, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Confirm Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(187, 242, 128, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Modify Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(187, 276, 128, 23);
		getContentPane().add(btnNewButton_3);
		JPanel logo=new Logo();
		logo.setLocation(206, 44);
		logo.setSize(89, 88);
		getContentPane().add(logo);
		setVisible(true);

	}
}
