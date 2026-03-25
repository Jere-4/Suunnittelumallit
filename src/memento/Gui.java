package memento;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) {

        Model model = new Model();
        controller = new Controller(model);

        ColorBox box1 = new ColorBox(model.getColor1());
        ColorBox box2 = new ColorBox(model.getColor2());
        ColorBox box3 = new ColorBox(model.getColor3());
        CheckBox cb = new CheckBox("Check me");
        cb.setSelected(model.isChecked());

        // save initial state
        controller.saveState();

        box1.setOnMouseClicked(e -> {
            controller.saveState();
            model.changeColor1();
            box1.setColor(model.getColor1());
        });

        box2.setOnMouseClicked(e -> {
            controller.saveState();
            model.changeColor2();
            box2.setColor(model.getColor2());
        });

        box3.setOnMouseClicked(e -> {
            controller.saveState();
            model.changeColor3();
            box3.setColor(model.getColor3());
        });

        cb.setOnAction(e -> {
            controller.saveState();
            model.toggleChecked();
            cb.setSelected(model.isChecked());
        });

        VBox root = new VBox(10, new HBox(10, box1, box2, box3), cb);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 500, 200);

        // CTRL+Z → Undo
        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN),
                () -> {
                    controller.undo();
                    updateView(box1, box2, box3, cb);
                }
        );

        // ✅ CTRL+Y → Redo
        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN),
                () -> {
                    controller.redo();
                    updateView(box1, box2, box3, cb);
                }
        );

        stage.setScene(scene);
        stage.setTitle("Memento Example");
        stage.show();
    }

    private void updateView(ColorBox box1, ColorBox box2, ColorBox box3, CheckBox cb) {
        Model m = controller.getModel();
        box1.setColor(m.getColor1());
        box2.setColor(m.getColor2());
        box3.setColor(m.getColor3());
        cb.setSelected(m.isChecked());
    }
}
