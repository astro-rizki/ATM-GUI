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
    
    

    // display the main menu and perform transactions
    private void performTransactions() {
	// local variable to store transaction currently being processed
	Transaction currentTransaction = null;
	TransactionController currentTransactionController = null;

	boolean userExited = false; // user has not chosen to exit

	// loop while user has not chosen option to exit system
	while (!userExited) {
	    // show main menu and get user selection
	    int mainMenuSelection = 0;

	    // decide how to proceed based on user's menu selection
	    switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:

		    // initialize as new object of chosen type
		    currentTransaction
			    = createTransaction(mainMenuSelection);
//		    currentTransactionController
//			    = new BalanceInquiryController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case WITHDRAWAL:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
//		    currentTransactionController
//			    = new WithdrawalController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case DEPOSIT:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
//		    currentTransactionController
//			    = new DepositController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case EXIT: // user chose to terminate session
		    userExited = true; // this ATM session should end
		    break;
		    
		default: break;
	    }
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
	}

	return temp;
    }

    
    public int getUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(int userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }
}