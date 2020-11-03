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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Staff {

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
    private TableView<StaffDao> table;

    @FXML
    private TableColumn<StaffDao, String> ime;

    @FXML
    private TableColumn<StaffDao, String> grad;

    @FXML
    private TableColumn<StaffDao, String> adres;

    @FXML
    private TableColumn<StaffDao, String> telefon;

    @FXML
    private TableColumn<StaffDao, String> email;

    @FXML
    private TableColumn<StaffDao, String> id;
    
    @FXML
    private TableColumn<StaffDao, String> salary;

    @FXML
    private TableColumn<StaffDao, String> pos_name;

    @FXML
    private Button button2;
    
    @FXML
    private Button checkbutton;
    
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
	    try {
	
	 if(StaffDao.insert(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),textbox7.getText(),textbox8.getText(),label1,flag)==true) {
		
	 
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
    void Check(ActionEvent event) {
    	 boolean flag=false;
 	    try {
 	    	if(StaffDao.select(textbox8.getText(), label1, flag)==true)
 	    	{
 	    	}
 	    	if(StaffDao.select(textbox8.getText(), label1, flag)==false){
 	    		if(StaffDao.insert1(textbox8.getText(),label1,flag)==true) {
 	 	      	 
 	 	    	 }
 	    		
 	    	}
 	
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
    	 if(StaffDao.update(textbox1.getText(),textbox2.getText(),textbox3.getText(),textbox4.getText(),textbox5.getText(),textbox7.getText(),Integer.parseInt(textbox6.getText()),label1,flag)==true) {
    		 
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
      	    	
      	 if(StaffDao.delete(Integer.parseInt(textbox6.getText()),label1,flag)==true) {
      		 
      	 }
      	 }
   	    catch (Exception e)
   	    		{
   	    	System.out.println(e);
   	    		
       }
   	    initialize();
    }
    ObservableList<StaffDao> oblist=FXCollections.observableArrayList();
 void initialize() {
	 oblist.clear();
		Connection com= DostavchikDao.getConnection();
		try {
			Statement st=com.createStatement();
			ResultSet rs=st.executeQuery("Select *FROM staff");
			while (rs.next())  
			{
			
				oblist.add(new StaffDao(rs.getString("staff_fullname"),rs.getString("staff_city"),rs.getString("staff_address"),rs.getString("staff_phone"),rs.getString("staff_email"),rs.getString("staff_salary"),rs.getString("pos_id"),Integer.parseInt(rs.getString("staff_id"))));
			 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
	    grad.setCellValueFactory(new PropertyValueFactory<>("grad"));
	    adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
	    telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
	    email.setCellValueFactory(new PropertyValueFactory<>("email"));
	    id.setCellValueFactory(new PropertyValueFactory<>("id1"));
	    salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
	    pos_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	    table.setItems(oblist);
	}

}
