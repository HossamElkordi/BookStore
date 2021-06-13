package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Sales implements Operation{

    @Override
    public ResultSet execute(ArrayList<String> input) {
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "Insert into Sales values ( ";
            for(int i = 0; i < input.size()-1; i++){
                stat = stat + "'" + input.get(i) + "', ";
            }
            stat = stat + "'" + input.get(input.size()-1)+"')";
            System.out.println(stat);
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(stat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
