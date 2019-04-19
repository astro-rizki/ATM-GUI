package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Annazar
 */
public final class Constants {

    //
    public static final int BALANCE_INQUIRY = 1;
    public static final int WITHDRAWAL = 2;
    public static final int DEPOSIT = 3;
    public static final int TRANSFERS = 4;
    public static final int UPDATE_PIN = 5;
    public static final int EXIT = 6;

    // withdraw
    public static final int WITHDRAWAL_CANCELED = 6;
    public static final int WITHDRAW_SUCCESSFUL = 1;
    public static final int BALANCE_NOT_ENOUGH = 2;
    public static final int CASHDISPENSER_NOT_ENOUGH = 3;

    // deposit
    public static final int DEPOSIT_CANCELED = 0;
    public static final int DEPOSIT_SUCCESSFUL = 1;
    public static final int ENVELOPE_IS_NOT_RECEIVED = 2;
    
    //change pin
    public static final int CHANGE_PIN_SUCCESSFUL = 1;
    public static final int CHANGE_PIN_FAIL = 2;

    //STATE
    public static final int LOAD_FIRST = 0;
    public static final int LOGIN_GETUSER = 11;
    public static final int LOGIN_GETPIN = 12;
    public static final int AUTH_USER = 19;
    public static final int MENU = 2;
    public static final int BALANCE = 3;
    public static final int DEPOSIT_GETAMOUNT = 41;
    public static final int DEPOSIT_GETENVELOPE = 42;
    public static final int DEPOSIT_ENV_RCVD = 43;
    public static final int DEPOSIT_ENV_NRCVD = 44;
    public static final int WITHDRAW = 5;
    public static final int TRANSFER_GET_ACCOUNT = 61;
    public static final int TRANSFER_GET_AMOUNT = 62;
    public static final int TRANSFER_SUCCESS = 63;
    public static final int TRANSFER_FAIL = 64;
    public static final int CHANGE_PIN = 7;
    public static final int CHANGE_PIN_GETNEW = 711;
    public static final int CHANGE_PIN_GETNEW_AGAIN = 712;
    public static final int CHANGE_PIN_SUCCESS = 72;
    public static final int ERR_RAN_OUT_OF_MONEY = 56;
    public static final int ERR_INSUFFICIENT = 57;
}
