package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionUtil;

import com.dao.BankDAO;

public class BankAppTest {

	public static void main(String[] args) throws SQLException {
		
		System.out.println(ConnectionUtil.getConnection());
		System.out.println("1:Register,2:Login,3:Deposit,4:Withdrawl,5:Money Transfer,6:Get Balance");
		System.out.println("Enter The Anyone Of The Above Features");
		Scanner scan=new Scanner(System.in);
		int features=scan.nextInt();
        System.out.println("You Have Selected:"+" "+features);
		switch(features)
		{
		case 1:
		BankDAO.userRegister();
		break;
		case 2:
		BankDAO.userlogin();
		break;
		case 3:
		BankDAO.deposit();
		break;
		case 4:
		BankDAO.withdrawl();
		break;
		case 5:
		BankDAO.moneytransfer();
		break;
		case 6:
		System.out.println(BankDAO.getbalance());
		break;	
       		}
		
	}

}
