package ch.noseryoung.blj;


public class Person implements Summarizable{
    private String firstname;
    private String lastname;
    private int age;
    //private LocalDate birthYear;
    private int customerID;

    public Person(String firstname, String lastname, int age, int customerID){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.customerID = customerID;
    }

    public int getAge() {
        return age;
    }
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void summarize(){
        System.out.println("**************************");
        System.out.println("Firstname : " + firstname);
        System.out.println("Lastname  : " + lastname);
        System.out.println("Age       : " + age);
        System.out.println("CustomerID: " + customerID);
        System.out.println("**************************");
    }
}
