package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Delete implements Operation{

    public ResultSet execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "delete from " + input.get(0);
            if(input.size() > 1){
                stat += (" where " + input.get(1));
            }
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(stat);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
