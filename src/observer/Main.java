package observer;

public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();
        Thread stationThread = new Thread(station);
        stationThread.start();

        // Create observers
        WeatherObserver phone1 = new PhoneDisplay("John");
        WeatherObserver phone2 = new PhoneDisplay("Alex");
        WeatherObserver window = new WindowDisplay();
        WeatherObserver car = new CarDisplay();

        // Register observers
        station.registerObserver(phone1);
        station.registerObserver(phone2);
        station.registerObserver(window);
        station.registerObserver(car);

        try {
            Thread.sleep(15000);

            System.out.println("\n--- Removing observer: Alex's Phone ---\n");
            station.removeObserver(phone2);

            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSimulation finished.");
        stationThread.interrupt();
    }
}
