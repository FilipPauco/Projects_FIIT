package com.example.eshoey.About;

import com.example.eshoey.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class About {
    @FXML
    private Button back;

    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("MainMenu_user.fxml");
    }
}
