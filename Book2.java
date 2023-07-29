class Book2 implements IBook {

    protected String title;
    protected String author;
    protected String ISBNNumber;


    public Book2() {
        this.title = "Title two";
        this.author = "Author three, Author four";
        this.ISBNNumber = "1245378754567";
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