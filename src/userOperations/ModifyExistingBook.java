package userOperations;

import java.sql.*;
import java.util.ArrayList;

public class ModifyExistingBook implements Operation{

    public ResultSet execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "update " + input.get(0) + " set " + input.get(1);
            if(input.size() > 2){
                stat += (" where " + input.get(2));
            }
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(stat);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
