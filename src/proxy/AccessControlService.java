package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    private static AccessControlService instance;

    private Set<String> allowedPairs = new HashSet<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, String documentId) {
        allowedPairs.add(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return allowedPairs.contains(username + ":" + documentId);
    }
}
