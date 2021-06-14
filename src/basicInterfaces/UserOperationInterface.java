package basicInterfaces;

import forms.AddNewBook;
import forms.Confirm;
import forms.Modify;
import forms.SearchForBooks;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  UserOperationInterface extends JFrame {

	private JFrame thisFram;
	/**
	 * Create the frame.
	 */
	public UserOperationInterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserOperationInterface.class.getResource("/Icon/logo.jpg")));
		setTitle("User Operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		getContentPane().setLayout(null);
		thisFram = this;

		JButton btnNewButton = new JButton("Add New Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new AddNewBook(thisFram);
			}
		});
		btnNewButton.setBounds(267, 174, 214, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new SearchForBooks(thisFram);
			}
		});
		btnNewButton_1.setBounds(267, 208, 214, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Confirm Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new Confirm(thisFram);
			}
		});
		btnNewButton_2.setBounds(267, 242, 214, 23);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Modify Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame frame = new Modify(thisFram);
			}
		});
		btnNewButton_3.setBounds(267, 276, 214, 23);
		getContentPane().add(btnNewButton_3);
		JPanel logo=new Logo();
		logo.setLocation(322, 44);
		logo.setSize(89, 88);
		getContentPane().add(logo);
		setVisible(true);

	}
}
