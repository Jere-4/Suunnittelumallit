package visitor;

public class File implements FileSystemElement {
    private String name;
    private int sizeInMB;

    public File(String name, int sizeInMB) {
        this.name = name;
        this.sizeInMB = sizeInMB;
    }

    public String getName() {
        return name;
    }

    public int getSizeInMB() {
        return sizeInMB;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
