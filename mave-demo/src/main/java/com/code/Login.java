package com.code;
import javafx.application.Platform;
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
public class Login{
    public PasswordField getPassword() {
		return password;
	}
	public void setPassword(PasswordField password) {
		this.password = password;
	}
	public TextField getUsername() {
		return username;
	}
	public void setUsername(TextField username) {
		this.username = username;
	}
	@FXML
    private Pane pane;

    @FXML
    private Button login;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    public PasswordField password;

    @FXML
    public TextField username;
    @FXML
	private Label label;
    static Parent root1;
    @FXML
    void handlebuttonExit(ActionEvent event){
    	Platform.exit();
    	 
    }
    @FXML
    void handlebuttonReset(ActionEvent event) {
    	password.clear();
    	username.clear();
    }
    boolean flag=false;
    @FXML
    void handlebuttonLogin(ActionEvent event) {
    	  String username1=username.getText();
   	   String password1=password.getText();
    	  if (username1.isEmpty()) {
             label.setText("Please enter your username");
          }
          if (password1.isEmpty()) {
             label.setText("Please enter a password");
          }
          LoginDao c = new LoginDao();
    	try {
    			c.getConnection();				
				if(c.validateLogin(username1,password1,label,flag)==true) {	
					if(c.validateLogin1(username1, password1, flag)==true)
					{
					LoginStart.close();	
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrator.fxml"));
			    		   root1 = (Parent) fxmlLoader.load();
			    		    Stage stage = new Stage();
			    		    stage.setScene(new Scene(root1)); 
			    		    stage.show();  
			    		    LoggerClass.Logger();
					}else {
						LoginStart.close();	
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrator2.fxml"));
			    		   root1 = (Parent) fxmlLoader.load();
			    		    Stage stage = new Stage();
			    		    stage.setScene(new Scene(root1)); 
			    		    stage.show();  
			    		    LoggerClass.Logger();
					}
			    		
					}
				
    	}
catch (Exception e)
		{
	System.out.println(e);
		}
    	 
    }   
    public static void close() {
    	((Stage)root1.getScene().getWindow()).close(); 
    }
	public static void show() {
		((Stage)root1.getScene().getWindow()).show(); 
		
	}
}

   
    	
   

