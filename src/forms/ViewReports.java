package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewReports extends JFrame {

	private JPanel contentPane;
	private JFrame thisFrame;

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
	}

}
