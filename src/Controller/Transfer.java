/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Controller;

/**
 *
 * @author ASUS
 */
public class Transfer extends Transaction {

    public Transfer(int userAccountNumber, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmBankDatabase);
    }

    @Override
    public int execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
