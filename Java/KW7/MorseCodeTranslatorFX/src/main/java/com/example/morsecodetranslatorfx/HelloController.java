package com.example.morsecodetranslatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloController {

    @FXML
    private TextArea textboxtop;
    @FXML
    private TextArea textboxbottom;
    @FXML
    protected void translate_button() {
            String sentence = textboxtop.getText();
            sentence = sentence.toLowerCase();
            System.out.println(sentence);
            String letters = "";
            for (int i = 0; i < sentence.length(); i++) {
                letters = letters + HelloApplication.getMorseCode().get(String.valueOf(sentence.charAt(i)));
                letters = letters + " ";
            }

            textboxbottom.setText(letters);

        System.out.println("****************************************************************************");
        System.out.println("Enter a morse code LETTER BY LETTER (X when you are finished): ");
        String morse = textboxbottom.getText();

        for (int i = 0; i < conversion.size(); i++){
            System.out.print(alphabet.get(conversion.get(i)));
        }
        System.out.println("\n****************************************************************************");
        return;

        conversion.add(morse);
    }
}