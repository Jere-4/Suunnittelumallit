package decorator;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    @Override
    public void print(String message) {
        String xmlMessage = "<message>" + message + "</message>";
        wrappedPrinter.print(xmlMessage);
    }
}
