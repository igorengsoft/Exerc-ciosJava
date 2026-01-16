package vehicles;

public class Car extends Vehicle {

    private String airConditioning;

    public Car() {


    }

    public Car(Double price, String plate, String airConditioning) {

        super(price, plate);
        this.airConditioning = airConditioning;
    }

    public String getAirConditioning() {

        return airConditioning;
    }

    public void setAirConditioning(String airConditioning) {

        this.airConditioning = airConditioning;
    }
    
}
