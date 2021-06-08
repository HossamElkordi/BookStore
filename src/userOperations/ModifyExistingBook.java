package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModifyExistingBook implements Operation{

    public void execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            Statement statement = connection.createStatement();
            String stat = "update " + input.get(0) + " set " + input.get(1);
            if(input.size() > 2){
                stat += (" where " + input.get(2));
            }
            statement.executeUpdate(stat);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
