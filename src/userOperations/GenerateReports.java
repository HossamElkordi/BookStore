package userOperations;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {
            writeReport(rs1, rs2, rs3);
        }catch (Exception e){
            System.out.println("Could not write to file.");
        }

        return null;
    }

    private void writeReport(ResultSet r1, ResultSet r2, ResultSet r3) throws IOException, SQLException {
        assert (r1 != null);
        assert (r2 != null);
        assert (r3 != null);

        //File file = new File("Report.txt");
        FileWriter fw = new FileWriter("report.txt",false);
        PrintWriter pw = new PrintWriter(fw);

        pw.write("Total sales for books in the previous month:- \n");
        r1.next();
        String s;
        s=r1.getString("count(*)");
        System.out.println("  ");
        pw.write("-"+s +"\n");
        pw.write("*******************************************\n");

        int numOfCustomers = 5;
        int numOfBooks = 10;

        pw.write("The top 5 customers who purchase the most purchase amount in descending order for the last three months:- \n");

        while(r2.next() && numOfCustomers != 0){
            s=r2.getString("UserName");
            pw.write("-"+ s+", "+r2.getString(1)+"\n");
            numOfCustomers--;
        }
        pw.write("*******************************************\n");

        pw.write("The top 10 selling books for the last three months:- \n");
        while(r3.next() && numOfBooks != 0){
            s=r3.getString("ISBN");
            pw.write("-"+s +", "+r3.getString("Title")+", "+r3.getString("count(*)")+"\n");
            numOfBooks--;
        }
        pw.write("*******************************************\n");
        pw.close();
        fw.close();
    }

}
