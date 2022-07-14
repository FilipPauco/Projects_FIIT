package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
/**
 * Classa pre spracovanie informacii GUI usera
 */

public class UserInfo {
    @FXML
    private TextField meno;
    public void Submit(ActionEvent actionEvent) {
        try {
            UserData s = new UserData(meno.getText());
            System.out.println("User data has been added !");
            meno.clear();
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
        m.changeScene("MainMenu_user.fxml");
    }

}
