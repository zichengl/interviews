package Traffic;

import java.util.ArrayList;
import java.util.List;

public class Traffic {
    public int simulate(Road road, Car car) {
        int time = 0;
        while (car.getPosition() < road.getLength()) {
            if (road.isGreen(car, time)) {
                car.move(); // position + 1
            }
            time++;
        }
        return time;
    }

    public void toggleLights(Road road) {

    }
    // Define a function to run the simulation:
}
class Road {
    int length = Integer.MAX_VALUE;
    private List<TrafficLight> lightList;

    public Road(List<TrafficLight> lightList) {
        lightList = new ArrayList<>();
    }

    public void addLight(int position, TrafficLight light) {
        lightList.add(position, light);
    }
    public boolean isGreen(Car car, int time) {
        if (car.getPosition() == 0) {
            return true;
        } else {
            return lightList.get(car.getPosition()).isGreen(time);
        }
    }
    public int getLength() {
        return this.length;
    }
}

class TrafficLight {
    private boolean isGreen;

    public TrafficLight() {
        isGreen = true;
    }

    public void toggle() {

        isGreen = !isGreen;
    }

    public boolean isGreen(int time) {
        return time % 2 == 0;
    }
}

class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }
    public void move() {
        position++;
    }
}
 //   Define a function to simulate the traffic flow for a road by taking a car object as input:

