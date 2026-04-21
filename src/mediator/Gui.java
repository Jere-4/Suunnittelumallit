package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoomMediator();

        List<String> users = List.of("Alice", "Bob", "Charlie");

        for (String username : users) {
            ChatClientController controller =
                    new ChatClientController(username, mediator);

            Stage stage = new Stage();
            new ChatClientUI(stage, controller, users);
        }
    }
}
