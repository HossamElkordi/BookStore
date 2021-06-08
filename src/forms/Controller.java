package forms;

import userOperations.*;
import userOperations.SearchForBooks;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Controller {

    private static Controller control;
    private String table = "";
    private String cond = "";
    private ArrayList<String> attr;
    private ArrayList<String> authors;
    private ArrayList<String> querry;
    private Operation op;


    private Controller(){
        attr = new ArrayList<String>();
        authors = new ArrayList<String>();
        querry = new ArrayList<String>();
    }

    public static Controller getControl(){
        if(control == null){
            control = new Controller();
        }
        return control;
    }

    public void setTable(String table){
        this.table = table;
    }

    public void setCondition(String cond){
        this.cond = cond;
    }

    public String getCondition(){
        return this.cond;
    }

    public void addAtribute(String attr){
        this.attr.add(attr);
    }

    public void addAuthor(String author){
        this.authors.add(author);
    }

    public ResultSet executeQuerry(String type){
        ResultSet rs = null;
        switch (type) {
            case "search" -> {
                op = new SearchForBooks();
                querry.add("*");
                querry.add(table);
                if (!cond.isEmpty()) querry.add(cond);
                rs = op.execute(querry);
            }
            case "insert" -> {
                op = new AddNewBooks();
                querry.add(table);
                for (String s : attr) querry.add(s);
                rs = op.execute(querry);
                for (String s : authors) {
                    querry.clear();
                    querry.add("Authors");
                    querry.add(attr.get(0));
                    querry.add(s);
                    rs = op.execute(querry);
                }
            }
            case "update" -> {
                op = new ModifyExistingBook();
                querry.add(table);
                querry.add(attr.get(0));
                querry.add(cond);
                op.execute(querry);
            }
            case "delete" -> {
                op = new ConfirmOrders();
                querry.add(table);
                if (!cond.isEmpty()) querry.add(cond);
                rs = op.execute(querry);
            }
        }
        table = "";
        cond = "";
        querry.clear();
        attr.clear();
        authors.clear();
        return rs;
    }
}
