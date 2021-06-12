package basicInterfaces;

import javax.swing.*;

public class Main2 {

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Homepage();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
