package com.code;
import java.io.File;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Login {
    @FXML
    private Pane pane;

    @FXML
    private Button login;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @FXML
	private Label label;
    @FXML
    void handlebuttonExit(ActionEvent event){
    	Stage stage = (Stage) exit.getScene().getWindow();
    	  stage.close();
    	 
    }
    @FXML
    void handlebuttonReset(ActionEvent event) {
    	password.clear();
    	username.clear();
    }
    @FXML
    void handlebuttonLogin(ActionEvent event) {
    	  if (username.getText().isEmpty()) {
             label.setText("Please enter your username");
              return;
          }
          if (password.getText().isEmpty()) {
             label.setText("Please enter a password");
              return;
          }
   String username1=username.getText();
   String password1=password.getText();
   LoginDao c = new LoginDao();
    	try {
    			c.getConnection();
    			boolean flag = false;
				if(c.validateLogin(username1,password1,label,flag)==true) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrator.fxml"));
	    		    Parent root1 = (Parent) fxmlLoader.load();
	    		    Stage stage = new Stage();
	    		    stage.setScene(new Scene(root1));  
	    		    stage.show();
				}
    	}
catch (Exception e)
		{
	System.out.println(e);
		}
    	 
    }       
    }
   
    	
   

