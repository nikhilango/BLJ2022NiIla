package ch.noseryoung.blj;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Person {
    public int year;
    public static int month;
    public int day;
    public String name;

    public Person(int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;

    }

    public static void readData() {
        String path = "C:\\Users\\nikhi\\Documents\\Noser Young\\Personen_Aufgabe_2022-2023.csv";
        String line = "";
        int counter = 0;
        String[] names = new String[40];
        int[] years = new int[40];
        int[] months = new int[40];
        int[] days = new int[40];
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                names[counter] = values[0];
                System.out.println("TEST");
                int value = Integer.parseInt(values[2]);
                years[counter] = value;
                System.out.println("TEST");
                value = Integer.parseInt(values[3]);
                months[counter] = value;
                value = Integer.parseInt(values[4]);
                days[counter] = value;
                //System.out.println(values[0]  + ", " + values[2] + ", " + values[3] + ", " + values[4]);
                counter++;
            }
            for (int i = 0; i < 40; i++){
                System.out.println(names[i] + ", " + years[i] + ", "+ months[i] +", " + days[i]);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}



