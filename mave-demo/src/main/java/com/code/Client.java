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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Client {

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
    private TableView<ClientDao> table;

    @FXML
    private TableColumn<ClientDao, String> ime;

    @FXML
    private TableColumn<ClientDao, String> grad;

    @FXML
    private TableColumn<ClientDao, String> adres;

    @FXML
    private TableColumn<ClientDao, String> telefon;

    @FXML
    private TableColumn<ClientDao, String> email;

    @FXML
    private TableColumn<ClientDao, String> id;

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
	
	    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty() || textbox4.getText().isEmpty() || textbox5.getText().isEmpty()) {
	      		 Alert a = new Alert(AlertType.WARNING);
	      	    	a.setContentText("Empty textfield");
	      	    	a.show();
	      	}
	 if(ClientDao.insert(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),label1,flag)==true) {
		
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
     	    	
     	 if(ClientDao.update(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
     		 
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
   	    	
   	 if(ClientDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
   		 
   	 }
   	 }
	    catch (Exception e)
	    		{
	    	System.out.println(e);
	    		
    }
	    initialize();
    }

    static Parent root1 ;
	 
    public static void close() {
    	((Stage)root1.getScene().getWindow()).close(); 
    }
    ObservableList<ClientDao> oblist=FXCollections.observableArrayList();
	public void initialize() {
		 oblist.clear();
		Connection com= DostavchikDao.getConnection();
		try {
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Select *FROM clients");
			while (rs.next())  
			{
			
				oblist.add(new ClientDao(rs.getString("cl_name"),rs.getString("cl_city"),rs.getString("cl_address"),rs.getString("cl_phone"),rs.getString("cl_email"),Integer.parseInt(rs.getString("cl_id"))));
			 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ime.setCellValueFactory(new PropertyValueFactory<>("ime1"));
	    grad.setCellValueFactory(new PropertyValueFactory<>("grad1"));
	    adres.setCellValueFactory(new PropertyValueFactory<>("adres1"));
	    telefon.setCellValueFactory(new PropertyValueFactory<>("telefon1"));
	    email.setCellValueFactory(new PropertyValueFactory<>("email1"));
	    id.setCellValueFactory(new PropertyValueFactory<>("id1"));
	    table.setItems(oblist);
	}
	  @FXML
	    void refresh(ActionEvent event) {
initialize();
	    }
}
