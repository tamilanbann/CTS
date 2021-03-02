package com.cognizant.truyum.dao;


import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl {
	
	public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, SQLException
	{
		 List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		 
			 Connection con= ConnectionHandler.getConnection();
			 String query="SELECT * FROM menu_item_list;";
			 PreparedStatement preStmt = con.prepareStatement(query);
			 ResultSet rs= preStmt.executeQuery();
			 
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
			 }
			 
			 
		 
		 return menuItemList;
	}
	
	public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, SQLException
	{
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Connection con= ConnectionHandler.getConnection();
		 String query="SELECT * FROM menu_item_list WHERE Active='Yes' AND Date_of_Launch< ?;";
		 PreparedStatement preStmt = con.prepareStatement(query);
		 preStmt.setString(1,LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		 ResultSet rs= preStmt.executeQuery();
		 
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
		 }
		 
		return menuItemList;
	}
	public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, SQLException
	{
		MenuItem menuItem=new MenuItem();
		Connection con= ConnectionHandler.getConnection();
		String query="SELECT * FROM menu_item_list WHERE id_menu=?;";
		PreparedStatement preStmt = con.prepareStatement(query);
		preStmt.setLong(1,menuItemId);
		ResultSet rs= preStmt.executeQuery();
		
		if(rs.next())
		 {
			 	long id=rs.getInt(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=(rs.getString(4).equals("Yes")) ? true:false;
				LocalDate date=LocalDate.parse(rs.getString(5));
				String category=rs.getString(6);
				boolean freeDelivery=(rs.getString(7).equals("Yes")) ? true:false;
				menuItem.setId(id);
				menuItem.setName(name);
				menuItem.setPrice(price);
				menuItem.setActive(active);
				menuItem.setDate(date);
				menuItem.setCategory(category);
				menuItem.setFreeDelivery(freeDelivery);

				
		 }
		
		return menuItem;
		
	}
	
	public void editMenuItem(MenuItem menuItem) throws ClassNotFoundException, SQLException
	{
		Connection con= ConnectionHandler.getConnection();
		String query="UPDATE menu_item_list SET name=?, price=? ,Active=? , Date_of_Launch=? , Category=? , Free_Delivery=? WHERE id_menu=?;";
		PreparedStatement preStmt = con.prepareStatement(query);
		preStmt.setString(1,menuItem.getName());
		preStmt.setFloat(2,menuItem.getPrice());
		preStmt.setString(3,(menuItem.isActive()) ?"Yes":"No");
		preStmt.setString(4,menuItem.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		preStmt.setString(5,menuItem.getCategory());
		preStmt.setString(6,(menuItem.isFreeDelivery()) ?"Yes":"No");
		preStmt.setLong(7,menuItem.getId());
		int result= preStmt.executeUpdate();
		
		
	}
	
	

}
