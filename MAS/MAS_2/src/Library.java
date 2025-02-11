import java.util.HashMap;
import java.util.Map;

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(String isbn, Book book) {
        if (!books.containsKey(isbn)) {
            books.put(isbn, book);
            book.setLibrary(this);
        }
    }

    public Book findBookByISBN(String isbn) {
        return books.get(isbn);
    }
}

