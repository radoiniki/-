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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
	    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty() || textbox4.getText().isEmpty() || textbox5.getText().isEmpty()|| textbox7.getText().isEmpty()|| textbox8.getText().isEmpty()) {
	      		 Alert a = new Alert(AlertType.WARNING);
	      	    	a.setContentText("Empty textfield");
	      	    	a.show();
	      	}
	    	if(PSkladDao.select(textbox8.getText(),label1,flag)==true) {
	    		Alert a = new Alert(AlertType.INFORMATION);
	 	    	a.setContentText("There is a order with that name! Please add another name for orders.");
	 	    	a.show();
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
	    	}
	    	
	    }
	    catch (Exception e)
	    		{
	    	System.out.println(e);
	    		
    }
	    initialize();
    }
    @FXML
    void Izpisvane(ActionEvent event) {
    	boolean flag=false;
    	if(Integer.parseInt(MainFromDao.pari())<1000) {
    		Alert a = new Alert(Alert.AlertType.CONFIRMATION);
 	    	a.setContentText("WARNING! Money are lower than 1000! Money are:"+MainFromDao.pari() + "be careful");
 	    	Optional<ButtonType> result =a.showAndWait();
 	    	if(result.get() == ButtonType.OK)
 	    	{
 	    		 if(PSkladDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {
 	    	   	 }
 	    	   	 if(PSkladDao.updatemoney(textbox4.getText(),label1,flag)==true) {

 	    	   	 }
 	    	   	 if(PSkladDao.updatemoney1(textbox8.getText(),label1,flag)==true) {

 	    	   	 }
 	    	}
 	    	else if(result.get() == ButtonType.CANCEL)
 	    	{
 	    	}
    	}
    	else {
    		 if(PSkladDao.update2(textbox5.getText(),textbox8.getText(),label1,flag)==true) {
	    	   	 }
	    	   	 if(PSkladDao.updatemoney(textbox4.getText(),label1,flag)==true) {

	    	   	 }
	    	   	 if(PSkladDao.updatemoney1(textbox8.getText(),label1,flag)==true) {

	    	   	 }
    	}
    	if(PSkladDao.updatekasa(label1,flag)==true) {

	  	 }
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
   			ResultSet rs=st.executeQuery("Select *FROM warehouse_orders w join worder_price p on w.worder_id=p.warehouse_orders_worder_id join stocks s on p.stocks_st_id=s.st_id join suppliers su on w.sup_id=su.sup_id");
   			while (rs.next())  
   			{
   			
   				oblist.add(new PSkladDao(rs.getString("worder_date"),rs.getString("sup_name"),Integer.parseInt(rs.getString("worder_total")),rs.getString("worder_name"),Integer.parseInt(rs.getString("worder_id")),rs.getString("st_name"),rs.getString("w_quantity"),rs.getString("w_price_each")));
   			 
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
  @FXML
  void refresh(ActionEvent event) {
initialize();
  }

}
