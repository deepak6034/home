package com.capgemini.wallet.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.wallet.bean.AccountDetails;
import com.capgemini.wallet.bean.CustomerDetails;
import com.capgemini.wallet.service.AccountValidation;

public class WalletDao implements IAccountDao {

	int bal;
	String accountNumber;
	String trans;
	AccountValidation validate = new AccountValidation();
	CustomerDao customer = new CustomerDao();
	AccountDao account1 = new AccountDao();
	LoginDao login = new LoginDao();
	TransactionDao transaction = new TransactionDao();
	Scanner sc = new Scanner(System.in);

	public int addAccountDetails(CustomerDetails customerDetails) {

		if (customer.addCustomerDetails(customerDetails) == 1 && account1.addAccountDetails(customerDetails) == 1
				&& login.addLoginDetails(customerDetails) == 1 && 	transaction.addTransactionDetails(customerDetails)==1)
			return 1;
		else
			return 0;
	}

	public boolean getLogin() {

		System.out.println("Enter your username: ");
		String username = sc.nextLine();

		System.out.println("Enter your password: ");
		String password = sc.nextLine();

		if (login.authenticate(username, password))
			return true;
		else
			return false;

	}

	public void showBalance() {

		System.out.println("Balance: " + account1.showBalance());

	}

	public boolean deposit(int amount) {

		if (account1.deposit(amount) == 1)
		{
			trans = amount + " credited";
			transaction.addTransactions(trans);
			return true;
		}
		else
			return false;
	}

	public boolean withdraw(int amount) {

		if (account1.withdraw(amount) == 1)
		{
			trans = amount + " debited";
			transaction.addTransactions(trans);
			return true;
		}
		else
			return false;

	}

	public boolean fundTransfer(String recieverAccountNumber, int amount) {

		if (account1.fundTransfer(recieverAccountNumber, amount) == 1)
			return true;
		else
			return false;

	}

	/*
	 * public void printTransactions() { boolean flag = false;
	 * 
	 * if (customerDetails != null) {
	 * 
	 * flag = true;
	 * 
	 * System.out
	 * .println(customerDetails.getAccountDetails().getLoginDetails().
	 * getTransaction().getTransactions());
	 * 
	 * } }
	 */
}
