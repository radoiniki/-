package com.code;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainForm{

    @FXML
    private Pane Pane;

    @FXML
    private Pane Pane1;

    @FXML
    private Button button1;

    @FXML
    private Pane Pane2;

    @FXML
    private Button button12;

    @FXML
    private Button button13;

    @FXML
    private Button button14;

    @FXML
    private Button button11;

    @FXML
    private Button button15;

    @FXML
    private Button button16;

    @FXML 
    private Button button17;

    @FXML
    private Button button18;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Pane Pane3;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Pane Pane4;

    @FXML
    private Button button31;

    @FXML
    private Button button32;

    @FXML
    private Pane Pane5;

    @FXML
    private Button button41;

    @FXML
    private Button button42;

    @FXML
    private Button button43;

    @FXML
    private Button button46;

    @FXML
    private Button button45;

    @FXML
    private Button button44;


    @FXML
    void showPane1(ActionEvent event) {
    	if(Pane2.isVisible())
    	{
    	Pane2.setVisible(false);
    	}
    	else {
     Pane2.setVisible(true);
    	}
    }
    @FXML
    void showPane3(ActionEvent event) {
    	if(Pane4.isVisible())
    	{
    	Pane4.setVisible(false);
    	}
    	else {
     Pane4.setVisible(true);
    	}
    }

    @FXML
    void showPane4(ActionEvent event) {
    	if(Pane5.isVisible())
    	{
    	Pane5.setVisible(false);
    	}
    	else {
     Pane5.setVisible(true);
    	}
    }
    @FXML
    void Exit(ActionEvent event) {
Platform.exit();
    }
    @FXML
    void AddSupplier(ActionEvent event) {
    	try {		
    	 Login.close();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneDostavchik.fxml"));
	    		   root1 = (Parent) fxmlLoader.load();
	    		    Stage stage = new Stage();
	    		    stage.setScene(new Scene(root1));  
	    		    stage.show();	    		    	    		   
			}
catch (Exception e)
	{
System.out.println(e);
	}
    }
    
    @FXML
    void AddClients(ActionEvent event) {
    	try {		
       	 Login.close();
   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneKlient.fxml"));
   	    		   root1 = (Parent) fxmlLoader.load();
   	    		    Stage stage = new Stage();
   	    		    stage.setScene(new Scene(root1));  
   	    		    stage.show();	    		    	    		   
   			}
   catch (Exception e)
   	{
   System.out.println(e);
   	}
    }
    
    static Parent root1;
	public static void close() {
		((Stage)root1.getScene().getWindow()).close();
		
	}
	 @FXML
	    void AddStocks(ActionEvent event) {
		 try {		
	       	 Login.close();
	   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneStoka.fxml"));
	   	    		   root1 = (Parent) fxmlLoader.load();
	   	    		    Stage stage = new Stage();
	   	    		    stage.setScene(new Scene(root1));  
	   	    		    stage.show();	    		    	    		   
	   			}
	   catch (Exception e)
	   	{
	   System.out.println(e);
	   	}
	 }
	 @FXML
	    void AddKasa(ActionEvent event) {
		 try {		
	       	 Login.close();
	   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneKasa.fxml"));
	   	    		   root1 = (Parent) fxmlLoader.load();
	   	    		    Stage stage = new Stage();
	   	    		    stage.setScene(new Scene(root1));  
	   	    		    stage.show();	    		    	    		   
	   			}
	   catch (Exception e)
	   	{
	   System.out.println(e);
	   	}
	    }
	    @FXML
	    void AddStaff(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneStaff.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void AddPSklad(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdanePSklad.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void AddPKlient(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdanePklient.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void AddSOperator(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VuvejdaneSOperator.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void nalichnoststoka(ActionEvent event) {
	    	Alert a = new Alert(AlertType.INFORMATION);
 	    	a.setContentText("Stocks are:"+MainFromDao.stocks());
 	    	a.show();
	    }
	    @FXML
	    void nalichnostpari(ActionEvent event) {
	    	Alert a = new Alert(AlertType.INFORMATION);
 	    	a.setContentText("Money are:"+MainFromDao.pari());
 	    	a.show();
	    }
	    @FXML
	    void SpravkaDost(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpravkaDost.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void SpravkaCl(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpravkaKl.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void SpravkaPr(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpravkaPr.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }

	    @FXML
	    void SpravkaNa(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpravkaNa.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    @FXML
	    void SpravkaDv(ActionEvent event) {
	    	try {		
		       	 Login.close();
		   				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpravkaDv.fxml"));
		   	    		   root1 = (Parent) fxmlLoader.load();
		   	    		    Stage stage = new Stage();
		   	    		    stage.setScene(new Scene(root1));  
		   	    		    stage.show();	    		    	    		   
		   			}
		   catch (Exception e)
		   	{
		   System.out.println(e);
		   	}
	    }
	    }
 