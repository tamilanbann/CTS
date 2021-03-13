package com.cts.EBanking;


import java.util.List;

public class SmartBankAccount extends BankAccount {
	
	public SmartBankAccount(int customerId, String name, double balance, List<String> accounts){
		super(customerId, name, balance,accounts);
		
	}
	
   // type  your code here
   
    public  double calculateFixedAccount(double amount,int months)
	{
	    
        double a=0.00;
	    if( amount>9999 && amount<1000001 && months>0 && months<121 )
	    {
	        double y= 1+(0.1/12);
	        
	        double x=Math.pow(y,months);
	        a = amount * x;
	    }
	    
	    return a;
	}
	public double calculateRecurringAccount(double amount,int months)
	{
	   
        
        double intrest=0.00;
	    if(amount>9999 && amount<50001 && months>0 && months<61)
	    {
	    	intrest= (amount*months)+(amount*(months*(months+1)/(2*12))*(0.07));
	    }
	    
	    return intrest;
	}
	

	
}
