package userOperations;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BookOrder implements  Operation{
    @Override
    public ResultSet execute(ArrayList<String> input) {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "Insert into Orders values ( "+"'" + input.get(0) + "'" +", "+"'" + input.get(1)+"'"+" )";
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(stat);
            }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
