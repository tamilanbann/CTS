package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
public class CartDaoCollectionImpl implements CartDao  {

	
	private static HashMap<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl()
	{
		if (userCarts==null ||userCarts.isEmpty())
		{
			userCarts=new HashMap<Long,Cart>();
		}
	}
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		 MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		 MenuItem obj = menuItemDao.getMenuItem(menuItemId);
		 //System.out.println(obj);
		 if(userCarts.containsKey(userId))
		 {
			 List<MenuItem> menuItemList=userCarts.get(userId).getMenuItemList();
			 menuItemList.add(obj);
			 Cart cartObj=new Cart();
			 cartObj.setMenuItemList(menuItemList);
			 userCarts.put(userId, cartObj);
			 
		 }
		 
		 else 
		 {
			 
			 List<MenuItem> menuItemList=new ArrayList<MenuItem>();
			 menuItemList.add(obj);
			 
			 Cart cartObj=new Cart(menuItemList,0);
			 //cartObj.setMenuItemList(menuItemList);
			 //System.out.println(cartObj);
			 userCarts.put(userId, cartObj);
			 
		 }
		
		
	}
	@Override
	public Cart getAllCartItems(long userId) throws Exception{
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList=userCarts.get(userId).getMenuItemList();
		
		if(menuItemList==null ||menuItemList.isEmpty())
		{
			throw new CartEmptyException("Cart is empty");
		}
		else
		{
			double total=0;
			for(MenuItem X: menuItemList)
			{
				total+=X.getPrice();
			}
			Cart cartObj=new Cart(menuItemList,total);
			return cartObj;
		}
		
	}
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList=userCarts.get(userId).getMenuItemList();
		
		//System.out.println(menuItemList);
		int i=0;
		for(MenuItem X: menuItemList)
		{
			if(X.getId()==menuItemId)
			{
				menuItemList.remove(X);
				break;
			}
			
		}
		
		
		/*Cart cartObj=new Cart();
		cartObj.setMenuItemList(menuItemList);
		userCarts.put(userId, cartObj);*/
		
	}

}
