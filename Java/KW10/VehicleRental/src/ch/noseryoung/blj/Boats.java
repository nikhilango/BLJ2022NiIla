package ch.noseryoung.blj;

public class Boats extends Cars implements Summarizable{

    private String typ;
    private int boatID;

    public Boats(String brand, String model, int ps, int seats, int price, String typ, int boatID) {
        super(brand, model, ps, seats, price, boatID);
        this.typ = typ;
        this.boatID = boatID;
    }

    @Override
    public void summarize(){
        System.out.println("****************************");
        System.out.println("Brand       :  " + brand);
        System.out.println("Model       :  " + model);
        System.out.println("Horsepower  :  " + ps);
        System.out.println("Seats       :  " + seats);
        System.out.println("Price       :  " + price);
        System.out.println("Typ         :  " + typ);
        System.out.println("BoatID      :  " + boatID);
        System.out.println("****************************");
    }

    public String getTyp() {
        return typ;
    }
}
