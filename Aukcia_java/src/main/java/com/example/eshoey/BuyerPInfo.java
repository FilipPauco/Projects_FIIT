package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Classa pre spracovanie informacii GUI kupcu - sukromnika
 */

public class BuyerPInfo {
    @FXML
    private TextField meno;
    @FXML
    private TextField mesto;
    @FXML
    private TextField byt;
    @FXML
    private TextField psc;
    @FXML
    private TextField cislo;

    public void Submit(ActionEvent actionEvent) {
        try {
            Adress adress = new Adress(mesto.getText(),Integer.parseInt(byt.getText()),Integer.parseInt(psc.getText()));
            BuyerPData s = new BuyerPData(meno.getText(),adress,cislo.getText());
            System.out.println("Buyer-Private data has been added !");
            meno.clear();
            mesto.clear();
            byt.clear();
            psc.clear();
            cislo.clear();
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please check format of your input !");
            alert.showAndWait();
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Person_choice.fxml");
    }
}
