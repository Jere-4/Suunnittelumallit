package chain_of_responsibility;

public abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(Message msg) {
        if (canHandle(msg.getType())) {
            process(msg);
        } else if (next != null) {
            next.handle(msg);
        } else {
            System.out.println("No handler available for message type: " + msg.getType());
        }
    }

    protected abstract boolean canHandle(MessageType type);
    protected abstract void process(Message msg);
}
