package observer;

public class WindowDisplay implements WeatherObserver {

    @Override
    public void update(int temperature) {
        System.out.println("[WindowDisplay] Temperature outside changed to: " + temperature);
    }
}
