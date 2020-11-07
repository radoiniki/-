package com.code;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Pklient {

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
    private TableView<PklientDao> table;

    @FXML
    private TableColumn<PklientDao, String> stockname;

    @FXML
    private TableColumn<PklientDao, String> date;

    @FXML
    private TableColumn<PklientDao, String> supname;

    @FXML
    private TableColumn<PklientDao, String> orderprice;

    @FXML
    private TableColumn<PklientDao, String> quantity;

    @FXML
    private TableColumn<PklientDao, String> priceach;

    @FXML
    private TableColumn<PklientDao, String> id;

    @FXML
    private TableColumn<PklientDao, String> name;

    @FXML
    private TableColumn<PklientDao, String> clname;

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
    private TextField textbox9;

    @FXML
    void Add(ActionEvent event) {
    	boolean flag=false;
    	 if(PklientDao.insert(textbox2.getText(),textbox9.getText(),textbox3.getText(),textbox4.getText(),textbox8.getText(),label1,flag)==true) {
	    		
	 	    }else {
	 	    	 Alert a = new Alert(AlertType.WARNING);
	 	    	a.setContentText("The information u add is incorrect! Please check your names");
	 	    	a.show();
	 	    }
    }

    @FXML
    void Back(ActionEvent event) {

    }

    @FXML
    void Edit(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
Platform.exit();
    }

    @FXML
    void Remove(ActionEvent event) {

    }

}
