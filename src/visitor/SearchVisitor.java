package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String pattern;
    private List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(pattern)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
