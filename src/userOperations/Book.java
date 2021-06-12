package userOperations;

public class Book {
        private final String ISBN;
        private final int Quantity;
        private final String Title;
        private final String Publisher;
        private final String PublicationYear;
        private final String Category;
        private final String Price;

        public Book(String ISBN, int Quantity, String title, String publisher, String publicationYear, String category, String price)
        {
            this.ISBN=ISBN;
            this.Quantity=Quantity;
            Title = title;
            Publisher = publisher;
            PublicationYear = publicationYear;
            Category = category;
            Price = price;
        }

        public String getISBN() {
            return this.ISBN;
        }

        public int getQuantity() {
            return Quantity;
        }

        public String getTitle() {
            return Title;
        }

        public String getPublisher() {
            return Publisher;
        }

        public String getPublicationYear() {
            return PublicationYear;
        }

        public String getCategory() {
            return Category;
        }

        public String getPrice() {
            return Price;
        }
}
