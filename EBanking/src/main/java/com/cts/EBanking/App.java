package com.cts.EBanking;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// CODE SKELETON - VALIDATION STARTS
		// DO NOT CHANGE THIS CODE

		new SkeletonValidator();

		// CODE SKELETON - VALIDATION ENDS

		// Please start your code from here
		//Configuration and Input data read here
		//Refer sample input details
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		SmartBankAccount obj=context.getBean("smartBankingAccount",SmartBankAccount.class);
		System.out.printf("Welcome Mr/Ms: %s\r\n"
				+ "Your customer id is :%d\r\n"
				+ "Please select account type\r\n"
				+ "",obj.getName(),obj.getCustomerId());
		Scanner scanner = new Scanner(System.in);		
		System.out.print("1 CurrentAccount\r\n"
				+ "2 RecurringAccount\r\n"
				+ "3 FixedAccount\r\n"
				+ "");
		double amount;
		int months;
		double balance;
		switch (scanner.nextInt()) {

		case 1:
			System.out.println("Select transaction type \n 1.Deposit \n 2.Withdraw");
			int choice = scanner.nextInt();
			if (choice == 1) {
				//Do call deposite
				System.out.println("Enter amount to be deposited");
				balance=obj.doDeposit(scanner.nextDouble());
				System.out.printf("Your balance amount is %.2f",balance);

			} else if (choice == 2) {
				//Do call Withdraw	
				System.out.println("Enter amount to be withdrawn");
				balance=obj.doWithdraw(scanner.nextInt());
				System.out.printf("Your balance amount is %.2f",balance);

			} else {
				System.out.println("Wrong choice");
			}
			break;
		case 2:
			//Code for recurringAccount
			System.out.println("Enter monthly installment");
			amount=scanner.nextDouble();
			System.out.println("Enter tenure in months");
			months=scanner.nextInt();
			balance=obj.calculateFixedAccount(amount,months);
			System.out.printf("Your balance after %d months will be %.2f",months,balance);
			break;
		case 3:
			//Code for FD 
			System.out.println("Enter FD amount");
			amount=scanner.nextDouble();
			System.out.println("Enter tenure in months");
			months=scanner.nextInt();
			balance=obj.calculateFixedAccount(amount,months);
			System.out.printf("Your balance after %d months will be %.2f",months,balance);
			break;

		default:
			System.out.println("Wrong Choice");

		}

	}
}
