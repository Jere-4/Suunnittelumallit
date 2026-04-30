package command;

public class PixelGridModel {

    private boolean[][] pixels;
    private int cursorX;
    private int cursorY;

    public PixelGridModel(int size) {
        pixels = new boolean[size][size];
    }

    public void moveUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveDown() {
        if (cursorY < pixels.length - 1) cursorY++;
    }

    public void moveLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveRight() {
        if (cursorX < pixels.length - 1) cursorX++;
    }

    public void togglePixel() {
        pixels[cursorY][cursorX] = !pixels[cursorY][cursorX];
    }

    public boolean isPixelOn(int x, int y) {
        return pixels[y][x];
    }

    public boolean isCursorAt(int x, int y) {
        return cursorX == x && cursorY == y;
    }

    public boolean[][] getPixels() {
        return pixels;
    }
}
