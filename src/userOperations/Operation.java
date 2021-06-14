package userOperations;

import java.sql.*;
import java.util.ArrayList;

public interface Operation {
    final String dbLink = "jdbc:mysql://127.0.0.1:3306/BookStore";
    final String user = "root";
    final String password = "input passwrod here";
    ResultSet execute(ArrayList<String> input) throws SQLException;
}