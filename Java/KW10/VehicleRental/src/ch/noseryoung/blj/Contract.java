package ch.noseryoung.blj;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.String.valueOf;


public class Contract {
    private Person person;
    private Cars car;
    private Boats boat;
    private LocalDate startDate;
    private LocalDate endDate;

    public Contract(Person person, Cars car, LocalDate startDate, LocalDate endDate){
        this.person = person;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Contract(Person person, Boats boat, LocalDate startDate, LocalDate endDate){
        this.person = person;
        this.boat = boat;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void checkForInvalidity(Person person, ArrayList denyList, LocalDate startDate1, LocalDate endDate1) throws Exception{
        if (person.getAge() < 18){
            throw new Exception("This person is a minor!");
        }
        else if (startDate1.isAfter(endDate1)) {
            throw new Exception("The leasedates are overlapping!");
        }
        for(int i = 0; i < denyList.size(); i++){
            Person denyedCustomer = (Person) denyList.get(i);
            if (person.getCustomerID() == denyedCustomer.getCustomerID()){
                throw new Exception("This person is blacklisted!");
            }
        }
    }

    public void showContract(){
        String age = valueOf(person.getAge());
        String ps = valueOf(car.getPs());
        String customerID = valueOf(person.getCustomerID());
        String seats = valueOf(car.getSeats());
        String price = valueOf(car.getPrice());
        System.out.println("+++++++++++PERSON++++++++++++++++++++++++++VEHICLE+++++++++++++");
        System.out.println("| Firstname  :  " + stringAdjust(person.getFirstname()) + "|" + "Brand:       " + stringAdjust(car.getBrand()) + "|");
        System.out.println("| Lastname   :  " + stringAdjust(person.getLastname()) + "|" + "Model:       " +  stringAdjust(car.getModel()) + "|");
        System.out.println("| Age        :  " + stringAdjust(age) + "|" + "Horsepower:  " +  stringAdjust(ps) + "|");
        System.out.println("| Customer ID:  " + stringAdjust(customerID) + "|" + "Seats:       " + stringAdjust(seats) + "|");
        System.out.println("| Price      :                                " + stringAdjust(price + " CHF") + "|");
        System.out.println("| Start Date :                                " + stringAdjust(String.valueOf(startDate)) + "|");
        System.out.println("| End Date   :                                " + stringAdjust(String.valueOf(endDate)) + "|");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public void showBoatContract(){
        String age = valueOf(person.getAge());
        String ps = valueOf(boat.getPs());
        String customerID = valueOf(person.getCustomerID());
        String seats = valueOf(boat.getSeats());
        String price = valueOf(boat.getPrice());
        System.out.println("+++++++++++PERSON++++++++++++++++++++++++++VEHICLE+++++++++++++");
        System.out.println("| Firstname  :  " + stringAdjust(person.getFirstname()) + "|" + "Brand:       " + stringAdjust(boat.getBrand()) + "|");
        System.out.println("| Lastname   :  " + stringAdjust(person.getLastname()) + "|" + "Model:       " +  stringAdjust(boat.getModel()) + "|");
        System.out.println("| Age        :  " + stringAdjust(age) + "|" + "Horsepower:  " +  stringAdjust(ps) + "|");
        System.out.println("| Customer ID:  " + stringAdjust(customerID) + "|" + "Seats:       " + stringAdjust(seats) + "|");
        System.out.println("| Typ        :                                " + stringAdjust(boat.getTyp()) + "|");
        System.out.println("| Price      :                                " + stringAdjust(price + " CHF") + "|");
        System.out.println("| Start Date :                                " + stringAdjust(String.valueOf(startDate)) + "|");
        System.out.println("| End Date   :                                " + stringAdjust(String.valueOf(endDate)) + "|");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    private String stringAdjust(String string){
        int stringLen = 0;
        for(int i = 0; i < string.length(); i++) {
            stringLen++;
        }
        int charsToAdd = 16 - stringLen;
        for (int i = 0; i < charsToAdd; i++){
            char space = ' ';
            string = string + space;
        }
        return string;
    }
}
