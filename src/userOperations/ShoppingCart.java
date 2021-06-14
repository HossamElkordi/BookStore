package userOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private List<Book> Cart;

    public ShoppingCart()
    {
        this.Cart = new ArrayList<>();
    }

    public void AddToCart(Book book)
    {
        this.Cart.add(book);
    }

    public List<Book> getCart() {
        return Cart;
    }


    public void Checkout(LogIn User)
    {
        Operation operation = new ModifyExistingBook();

        Sales sa = new Sales();

        for(Book book: this.Cart)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("BOOK");
            temp.add("Quantity= Quantity-"+book.getQuantity());
            temp.add("ISBN="+book.getISBN());
            operation.execute(temp);

            ArrayList<String> list = new ArrayList<>();
            list.add(User.getUserName());
            list.add(book.getISBN());
            list.add(java.time.LocalDate.now().toString());
            list.add(book.getPrice());
            sa.execute(list);
        }
        clear();
    }

    private void clear()
    {
        this.Cart=new ArrayList<>();
    }

}