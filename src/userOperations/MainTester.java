package userOperations;

import java.util.ArrayList;

public class MainTester {
    public static void main(String[] args) {
        Operation op = new AddNewBooks();
        op.execute(new ArrayList<String>());
    }
}
