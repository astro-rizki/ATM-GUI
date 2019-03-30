/*
 * Copyright March - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Interface;

import java.util.Observable;
import java.util.Observer;
import Model.Constants;
import Controller.*;
import View.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainATM implements Observer {

    private String ACT_CODE;
    private int CURRENT_STATE = 0;
    private ATMFrame atmBox = new ATMFrame();
    private int getFromLabel1;
    private int getFromLabel2;

    public static void main(String Args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainATM atm = new MainATM();
        atm.execute();
    }

    void execute() {
        atmBox.setVisible(true);
        atmBox.getKeyAdapter().addObserver(this);
        atmBox.getOuterPadAdapter().addObserver(this);
        try {
            Thread.sleep(750);
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = Constants.LOGIN_GETUSER;
        } catch (InterruptedException ex) {
            System.out.println("--> " + ex.toString());
        }

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

    private void execute_action(String x) throws InterruptedException {
        switch (CURRENT_STATE) {
            case Constants.LOGIN_GETUSER:
                loginUser(x);
                break;
            case Constants.LOGIN_GETPIN:
                loginPIN(x);
                break;
            case Constants.MENU:
                Menu(x);
                break;
            case Constants.BALANCE:
                Balance(x);
                break;
            case Constants.DEPOSIT_GETAMOUNT:
                DepositGetAmount(x);
                break;
            case Constants.DEPOSIT_GETENVELOPE:
                DepositGetEnvelope(x);
                break;
            case Constants.WITHDRAW:
                Withdraw(x);
                break;
        }
    }

    /* kalau dari showLoginGETUSER ngeklik OK atau CCL, masuk sini */
    private void loginUser(String x) throws InterruptedException {
        if (x.equals("OKACT")) {
            getFromLabel1 = atmBox.getAtmScreen().getCursorLabelAmount();
            atmBox.getAtmScreen().showGetPIN();
            CURRENT_STATE = Constants.LOGIN_GETPIN;
        } else if (x.equals("CCLACT")) {
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = Constants.LOGIN_GETUSER;
        }
    }

    /* kalau dari showLoginGETPIN ngeklik OK atau CCL, masuk sini
       ada identifikasi (AUTH USER) dari controller*/
    private void loginPIN(String x) {
        if (x.equals("OKACT")) {
            getFromLabel2 = atmBox.getAtmScreen().getCursorLabelAmount();
            if (true) {     // AUTH USER
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
            } else {
                atmBox.getAtmScreen().second_load_welcome();
                CURRENT_STATE = Constants.LOGIN_GETUSER;
            }
        } else if (x.equals("CCLACT")) {
            atmBox.getAtmScreen().second_load_welcome();
            CURRENT_STATE = Constants.LOGIN_GETUSER;
        }
    }

    
    private void Menu(String x) {
        System.out.println(x);
        switch (x) {
            case "ACT1":
                break;
            case "ACT2":
                atmBox.getAtmScreen().showBalance(0); //ambil jumlah dari kontroller
                CURRENT_STATE = Constants.BALANCE;
                break;
            case "ACT3":
                atmBox.getAtmScreen().showWithdraw();
                CURRENT_STATE = Constants.WITHDRAW;
                break;
            case "ACT4":
                break;
            case "ACT5":
                break;
            case "ACT6":
                atmBox.getAtmScreen().showDepositAmount();
                CURRENT_STATE = Constants.DEPOSIT_GETAMOUNT;
                break;
            case "ACT7":
                break;
            case "ACT8":
                atmBox.getAtmScreen().show_thank_you();
                atmBox.getAtmScreen().show_clearing();
                atmBox.getAtmScreen().second_load_welcome();
                CURRENT_STATE = Constants.LOGIN_GETUSER;
                break;
        }
    }

    private void Balance(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = Constants.MENU;
        }
    }

    private void DepositGetAmount(String x) {
        if ("OKACT".equals(x) || "ACT4".equals(x)) {
            atmBox.getAtmScreen().showDeposit();
            CURRENT_STATE = Constants.DEPOSIT_GETENVELOPE;
        } else if ("CCLACT".equals(x) || "ACT8".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = Constants.MENU;
        }
    }

    private void DepositGetEnvelope(String x) {
        if ("ACT8".equals(x) || "CCLACT".equals(x)) {
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = Constants.MENU;
        } else if("OKACT".equals(x) || "ACT4".equals(x)){
            atmBox.getAtmScreen().showMenu();
            CURRENT_STATE = Constants.MENU;
        }
    }

    private void Withdraw(String x) throws InterruptedException {
        switch (x) {
            //logiknya, pakek metod amnbil, terus balik ke main menu, kl cukup uangnya
            case "ACT1":
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
                atmBox.getAtmDispense().blink();
                break;
            case "ACT2":
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
                atmBox.getAtmDispense().blink();
                break;
            case "ACT3":
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
                atmBox.getAtmDispense().blink();
                break;
            case "ACT4":
                break;
            case "ACT5":
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
                atmBox.getAtmDispense().blink();
                break;
            case "ACT6":
                break;
            case "ACT7":
                break;
            case "ACT8":
            case "CCLACT":
                atmBox.getAtmScreen().showMenu();
                CURRENT_STATE = Constants.MENU;
                break;
        }
        Thread.sleep(500);
    }

}
