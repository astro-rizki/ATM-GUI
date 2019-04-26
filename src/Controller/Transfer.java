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
public class Transfer extends Transaction {
    
    private int currentAccNum = 0;
    private int targetAccNum = 0;
    private double amount = 0.0;

    public Transfer(int userAccountNumber, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmBankDatabase);
        this.currentAccNum = userAccountNumber;
    }
    
    @Override
    public int execute() {
        try{
            if(currentAccNum == targetAccNum)
                return TRANSFER_FAIL;
            getBankDatabase().getAccount(currentAccNum).debit(amount);
            double current = getBankDatabase().getAccount(getTargetAccNum()).getAvailableBalance();
            getBankDatabase().getAccount(getTargetAccNum()).setAvailableBalance(current + amount);
            current = getBankDatabase().getAccount(getTargetAccNum()).getTotalBalance();
            getBankDatabase().getAccount(getTargetAccNum()).setTotalBalance(current + amount);
            return TRANSFER_SUCCESS;
        } catch (Exception e) {
            return TRANSFER_FAIL;
        }
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTargetAccNum() {
        return targetAccNum;
    }

    public void setTargetAccNum(int targetAccNum) {
        this.targetAccNum = targetAccNum;
    }
    
}
