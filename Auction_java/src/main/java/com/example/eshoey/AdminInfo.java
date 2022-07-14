package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Classa pre spracovanie informacii GUI admina
 */

public class AdminInfo {
    @FXML
    private TextField meno;
    @FXML
    private TextField mesto;

    public void Submit(ActionEvent actionEvent) {
        try {
            AdminData s = new AdminData(meno.getText(),Integer.parseInt(mesto.getText()));
            System.out.println("Admin data has been added !");
            meno.clear();
            mesto.clear();
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
        m.changeScene("MainMenu_admin.fxml");
    }
}
