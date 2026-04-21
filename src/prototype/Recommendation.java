package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            copy.books = new ArrayList<>();
            for (Book book : this.books) {
                copy.books.add(book.clone()); // deep copy
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                "Target Audience: " + targetAudience + "\n"
        );
        for (int i = 0; i < books.size(); i++) {
            sb.append(i).append(". ").append(books.get(i)).append("\n");
        }
        return sb.toString();
    }
}
