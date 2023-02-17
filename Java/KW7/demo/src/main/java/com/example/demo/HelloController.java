package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class HelloController {
    public Text currentFirstname;
    public Text currentLastname;
    public Text currentAge;
    public Text currentGender;
    public Text personCounterDisplay;
    @FXML
    private TextField firstnameInput;
    @FXML
    private TextField lastnameInput;
    @FXML
    private TextField ageInput;
    @FXML
    private TextField genderInput;

    public int personCounter = 0;

    public int personAmount = 0;

    int counter = 0;
    public ArrayList <String> firstnameList = new ArrayList<>();
    public ArrayList <String> lastnameList = new ArrayList<>();
    public ArrayList <String> ageList = new ArrayList<>();
    public ArrayList <String> genderList = new ArrayList<>();


    @FXML
    protected void prevButton() {
        if (personCounter > 0){
            personCounter--;
        }
        System.out.println("prevButton was pressed " + personCounter + " ," + personAmount);
        currentFirstname.setText(firstnameList.get(personCounter));
        currentLastname.setText(lastnameList.get(personCounter));
        currentAge.setText(String.valueOf(ageList.get(personCounter)));
        currentGender.setText(genderList.get(personCounter));
        personCounterDisplay.setText(String.valueOf(personCounter + 1));
    }
    @FXML
    protected void saveButton() {
        System.out.println("saveButton was pressed");
        firstnameList.set(personCounter, firstnameInput.getText());
        lastnameList.set(personCounter, lastnameInput.getText());
        ageList.set(personCounter, ageInput.getText());
        genderList.set(personCounter, genderInput.getText());
        currentFirstname.setText(firstnameList.get(personCounter));
        currentLastname.setText(lastnameList.get(personCounter));
        currentAge.setText(String.valueOf(ageList.get(personCounter)));
        currentGender.setText(genderList.get(personCounter));
        personCounterDisplay.setText(String.valueOf(personCounter + 1));
    }
    @FXML
    protected void newButton() {
        personAmount++;
        firstnameList.add(firstnameInput.getText());
        lastnameList.add(lastnameInput.getText());
        System.out.println(ageInput.getText());
        ageList.add(ageInput.getText());
        genderList.add(genderInput.getText());
        currentFirstname.setText(firstnameList.get(personCounter));
        currentLastname.setText(lastnameList.get(personCounter));
        currentAge.setText(String.valueOf(ageList.get(personCounter)));
        currentGender.setText(genderList.get(personCounter));
        personCounterDisplay.setText(String.valueOf(personCounter + 1));
    }
    @FXML
    protected void deleteButton() {
        System.out.println("deleteButton was pressed");
        firstnameList.remove(personCounter);
        lastnameList.remove(personCounter);
        ageList.remove(personCounter);
        genderList.remove(personCounter);
        personAmount--;
        if (personCounter != 0){
            currentFirstname.setText(firstnameList.get(personCounter - 1));
            currentLastname.setText(lastnameList.get(personCounter - 1));
            currentAge.setText(String.valueOf(ageList.get(personCounter - 1)));
            currentGender.setText(genderList.get(personCounter - 1));
            personCounterDisplay.setText(String.valueOf(personCounter + 1));
        }
        else if (personCounter == 0){
            currentFirstname.setText(firstnameList.get(personCounter + 1));
            currentLastname.setText(lastnameList.get(personCounter + 1));
            currentAge.setText(String.valueOf(ageList.get(personCounter + 1)));
            currentGender.setText(genderList.get(personCounter + 1));
            personCounterDisplay.setText(String.valueOf(personCounter + 1));
        }
    }
    @FXML
    protected void nextButton() {
        if ((personCounter != 0 || counter != 0) && personCounter + 1 < personAmount){
            personCounter++;
        }
        System.out.println("nextButton was pressed " + personCounter + " ," + personAmount);
        counter = 1;
        currentFirstname.setText(firstnameList.get(personCounter));
        currentLastname.setText(lastnameList.get(personCounter));
        currentAge.setText(String.valueOf(ageList.get(personCounter)));
        currentGender.setText(genderList.get(personCounter));
        personCounterDisplay.setText(String.valueOf(personCounter + 1));
    }
}