package chain_of_responsibility;

public class GeneralFeedbackHandler extends Handler {

    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void process(Message msg) {
        System.out.println("Analyzing general feedback from " + msg.getSenderEmail());
        System.out.println("Feedback: " + msg.getContent());
        System.out.println("Response: Thank you for your feedback!\n");
    }
}
