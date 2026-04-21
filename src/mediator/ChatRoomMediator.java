package mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomMediator implements ChatMediator {

    private final Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender, String receiver, String message) {
        ChatClientController target = clients.get(receiver);
        if (target != null) {
            target.receiveMessage(sender, message);
        }
    }
}
