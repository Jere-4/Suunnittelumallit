package visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemElement element) {
        children.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getChildren() {
        return children;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : children) {
            element.accept(visitor);
        }
    }
}
