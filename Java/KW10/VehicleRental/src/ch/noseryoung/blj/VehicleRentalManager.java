package ch.noseryoung.blj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class VehicleRentalManager {
    private ArrayList customerList;
    private ArrayList denyList;
    private ArrayList vehicles;
    private ArrayList contracts;

    public VehicleRentalManager(ArrayList customerList, ArrayList denyList, ArrayList contracts, ArrayList vehicles){
        this.customerList = customerList;
        this.denyList = denyList;
        this.contracts = contracts;
        this.vehicles = vehicles;
    }

    public void addPerson(String firstname, String lastname, int age, int customerID){
        Person person = new Person(firstname, lastname, age, customerID);
        customerList.add(person);
        person.summarize();
    }

    public void addVehicles(String brand, String model, int ps, int seats, int price, int carID){
        Cars car = new Cars(brand, model, ps, seats, price, carID);
        vehicles.add(car);
        car.summarize();
    }

    public void addContract(int customerID, int vehicleID, LocalDate startDate, LocalDate endDate) throws Exception {
        Contract contract = new Contract((Person) customerList.get(customerID), (Cars) vehicles.get(vehicleID), startDate, endDate);
        contract.checkForInvalidity((Person) customerList.get(customerID), denyList);
        contracts.add(contract);
        contract.showContract();
    }
}
