/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import static Model.Constants.*;

/**
 *
 * @author Annazar
 */
public class ATM_Controller {

    private int userAuthenticated;
    private int currentAccountNumber; // current user's account number
    private final CashDispenser cashDispenser = new CashDispenser(); // ATM's cash dispenser
    private final DepositSlot depositSlot = new DepositSlot();
    private final BankDatabase bankDatabase = new BankDatabase(); // account information database


    public ATM_Controller() {
	userAuthenticated = 0;
	currentAccountNumber = 0;
    }

    // attempts to authenticate user against database
    public boolean authenticateUser(int accountNumber, int PIN) {

	// set userAuthenticated to boolean value returned by database
	setUserAuthenticated(bankDatabase.authenticateUser(accountNumber, PIN));

	// check whether authentication succeeded
	if (getUserAuthenticated() == 1) {
	    setCurrentAccountNumber(accountNumber); // save user's account #
            return true;
	} else {
	   return false;
	}
    }


    public Transaction createTransaction(int type) {
	Transaction temp = null;

	switch (type) {
	    case BALANCE_INQUIRY:
		temp = new BalanceInquiry(
			getCurrentAccountNumber(), bankDatabase);
		break;
	    case WITHDRAWAL:
		temp = new Withdrawal(
			getCurrentAccountNumber(), bankDatabase, cashDispenser);
		break;
	    case DEPOSIT:
		temp = new Deposit(
			getCurrentAccountNumber(), bankDatabase, depositSlot);
		break;
            case TRANSFERS:
                temp = new Transfer(
			getCurrentAccountNumber(), bankDatabase);
		break;
            case UPDATE_PIN:
                temp = new ChangePIN(
			getCurrentAccountNumber(), bankDatabase);
		break;
	}

	return temp;
    }

    
    public int getUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(int userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
    
    public double getCurrentAccountBalance(){
        return bankDatabase.getAccount(currentAccountNumber).getTotalBalance();
    }
    
    public double getCurrentAccAvailBalance(){
        return bankDatabase.getAccount(currentAccountNumber).getAvailableBalance();
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public boolean isTransferSufficent(int userAccount, double amount) {
        return bankDatabase.getAccount(userAccount).getAvailableBalance() > amount;
    }
    
    public boolean isAccountAda(int accountNumber){
        return bankDatabase.isAccountExist(accountNumber);
    }
}