package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {

    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MIN_TEMP = -20;
    private final int MAX_TEMP = 40;
    private Random rand = new Random();
    private boolean running = true;

    public WeatherStation() {
        // Initial random temperature
        this.temperature = rand.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = rand.nextBoolean() ? 1 : -1;
        int newTemp = temperature + change;

        if (newTemp <= MAX_TEMP && newTemp >= MIN_TEMP) {
            temperature = newTemp;
        }
    }

    @Override
    public void run() {
        System.out.println("Weather Station started with initial temperature: " + temperature);

        while (running) {
            updateTemperature();
            notifyObservers();

            try {
                Thread.sleep((rand.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}
