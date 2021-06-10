package userOperations;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Book> Cart;

    public ShoppingCart()
    {
        this.Cart = new ArrayList<>();
    }

    public void AddToCart(String ISBN,int Quantity)
    {
        this.Cart.add(new Book(ISBN,Quantity));
    }

    List<Book> Checkout()
    {
        List<Book> CopyCart = new ArrayList<>(this.Cart);
        Operation operation = new ModifyExistingBook();
        for(Book book: CopyCart)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("BOOK");
            temp.add("Quantity= Quantity-"+book.getQuantity());
            temp.add("ISBN="+book.getISBN());
            operation.execute(temp);
        }
        remove();
        return CopyCart;
    }

    private void remove()
    {
        this.Cart=new ArrayList<>();
    }

}