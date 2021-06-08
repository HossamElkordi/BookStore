package basicInterfaces;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UserOperationInterface temp=new UserOperationInterface();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
