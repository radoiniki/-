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

public class SpravkaDv {

    @FXML
    private TableView<SpravkaDvDao> table;

    @FXML
    private TableColumn<SpravkaDvDao, String> salary;

    @FXML
    private TableColumn<SpravkaDvDao, String> orderprice;

    @FXML
    private TableColumn<SpravkaDvDao, String> stockprice;

    @FXML
    private TableView<SpravkaDvDao1> table1;

    @FXML
    private TableColumn<SpravkaDvDao1, String> orderprice1;

    @FXML
    private TableColumn<SpravkaDvDao1, String> stockprice1;

    @FXML
    void show(ActionEvent event) {
initialize();
initialize1();
initialize2();
    }
    	    ObservableList<SpravkaDvDao> oblist=FXCollections.observableArrayList();
    	    void initialize() {
    	    	 oblist.clear();
    	 		Connection com= DostavchikDao.getConnection();
    	 		try {
    	 			Statement st=com.createStatement();
    	 			ResultSet rs=st.executeQuery("SELECT worder_total,w_price FROM worder_price w JOIN warehouse_orders wo on w.warehouse_orders_worder_id=wo.worder_id ");
    	 			while (rs.next())  
    	 			{
    	 				
    	 			
    	 				oblist.add(new SpravkaDvDao(rs.getString("worder_total"),rs.getString("w_price")));
    	 			 
    	 			}
    	 			
    	 		} catch (SQLException e) {
    	 			// TODO Auto-generated catch block
    	 			e.printStackTrace();
    	 		}
    
    	 		orderprice.setCellValueFactory(new PropertyValueFactory<>("orderprice"));
    	 	   stockprice.setCellValueFactory(new PropertyValueFactory<>("stockprice"));
    	 	    table.setItems(oblist);

}
    	    void initialize1() {
   	 		Connection com= DostavchikDao.getConnection();
   	 		try {

   	 			Statement st=com.createStatement();
   	 			ResultSet rs=st.executeQuery("SELECT staff_salary from staff ");
 
   	 			while (rs.next())  
   	 			{
   	 			
   	 				oblist.add(new SpravkaDvDao(rs.getString("staff_salary")));
   	 			 
   	 			}
   	 			
   	 		} catch (SQLException e) {
   	 			// TODO Auto-generated catch block
   	 			e.printStackTrace();
   	 		}
   
   	 		salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
   	 	    table.setItems(oblist);

}
    	    ObservableList<SpravkaDvDao1> oblist2=FXCollections.observableArrayList();
    	    void initialize2() {
    	    	 oblist2.clear();
    	 		Connection com= DostavchikDao.getConnection();
    	 		try {
    	 			Statement st=com.createStatement();
    	 			ResultSet rs=st.executeQuery("SELECT corder_total,price FROM corder_price w JOIN client_orders wo on w.client_orders_corder_id=wo.corder_id ");
    	 			while (rs.next())  
    	 			{
    	 				
    	 			
    	 				oblist2.add(new SpravkaDvDao1(rs.getString("corder_total"),rs.getString("price")));
    	 			 
    	 			}
    	 			
    	 		} catch (SQLException e) {
    	 			// TODO Auto-generated catch block
    	 			e.printStackTrace();
    	 		}
    
    	 		orderprice1.setCellValueFactory(new PropertyValueFactory<>("orderprice"));
    	 	   stockprice1.setCellValueFactory(new PropertyValueFactory<>("stockprice"));
    	 	    table1.setItems(oblist2);

}
}