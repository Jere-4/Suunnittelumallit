package mediator;

public class ChatClientController {

    private final String username;
    private final ChatMediator mediator;
    private ChatClientUI ui;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUI(ChatClientUI ui) {
        this.ui = ui;
    }

    public void sendMessage(String receiver, String message) {
        mediator.sendMessage(username, receiver, message);
        ui.displayMessage("To " + receiver + ": " + message);
    }

    public void receiveMessage(String sender, String message) {
        ui.displayMessage("From " + sender + ": " + message);
    }
}
