/*
 * Copyright March - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Interface;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controller.*;
import View.*;
import static Model.Constants.*;

public class MainATM implements Observer {

    private int CURRENT_STATE = 0;
    private final ATMFrame atmBox = new ATMFrame();
    private int getFromLabel1;
    private int getFromLabel2;
    private int userAcc;
    private ATM_Controller controller = new ATM_Controller();

    public static void main(String Args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainATM atm = new MainATM();
        atm.execute();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            if ((o.getClass().getName().equals("View.KeypadAdapter")
                    && ((int) arg == 13 || (int) arg == 12))) {
                if ((int) arg == 12) {
                    execute_action("OKACT");
                } else if ((int) arg == 13) {
                    execute_action("CCLACT");
                }
            } else if (o.getClass().getName().equals("View.OuterKeypadAdapter")) {
                execute_action((String) arg);
            }
        } catch (InterruptedException ie) {

        }
    }

    void execute() {
        atmBox.setVisible(true);
        atmBox.getKeyAdapter().addObserver(this);
        atmBox.getOuterPadAdapter().addObserver(this);
        try {
            Thread.sleep(750);
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = LOGIN_GETUSER;
        } catch (InterruptedException ex) {
            System.out.println("--> " + ex.toString());
        }

    }

    private void execute_action(String x) throws InterruptedException {
        switch (CURRENT_STATE) {
            case LOGIN_GETUSER:
                loginUser(x);
                break;
            case LOGIN_GETPIN:
                loginPIN(x);
                break;
            case MENU:
                Menu(x);
                break;
            case BALANCE:
                Balance(x);
                break;
            case DEPOSIT_GETAMOUNT:
                DepositGetEnvelope(x);
                break;
            case DEPOSIT_GETENVELOPE:
                DepositProceed(x);
                break;
            case DEPOSIT_ENV_RCVD:
                DepositEnvelopeReceived(x);
                break;
            case DEPOSIT_ENV_NRCVD:
                DepositEnvelopeNotReceived(x);
                break;
            case WITHDRAW:
                Withdraw(x);
                break;
            case ERR_RAN_OUT_OF_MONEY:
                ranOutMoney(x);
                break;
            case ERR_INSUFFICIENT:
                WithdrawInsufficient(x);
                break;
        }
    }

    
    private void Menu(String x) {
        switch (x) {
            case "ACT1":
                break;
            case "ACT2":
                showBalance();
                break;
            case "ACT3":
                Withdraw();
                break;
            case "ACT4":
                break;
            case "ACT5":
                break;
            case "ACT6":
                Deposit();
                break;
            case "ACT7":
                break;
            case "ACT8":
//                atmBox.getAtmScreen().show_thank_you();
//                atmBox.getAtmScreen().show_clearing();
                atmBox.getAtmScreen().second_load_welcome();
                CURRENT_STATE = LOGIN_GETUSER;
                break;
        }
    }

    /* kalau dari showLoginGETUSER ngeklik OK atau CCL, masuk sini */
    private void loginUser(String x) throws InterruptedException {
        if (x.equals("OKACT")) {
            getFromLabel1 = (int) atmBox.getAtmScreen().getCursorLabelAmount();
            atmBox.getAtmScreen().showGetPIN();
            CURRENT_STATE = LOGIN_GETPIN;
        } else if (x.equals("CCLACT")) {
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = LOGIN_GETUSER;
        }
    }

    /* kalau dari showLoginGETPIN ngeklik OK atau CCL, masuk sini
       ada identifikasi (AUTH USER) dari controller*/
    private void loginPIN(String x) {
        if (x.equals("OKACT")) {
            getFromLabel2 = (int) atmBox.getAtmScreen().getCursorLabelAmount();
            if (controller.authenticateUser(getFromLabel1, getFromLabel2)) {     // AUTH USER
                userAcc = getFromLabel1;
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = MENU;
            } else {
                atmBox.getAtmScreen().second_load_welcome();
                CURRENT_STATE = LOGIN_GETUSER;
            }
        } else if (x.equals("CCLACT")) {
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = LOGIN_GETUSER;
        }
    }

    private void showBalance() {
        BalanceInquiry m = (BalanceInquiry) controller.createTransaction(BALANCE_INQUIRY);
        double avail = m.getAvailableBalance();
        double total = m.getTotalBalance();
        atmBox.getAtmScreen().showBalance(userAcc, avail, total);
        CURRENT_STATE = BALANCE;
    }

    private void Balance(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void DepositGetEnvelope(String x) {
        double j = atmBox.getAtmScreen().getCursorLabelAmount() / 100;
        if ("OKACT".equals(x) || "ACT4".equals(x)) {
            atmBox.getAtmScreen().showDepositGetEnv(j);
            CURRENT_STATE = DEPOSIT_GETENVELOPE;
        } else if ("CCLACT".equals(x) || "ACT8".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void DepositProceed(String x) {
        Deposit d = (Deposit) controller.createTransaction(DEPOSIT);
        if ("OKACT".equals(x) || "ACT4".equals(x)) {
            switch (d.execute()) {
                case WITHDRAW_SUCCESSFUL:
                    atmBox.getAtmScreen().showDepositEnvelopeRCVD();
                    CURRENT_STATE = DEPOSIT_ENV_RCVD;
                    break;
                case ENVELOPE_IS_NOT_RECEIVED:
                    atmBox.getAtmScreen().showDepositEnvelopeNotRCVD();
                    CURRENT_STATE = DEPOSIT_ENV_NRCVD;
                    break;
            }
        } else if ("ACT8".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void Withdraw(String x) throws InterruptedException {
        int amount = 0;
        int result = 0;
        Withdrawal w = (Withdrawal) controller.createTransaction(WITHDRAWAL);
        switch (x) {
            //logiknya, pakek metod amnbil, terus balik ke main menu, kl cukup uangnya
            case "ACT1":
                amount = 20;
                break;
            case "ACT2":
                amount = 40;
                break;
            case "ACT3":
                amount = 60;
                break;
            case "ACT4":
                break;
            case "ACT5":
                amount = 100;
                break;
            case "ACT6":
                amount = 200;
                break;
            case "ACT7":
                break;
            case "ACT8":
            case "CCLACT":
                break;
        }
        if (amount > 0) {
            w.setAmount(amount);
            w.setAccountNumber(userAcc);
            result = w.execute();
        }

        switch (result) {
            case WITHDRAW_SUCCESSFUL:
                atmBox.getAtmDispense().blink();
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = MENU;
                break;
            case BALANCE_NOT_ENOUGH:
                atmBox.getAtmScreen().show_insufficientBalance(BALANCE, amount);
                CURRENT_STATE = ERR_INSUFFICIENT;
                break;
            case CASHDISPENSER_NOT_ENOUGH:
                atmBox.getAtmScreen().show_ranOutMoney();
                CURRENT_STATE = ERR_RAN_OUT_OF_MONEY;
                break;
            case 0:
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = MENU;
        }
    }

    private void DepositEnvelopeReceived(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void DepositEnvelopeNotReceived(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x)) {
            atmBox.getAtmScreen().showDepositGetAmount();
            CURRENT_STATE = DEPOSIT_GETAMOUNT;
        } else if ("CCLACT".equals(x) || "ACT8".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void Deposit() {
        atmBox.getAtmScreen().showDepositGetAmount();
        CURRENT_STATE = DEPOSIT_GETAMOUNT;
    }
    
    private void Withdraw() {
        atmBox.getAtmScreen().showWithdraw();
        CURRENT_STATE = WITHDRAW;
    }

    private void ranOutMoney(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

    private void WithdrawInsufficient(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = MENU;
        }
    }

}
