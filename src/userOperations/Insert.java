package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Insert implements Operation{

    public ResultSet execute(ArrayList<String> input) {
        try{
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "insert into " + input.get(0) + " values(" + input.get(1);

            for(int i = 2; i < input.size(); ++i){
                stat += ("," + input.get(i));
            }
            stat += ")";
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(stat);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
