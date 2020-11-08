package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
     			ResultSet rs=st.executeQuery("Select *FROM client_orders w join corder_price p on w.corder_id=p.client_orders_corder_id");
     			while (rs.next())  
     			{
     			
     				oblist.add(new PklientDao(rs.getString("stocks_st_id"),rs.getString("corder_date"),rs.getString("staff_id"),Integer.parseInt(rs.getString("corder_total")),Integer.parseInt(rs.getString("quantity")),Integer.parseInt(rs.getString("price_each")),rs.getString("corder_name"),rs.getString("cl_id"),Integer.parseInt(rs.getString("corder_id"))));
     			 
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
    void Izpisvane(ActionEvent event) {
    	boolean flag=false;
   	 if(PklientDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {
   	 }
    }


}
