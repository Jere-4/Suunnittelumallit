package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends Handler {

    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void process(Message msg) {
        System.out.println("Logging development suggestion from " + msg.getSenderEmail());
        System.out.println("Suggestion: " + msg.getContent());
        System.out.println("Status: Added to backlog.\n");
    }
}
