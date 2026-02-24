package decorator;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        wrappedPrinter.print(encrypted);
    }

    private String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char)(c + 3)); // simple Caesar cipher
        }
        return sb.toString();
    }
}
