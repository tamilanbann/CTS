package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl {

 public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, SQLException
 {
	 	Connection con= ConnectionHandler.getConnection();
		String query="INSERT INTO cart VALUES(?,?);";
		PreparedStatement preStmt = con.prepareStatement(query);
		preStmt.setLong(1,userId);
		preStmt.setLong(2,menuItemId);
		int result = preStmt.executeUpdate();
 }
 
 
 public List<MenuItem> getAllCartItems(long userId) throws ClassNotFoundException, SQLException
 
 {
	 List<MenuItem> menuItemList = new ArrayList<MenuItem>();
	 
	 Cart cart=new Cart(menuItemList,0);
	 Connection con= ConnectionHandler.getConnection();
	 String query="SELECT * FROM menu_item_list WHERE id_menu IN (SELECT id_menu FROM cart WHERE id_user=?;);";
	 PreparedStatement preStmt = con.prepareStatement(query);
	 preStmt.setLong(1, userId);
	 ResultSet rs= preStmt.executeQuery();
	 float total=0.00f;
	 while(rs.next())
	 {
		 	long id=rs.getInt(1);
			String name=rs.getString(2);
			float price=rs.getFloat(3);
			boolean active=(rs.getString(4).equals("Yes")) ? true:false;
			LocalDate date=LocalDate.parse(rs.getString(5));
			String category=rs.getString(6);
			boolean freeDelivery=(rs.getString(7).equals("Yes")) ? true:false;
			MenuItem menuItem= new MenuItem(id,name,price,active,date,category,freeDelivery);
			menuItemList.add(menuItem);
			total+=price;
	 }
	 
	 cart.setTotal(total);
	 return menuItemList;
 }
 
 public void  removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, SQLException
 {
	 	Connection con= ConnectionHandler.getConnection();
		String query="DELETE FROM Cart WHERE id_user=?, id_menu=?;";
		PreparedStatement preStmt = con.prepareStatement(query);
		preStmt.setLong(1,userId);
		preStmt.setLong(2,menuItemId);
		int result = preStmt.executeUpdate();
 }
 
}
