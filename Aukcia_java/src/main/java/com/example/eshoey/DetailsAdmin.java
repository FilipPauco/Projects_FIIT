package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * zobrazenie detailov aukcie admina
 */
public class DetailsAdmin implements Initializable {
    private Item selectedItem;

    @FXML
    private Label brand;
    @FXML
    private Label name;
    @FXML
    private Label size;
    @FXML
    private Label quantity;
    @FXML
    private Label actual;
    @FXML
    private Label price;
    @FXML
    private Label setError;
    @FXML
    private TextField insertPrice;
    @FXML
    private Label sell;

    public void initData(Item item){
        selectedItem = item;
        brand.setText(selectedItem.getBrand());
        name.setText(selectedItem.getName());
        size.setText(String.valueOf(selectedItem.getSizo()));
        quantity.setText(selectedItem.getQuantity());
        if(val == 0)
            price.setText(String.valueOf(selectedItem.getPrice()));
        else
            price.setText(String.valueOf(val));
        actual.setText(price.getText());
        sell.setText(selectedItem.getSeller());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private Button back;
    @FXML
    private Button bidB;
    @FXML
    private Button endB;


    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Auction_admin.fxml");
    }

    int val = 0;
    public void setValue(ActionEvent actionEvent) {
        if(Integer.parseInt(insertPrice.getText()) > Double.parseDouble(actual.getText())){
            setError.setText("Your bid is accepted !");
            update();
            price.setText(insertPrice.getText());
            selectedItem.setPrice(Double.parseDouble(insertPrice.getText()));
            val = Integer.parseInt(insertPrice.getText());
            actual.setText(insertPrice.getText());
        }
        else{
            setError.setText("Your bid is too low !");
        }
    }

    @FXML private RadioButton legal;
    @FXML private RadioButton privates;

    int k = 5;


    public void endAuction(ActionEvent actionEvent) throws IOException, InterruptedException, RuntimeException {
        int k = Integer.parseInt(actual.getText());
        if(legal.isSelected()) {
            setError.setText("Auction successfully ended with " + k * 0.95 + " €");
            Legal l = new Legal();
            l.message(k);
            System.out.println(l.message(k));

        }
        else
            setError.setText("Auction successfully ended with "+k+" €");
        Private p = new Private();
        System.out.println(p.message(k));
        //Output message = (num) -> "Auction ended with "+num+" €";
        //System.out.println(message);
        String query = "DELETE FROM item WHERE size =" + size.getText();
        executeQuery(query);
        insertPrice.setText("");
        insertPrice.setEditable(false);
        bidB.setDisable(true);

    }

    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showDialog(ActionEvent actionEvent) {
        TextInputDialog text = new TextInputDialog();
        text.setTitle("Verification");
        text.setHeaderText("Verify yourself !");
        text.setContentText("Code: ");
        Optional<String> result = text.showAndWait();
        int a = 5;
        TextField input = text.getEditor();
        if(!input.getText().equals("123456")) {
            legal.setSelected(false);
            setError.setText("Password doesnt match !");
        }
        else
            setError.setText("Now, you are verified as legal person !");
    }

    public void update(){
        String query = "UPDATE item SET price = "+ Double.parseDouble(insertPrice.getText())+"WHERE size = "+size.getText()+"";
        executeQuery(query);
    }
}
