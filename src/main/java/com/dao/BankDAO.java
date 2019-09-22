package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionUtil;

public class BankDAO {
//	User Register
	
	public static void userRegister() throws SQLException
	{
		Connection conn = ConnectionUtil.getConnection();
		
		String sql_stmt = "INSERT INTO customer (user_name,email,password) VALUES (?,?,?)";
		PreparedStatement pstmt = null;
			
			pstmt = conn.prepareStatement(sql_stmt);
			pstmt.setString(1, "name");
			pstmt.setString(2, "emailid");
			pstmt.setString(3, "password");
			
		   int rows = pstmt.executeUpdate();
		
		System.out.println("Processing Registeration...");
		 Scanner scan1=new Scanner(System.in);
		 System.out.println("Enter Your Name");
		 String name=scan1.nextLine();
		 System.out.println("User Name : "+name);
		 System.out.println("Enter Your Email id");
		 String emailid=scan1.nextLine();
		 System.out.println("Email id:"+" "+emailid);
		 System.out.println("Enter Your Password");
		 String password=scan1.nextLine();
		 System.out.println("password:"+" "+password);
			
			if(rows == 1)
			{
				System.out.println("Record is inserted!");
			}
			else
			{
				System.out.println("Record isn't inserted!");
			}
			
		
				pstmt.close();
				
		System.out.println("Registration Sucessful...");
	}
	
	public static void userlogin() throws SQLException
	{
		Connection con=ConnectionUtil.getConnection();
		
		String sql_stmnt="select user_name from customer where email =? and password = ?";
		PreparedStatement pstmt=null;
	
		pstmt=con.prepareStatement(sql_stmnt);
		pstmt.setString(1, "emailid");
		pstmt.setString(2, "password");
		System.out.println("Logging You In...");
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name=scan.nextLine();
		System.out.println("User Name:"+" "+name);
		System.out.println("Enter Your Email id");
		String emailid=scan.nextLine();
		System.out.println("Enter Your Password");
		String password=scan.nextLine();
		
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			String user_name=rs.getString("user_name:");
			System.out.println("Welcome" + " " + user_name);
			
		}
		
	}
	public static void transactions() {
		@SuppressWarnings("resource")
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Press 1 For:Deposit\nPress 2 For:Withdrawl\nPress 3 For:Mini Statement\nPress 4 For:Money Transfer");
		int num = scan3.nextInt();
		System.out.println("Your Choice:" + " " + num);
		if (num == 1) 
		{
			System.out.println("You Have selected:Cash Deposit");
		}
		else if (num == 2) 
		{
			System.out.println("You Have selected:Cash Withdrawl");
		}
		else if (num == 3) 
		{
			System.out.println("You Have selected:Mini Statement");
		}
		else if (num == 4)
		{
			System.out.println("You Have Selected Money Transfer");
		}

	}
	public static int getbalance() throws SQLException
	{
		String sql_stmnt="select amount from user_account where id=?";
		Connection con=ConnectionUtil.getConnection();
		PreparedStatement pstmt=null;
		int amount=0;
		pstmt=con.prepareStatement(sql_stmnt);
		pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				amount = rs.getInt("amount");
			}
			return amount;
		
	}
	public static void deposit() throws SQLException 
	{
		@SuppressWarnings("resource")
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id"); 
		int id = scan.nextInt();
		System.out.println("Enter the amount");
		int amount = scan.nextInt();
		int balance = BankDAO.getbalance();
		int totalAmount = amount + balance;
		
		Connection conn = ConnectionUtil.getConnection();
		String sql_stmnt="update user_account SET amount=? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql_stmnt);
		
		pstmt.setInt(1, totalAmount);
		pstmt.setInt(2, id);
		
		int rows = pstmt.executeUpdate();
		System.out.println("Available Balance:"+" "+totalAmount);
		if(rows>= 1)
		{
			System.out.println("Deposit success!");
		}
		else {
			System.out.println("Deposit isn't success");
		}
		
	}
	public static void withdrawl() throws SQLException
	{
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		String sql_stmnt="update user_account SET amount=? where id = ?";
		System.out.println("Enter The ID");
		int id=scan.nextInt(); 
		System.out.println("Enter The Amount To Be WithDrawn:");
		int amount=scan.nextInt();
		int balance = BankDAO.getbalance();
		if( balance > 0 && balance > amount )
		{
			int totalAmount = balance-amount;
			
			System.out.println("Available Balance:"+" "+totalAmount);
			
			Connection conn = ConnectionUtil.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql_stmnt);
			
			pstmt.setInt(1, totalAmount);
			pstmt.setInt(2, id);
			int rows = 0;
			rows = pstmt.executeUpdate();
			if(rows >= 1)
			{
				System.out.println("Withdrawl success!");
			}
			}
		else 
		{
			System.out.println("Invalid amount!");
		}
	
     	
			
	}
	public static int availablebalance()
	{
		int totalamount=500;
	    return totalamount;
	}
	public static int addamount(int amount)
	{
		return amount;
	}
	public static int minusamount(int amount)
	{
		return amount;
	}
	public static void moneytransfer()
	{
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter From AccountNumber:");
        String fac=scan.nextLine();
        System.out.println("From AccountNumber:"+" "+fac);
        System.out.println("Enter To AccountNumber:");
        String tac=scan.nextLine();
        System.out.println("From AccountNumber:"+" "+tac);
        System.out.println("Enter The Amount To Be Transfered");
        String amt=scan.nextLine();
        System.out.println("Amount Transfered:"+" "+amt);
	}

		
}
	
