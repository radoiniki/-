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

public class SpravkaDost {

    @FXML
    private TableView<SpravkaDostDao> table;

    @FXML
    private TableColumn<SpravkaDostDao, String> stockname;

    @FXML
    private TableColumn<SpravkaDostDao, String> orderprice;

    @FXML
    private TableColumn<SpravkaDostDao, String> quantity;

    @FXML
    private TableColumn<SpravkaDostDao, String> supname;

    @FXML
    private TableColumn<SpravkaDostDao, String> date;
    
    @FXML
    private TableColumn<SpravkaDostDao, String> order;

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
    ObservableList<SpravkaDostDao> oblist=FXCollections.observableArrayList();
    void initialize() {
     	 oblist.clear();
     		Connection com= DostavchikDao.getConnection();
     		try {
     			Statement st=com.createStatement();
     			ResultSet rs=st.executeQuery("Select *FROM warehouse_orders w join worder_price p on w.worder_id=p.warehouse_orders_worder_id join stocks s on p.stocks_st_id=s.st_id join suppliers su on w.sup_id=su.sup_id");
     			while (rs.next())  
     			{
     			
     				oblist.add(new SpravkaDostDao(rs.getString("worder_date"),rs.getString("sup_name"),Integer.parseInt(rs.getString("w_price")),Integer.parseInt(rs.getString("worder_total")),rs.getString("st_name"),rs.getString("w_quantity")));
     			 
     			}
     			
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		date.setCellValueFactory(new PropertyValueFactory<>("date"));
     		supname.setCellValueFactory(new PropertyValueFactory<>("supname"));
     	    orderprice.setCellValueFactory(new PropertyValueFactory<>("wprice"));
     	order.setCellValueFactory(new PropertyValueFactory<>("wtotal"));
     	stockname.setCellValueFactory(new PropertyValueFactory<>("stockname"));
  		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

     	    table.setItems(oblist);
     	}
    @FXML
    void show(ActionEvent event) {
initialize();
    }

}