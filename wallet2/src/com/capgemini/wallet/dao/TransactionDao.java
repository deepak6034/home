package com.capgemini.wallet.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.wallet.bean.CustomerDetails;

public class TransactionDao {
	

	int status;
	public int addTransactionDetails(CustomerDetails customerDetails)

	{
		try {
			Connection con = DBConnection.getConnection();
			String Query = "insert into Transaction(accountNumber) values(?)";
			PreparedStatement pstmt = con.prepareStatement(Query);
		//	pstmt.setBlob(1, (Blob) customerDetails.getAccountDetails().getLoginDetails().getTransaction().getTransactions());
			pstmt.setString(1, customerDetails.getAccountDetails().getAcccountNumber());
			
			status = pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return status;

	}

	public void addTransactions(String transaction) {
		
		try {
			Connection con = DBConnection.getConnection();
			String Query = "Update transaction SET transactions=CONCAT(transactions, ?) where accountNumber=?";
			PreparedStatement pstmt = con.prepareStatement(Query);
		    pstmt.setString(1, "\n" +transaction );
		    pstmt.setString(2, "79861");
			status = pstmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
