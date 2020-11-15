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

public class SpravkaKl {

    @FXML
    private TableView<SpravkaKlDao> table;

    @FXML
    private TableColumn<SpravkaKlDao, String> stockname;

    @FXML
    private TableColumn<SpravkaKlDao, String> orderprice;

    @FXML
    private TableColumn<SpravkaKlDao, String> quantity;

    @FXML
    private TableColumn<SpravkaKlDao, String> supname;

    @FXML
    private TableColumn<SpravkaKlDao, String> date;
    
    @FXML
    private TableColumn<SpravkaKlDao, String> order;
    
    @FXML
    private TableColumn<SpravkaKlDao, String> clname;


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
    ObservableList<SpravkaKlDao> oblist=FXCollections.observableArrayList();
    void initialize() {
     	 oblist.clear();
     		Connection com= DostavchikDao.getConnection();
     		try {
     			Statement st=com.createStatement();
     			ResultSet rs=st.executeQuery("Select *FROM client_orders w join corder_price p on w.corder_id=p.client_orders_corder_id join stocks s on p.stocks_st_id=s.st_id join staff st on w.staff_id=st.staff_id join clients c on w.cl_id=c.cl_id");
     			while (rs.next())  
     			{
     			
     				oblist.add(new SpravkaKlDao(rs.getString("corder_date"),rs.getString("staff_fullname"),Integer.parseInt(rs.getString("price")),Integer.parseInt(rs.getString("corder_total")),rs.getString("st_name"),rs.getString("quantity"),rs.getString("cl_name")));
     			 
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
  clname.setCellValueFactory(new PropertyValueFactory<>("clname"));
     	    table.setItems(oblist);
     	}
    @FXML
    void show(ActionEvent event) {
initialize();
    }

}