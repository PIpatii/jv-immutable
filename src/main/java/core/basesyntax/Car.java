package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        this.engine = engine == null ? engine : engine.clone();
    }
    //implement this class

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> newWheel = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheel.add(wheel.clone());
        }
        return newWheel;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            return new Car(year, color, getCopy(wheels), engine.clone());
        }
        List<Wheel> allWheels = new ArrayList<>();
        allWheels.addAll(wheels);
        allWheels.add(newWheel);
        return new Car(year, color, getCopy(allWheels), engine.clone());
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, getCopy(wheels), engine.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }
}
