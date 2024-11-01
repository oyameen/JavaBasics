package MarkerInterface;

interface Privilege {
}

public class BookParser {

    private final Book book;

    public BookParser(Book book) {
        this.book = book;
    }

    private void printNumberOfPages() {
        if (book instanceof Privilege) {
            System.out.println(book.getNumberOfPages());
        } else {
            System.out.println("No Privilege for getNumberOfPages.");
        }
    }

    public static void main(String[] args) {
        BookParser bookParser = new BookParser(new Book1());
        bookParser.printNumberOfPages();
        bookParser = new BookParser(new Book2());
        bookParser.printNumberOfPages();

    }
}

abstract class Book {
    abstract int getNumberOfPages();
}

class Book1 extends Book implements Privilege {

    @Override
    int getNumberOfPages() {
        return 100;
    }
}

class Book2 extends Book {

    @Override
    int getNumberOfPages() {
        return 100;
    }
}