package forms;

import userOperations.Select;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import userOperations.GenerateReports;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewReports extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;
	private GenerateReports gr;
	private JLabel textField;

	/**
	 * Create the frame.
	 */
	public ViewReports(JFrame parent) {
		
		thisFrame = this;
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewReports.class.getResource("/Icon/logo.jpg")));
		setTitle("View Reports");

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


		JButton btnNewButton = new JButton("Generate report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gr = new GenerateReports();
				try {
					gr.execute(null);
					textField.setText("Report.txt created in BookStore folder");
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(300, 48, 134, 32);
		contentPane.add(btnNewButton);

		textField = new JLabel();
		textField.setBounds(250, 100, 300, 22);
		textField.setText("Tap on the button to create a new report");
		contentPane.add(textField);




	}

}
