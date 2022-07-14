package com.example.eshoey;

import com.example.eshoey.HelloApplication;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Classa pre login okno
 */

public class Login implements EventHandler<ActionEvent>{
    public Login(){

    }
    Button b;
    @FXML
    private Button button;
    @FXML
    private Button register;
    @FXML
    private RadioButton cb1;
    @FXML
    private RadioButton cb2;
    @FXML
    private RadioButton cb3;
    @FXML
    private RadioButton cb4;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    TextField btn;
    TextField bto;

    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    private void checkLogin() throws IOException{
        HelloApplication m = new HelloApplication();

        String line = null;
        String name = "";
        String pass = "";
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
            int i=0;
            while ((line = reader.readLine()) != null) {
                if(i==0)
                    name = line;
                else
                    pass = line;
                i++;
            }
            //System.out.println("Welcome - "+name);
        }
        if(cb1.isSelected()){
            if(username.getText().toString().equals("seller") && password.getText().toString().equals("Sell123") || username.getText().equals(name) && password.getText().equals(pass)){
                wrongLogin.setText("Login successful");
                m.changeScene("MainMenu.fxml");
            }
            else
                wrongLogin.setText("Wrong username or password, or check selected checkbox");
        }
        else if(cb2.isSelected()){
            if(username.getText().toString().equals("buyer") && password.getText().toString().equals("Buy456") || username.getText().equals(name) && password.getText().equals(pass)){
                wrongLogin.setText("Login successful");
                m.changeScene("Person_choice.fxml");
            }
            else
                wrongLogin.setText("Wrong username or password, or check selected checkbox");
        }
        else if(cb3.isSelected()){
            if(username.getText().toString().equals("user") && password.getText().toString().equals("123") || username.getText().equals(name) && password.getText().equals(pass)){
                wrongLogin.setText("Login successful");
                m.changeScene("MainMenu_user.fxml");
            }
            else
                wrongLogin.setText("Wrong username or password, or check selected checkbox");
        }
        else if(cb4.isSelected()){
            if(username.getText().toString().equals("admin") && password.getText().toString().equals("Adm789") || username.getText().equals(name) && password.getText().equals(pass)){
                wrongLogin.setText("Login successful");
                m.changeScene("MainMenu_admin.fxml");
            }
            else
                wrongLogin.setText("Wrong username or password, or check selected checkbox");
        }
        else
            wrongLogin.setText("Please select checkbox");
        }

    public void checkEvent(ActionEvent actionEvent) {
    }

    /**
     *
     * @param event - button s vlastne definovanym gui
     * @throws IOException
     */

    public void register(ActionEvent event) throws IOException{
        b = new Button();
        b.setText("Register");
        b.setOnAction(this);
        HBox sp = new HBox();
        //sp.getChildren().addAll(b);
        btn = new TextField();
        bto = new TextField();
        btn.setMaxSize(80,30);
        btn.setPromptText("Name");
        bto.setPromptText("Password");
        bto.setMaxSize(80,30);
        sp.getChildren().addAll(btn,bto,b);
        sp.setAlignment(Pos.CENTER);
        sp.setSpacing(25);
        Scene s = new Scene(sp,600,400);
        HelloApplication m = new HelloApplication();
        m.changeScene2(s);

    }


    /**
     *
     * @param actionEvent - vlastny handler
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()== b && !btn.getText().isBlank() && !bto.getText().isBlank()){
            try {
                PrintWriter out = new PrintWriter("filename.txt");
                out.println(btn.getText());
                out.println(bto.getText());
                System.out.println("Data added !");
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Empty data !");
    }
}

