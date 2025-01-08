public class Book implements Comparable<Book> {
    private String title;
    private String code;
    private int pages;
    private float price;

    public Book(String title, String code, int pages, float price) {
        this.title = title;
        this.code = code;
        this.pages = pages;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCode() {
        return this.code;
    }

    public int getPages() {
        return this.pages;
    }

    public float getPrice() {
        return this.price;
    }
    
    @Override
    public int compareTo(Book book) throws NullPointerException {
        if (book == null) throw new NullPointerException("No valid book given as argument.");
        
        return this.title.compareTo(book.getTitle());
    }

    @Override
    public boolean equals(Object obj) throws NullPointerException {
        Book book;

        if (obj == null) throw new NullPointerException("No valid book given as argument.");
        if (obj instanceof Book) book = (Book) obj;
        else throw new ClassCastException("Argument given is not a Book");

        return this.getCode().equals(book.getCode());
    }
}