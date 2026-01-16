package vehicles;

public abstract class Vehicle {

    private Double price;
    private String plate;

    public Vehicle() {

        
    }

    public Vehicle(Double price, String plate) {

        this.price = price;
        this.plate = plate;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

    public String getPlate() {

        return plate;
    }

    public void setPlate(String plate) {

        this.plate = plate;
    }
}
