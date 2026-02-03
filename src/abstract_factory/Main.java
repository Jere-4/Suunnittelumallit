package abstract_factory;

public class Main {
    public static void main(String[] args) {

        UIFactory factory = new AFactory();

        Button btn = factory.createButton("Click Me");
        TextField tf = factory.createTextField("Enter Name");
        Checkbox cb = factory.createCheckbox("Accept Terms");

        btn.display();
        tf.display();
        cb.display();

        System.out.println("\n--- Updating UI elements dynamically ---\n");

        btn.setText("Updated Button");
        tf.setText("New Field Text");
        cb.setText("Updated Checkbox");

        btn.display();
        tf.display();
        cb.display();

        System.out.println("\n--- Switching to Style B ---\n");

        UIFactory factoryB = new BFactory();

        Button btn2 = factoryB.createButton("Start");
        TextField tf2 = factoryB.createTextField("Input");
        Checkbox cb2 = factoryB.createCheckbox("Enable Feature");

        btn2.display();
        tf2.display();
        cb2.display();
    }
}
