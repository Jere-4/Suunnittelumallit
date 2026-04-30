package command;

public class GenerateCodeCommand implements Command {

    private PixelGridModel model;

    public GenerateCodeCommand(PixelGridModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        boolean[][] pixels = model.getPixels();

        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < pixels.length; y++) {
            System.out.print("    { ");
            for (int x = 0; x < pixels[y].length; x++) {
                System.out.print(pixels[y][x] ? "1" : "0");
                if (x < pixels[y].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" },");
        }
        System.out.println("};");
    }
}
