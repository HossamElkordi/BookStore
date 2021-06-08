package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AddNewBooks implements Operation{

    public void execute(ArrayList<String> input) {
        try{
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            Statement statement = connection.createStatement();
            String stat = "insert into " + input.get(0) + " values(" + input.get(1);

            for(int i = 2; i < input.size(); ++i){
                stat += ("," + input.get(i));
            }
            stat += ")";
            statement.executeUpdate(stat);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
