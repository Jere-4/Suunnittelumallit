package composite;

public interface OrganizationComponent {
    void add(OrganizationComponent component);
    void remove(OrganizationComponent component);
    double getSalary();
    String toXML(String indent);
}
