package visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory photos = new Directory("photos");
        Directory docs = new Directory("docs");

        File img1 = new File("vacation1.jpg", 5);
        File img2 = new File("vacation2.jpg", 7);
        File report = new File("report.pdf", 2);
        File notes = new File("notes.txt", 1);

        photos.add(img1);
        photos.add(img2);
        docs.add(report);
        docs.add(notes);

        root.add(photos);
        root.add(docs);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor jpgSearch = new SearchVisitor(".jpg");
        root.accept(jpgSearch);

        System.out.println("\nJPEG files found:");
        for (File f : jpgSearch.getMatchingFiles()) {
            System.out.println(" - " + f.getName());
        }
    }
}
