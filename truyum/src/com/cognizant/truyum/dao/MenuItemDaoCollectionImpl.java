package com.cognizant.truyum.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao{

	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl()
	{
		if (menuItemList==null ||menuItemList.isEmpty())
		{
			menuItemList=new ArrayList<MenuItem>();
			MenuItem menu1= new MenuItem(1,"Sandwich",99.0f,true,LocalDate.parse("2017-03-15"),"Main Course",true);
			MenuItem menu2= new MenuItem(2,"Burger",129.0f,true,LocalDate.parse("2017-12-23"),"Main Course",false);
			MenuItem menu3= new MenuItem(3,"Pizza",149.0f,true,LocalDate.parse("2018-08-21"),"Main Course",false);
			MenuItem menu4= new MenuItem(4,"French Fries",57.0f,false,LocalDate.parse("2017-07-02"),"Starters",true);
			MenuItem menu5= new MenuItem(5,"Chocolate Brownie",32.0f,true,LocalDate.parse("2022-11-02"),"Dessert",true);
			//create other 4 menu items
			
			menuItemList.add(menu1);
			menuItemList.add(menu2);
			menuItemList.add(menu3);
			menuItemList.add(menu4);
			menuItemList.add(menu5);
			//repeat same for 4 menuitems
		
		}
		
	}
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// read case study document and implement
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemListCustomer=new ArrayList<MenuItem>(); 
		LocalDate currentDate = LocalDate.now();
		 for(MenuItem menu:menuItemList)
		 {
			 	
			 	//LocalDate date = LocalDateTime.parse(X.getDate(),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	            //Duration duration = Duration.between(currentDate,X.getDate());
	            if(menu.getDate().isBefore(currentDate) || menu.getDate().equals(currentDate))
	            {
	            	menuItemListCustomer.add(menu);
	            	
	            }
		 }
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		int i=0;
		for(MenuItem X:menuItemList)
		{
			if(X.getId()==menuItem.getId())
			{
				menuItemList.set(i, menuItem);
			}
			i++;
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		MenuItem obj=new MenuItem();
		for(MenuItem X:menuItemList)
		{
			if(X.getId()==menuItemId)
			{
				obj=X;
			}
			
		}
		
		return obj;
	}

}
