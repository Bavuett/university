import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private HashMap<Book, Integer> library;

    public Library() {
        this.library = new HashMap<Book, Integer>();
    }

    public boolean add(Book book, int copies) throws IllegalArgumentException, NullPointerException {
        if (book == null) throw new NullPointerException("No valid Book given as argument.");
        if (copies < 0) throw new IllegalArgumentException("No valid copies number given as argument.");
        
        this.library.put(book, this.library.getOrDefault(book, 0) + copies);
        return true;
    }

    public boolean remove(Book book, int copies) throws IllegalArgumentException, NullPointerException {
        if (book == null) throw new NullPointerException("No valid Book given as argument.");
        if (copies < 0 || copies > this.library.getOrDefault(book, 0)) throw new IllegalArgumentException("No valid copies number given as argument.");

        if (copies == this.library.get(book)) library.remove(book);
        else this.library.put(book, library.get(book) - copies);
        return true;
    }

    public List<Book> sortByCode() {
        List<Book> orderedBooks = new ArrayList<>();

        for (Book book: this.library.keySet()) {
            orderedBooks.add(book);
        }

        orderedBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book arg0, Book arg1) {
                return arg0.getCode().compareTo(arg1.getCode());
            }
        });

        return orderedBooks;
    }

    public List<Book> sortyByPrice() {
        List<Book> orderedBooks = new ArrayList<>();

        for (Book book: this.library.keySet()) {
            orderedBooks.add(book);
        }

        orderedBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book arg0, Book arg1) {
                if (arg0.getPrice() > arg1.getPrice()) return 1;
                if (arg0.getPrice() < arg1.getPrice()) return -1;

                return 0;
            }
        });

        return orderedBooks;
    }

    public List<Book> findBooks(int pages) {
        List<Book> matchingCriteriaBooks = new ArrayList<>();

        for (Book book: this.library.keySet()) {
            if (book.getPages() > pages) matchingCriteriaBooks.add(book);
        }

        matchingCriteriaBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book arg0, Book arg1) {
                return arg0.getCode().compareTo(arg1.getCode());
            }
        });

        return matchingCriteriaBooks;
    }

    public int getCopiesNumber() {
        int sum = 0;

        for (Book book: this.library.keySet()) {
            sum += this.library.get(book);
        }

        return sum;
    }
}
