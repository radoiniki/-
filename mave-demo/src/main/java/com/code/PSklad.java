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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PSklad {

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
    private TableView<PSkladDao> table;

    @FXML
    private TableColumn<PSkladDao, String> stockname;

    @FXML
    private TableColumn<PSkladDao, String> date;

    @FXML
    private TableColumn<PSkladDao, String> supname;

    @FXML
    private TableColumn<PSkladDao, String> orderprice;

    @FXML
    private TableColumn<PSkladDao, String> quantity;

    @FXML
    private TableColumn<PSkladDao, String> priceach;

    @FXML
    private TableColumn<PSkladDao, String> id;

    @FXML
    private TableColumn<PSkladDao, String> name;

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
    private Button checkbutton;

    @FXML
    private TextField textbox8;

    @FXML
    void Add(ActionEvent event) {
    	boolean flag=false;
	    try {
	    	if(PSkladDao.select(textbox8.getText(),label1,flag)==true) {
	    
	    	}
	    	else {
	    	 if(PSkladDao.insert(textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox8.getText(),label1,flag)==true) {
	    		
	 	    }else {
	 	    	 Alert a = new Alert(AlertType.WARNING);
	 	    	a.setContentText("The information u add is incorrect! Please check your names");
	 	    	a.show();
	 	    }
	 if(PSkladDao.insert1(textbox1.getText(),textbox8.getText(),textbox5.getText(),textbox7.getText(),label1,flag)==true) {
	
	 }else {
	    	 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("The information u add is incorrect! Please check your names");
	    	a.show();
	    }
	 if(PSkladDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {
   	 }
	    	}
	    	
	    }
	    catch (Exception e)
	    		{
	    	System.out.println(e);
	    		
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
   	 if(PSkladDao.update(textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox8.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
   		 
   	 }
   	 if(PSkladDao.update1(textbox1.getText(),textbox5.getText(),textbox7.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
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
     	    	
     	 if(PSkladDao.delete1(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
     		 
     	 }
     	 if(PSkladDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
     		 
     	 }
     	 }
  	    catch (Exception e)
  	    		{
  	    	System.out.println(e);
  	    		
      }
  	    initialize();
    }
    ObservableList<PSkladDao> oblist=FXCollections.observableArrayList();
  void initialize() {
   	 oblist.clear();
   		Connection com= DostavchikDao.getConnection();
   		try {
   			Statement st=com.createStatement();
   			ResultSet rs=st.executeQuery("Select *FROM warehouse_orders w join worder_price p on w.worder_id=p.warehouse_orders_worder_id");
   			while (rs.next())  
   			{
   			
   				oblist.add(new PSkladDao(rs.getString("worder_date"),Integer.parseInt(rs.getString("sup_id")),Integer.parseInt(rs.getString("worder_total")),rs.getString("worder_name"),Integer.parseInt(rs.getString("worder_id")),rs.getString("stocks_st_id"),rs.getString("w_quantity"),rs.getString("w_price_each")));
   			 
   			}
   			
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		date.setCellValueFactory(new PropertyValueFactory<>("date"));
   		supname.setCellValueFactory(new PropertyValueFactory<>("supname"));
   	    orderprice.setCellValueFactory(new PropertyValueFactory<>("priceorder"));
   	   name.setCellValueFactory(new PropertyValueFactory<>("ordername"));
   	   id.setCellValueFactory(new PropertyValueFactory<>("worderid"));
   	stockname.setCellValueFactory(new PropertyValueFactory<>("stockid"));
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	   priceach.setCellValueFactory(new PropertyValueFactory<>("priceeach"));
   	    table.setItems(oblist);
   	}

}
