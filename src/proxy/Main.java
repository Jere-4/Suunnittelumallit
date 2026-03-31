package proxy;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");

        // Add unprotected document
        library.addDocument(new Document("doc1", "2026-01-01", "Public content of Document 1"));

        // Add protected document
        library.addProtectedDocument("doc2", "2026-03-10", "Top-secret content in Document 2");

        // Set access rules
        acs.allowAccess("alice", "doc2");

        // Access tests
        try {
            System.out.println("Alice reading doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("Bob reading doc1: " + library.getDocument("doc1").getContent(bob));

            System.out.println("Alice reading doc2: " + library.getDocument("doc2").getContent(alice));
            System.out.println("Bob reading doc2: " + library.getDocument("doc2").getContent(bob)); // should fail
        }
        catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
