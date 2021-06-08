package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchForBooks implements Operation{

    public void execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            Statement statement = connection.createStatement();
            String stat = "select "+ input.get(0) + " from " + input.get(1);
            if(input.size() > 2){
                stat += (" where " + input.get(2));
            }
            ResultSet resultSet = statement.executeQuery(stat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
