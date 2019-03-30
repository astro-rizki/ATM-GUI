/*
 * Copyright March - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package View;

import java.util.Observable;

/**
 *
 * @author ASUS
 */
public class OuterKeypadAdapter extends Observable {
    private String actionSelected;

    public String getActionSelected() {
        return actionSelected;
    }

    public void setActionSelected(String actionSelected) {
        this.actionSelected = actionSelected;
        setChanged();
        notifyObservers(actionSelected);
    }
}
