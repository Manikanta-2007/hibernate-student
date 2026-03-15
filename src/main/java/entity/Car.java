package entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    private int numberOfDoors;

    public Car() {
    }

    public Car(String brand, int numberOfDoors) {
        super(brand);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}