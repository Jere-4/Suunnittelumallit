package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientUI {

    private final ChatClientController controller;
    private final TextArea chatArea = new TextArea();

    public ChatClientUI(Stage stage,
                        ChatClientController controller,
                        List<String> allUsers) {

        this.controller = controller;
        controller.setUI(this);

        stage.setTitle("Chat - " + controller.getUsername());

        chatArea.setEditable(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message...");

        ComboBox<String> recipientBox = new ComboBox<>();
        recipientBox.getItems().addAll(allUsers);
        recipientBox.getItems().remove(controller.getUsername());
        recipientBox.setPromptText("Recipient");

        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String msg = messageField.getText();
            String recipient = recipientBox.getValue();
            if (msg != null && !msg.isEmpty() && recipient != null) {
                controller.sendMessage(recipient, msg);
                messageField.clear();
            }
        });

        HBox controls = new HBox(10, recipientBox, messageField, sendButton);
        VBox root = new VBox(10, chatArea, controls);
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root, 450, 300));
        stage.show();
    }

    public void displayMessage(String message) {
        chatArea.appendText(message + "\n");
    }
}
