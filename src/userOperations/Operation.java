package userOperations;

import java.sql.*;
import java.util.ArrayList;

public interface Operation {
    final String dbLink = "jdbc:mysql://127.0.0.1:3306/BookStore";
    final String user = "root";
    final String password = "wrong password287";
    ResultSet execute(ArrayList<String> input) throws SQLException;
}