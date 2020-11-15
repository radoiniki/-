package com.code;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SpravkaNa {
	  @FXML
	    private TableView<SpravkaPrDao> table;

	    @FXML
	    private TableColumn<SpravkaPrDao, String> income;

	    @FXML
	    private TableColumn<SpravkaPrDao, String> costs;

	    @FXML
	    private TableColumn<SpravkaPrDao, String> profit;

	  @FXML
	    void back(ActionEvent event) {
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
	    void show(ActionEvent event) {
	initialize();
	    }
	    ObservableList<SpravkaPrDao> oblist=FXCollections.observableArrayList();
	    void initialize() {
	    	 oblist.clear();
	 		Connection com= DostavchikDao.getConnection();
	 		try {
	 			Statement st=com.createStatement();
	 			ResultSet rs=st.executeQuery("Select *FROM stocks");
	 			while (rs.next())  
	 			{
	 			
	 				oblist.add(new SpravkaPrDao(rs.getString("st_expdate"),rs.getString("st_name"),rs.getString("st_quantity")));
	 			 
	 			}
	 			
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		income.setCellValueFactory(new PropertyValueFactory<>("income"));
	 	    costs.setCellValueFactory(new PropertyValueFactory<>("costs"));
	 	    profit.setCellValueFactory(new PropertyValueFactory<>("profit"));
	 	    table.setItems(oblist);

	    }
}