package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;

/**
 * Detaily aukcie kupcu
 */
public class Details implements Initializable, PriceOutput {
    private Item selectedItem;
    private ItemBoots s;
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
    @FXML
    private Label sell;
    @FXML
    private Label seller;

    public void initData(Item item){
        selectedItem = item;
        brand.setText(selectedItem.getBrand());
        name.setText(selectedItem.getName());
        size.setText(String.valueOf(selectedItem.getSizo()));
        quantity.setText(selectedItem.getQuantity());
        String a = selectedItem.getType();
        Object selectedlitem = check(a);
        if(val == 0)
            price.setText(String.valueOf(selectedItem.getPrice()));
        else
            price.setText(String.valueOf(val));
        actual.setText(price.getText());
        sell.setText(selectedItem.getSeller());
        //seller.setText("wwtwqt");
        System.out.println("Class of Object is : " + selectedlitem.getClass());

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
        if(sell.getText().equals(seller.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Bidding on own auction is not allowed !");
            alert.showAndWait();
            return;
        }

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

    int k = 5;


    /**
     * V tejto metode vyuzivam lambu, default metodu
     * @param actionEvent
     * @throws IOException
     * @throws InterruptedException
     * @throws RuntimeException
     */
    public void endAuction(ActionEvent actionEvent) throws IOException, InterruptedException, RuntimeException {
        if(!sell.getText().equals(seller.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("This auction is not yours !");
            alert.showAndWait();
            return;
        }
        double k = Double.parseDouble(actual.getText());
        FileReader file = new FileReader("auctionWinner.txt");
        BufferedReader buffer = new BufferedReader(file);
        String line = buffer.readLine();
        String options[] ={"BL1","BL2","BL3","BL4","BL5","BL6","BL7","BL8","BL9","BL10",};
        if(line.contains("L")){
            setError.setText("Auction successfully ended with " + k * 0.95 + " € "+line);
            Legal l = new Legal();
            System.out.println(l.message(k));
            Details ds = new Details();
            ds.say(Double.parseDouble(actual.getText()));
            Output message = (String seller) -> {return seller+", Thanks for using this auction !";};
            System.out.println(message.say(seller.getText()));
        }
        else
            setError.setText("Auction successfully ended with "+k+" € "+line);
            Private p = new Private();
            System.out.println(p.message(k));
            Details ds = new Details();
            ds.say(Double.parseDouble(actual.getText()));
            Output message = (String seller) -> {return seller+", Thanks for using this auction !";};
            System.out.println(message.say(seller.getText()));


            String query = "DELETE FROM item WHERE name ='" + name.getText()+"' ";
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


    public void update(){
        String query = "UPDATE item SET price = "+ Double.parseDouble(insertPrice.getText())+"WHERE name = '"+name.getText()+"'";
        executeQuery(query);
    }

    public void inData(String value,String value2) {
        seller.setText(value);
    }
    public Object check(String a){
        if((a.equals("Sport"))){
            Size si = new Size(5);
            ItemSport s = new ItemSport(1,"w","w",si,"e",5,"f");
            return s;
        }
        else if((a.equals("Sport-I"))){
            Size si = new Size(5);
            ItemSportIndoor s = new ItemSportIndoor(1,"w","w",si,"e",5,"f");
            return s;
        }
        else if((a.equals("Sport-O"))){
            Size si = new Size(5);
            ItemSportOutdoor s = new ItemSportOutdoor(1,"w","w",si,"e",5,"f");
            return s;
        }
        else if((a.equals("Boots"))){
            Size si = new Size(5);
            ItemBoots s = new ItemBoots(1,"w","w",si,"e",5,"f");
            return s;
        }
        return selectedItem;
    }
}
