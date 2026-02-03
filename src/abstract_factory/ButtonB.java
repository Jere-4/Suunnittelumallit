package abstract_factory;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("(" + "=".repeat(text.length() + 2) + ")");
        System.out.println("| " + text + " |");
        System.out.println("(" + "=".repeat(text.length() + 2) + ")");
    }
}
