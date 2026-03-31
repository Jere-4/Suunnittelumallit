package proxy;

public class DocumentProxy implements DocumentInterface {

    private final Document realDocument;
    private final AccessControlService acs;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.acs = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        }
        throw new AccessDeniedException(
                "Access denied for user '" + user.getUsername() +
                        "' to document '" + realDocument.getId() + "'"
        );
    }
}
