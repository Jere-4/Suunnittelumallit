package composite;

public class Main {
    public static void main(String[] args) {

        // Create departments
        Department root = new Department("Head Office");
        Department it = new Department("IT Department");
        Department hr = new Department("HR Department");

        // Employees
        Employee e1 = new Employee("Alice", 5000);
        Employee e2 = new Employee("Bob", 4500);
        Employee e3 = new Employee("Clara", 6000);
        Employee e4 = new Employee("David", 4000);

        // Build structure
        it.add(e1);
        it.add(e2);

        hr.add(e3);
        hr.add(e4);

        root.add(it);
        root.add(hr);

        // Print total salary
        System.out.println("Total organization salary: " + root.getSalary());

        // Print XML
        System.out.println("\nOrganizational Structure (XML):");
        System.out.println(root.toXML(""));
    }
}
