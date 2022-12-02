package ch.noseryoung.blj;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    public int year;
    public int month;
    public int day;
    public String name;
    private static int age;
    public Person(int year, int month, int day, String name){
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;

    }

    public static void sort(Person[] persArr){

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


}
