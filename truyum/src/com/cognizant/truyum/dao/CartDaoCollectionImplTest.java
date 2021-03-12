package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		/*System.out.println("\n======Items Added======\n");
		testAddCartItem();
		System.out.println("\n======after Items has been removed======\n");
		testRemoveCartItem();
		System.out.println("\n======Display cart items======\n");
		testGetAllCartItems();*/
		
		testcartsql();
		
	}
	
	public static void testAddCartItem() throws Exception 
	{
		CartDao	cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1,1);
		cartDao.addCartItem(1,2);
		cartDao.addCartItem(1,3);
		Cart obj=cartDao.getAllCartItems(1);
		
		List<MenuItem> menuItemList=obj.getMenuItemList();
		for(MenuItem item: menuItemList)
			System.out.println(item);
		
		
		
	}
	
	public static void testRemoveCartItem() throws Exception
	{
		CartDao	cartDao=new CartDaoCollectionImpl();
		Cart obj = new Cart();
		obj=cartDao.getAllCartItems(1);
		List<MenuItem> menuItemList=obj.getMenuItemList();
		cartDao.removeCartItem(1,1);
		try 
		{
			obj=cartDao.getAllCartItems(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		for(MenuItem item: menuItemList)
			System.out.println(item);
		
		
	}
	public static void testGetAllCartItems() throws Exception
	{
		CartDao	cartDao=new CartDaoCollectionImpl();
		Cart obj = new Cart();
		obj=cartDao.getAllCartItems(1);
		List<MenuItem> menuItemList=obj.getMenuItemList();
		for(MenuItem item: menuItemList)
			System.out.println(item);
	}
	public static void testcartsql() throws ClassNotFoundException, SQLException
	{
		CartDaoSqlImpl obj= new CartDaoSqlImpl();
		obj.addCartItem(1,1,1);
		obj.addCartItem(1,2,2);
		obj.addCartItem(1,3,3);
		List<MenuItem> menuItemList=obj.getAllCartItems(1);
		System.out.println("\n======Items Added======\n");
		for(MenuItem item: menuItemList)
			System.out.println(item);
		
		obj.removeCartItem(1,1);
		menuItemList=obj.getAllCartItems(1);
		System.out.println("\n======after Items has been removed======\n");
		for(MenuItem item: menuItemList)
			System.out.println(item);
		obj.removeCartItem(1,2);
		obj.removeCartItem(1,3);
	}
}
