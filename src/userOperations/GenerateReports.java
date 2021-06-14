package userOperations;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class GenerateReports implements  Operation{
    @Override
    public ResultSet execute(ArrayList<String> input) throws SQLException {

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        Connection connection = DriverManager.getConnection(dbLink, user, password);
        /*The total sales for books in the previous month*/
        String stat1  = "select count(*) from sales where date > now() - interval 1 month";
        Statement statement1 =  connection.prepareStatement(stat1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs1 = statement1.executeQuery(stat1);

        /*The top 5 customers who purchase the most purchase amount in descending order for the last three months*/
        String stat2 = "select UserName,Sum(payment) from sales where date > now() - interval 3 month group by UserName order by sum(payment) desc";
        Statement statement2 = connection.prepareStatement(stat2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs2 = statement2.executeQuery(stat2);

        /*The top 10 selling books for the last three months*/
        String stat3 = "select ISBN, Title,count(*) from sales natural join book where date > now() - interval 3 month group by ISBN order by count(*) desc";
        Statement statement3 = connection.prepareStatement(stat3, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs3 = statement3.executeQuery(stat3);

        return null;
    }
}
