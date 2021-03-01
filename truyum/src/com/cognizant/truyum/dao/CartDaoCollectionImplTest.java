package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		testAddCartItem();
		testRemoveCartItem();
	}
	
	public static void testAddCartItem() throws Exception 
	{
		CartDao	cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1,2);
		Cart obj=cartDao.getAllCartItems(1);
		System.out.println(obj);
		
		
		
	}
	
	public static void testRemoveCartItem() 
	{
		CartDao	cartDao=new CartDaoCollectionImpl();
		Cart obj = new Cart();
		cartDao.removeCartItem(1,1);
		try 
		{
			obj=cartDao.getAllCartItems(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(obj);
	}
}
