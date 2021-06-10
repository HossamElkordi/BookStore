package userOperations;

public class Book {
        private final String ISBN;
        private final int Quantity;

        Book(String ISBN,int Quantity)
        {
            this.ISBN=ISBN;
            this.Quantity=Quantity;
        }

        public String getISBN() {
            return this.ISBN;
        }

        public int getQuantity() {
            return Quantity;
        }

}
