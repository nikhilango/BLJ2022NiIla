package ch.noseryoung.blj;

public class Cars {
    private String brand;
    private String model;
    private int ps;
    private int seats;
    private int price;
    private int carID;

    public Cars(String brand, String model, int ps, int seats, int price, int carID){
        this.brand = brand;
        this.model = model;
        this.ps = ps;
        this.seats = seats;
        this.price = price;
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPs() {
        return ps;
    }

    public int getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }

    public void summarize(){
        System.out.println("****************************");
        System.out.println("Brand     :  " + brand);
        System.out.println("Model     :  " + model);
        System.out.println("Horsepower:  " + ps);
        System.out.println("Seats     :  " + seats);
        System.out.println("Price     :  " + price);
        System.out.println("CarID     :  " + carID);
        System.out.println("****************************");
    }

    public int getCarID() {
        return carID;
    }
}
