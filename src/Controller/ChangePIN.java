/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Controller;

import static Model.Constants.*;

/**
 *
 * @author ASUS
 */
public class ChangePIN extends Transaction {
    private int newPIN = 0;

    public ChangePIN(int userAccountNumber, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmBankDatabase);
    }

    @Override
    public int execute() {
        if(super.getBankDatabase().updatePIN(super.getAccountNumber(), newPIN)){
            return CHANGE_PIN_SUCCESS;
        } else {
            return CHANGE_PIN_FAIL;
        }
    }

    public int getNewPIN() {
        return newPIN;
    }

    public void setNewPIN(int newPIN) {
        this.newPIN = newPIN;
    }
    
}
