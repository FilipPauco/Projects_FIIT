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
 * Classa pre kupcovu aukciu
 */
public class DetailsSeller implements Initializable, PriceOutput  {
    private Item selectedItem;
    private ItemBoots iB;
    private ItemSport iS;
    private ItemSportIndoor iSI;
    private ItemSportOutdoor iSO;


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

    public void initData(Item item,ItemBoots iB,ItemSport iS,ItemSportIndoor iSI,ItemSportOutdoor iSO){
        selectedItem = item;
        this.iB = iB;
        this.iS = iS;
        this.iSI = iSI;
        this.iSO = iSO;
        brand.setText(selectedItem.getBrand());
        name.setText(selectedItem.getName());
        size.setText(String.valueOf(selectedItem.getSizo()));
        quantity.setText(selectedItem.getQuantity());
        String a = selectedItem.getType();
        if(val == 0)
            price.setText(String.valueOf(selectedItem.getPrice()));
        else
            price.setText(String.valueOf(val));
        actual.setText(price.getText());

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
        m.changeScene("Auction.fxml");
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


    /**
     * Ukoncenie aukcie
     * @param actionEvent
     * @throws IOException
     * @throws InterruptedException
     * @throws RuntimeException
     */
    public void endAuction(ActionEvent actionEvent)throws IOException, InterruptedException, RuntimeException{
        int k = Integer.parseInt(actual.getText());
        if(legal.isSelected()) {
            setError.setText("Auction successfully ended with " + k * 0.95 + " €");
            Legal l = new Legal();
            System.out.println(l.message(k));
            DetailsSeller ds = new DetailsSeller();
            ds.say(Double.parseDouble(actual.getText()));
            //Output message = (num) -> "Auction ended with "+num*0.95+" €";
            //System.out.println(message);
        }
        else
            setError.setText("Auction successfully ended with "+k+" €");
        Private p = new Private();
        System.out.println(p.message(k));
        DetailsSeller ds = new DetailsSeller();
        ds.say(Double.parseDouble(actual.getText()));
        //Output message = (num) -> "Auction ended with "+num+" €";
        //System.out.println(message);
        String query = "DELETE FROM item WHERE size =" + size.getText();
        executeQuery(query);
        insertPrice.setText("");
        insertPrice.setEditable(false);
        bidB.setDisable(true);

    }

    /**
     * praca s databazou
     * @param query
     */
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
    /**
     * praca s databazou
     */
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