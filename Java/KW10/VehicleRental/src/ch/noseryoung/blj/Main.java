package ch.noseryoung.blj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> customerList = new ArrayList<>();
        ArrayList<Person> denyList = new ArrayList<>();
        ArrayList<Contract> contracts = new ArrayList<>();
        ArrayList<Cars> vehicles = new ArrayList<>();
        int customerID = 0;
        int vehicleID = 0;
        boolean isRunning = true;
        while(isRunning){
            Scanner scan = new Scanner(System.in);
            Scanner scan1 = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            System.out.println("*************WELCOME TO ILANGO CARS GmbH*************");
            System.out.println("SELECT AN OPTION: ADD PERSON       1");
            System.out.println("                : ADD CAR          2");
            System.out.println("                : ADD AIRCRAFT     3");
            System.out.println("                : ADD BOAT         4");
            System.out.println("                : ADD CONTRACT     5");
            System.out.println("                : SHOW PERSONS     6");
            System.out.println("                : SHOW VEHICLES    7");
            System.out.println("                : SHOW CONTRACTS   8");
            System.out.println("                : ADD TO DENY LIST 9");
            System.out.println("                : EXIT             0");
            System.out.println("*****************************************************");
            int mode = scan.nextInt();
            VehicleRentalManager rental = new VehicleRentalManager(customerList, denyList, contracts, vehicles);
            switch (mode){
                case 1:
                    System.out.println("ENTER FIRST NAME: ");
                    String firstname = scan1.nextLine();
                    System.out.println("ENTER LAST NAME: ");
                    String lastname = scan2.nextLine();
                    System.out.println("ENTER AGE: ");
                    int age = scan.nextInt();
                    rental.addPerson(firstname, lastname, age, customerID++);
                    break;
                case 2:
                    System.out.println("ENTER CAR BRAND: ");
                    String brand = scan1.nextLine();
                    System.out.println("ENTER CAR MODEL: ");
                    String model = scan2.nextLine();
                    System.out.println("ENTER HORSEPOWER OF CAR: ");
                    int ps = scan.nextInt();
                    System.out.println("ENTER AMOUNT OF SEATS: ");
                    int seats = scan1.nextInt();
                    System.out.println("ENTER PRICE: ");
                    int price = scan2.nextInt();
                    rental.addCar(brand, model, ps, seats, price, vehicleID++);
                    break;
                case 3:
                    System.out.println("ENTER AIRCRAFT BRAND: ");
                    String abrand = scan1.nextLine();
                    System.out.println("ENTER AIRCRAFT MODEL: ");
                    String amodel = scan2.nextLine();
                    System.out.println("ENTER HORSEPOWER OF AIRCRAFT: ");
                    int aps = scan.nextInt();
                    System.out.println("ENTER AMOUNT OF SEATS: ");
                    int aseats = scan1.nextInt();
                    System.out.println("ENTER PRICE: ");
                    int aprice = scan2.nextInt();
                    rental.addAircraft(abrand, amodel, aps, aseats, aprice, vehicleID++);
                    break;
                case 4:
                    System.out.println("ENTER BOAT BRAND: ");
                    String bbrand = scan1.nextLine();
                    System.out.println("ENTER BOAT MODEL: ");
                    String bmodel = scan2.nextLine();
                    System.out.println("ENTER HORSEPOWER OF THE BOAT: ");
                    int bps = scan.nextInt();
                    System.out.println("ENTER AMOUNT OF SEATS: ");
                    int bseats = scan1.nextInt();
                    System.out.println("ENTER BOAT TYP:  ");
                    String btyp = scan2.nextLine();
                    System.out.println("ENTER PRICE: ");
                    int bprice = scan.nextInt();
                    rental.addBoat(bbrand, bmodel, bps, bseats, bprice, btyp, vehicleID++);
                    break;
                case 5:
                    System.out.println("SELECT PERSONID: ");
                    int personID = scan1.nextInt();
                    System.out.println("SELECT VEHICLE ID: ");
                    int vehicleID1 = scan2.nextInt();
                    System.out.println("SELECT STARTDATE: ");
                    int startDay = scan.nextInt();
                    int startMonth = scan1.nextInt();
                    int startYear = scan2.nextInt();
                    System.out.println("SELECT ENDDATE: ");
                    int endDay = scan.nextInt();
                    int endMonth = scan1.nextInt();
                    int endYear = scan2.nextInt();
                    if (vehicles.get(vehicleID1).getClass().getSimpleName().equals("Cars") || vehicles.get(vehicleID1).getClass().getSimpleName().equals("Aircrafts")){
                        rental.addContract(personID, vehicleID1, LocalDate.of(startYear, startMonth, startDay), LocalDate.of(endYear, endMonth, endDay));
                    }
                    else if (vehicles.get(vehicleID1).getClass().getSimpleName().equals("Boats")){
                        rental.addBoatContract(personID, vehicleID1, LocalDate.of(startYear, startMonth, startDay), LocalDate.of(endYear, endMonth, endDay));
                    }
                    break;
                case 6:
                    for (int i = 0; i < customerList.size(); i++){
                        customerList.get(i).summarize();
                    }
                    break;
                case 7:
                    for (int i = 0; i < vehicles.size(); i++){
                        vehicles.get(i).summarize();
                    }
                    break;
                case 8:
                    for (int i = 0; i < contracts.size(); i++){
                        contracts.get(i).showContract();
                    }
                    break;
                case 9:
                    System.out.println("SELECT PERSON ID TO PUT IN DENY LIST: ");
                    int denylistedID = scan.nextInt();
                    denyList.add(customerList.get(denylistedID));
                    System.out.println("THE PERSON HAS BEEN ENTERED INTO THE DENY LIST!");
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("THANK YOU FOR VISITING OUR DEALERSHIP!");
                    break;
                default:
                    System.out.println("Enter a valid mode!");
            }
        }

    }
}