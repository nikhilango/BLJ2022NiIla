package com.example.demo;

import java.util.ArrayList;

public class Person {
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    ArrayList<String> firstnameList = new ArrayList<>();
    ArrayList<String> lastnameList = new ArrayList<>();
    ArrayList<Integer> ageList = new ArrayList<>();
    ArrayList<String> genderList = new ArrayList<>();
    public Person(String firstname,String lastname,int age, String gender){
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }

    public void presentYourself(){
        System.out.println("This is " + firstname + " " + lastname + ", is a " + gender + " and is " + age + " years old.");

        System.out.println("\n");
    }

    public void saveInfo(int personAmount){
        firstnameList.set(personAmount, firstname);
        lastnameList.set(personAmount, lastname);
        ageList.set(personAmount, age);
        genderList.set(personAmount, gender);
    }
    public void newInfo(){
        firstnameList.add(firstname);
        lastnameList.add(lastname);
        ageList.add(age);
        genderList.add(gender);
    }
    public void delPerson(int personCounter){
        firstnameList.remove(personCounter);
        lastnameList.remove(personCounter);
        ageList.remove(personCounter);
        genderList.remove(personCounter);
    }
}
