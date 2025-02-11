import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<Book> books;

    public Person(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
            book.setOwner(this);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
