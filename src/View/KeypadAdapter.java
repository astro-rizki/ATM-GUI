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
public class KeypadAdapter extends Observable {
    
    private int selected_num = 0;

    public int getSelected_num() {
        return selected_num;
    }

    public void setSelected_num(int selected_num) {
        this.selected_num = selected_num;
        setChanged();
        notifyObservers(selected_num);
    }
    
}
