package userOperations;

import java.sql.*;
import java.util.ArrayList;

public class BookOrder implements  Operation{
    @Override
    public ResultSet execute(ArrayList<String> input) throws SQLException {
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection(dbLink, user, password);
            String stat = "Insert into Orders values ( "+"'" + input.get(0) + "'" +", "+"'" + input.get(1)+"'"+" )";
            Statement statement =  connection.prepareStatement(stat, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(stat);
            }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
