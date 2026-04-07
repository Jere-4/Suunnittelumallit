package builder;

public class Main {

    public static void main(String[] args) {

        // Build Gaming Computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);
        gamingDirector.constructComputer();

        Computer gamingComputer = gamingDirector.getComputer();
        System.out.println("Gaming Computer:");
        System.out.println(gamingComputer);

        // Build Office Computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);
        officeDirector.constructComputer();

        Computer officeComputer = officeDirector.getComputer();
        System.out.println("Office Computer:");
        System.out.println(officeComputer);
    }
}
