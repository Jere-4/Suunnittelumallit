package visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
