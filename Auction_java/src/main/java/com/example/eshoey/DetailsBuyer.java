package com.example.eshoey;

import com.example.eshoey.Menus.Choice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Aukcia kupcu
 */
public class DetailsBuyer implements Initializable {
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
    private Label sell;
    @FXML
    private Label setError;
    @FXML
    private TextField insertPrice;
    @FXML
    private TextField password;
    @FXML
    private ChoiceBox<String> buyerLegal;
    @FXML
    private ChoiceBox<String> buyerPrivate;


    /**
     * Nacitanie itemu z predosleho okna do noveho okna GUI
     * @param item
     */
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

    /**
     * Metoda, ktora sa vykona pri otvoreni daneho fxml
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String line = null;
        String namen = "";
        String pass = "";
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
            int i=0;
            while ((line = reader.readLine()) != null) {
                if(i==0)
                    namen = line;
                else
                    pass = line;
                i++;
            }
            //System.out.println("Welcome - "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String optionLegal[] = {"BL1","BL2","BL3","BL4","BL5","BL6","BL7","BL8","BL9",namen};
        String optionPrivate[] = {"BP1","BP2","BP3","BP4","BP5","BP6","BP7","BP8","BP9",namen};
        buyerLegal.getItems().addAll(optionLegal);
        buyerPrivate.getItems().addAll(optionPrivate);
        buyerLegal.setDisable(true);
        buyerPrivate.setDisable(false);
    }
    @FXML
    private Button back;
    @FXML
    private Button bidB;
    @FXML
    private Button endB;


    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Auction_buyerPrivate.fxml");
    }

    int val = 0;

    /**
     * Metoda na bidovanie, vyuzitie vlastnej vynimky
     * @param actionEvent
     * @throws FileNotFoundException
     */
    public void setValue(ActionEvent actionEvent) throws FileNotFoundException {
        String line = null;
        String namen = "";
        String pass = "";
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
            int i=0;
            while ((line = reader.readLine()) != null) {
                if(i==0)
                    namen = line;
                else
                    pass = line;
                i++;
            }
            //System.out.println("Welcome - "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(legal.isSelected())
            buyerPrivate.setValue(null);
        if(privates.isSelected()) {
            buyerLegal.setValue(null);
            legal.setDisable(true);
        }
        if(Integer.parseInt(insertPrice.getText()) > Double.parseDouble(actual.getText())) {
            if (password.getText().isEmpty() || (buyerPrivate.getValue() == null && buyerLegal.getValue() == null))
                setError.setText("Please choose person and input password !");
            else {
                if ((password.getText().equals(pass) || password.getText().equals(buyerPrivate.getValue())) && !password.getText().isEmpty()) {
                    PrintWriter out = new PrintWriter("auctionWinner.txt");
                    out.println(buyerPrivate.getValue());
                    out.close();
                    setError.setText("Your bid is accepted !");
                    update();
                    price.setText(insertPrice.getText());
                    selectedItem.setPrice(Double.parseDouble(insertPrice.getText()));
                    val = Integer.parseInt(insertPrice.getText());
                    actual.setText(insertPrice.getText());
                } else if ((password.getText().equals(pass) || password.getText().equals(buyerLegal.getValue())) && !password.getText().isEmpty()) {
                    PrintWriter out = new PrintWriter("auctionWinner.txt");
                    out.println(buyerLegal.getValue());
                    out.close();
                    setError.setText("Your bid is accepted !");
                    update();
                    price.setText(insertPrice.getText());
                    selectedItem.setPrice(Double.parseDouble(insertPrice.getText()));
                    val = Integer.parseInt(insertPrice.getText());
                    actual.setText(insertPrice.getText());
                }
                else
                    setError.setText("Incorrect password !");
            }

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
            //Output message = (num) -> "Auction ended with "+num*0.95+" €";
            //System.out.println(message);
        }
        else {
            FileReader file = new FileReader("auctionWinner.txt");
            BufferedReader buffer = new BufferedReader(file);
            String line = buffer.readLine();
            setError.setText("Auction successfully ended with " + k + " € and winner is " +line);
        }
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
        else {
            setError.setText("Now, you are verified as legal person !");
            buyerPrivate.setDisable(true);
            buyerPrivate.setValue(null);
            buyerLegal.setDisable(false);
        }
    }

    public void update(){
        String query = "UPDATE item SET price = "+ Double.parseDouble(insertPrice.getText())+"WHERE name = '"+name.getText()+"'";
        executeQuery(query);
    }

    public void showDialog2(ActionEvent actionEvent) {
        buyerLegal.setValue(null);
        buyerLegal.setDisable(true);
        buyerPrivate.setDisable(false);
    }
}
