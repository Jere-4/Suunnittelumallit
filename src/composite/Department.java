package composite;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationComponent c : components) {
            total += c.getSalary();
        }
        return total;
    }

    @Override
    public String toXML(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append("<department name=\"").append(name).append("\">\n");
        for (OrganizationComponent c : components) {
            sb.append(c.toXML(indent + "  "));
        }
        sb.append(indent).append("</department>\n");
        return sb.toString();
    }
}
