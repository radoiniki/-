package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Pklient {

    @FXML
    private TextField textbox1;

    @FXML
    private TextField textbox2;

    @FXML
    private TextField textbox3;

    @FXML
    private TextField textbox4;

    @FXML
    private TextField textbox5;

    @FXML
    private TableView<PklientDao> table;

    @FXML
    private TableColumn<PklientDao, String> stockname;

    @FXML
    private TableColumn<PklientDao, String> date;

    @FXML
    private TableColumn<PklientDao, String> supname;

    @FXML
    private TableColumn<PklientDao, String> orderprice;

    @FXML
    private TableColumn<PklientDao, String> quantity;

    @FXML
    private TableColumn<PklientDao, String> priceach;

    @FXML
    private TableColumn<PklientDao, String> id;

    @FXML
    private TableColumn<PklientDao, String> name;

    @FXML
    private TableColumn<PklientDao, String> clname;

    @FXML
    private Button button2;

    @FXML
    private Button button1;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Label label1;

    @FXML
    private TextField textbox6;

    @FXML
    private Button button5;

    @FXML
    private TextField textbox7;

    @FXML
    private TextField textbox8;

    @FXML
    private TextField textbox9;

    @FXML
    void Add(ActionEvent event) {
    	boolean flag=false;
    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty() || textbox4.getText().isEmpty() || textbox5.getText().isEmpty()|| textbox7.getText().isEmpty()|| textbox8.getText().isEmpty() || textbox9.getText().isEmpty()) {
   		 Alert a = new Alert(AlertType.WARNING);
   	    	a.setContentText("Empty textfield");
   	    	a.show();
   	}
    	if(PklientDao.select(textbox8.getText(),label1,flag)==true) {
    		Alert a = new Alert(AlertType.INFORMATION);
 	    	a.setContentText("There is a order with that name! Please add another name for orders.");
 	    	a.show();
    	}
    	else {
    	 if(PklientDao.insert(textbox2.getText(),textbox9.getText(),textbox3.getText(),textbox4.getText(),textbox8.getText(),label1,flag)==true) {
	    		
	 	    }else {
	 	    	 Alert a = new Alert(AlertType.WARNING);
	 	    	a.setContentText("The information u add is incorrect! Please check your names");
	 	    	a.show();
	 	    }
    	 if(PklientDao.insert1(textbox1.getText(),textbox8.getText(),Integer.parseInt(textbox5.getText()),Integer.parseInt(textbox7.getText()),label1,flag)==true) {
	    		
	 	    }else {
	 	    	 Alert a = new Alert(AlertType.WARNING);
	 	    	a.setContentText("The information u add is incorrect! Please check your names");
	 	    	a.show();
	 	    }
    	}
    	initialize();
    }

    @FXML
    void Back(ActionEvent event) {
    	try {	
	    	MainForm.close();
	    	Login.show();
	    	}
	catch (Exception e)
		{
	System.out.println(e);
		}
    }

    @FXML
    void Edit(ActionEvent event) {
    	boolean flag=false;
      	 try {
      	 if(PklientDao.update(textbox2.getText(),textbox9.getText(),textbox3.getText(),textbox4.getText(),textbox8.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
      		 
      	 }
      	else {
	    	 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("The information u add is incorrect! Please check your names");
	    	a.show();
	    }
      	 if(PklientDao.update1(textbox1.getText(),textbox5.getText(),textbox7.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
      	 }
      	else {
	    	 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("The information u add is incorrect! Please check your names");
	    	a.show();
	    }
      	 }
   	    catch (Exception e)
   	    		{
   	    	System.out.println(e);
   	    		
       }
   	    initialize();
    }

    @FXML
    void Exit(ActionEvent event) {
Platform.exit();
    }

    @FXML
    void Remove(ActionEvent event) {
    	boolean flag=false;
    	 try {
    	    	
    	 if(PklientDao.delete1(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
    		 
    	 }
    	 else {
 	    	 Alert a = new Alert(AlertType.WARNING);
 	    	a.setContentText("Check id");
 	    	a.show();
 	    }
    	 if(PklientDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
    		 
    	 }
    	 else {
 	    	 Alert a = new Alert(AlertType.WARNING);
 	    	a.setContentText("Check id");
 	    	a.show();
 	    }
    	 }
 	    catch (Exception e)
 	    		{
 	    	System.out.println(e);
 	    		
     }
 	    initialize();
    }
    ObservableList<PklientDao> oblist=FXCollections.observableArrayList();
    void initialize() {
     	 oblist.clear();
     		Connection com= DostavchikDao.getConnection();
     		try {
     			Statement st=com.createStatement();
     			ResultSet rs=st.executeQuery("Select *FROM client_orders w join corder_price p on w.corder_id=p.client_orders_corder_id join stocks s on p.stocks_st_id=s.st_id join staff st on w.staff_id=st.staff_id join clients c on w.cl_id=c.cl_id");
     			while (rs.next())  
     			{
     			
     				oblist.add(new PklientDao(rs.getString("st_name"),rs.getString("corder_date"),rs.getString("staff_fullname"),Integer.parseInt(rs.getString("corder_total")),Integer.parseInt(rs.getString("quantity")),Integer.parseInt(rs.getString("price_each")),rs.getString("corder_name"),rs.getString("cl_name"),Integer.parseInt(rs.getString("corder_id"))));
     			 
     			}
     			
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     	   	stockname.setCellValueFactory(new PropertyValueFactory<>("stockname"));
     		date.setCellValueFactory(new PropertyValueFactory<>("date"));
     		supname.setCellValueFactory(new PropertyValueFactory<>("staffname"));
     	    orderprice.setCellValueFactory(new PropertyValueFactory<>("priceorder"));
     	   name.setCellValueFactory(new PropertyValueFactory<>("ordername"));
  		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
  	   priceach.setCellValueFactory(new PropertyValueFactory<>("priceeach"));
  	   clname.setCellValueFactory(new PropertyValueFactory<>("clname"));
  	 id.setCellValueFactory(new PropertyValueFactory<>("corderid"));
     	    table.setItems(oblist);
     	}
    @FXML
    void refresh(ActionEvent event) {
initialize();
    }
    @FXML
    void Izpisvane(ActionEvent event) {
    	boolean flag=false;
    	if(Integer.parseInt(MainFromDao.stocks())<1000) {
    		Alert a = new Alert(Alert.AlertType.CONFIRMATION);
 	    	a.setContentText("WARNING! Stocks are lower than 1000! Stocks are:"+MainFromDao.stocks() + "be careful");
 	    	Optional<ButtonType> result =a.showAndWait();
 	    	if(result.get() == ButtonType.OK)
 	    	{
 	    		 if(PklientDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {

 	    	   	 }
 	    	   	 if(PklientDao.updatemoney(textbox4.getText(),label1,flag)==true) {

 	    	   	 }
 	    	   	 if(PklientDao.updatemoney1(textbox8.getText(),label1,flag)==true) {

 	    	   	 }
 	    	}
 	    	else if(result.get() == ButtonType.CANCEL)
 	    	{
 	    	}
    	}
    	else{
   	 if(PklientDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {

   	 }
   	 if(PklientDao.updatemoney(textbox4.getText(),label1,flag)==true) {

   	 }
   	 if(PklientDao.updatemoney1(textbox8.getText(),label1,flag)==true) {

   	 }
   	
    }
    	if(PklientDao.updatekasa(label1,flag)==true) {

     	 }
}
}