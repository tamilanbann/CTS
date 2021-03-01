package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.out.println("Items Added");
		testAddCartItem();
		System.out.println("after Items has been removed");
		testRemoveCartItem();
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
}
