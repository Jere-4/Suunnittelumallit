package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {

        // Build the handler chain
        Handler h1 = new CompensationHandler();
        Handler h2 = new ContactRequestHandler();
        Handler h3 = new DevelopmentSuggestionHandler();
        Handler h4 = new GeneralFeedbackHandler();

        h1.setNext(h2).setNext(h3).setNext(h4);

        // Create messages
        Message m1 = new Message(
                MessageType.COMPENSATION_CLAIM,
                "My flight was delayed by 5 hours.",
                "customer1@example.com"
        );

        Message m2 = new Message(
                MessageType.CONTACT_REQUEST,
                "I want to speak with a sales representative.",
                "customer2@example.com"
        );

        Message m3 = new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the mobile app.",
                "customer3@example.com"
        );

        Message m4 = new Message(
                MessageType.GENERAL_FEEDBACK,
                "Great service overall!",
                "customer4@example.com"
        );

        // Process each message
        h1.handle(m1);
        h1.handle(m2);
        h1.handle(m3);
        h1.handle(m4);
    }
}
