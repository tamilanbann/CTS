package com.cognizant.truyum.dao;



import com.cognizant.truyum.model.Cart;


public interface CartDao {
	void addCartItem(long userId, long menuItemId);
	Cart getAllCartItems(long userId) throws Exception; 
	 void removeCartItem(long userId,long menuItemId);
}
