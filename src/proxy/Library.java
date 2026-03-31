package proxy;

import java.util.HashMap;

public class Library {

    private HashMap<String, DocumentInterface> documents = new HashMap<>();

    public void addDocument(DocumentInterface doc) {
        documents.put(doc.getId(), doc);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }

    public void addProtectedDocument(String id, String date, String content) {
        Document realDoc = new Document(id, date, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }
}
