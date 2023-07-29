class Book1 implements IBook {

    protected String title;
    protected String author;
    protected String ISBNNumber;

    public Book1() {
        this.title = "Title one";
        this.author = "Author one, Author Two";
        this.ISBNNumber = "1245378424567";
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getAuthors() {
        return this.author;
    }

    @Override
    public String getISBN13() {
        return this.ISBNNumber;
    }
}