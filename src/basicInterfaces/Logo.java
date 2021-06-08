package basicInterfaces;

import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Logo extends JPanel {
	private Image logo;
	

	/**
	 * Create the panel.
	 */
	public Logo() {
		setLayout(null);

		try {
			logo=ImageIO.read(Logo.class.getResource("/Icon/logo.jpg"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(logo.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
	}

}
