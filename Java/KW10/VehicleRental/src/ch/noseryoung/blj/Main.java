package ch.noseryoung.blj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> customerList = new ArrayList<>();
        ArrayList<Person> denyList = new ArrayList<>();
        ArrayList<Contract> contracts = new ArrayList<>();
        ArrayList<Cars> vehicles = new ArrayList<>();
        int customerID = 0;
        int vehicleID = 0;
        while(true){
            Scanner scan = new Scanner(System.in);
            Scanner scan1 = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            System.out.println("*************WELCOME TO ILANGO CARS GmbH*************");
            System.out.println("SELECT AN OPTION: ADD PERSON     1");
            System.out.println("                : ADD CAR        2");
            System.out.println("                : ADD CONTRACT   3");
            System.out.println("                : SHOW PERSONS   4");
            System.out.println("                : SHOW CARS      5");
            System.out.println("                : SHOW CONTRACTS 6");
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
                    rental.addVehicles(brand, model, ps, seats, price, vehicleID++);
                    break;
                case 3:
                    System.out.println("SELECT PERSONID: ");
                    int personID = scan1.nextInt();
                    System.out.println("SELECT CAR ID: ");
                    int carID = scan2.nextInt();
                    System.out.println("SELECT STARTDATE: ");
                    int startDay = scan.nextInt();
                    int startMonth = scan1.nextInt();
                    int startYear = scan2.nextInt();
                    System.out.println("SELECT ENDDATE: ");
                    int endDay = scan.nextInt();
                    int endMonth = scan1.nextInt();
                    int endYear = scan2.nextInt();
                    rental.addContract(personID, carID, LocalDate.of(startYear, startMonth, startDay), LocalDate.of(endYear, endMonth, endDay));
                    break;
                case 4:
                    for (int i = 0; i < customerList.size(); i++){
                        customerList.get(i).summarize();
                        /*System.out.println("**************************");
                        System.out.println("Firstname  : " +customerList.get(i).getFirstname());
                        System.out.println("Lastname   : " +customerList.get(i).getLastname());
                        System.out.println("Age        : " +customerList.get(i).getAge());
                        System.out.println("Cutomer ID : " +customerList.get(i).getCustomerID());*/
                    }
                    break;
                case 5:
                    for (int i = 0; i < vehicles.size(); i++){
                        vehicles.get(i).summarize();
                        /*System.out.println("**************************");
                        System.out.println("Brand         :" + vehicles.get(i).getBrand());
                        System.out.println("Model         :" + vehicles.get(i).getModel());
                        System.out.println("Horsepower    :" + vehicles.get(i).getPs());
                        System.out.println("Seats         :" + vehicles.get(i).getSeats());
                        System.out.println("Price         :" + vehicles.get(i).getPrice());
                        System.out.println("Car ID        :" + vehicles.get(i).getCarID());*/
                    }
                    break;
                case 6:
                    for (int i = 0; i < contracts.size(); i++){
                        contracts.get(i).showContract();
                        /*String age1 = valueOf(customerList.get(i).getAge());
                        String ps1 = valueOf(vehicles.get(i).getPs());
                        String customerID1 = valueOf(customerList.get(i).getCustomerID());
                        String seats1 = valueOf(vehicles.get(i).getSeats());
                        String price1 = valueOf(vehicles.get(i).getPrice());
                        System.out.println("+++++++++++PERSON++++++++++++++++++++++++++VEHICLE+++++++++++++");
                        System.out.println("| Firstname  :  " + stringAdjust(customerList.get(i).getFirstname()) + "|" + "Brand:       " + stringAdjust(vehicles.get(i).getBrand()) + "|");
                        System.out.println("| Lastname   :  " + stringAdjust(customerList.get(i).getLastname()) + "|" + "Model:       " +  stringAdjust(vehicles.get(i).getModel()) + "|");
                        System.out.println("| Age        :  " + stringAdjust(age1) + "|" + "Horsepower:  " +  stringAdjust(ps1) + "|");
                        System.out.println("| Customer ID:  " + stringAdjust(customerID1) + "|" + "Seats:       " + stringAdjust(seats1) + "|");
                        System.out.println("| Price      :                                " + stringAdjust(price1 + " CHF") + "|");
                        System.out.println("| Start Date :                                " + stringAdjust(String.valueOf(contracts.get(i).getStartDate())) + "|");
                        System.out.println("| End Date   :                                " + stringAdjust(String.valueOf(contracts.get(i).getEndDate())) + "|");
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");*/
                    }
                    break;
                default:
                    System.out.println("Enter a valid mode!");
            }
        }

    }
}