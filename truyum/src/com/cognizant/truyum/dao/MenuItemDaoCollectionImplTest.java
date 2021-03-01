package com.cognizant.truyum.dao;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
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
}
