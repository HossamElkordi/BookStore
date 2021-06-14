package userOperations;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PromoteUser implements  Operation{
    @Override
    public ResultSet execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            for(int i = 0 ; i < input.size(); i++){
                String stat = "update User set Type = 'manager' where UserName = '" + input.get(i)+"'";
                System.out.println(stat);
                Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                statement.executeUpdate(stat);
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables.getMessage());
            throwables.printStackTrace();
        }
        return null;
    }
}
