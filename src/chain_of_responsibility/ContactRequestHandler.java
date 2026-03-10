package chain_of_responsibility;

public class ContactRequestHandler extends Handler {

    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void process(Message msg) {
        System.out.println("Handling contact request from " + msg.getSenderEmail());
        System.out.println("Forwarding to customer service.\n");
    }
}
