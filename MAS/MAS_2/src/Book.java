class Book {
    private String title;
    private Person owner;
    private Library library;

    public Book(String title) {
        this.title = title;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void addOwner(Person person){
        owner = person;
        person.addBook(this);
    }
}