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

public class Stoka {


    @FXML
    private TextField textbox1;

    @FXML
    private TextField textbox2;

    @FXML
    private TextField textbox3;

    @FXML
    private TableView<StokaDao> table;

    @FXML
    private TableColumn<StokaDao, String> ime;

    @FXML
    private TableColumn<StokaDao, String> expdate;

    @FXML
    private TableColumn<StokaDao, String> quantity;

    @FXML
    private TableColumn<StokaDao, String> id;

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
    void Add(ActionEvent event) {
    	boolean flag=false;
	    try {
	    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty()) {
	      		 Alert a = new Alert(AlertType.WARNING);
	      	    	a.setContentText("Empty textfield");
	      	    	a.show();
	      	}
	    if(StokaDao.select(textbox1.getText(),label1,flag)==true) {
	    
	    }
	    else if(StokaDao.select(textbox1.getText(),label1,flag)==false) {
	 if(StokaDao.insert(textbox1.getText(),textbox2.getText(),Integer.parseInt(textbox3.getText()),label1,flag)==true) {
		
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
    	    	
    	 if(StokaDao.update(textbox1.getText(),textbox2.getText(),Integer.parseInt(textbox3.getText()),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
    		 
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
      	    	
      	 if(StokaDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
      		 
      	 }else {
      		 label1.setText("Delete PSklad and PKlient with that stock");
      	 }
      	 }
   	    catch (Exception e)
   	    		{
   	    	System.out.println(e);
   	    		
       }
   	    initialize();
    }
    ObservableList<StokaDao> oblist=FXCollections.observableArrayList();
    public void initialize() {
		 oblist.clear();
		Connection com= DostavchikDao.getConnection();
		try {
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Select *FROM stocks");
			while (rs.next())  
			{
			
				oblist.add(new StokaDao(Integer.parseInt(rs.getString("st_quantity")),rs.getString("st_name"),rs.getString("st_expdate"),Integer.parseInt(rs.getString("st_id"))));
			 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ime.setCellValueFactory(new PropertyValueFactory<>("ime1"));
	    expdate.setCellValueFactory(new PropertyValueFactory<>("expDate1"));
	    quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	    id.setCellValueFactory(new PropertyValueFactory<>("id1"));
	    table.setItems(oblist);
	}

}
