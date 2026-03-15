package entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BIKE")
public class Bike extends Vehicle {

    private boolean geared;

    public Bike() {
    }

    public Bike(String brand, boolean geared) {
        super(brand);
        this.geared = geared;
    }

    public boolean isGeared() {
        return geared;
    }

    public void setGeared(boolean geared) {
        this.geared = geared;
    }
}