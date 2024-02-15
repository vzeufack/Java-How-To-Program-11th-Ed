public class Book {
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;

    public Book(){}

    public Book(String isbn, String title, int editionNumber, String copyright){
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public int getEditionNumber(){
        return this.editionNumber;
    }

    public String getCopyright(){
        return this.copyright;
    }

    @Override
    public String toString()
    {return getIsbn() + " - " + getTitle();}
}