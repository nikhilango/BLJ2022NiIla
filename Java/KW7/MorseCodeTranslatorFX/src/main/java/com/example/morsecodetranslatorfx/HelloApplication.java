package com.example.morsecodetranslatorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Morse Code Translator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static HashMap<String, String> getMorseCode(){
        HashMap<String, String> morseCode = new HashMap<>();
        morseCode.put(" ", "/");
        morseCode.put("a", ".-");
        morseCode.put("b", "-...");
        morseCode.put("c", "-.-.");
        morseCode.put("d", "-..");
        morseCode.put("e", ".");
        morseCode.put("f", "..-.");
        morseCode.put("g", "--.");
        morseCode.put("h", "....");
        morseCode.put("i", "..");
        morseCode.put("j", ".---");
        morseCode.put("k", "-.-");
        morseCode.put("l", ".-..");
        morseCode.put("m", "--");
        morseCode.put("n", "-.");
        morseCode.put("o", "---");
        morseCode.put("p", ".--.");
        morseCode.put("q", "--.-");
        morseCode.put("r", ".-.");
        morseCode.put("s", "...");
        morseCode.put("t", "-");
        morseCode.put("u", "..-");
        morseCode.put("v", "...-");
        morseCode.put("w", ".--");
        morseCode.put("x", "-..-");
        morseCode.put("y", "-.--");
        morseCode.put("z", "--..");
        morseCode.put("0", ".----");
        morseCode.put("1", "..---");
        morseCode.put("2", "...--");
        morseCode.put("3", "....-");
        morseCode.put("4", ".....");
        morseCode.put("5", "-....");
        morseCode.put("6", "--...");
        morseCode.put("7", "---..");
        morseCode.put("8", "----.");
        morseCode.put("9", "-----");
        HashMap<String, String> alphabet = new HashMap<>();
        alphabet.put( "/", " ");
        alphabet.put(".-", "a") ;
        alphabet.put("-...", "b");
        alphabet.put( "-.-.", "c");
        alphabet.put( "-..", "d");
        alphabet.put(".", "e");
        alphabet.put("..-.", "f");
        alphabet.put("--.", "g");
        alphabet.put("....", "h");
        alphabet.put( "..", "i");
        alphabet.put(".---", "j");
        alphabet.put("-.-", "k");
        alphabet.put(".-..", "l");
        alphabet.put( "--", "m");
        alphabet.put( "-.", "n");
        alphabet.put( "---", "o");
        alphabet.put( ".--.", "p");
        alphabet.put( "--.-", "q");
        alphabet.put(".-.", "r");
        alphabet.put("...", "s");
        alphabet.put( "-", "t");
        alphabet.put("..-", "u");
        alphabet.put("...-", "v");
        alphabet.put(".--", "w");
        alphabet.put("-..-", "x");
        alphabet.put("-.--", "y");
        alphabet.put( "--..", "z");
        alphabet.put(".----", "0");
        alphabet.put("..---", "1");
        alphabet.put("...--", "2");
        alphabet.put("....-", "3");
        alphabet.put(".....", "4");
        alphabet.put("-....", "5");
        alphabet.put("--...", "6");
        alphabet.put("---..", "7");
        alphabet.put("----.", "8");
        alphabet.put("-----", "9");
        return morseCode;
    }

}