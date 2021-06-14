package userOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Select implements Operation{

    public ResultSet execute(ArrayList<String> input) {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "select " + input.get(0) + " from " + input.get(1);
            if(input.size() > 2){
                if(input.get(2).contains("Author")){
                    stat += (" natural join Authors" + " where " + input.get(2));
                }else{
                    stat += (" where " + input.get(2));
                }
            }
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(stat);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
