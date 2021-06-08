package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class ConfirmOrders implements Operation{

    public void execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            Statement statement = connection.createStatement();
            String stat = "delete from " + input.get(0);
            if(input.size() > 1){
                stat += (" where " + input.get(1));
            }
            statement.executeUpdate(stat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
