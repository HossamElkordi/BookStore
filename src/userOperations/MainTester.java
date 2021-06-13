package userOperations;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainTester {
    public static void main(String[] args) throws SQLException {
        Operation op = new AddNewBooks();
        op.execute(new ArrayList<String>());
    }
}
