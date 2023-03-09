package ch.noseryoung.blj;

public class Aircrafts extends Cars{

    private int aircraftID;

    public Aircrafts(String brand, String model, int ps, int seats, int price, int aircraftID) {
        super(brand, model, ps, seats, price, aircraftID);
        this.aircraftID = aircraftID;
    }

    @Override
    public void summarize(){
        System.out.println("****************************");
        System.out.println("Brand       :  " + brand);
        System.out.println("Model       :  " + model);
        System.out.println("Horsepower  :  " + ps);
        System.out.println("Seats       :  " + seats);
        System.out.println("Price       :  " + price);
        System.out.println("AircraftID  :  " + aircraftID);
        System.out.println("****************************");
    }
}
