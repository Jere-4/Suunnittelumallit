package prototype;

public class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone(); // fields are immutable/primitives
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author +
                " (" + genre + ", " + publicationYear + ")";
    }
}
