package vehicles;

public class Motorcycle extends Vehicle {

    private Integer cylinderCapacity;

    public Motorcycle() {


    }

    public Motorcycle(Double price, String plate, Integer cylinderCapacity) {

        super(price, plate);
    }

    public Integer getCylinderCapacity() {

        return cylinderCapacity;
    }

    public void setCylinderCapacity(Integer cylinderCapacity) {

        this.cylinderCapacity = cylinderCapacity;
    }
}