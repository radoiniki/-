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

public class Kasa {


    @FXML
    private TextField textbox1;

    @FXML
    private TextField textbox2;

    @FXML
    private TextField textbox4;

    @FXML
    private TableView<KasaDao> table;

    @FXML
    private TableColumn<KasaDao, String> ime;

    @FXML
    private TableColumn<KasaDao, String> grad;

    @FXML
    private TableColumn<KasaDao, String> adres;

    @FXML
    private TableColumn<KasaDao, String> telefon;

    @FXML
    private TableColumn<KasaDao, String> id;

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
    private Button button5;

    @FXML
    void Add(ActionEvent event) {
    	boolean flag=false;
	    try {
	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() || textbox4.getText().isEmpty()) {
		 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("Empty textfield");
	    	a.show();
	}

	    
	 if(KasaDao.insert(textbox1.getText(),textbox2.getText(),textbox4.getText(),label1,flag)==true) {
		
	 }else {
		 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("Cant't have more than one moneydesk");
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
    	    	
    	 if(KasaDao.update(textbox1.getText(),textbox2.getText(),textbox4.getText(),label1,flag)==true) {
    		 
    	 }
    	 }
 	    catch (Exception e)
 	    		{
 	    	System.out.println(e);
    }
    }

    @FXML
    void Exit(ActionEvent event) {
Platform.exit();
    }

    @FXML
    void Remove(ActionEvent event) {
    	boolean flag=false;
      	 try {
      	    	
      	 if(KasaDao.delete(label1,flag)==true) {
      		 
      	 }
      	 }
   	    catch (Exception e)
   	    		{
   	    	System.out.println(e);
   	    		
       }
      	 initialize();
    }

    ObservableList<KasaDao> oblist=FXCollections.observableArrayList();
    void initialize() {
    	 oblist.clear();
 		Connection com= DostavchikDao.getConnection();
 		try {
 			Statement st=com.createStatement();
 			ResultSet rs=st.executeQuery("Select *FROM moneydesk");
 			while (rs.next())  
 			{
 			
 				oblist.add(new KasaDao(rs.getString("money_income"),rs.getString("money_costs"),rs.getString("money_profit"),rs.getString("money_date")));
 			 
 			}
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		ime.setCellValueFactory(new PropertyValueFactory<>("income"));
 	    grad.setCellValueFactory(new PropertyValueFactory<>("costs"));
 	    adres.setCellValueFactory(new PropertyValueFactory<>("date"));
 	    telefon.setCellValueFactory(new PropertyValueFactory<>("profit"));
 	    table.setItems(oblist);

    }
    @FXML
    void refresh(ActionEvent event) {
    	
initialize();
    }
}
