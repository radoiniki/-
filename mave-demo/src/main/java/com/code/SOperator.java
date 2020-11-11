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

public class SOperator {


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
    private TableView<SOperatorDao> table;

    @FXML
    private TableColumn<SOperatorDao, String> ime;

    @FXML
    private TableColumn<SOperatorDao, String> grad;

    @FXML
    private TableColumn<SOperatorDao, String> adres;

    @FXML
    private TableColumn<SOperatorDao, String> telefon;

    @FXML
    private TableColumn<SOperatorDao, String> email;

    @FXML
    private TableColumn<SOperatorDao, String> id;

    @FXML
    private TableColumn<SOperatorDao, String> password;
    
    @FXML
    private TableColumn<SOperatorDao, String> username;

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
    void Add(ActionEvent event) {
    	boolean flag=false;
    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty() || textbox4.getText().isEmpty() || textbox5.getText().isEmpty()|| textbox7.getText().isEmpty()|| textbox8.getText().isEmpty()) {
      		 Alert a = new Alert(AlertType.WARNING);
      	    	a.setContentText("Empty textfield");
      	    	a.show();
      	}
if(SOperatorDao.select(textbox5.getText(),label1,flag)==true) {
    		
 	    }
else {
    	if(SOperatorDao.insert(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),label1,flag)==true) {
    		
 	    }else {
 	    	 Alert a = new Alert(AlertType.WARNING);
 	    	a.setContentText("The information u add is incorrect! Please check your names");
 	    	a.show();
 	    }
	 if(SOperatorDao.insert1(textbox7.getText(),textbox8.getText(),textbox5.getText(),label1,flag)==true) {
    		
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
     	 if(SOperatorDao.update(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
     		 
     	 }
     	else {
	    	 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("The information u add is incorrect! Please check your names");
	    	a.show();
	    }
     	 if(SOperatorDao.update1(textbox7.getText(),textbox8.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
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
   	    	
   	 if(SOperatorDao.delete1(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
   		 
   	 }
   	 else {
	    	 Alert a = new Alert(AlertType.WARNING);
	    	a.setContentText("Check id");
	    	a.show();
	    }
   	 if(SOperatorDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
   		 
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
    ObservableList<SOperatorDao> oblist=FXCollections.observableArrayList();
    void initialize() {
     	 oblist.clear();
     		Connection com= DostavchikDao.getConnection();
     		try {
     			Statement st=com.createStatement();
     			ResultSet rs=st.executeQuery("Select *FROM warehouse_operator w join user1 p on w.op_id=p.op_id");
     			while (rs.next())  
     			{
     			
     				oblist.add(new SOperatorDao(rs.getString("op_fullname"),rs.getString("op_city"),rs.getString("op_address"),rs.getString("op_phone"),rs.getString("op_email"),rs.getString("username"),rs.getString("password"),rs.getString("op_id")));
     			 
     			}
     			
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		ime.setCellValueFactory(new PropertyValueFactory<>("name"));
    	    grad.setCellValueFactory(new PropertyValueFactory<>("city"));
    	    adres.setCellValueFactory(new PropertyValueFactory<>("adress"));
    	    telefon.setCellValueFactory(new PropertyValueFactory<>("phone"));
    	    email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	    id.setCellValueFactory(new PropertyValueFactory<>("opid"));
    	    username.setCellValueFactory(new PropertyValueFactory<>("username"));
    	    password.setCellValueFactory(new PropertyValueFactory<>("password"));
     	    table.setItems(oblist);
     	}
}
