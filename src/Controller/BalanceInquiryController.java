/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Keypad;
import View.Screen;

/**
 *
 * @author Annazar
 */
public class BalanceInquiryController extends TransactionController {

    private BalanceInquiry transaction;

    public BalanceInquiryController(Transaction theTransaction, Keypad theKeypad, Screen theScreen) {
	super(theKeypad, theScreen);
	transaction = (BalanceInquiry) theTransaction;
    }


    @Override
    public int run() {
	Screen screen = getScreen();

	double availableBalance = transaction.getAvailableBalance();
	double totalBalance = transaction.getTotalBalance();

	screen.displayMessage("\nBalance Information:\n");
	screen.displayMessage(" - Available balance\t: ");
	screen.displayDollarAmount(availableBalance);
	screen.displayMessage("\n - Total balance\t: ");
	screen.displayDollarAmount(totalBalance);
	screen.displayMessage("\n");
	
	return 0;
    }
    
}