
package com.code;

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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Dostavchik{

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
    private TableView<DostavchikDao> table;

    @FXML
    private TableColumn<DostavchikDao, String> ime;

    @FXML
    private TableColumn<DostavchikDao, String> grad;

    @FXML
    private TableColumn<DostavchikDao, String> adres;

    @FXML
    private TableColumn<DostavchikDao, String> telefon;

    @FXML
    private TableColumn<DostavchikDao, String> email;
    
    @FXML
    private TableColumn<DostavchikDao, String> id;

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

ObservableList<DostavchikDao> oblist=FXCollections.observableArrayList();
	public void initialize() {
		 oblist.clear();
		Connection com= DostavchikDao.getConnection();
		try {
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Select *FROM suppliers");
			while (rs.next())  
			{
			
				oblist.add(new DostavchikDao(rs.getString("sup_name"),rs.getString("sup_city"),rs.getString("sup_address"),rs.getString("sup_phone"),rs.getString("sup_email"),Integer.parseInt(rs.getString("sup_id"))));
			 
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
	 
	 static Parent root1 ;
	 
	    public static void close() {
	    	((Stage)root1.getScene().getWindow()).close(); 
	    }
	    @FXML
	    void Add(ActionEvent event) {
	    	boolean flag=false;
    	    try {
    	    	if(textbox1.getText().isEmpty() || textbox2.getText().isEmpty() ||textbox3.getText().isEmpty() || textbox4.getText().isEmpty() || textbox5.getText().isEmpty()) {
    	      		 Alert a = new Alert(AlertType.WARNING);
    	      	    	a.setContentText("Empty textfield");
    	      	    	a.show();
    	      	}
    	    
    	 if(DostavchikDao.insert(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),label1,flag)==true) {
			
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
	      	    	
	      	 if(DostavchikDao.update(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
	      		 
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
	    	    	
	    	 if(DostavchikDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
	    		 
	    	 }
	    	 }
	 	    catch (Exception e)
	 	    		{
	 	    	System.out.println(e);
	 	    		
	     }
	 	    initialize();
	    }

} 
