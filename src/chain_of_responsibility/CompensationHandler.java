package chain_of_responsibility;

public class CompensationHandler extends Handler {

    @Override
    protected boolean canHandle(MessageType type) {
        return type == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void process(Message msg) {
        System.out.println("Processing compensation claim from " + msg.getSenderEmail());
        System.out.println("Reviewing claim: " + msg.getContent());
        System.out.println("Result: Claim approved.\n");
    }
}
