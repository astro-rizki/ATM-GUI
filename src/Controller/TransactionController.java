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
public abstract class TransactionController {

    private Keypad keypad;
    private Screen screen;

    public TransactionController(Keypad theKeypad, Screen theScreen) {
	keypad = theKeypad;
	screen = theScreen;
    }

    public abstract int run();

    /**
     * @return the keypad
     */
    public Keypad getKeypad() {
	return keypad;
    }

    /**
     * @return the screen
     */
    public Screen getScreen() {
	return screen;
    }

}
