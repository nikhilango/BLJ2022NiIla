module com.example.morsecodetranslatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.morsecodetranslatorfx to javafx.fxml;
    exports com.example.morsecodetranslatorfx;
}