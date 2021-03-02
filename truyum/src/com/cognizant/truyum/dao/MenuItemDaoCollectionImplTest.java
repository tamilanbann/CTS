package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*System.out.println("=== Menu Item List Admin ===");
		testGetMenuItemListAdmin();
		System.out.println("=== Menu Item List Customer ===");
		testGetMenuItemListCustomer();
		System.out.println("=== Menu modification ===");
		testModifyMenuItem();*/
		
		testMenuSql();
		
		
		
	}
	public static void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		 List <MenuItem> menuItemList= menuItemDao.getMenuItemListAdmin();
		 for(MenuItem X:menuItemList)
		 {
			 System.out.println(X);
		 }
	}
	
	public static void testGetMenuItemListCustomer()
	{
		 MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		 List <MenuItem> menuItemList= menuItemDao.getMenuItemListCustomer();
		 for(MenuItem X:menuItemList)
		 {
			 System.out.println(X);
		 }
	}
	
	public static  void testModifyMenuItem()
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem= new MenuItem(1,"Sandwich",99.0f,true,LocalDate.parse("2017-03-15"),"Main Course",true);
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(menuItem.getId()));
		
		
	}
	public static void testMenuSql() throws ClassNotFoundException, SQLException
	{
		MenuItemDaoSqlImpl obj=new MenuItemDaoSqlImpl();
		MenuItem item =obj.getMenuItem(2);
		System.out.println("=======specific item=======");
		System.out.println(item);
		System.out.println("=======customer table=======");
		List<MenuItem> list= obj.getMenuItemListCustomer();
		for(MenuItem X:list)
		 {
			 System.out.println(X);
		 }
		System.out.println("=======admin table=======");
		list= obj.getMenuItemListAdmin();
		for(MenuItem X:list)
		 {
			 System.out.println(X);
		 }
	}
}
