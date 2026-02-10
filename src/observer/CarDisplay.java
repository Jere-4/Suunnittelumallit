package observer;

public class CarDisplay implements WeatherObserver {

    @Override
    public void update(int temperature) {
        System.out.println("[CarDisplay] FYI: New temp = " + temperature);
    }
}
