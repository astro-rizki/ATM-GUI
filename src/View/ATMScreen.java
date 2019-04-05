/*
 * Copyright March - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package View;

import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.*;

/**
 *
 * @author ASUS
 */
public class ATMScreen extends javax.swing.JPanel implements Observer {

    private Timer tm;
    private String cursorPosition;

    /**
     * Creates new form ATMScreen
     */
    public ATMScreen() {
        initComponents();
        first_load_animate();
    }

    private void first_load_animate() {
        disableAllLabel();

        midLabel.setVisible(true);
        botLabel1.setVisible(true);
        midLabel.setText("Starting System..");
        botLabel1.setText("Please Wait");
        super.repaint();
    }

    public void second_load_welcome() {
        botLabel1.setVisible(false);
        midLabel.setVisible(false);
        topLabel.setVisible(true);
        topLabel.setText("Welcome");
        showGetAccNumber();
    }

    public void showGetAccNumber() {
        midleft1.setVisible(true);
        midright1.setVisible(true);
        midleft2.setVisible(false);
        midright2.setVisible(false);
        midright1.setText("");
        midright1.setHorizontalTextPosition(LEFT);
        midright1.repaint();
        midleft1.setText("Enter your Account number :");
        super.repaint();
        setCurrentCursor();
    }

    public void showGetPIN() {
        midleft2.setVisible(true);
        midright2.setVisible(true);
        midright2.setText("");
        midleft2.setText("Enter your PIN    :");
        setCurrentCursor();
        super.repaint();
    }

    private void disableAllLabel() {
        disableChoiceLabel();
        topLabel.setVisible(false);
        midleft1.setVisible(false);
        midleft2.setVisible(false);
        midright1.setVisible(false);
        midright2.setVisible(false);
        midLabel.setVisible(false);
        botLabel1.setVisible(false);
        botLabel2.setVisible(false);
    }

    private void disableChoiceLabel() {
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        label8.setVisible(false);
    }

    private void enableChoiceLabel() {
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        label5.setVisible(true);
        label6.setVisible(true);
        label7.setVisible(true);
        label8.setVisible(true);
    }

    private void showOKandCancel() {
        label4.setText("OK");
        label8.setText("CANCEL");
        label4.setVisible(true);
        label8.setVisible(true);
    }

    public void showMenu() {
        disableAllLabel();
        enableChoiceLabel();
        topLabel.setVisible(true);

        label1.setText("");
        label2.setText("VIEW BALANCE");
        label3.setText("WITHDRAWAL");
        label4.setText("");
        label5.setText("");
        label6.setText("DEPOSIT");
        label7.setText("");
        label8.setText("EXIT");
        topLabel.setText("SELECT TRANSACTION");
        super.repaint();
    }

    /*  IS : Pasti dipanggil dari showMenu(), tidak perlu repaint2
    *   FS : Menampilkan pilihan Aksi untuk withdraw */
    public void showWithdraw() {
        label1.setText("$ 20");
        label2.setText("$ 40");
        label3.setText("$ 60");
        label4.setText("");
        label5.setText("$100");
        label6.setText("$200");
        label7.setText("");
        label8.setText("CANCEL");
        topLabel.setText("WITHDRAWAL");
    }

    public void showDepositGetAmount() {
        disableChoiceLabel();
        showOKandCancel();
        topLabel.setText("DEPOSIT");
        midleft1.setText("PLEASE INSERT ");
        midleft2.setText("DEPOSIT AMOUNT : ");
        midright2.setText(printDollarAmount(0));
        topLabel.setVisible(true);
        midleft1.setVisible(true);
        midleft2.setVisible(true);
        midright2.setVisible(true);
        botLabel1.setVisible(false);
        botLabel2.setVisible(false);
        midright2.setHorizontalTextPosition(JLabel.LEFT);
        setCurrentCursor();
        super.repaint();
    }

    public void showDepositGetEnv(double amount) {
        midleft1.setText("PLEASE INSERT THE ENVELOPE");
        midleft2.setText("CONTAINING    " + printDollarAmount(amount));
        midright2.setVisible(false);
        super.repaint();
    }

    public void showDepositEnvelopeRCVD() {
        topLabel.setText("SUCCEED");
        midleft1.setText("Your envelope will be");
        midleft2.setText("checked soon.");
        midright2.setVisible(false);
        label8.setVisible(false);
        topLabel.setVisible(true);
        super.repaint();
    }

    public void showDepositEnvelopeNotRCVD() {
        topLabel.setText("FAIL");
        midleft1.setText("Make sure your");
        midleft2.setText("envelope not folded");
        label4.setText("TRY AGAIN");
        label8.setText("MENU");
        topLabel.setVisible(true);
        midright2.setVisible(false);
        super.repaint();
    }

    public void showBalance(int acc, double avail, double total) {
        disableChoiceLabel();
        showOKandCancel();
        cursorPosition = "NONE";
        label8.setVisible(false);
        topLabel.setText("ACCOUNT INFO");
        midleft1.setText("Your Account number    :");
        midleft2.setText("Your Available Balance :");
        midright1.setText(acc + "");
        midright2.setText(printDollarAmount(avail));
        botLabel1.setText("Your Total Balance is :");
        botLabel2.setText(printDollarAmount(total));
        midleft1.setVisible(true);
        midleft2.setVisible(true);
        midright1.setVisible(true);
        midright2.setVisible(true);
        botLabel1.setVisible(true);
        botLabel2.setVisible(true);
        super.repaint();
    }

    public void show_thank_you() {
        disableAllLabel();

        midLabel.setVisible(true);
        botLabel1.setVisible(true);
        midLabel.setText("THANK YOU");
        botLabel1.setText("GOODBYE!");
        super.repaint();
    }

    public void show_clearing() {
        disableAllLabel();

        midLabel.setVisible(true);
        botLabel1.setVisible(true);
        midLabel.setText("Clearing System..");
        botLabel1.setText("Please Wait");
        super.repaint();
    }

    public void show_ranOutMoney() {
        disableAllLabel();
        showOKandCancel();
        topLabel.setText("!OUT OF MONEY!");
        midleft1.setText("We're sorry, our machine");
        midleft2.setText("are running out of money");
        botLabel1.setText("Please Contact");
        botLabel2.setText("Administrator");
        topLabel.setVisible(true);
        midleft1.setVisible(true);
        midleft2.setVisible(true);
        botLabel1.setVisible(true);
        botLabel2.setVisible(true);
        label8.setVisible(false);

        super.repaint();
    }

    public void show_insufficientBalance(double balance, int amount) {
        disableAllLabel();
        showOKandCancel();
        topLabel.setText("!Insufficient Balance!");
        midleft1.setText("Unable to process");
        midleft2.setText("your withdraw : " + printDollarAmount(amount));
        botLabel1.setText("Your Balance is");
        botLabel2.setText(printDollarAmount(balance));
        topLabel.setVisible(true);
        midleft1.setVisible(true);
        midleft2.setVisible(true);
        botLabel1.setVisible(true);
        botLabel2.setVisible(true);
        label8.setVisible(false);

        super.repaint();
    }

    private String printDollarAmount(double amount) {
        return String.format("$%,.2f", amount);
    }

    private double getNumericDollarAmount(String strAmount) {
        String dump = strAmount.replaceAll(",", "");
        dump = dump.replaceAll("\\.", "");
        dump = dump.replaceAll(" ", "");
        dump = dump.replaceAll("\\$", "");
        return (Double.parseDouble(dump) / 100);
    }

    private void appendOnLabelDollar(JLabel j, int x) {
        long numericVal = (int) (getNumericDollarAmount(j.getText()) * 1000);

        if (getNumericDollarAmount(j.getText()) * 10 <= 20000000) {
            numericVal = numericVal + x;
            if (x == 10) {
                numericVal -= 10;
            }
            j.setText(printDollarAmount((double) numericVal / 100));
        } else {
            botLabel1.setText("Maximum amount is");
            botLabel2.setText("$20,000,000.00");
            botLabel1.setVisible(true);
            botLabel2.setVisible(true);
            super.repaint();
        }
    }

    private void clearLabelDollar(JLabel j) {
        j.setText(printDollarAmount(0));
        botLabel1.setVisible(false);
        botLabel2.setVisible(false);
        super.repaint();
    }

    private void deleteOnLabelDollar(JLabel j) {
        long numericVal = (int) (getNumericDollarAmount(j.getText()) * 100);
        numericVal = numericVal / 10;
        j.setText(printDollarAmount((double) numericVal / 100));
        botLabel1.setVisible(false);
        botLabel2.setVisible(false);
        super.repaint();
    }

    private void appendOnLabel(JLabel j, int x) {
        int someNumFrmString = 0;

        try {
            someNumFrmString = Integer.parseInt(j.getText());
        } catch (NumberFormatException n) {
            clearLabel(j);
        }

        someNumFrmString = someNumFrmString * 10 + x;
        if (x == 10) {
            someNumFrmString -= 10;
        }
        j.setText(someNumFrmString + "");
    }

    private void clearLabel(JLabel j) {
        j.setText("");
    }

    private void deleteOnLabel(JLabel j) {
        int someNumFrmString = 0;

        try {
            someNumFrmString = Integer.parseInt(j.getText());
        } catch (NumberFormatException n) {
            clearLabel(j);
        }

        someNumFrmString = someNumFrmString / 10;
        if (someNumFrmString != 0) {
            j.setText(someNumFrmString + "");
        } else {
            clearLabel(j);
        }
    }

    public void updateLabel(Object arg) {
//        setCurrentCursor();
        int x = (int) arg;

        setLabel(x);
    }

    private void setLabel(int x) {
        switch (cursorPosition) {
            case "TOP":
                if (midright1.getText().contains(".")) {
                    if (x > 0 && x <= 10) {
                        appendOnLabelDollar(midright1, x);
                    } else if (x == 11) {
                        clearLabelDollar(midright1);
                    } else if (x == 14) {
                        deleteOnLabelDollar(midright1);
                    }
                } else {
                    if (x > 0 && x <= 10) {
                        appendOnLabel(midright1, x);
                    } else if (x == 11) {
                        clearLabel(midright1);
                    } else if (x == 14) {
                        deleteOnLabel(midright1);
                    }
                }
                break;
            case "BOT":
                if (midright2.getText().contains(".")) {
                    if (x > 0 && x <= 10) {
                        appendOnLabelDollar(midright2, x);
                    } else if (x == 11) {
                        clearLabelDollar(midright2);
                    } else if (x == 14) {
                        deleteOnLabelDollar(midright2);
                    }
                } else {
                    if (x > 0 && x <= 10) {
                        appendOnLabel(midright2, x);
                    } else if (x == 11) {
                        clearLabel(midright2);
                    } else if (x == 14) {
                        deleteOnLabel(midright2);
                    }
                }
                break;
        }
    }

    public void setCurrentCursor() {
        if (midright1.isVisible() && !midright2.isVisible()) {
            cursorPosition = "TOP";
        } else if (midright2.isVisible()) {
            cursorPosition = "BOT";
        } else {
            cursorPosition = "NONE";
        }
    }

    public String getCurrentCursor() {
        return this.cursorPosition;
    }

    public double getCursorLabelAmount() {
        switch (this.cursorPosition) {
            case "TOP":
                if (midright1.getText().contains(".")) {
                    return getNumericDollarAmount(midright1.getText()) * 100;
                } else if (!midright1.getText().equals("")) {
                    return Integer.parseInt(midright1.getText());
                }
            case "BOT":
                if (midright2.getText().contains(".")) {
                    return getNumericDollarAmount(midright2.getText()) * 100;
                } else if (!midright2.getText().equals("")) {
                    return Integer.parseInt(midright2.getText());
                }
            default:
                break;
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label8 = new javax.swing.JLabel();
        midLabel = new javax.swing.JLabel();
        midleft2 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        botLabel1 = new javax.swing.JLabel();
        midleft1 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        midright1 = new javax.swing.JLabel();
        midright2 = new javax.swing.JLabel();
        botLabel2 = new javax.swing.JLabel();
        topLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 153));
        setMaximumSize(new java.awt.Dimension(770, 470));
        setMinimumSize(new java.awt.Dimension(750, 460));
        setPreferredSize(new java.awt.Dimension(750, 460));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label8.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 255, 255));
        label8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label8.setText("LABEL8");
        add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 270, -1));

        midLabel.setFont(new java.awt.Font("OCR-A BT", 1, 42)); // NOI18N
        midLabel.setForeground(new java.awt.Color(255, 255, 255));
        midLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        midLabel.setText("MID LABEL");
        add(midLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 510, -1));

        midleft2.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        midleft2.setForeground(new java.awt.Color(255, 255, 255));
        midleft2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        midleft2.setText("LABEL B :");
        add(midleft2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 410, -1));

        label6.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label6.setText("LABEL6");
        add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 270, -1));

        label7.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label7.setText("LABEL7");
        add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 270, -1));

        label4.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label4.setText("LABEL4");
        add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 270, -1));

        label1.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("LABEL1");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 270, -1));

        label2.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("LABEL2");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 270, -1));

        label3.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("LABEL3");
        add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 270, -1));

        botLabel1.setFont(new java.awt.Font("OCR-A BT", 1, 22)); // NOI18N
        botLabel1.setForeground(new java.awt.Color(255, 255, 255));
        botLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botLabel1.setText("BOTTOM 1");
        add(botLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 510, -1));

        midleft1.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        midleft1.setForeground(new java.awt.Color(255, 255, 255));
        midleft1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        midleft1.setText("LABEL A :");
        add(midleft1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 410, -1));

        label5.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label5.setText("LABEL5");
        add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, -1));

        midright1.setFont(new java.awt.Font("OCR-A BT", 1, 24)); // NOI18N
        midright1.setForeground(new java.awt.Color(255, 255, 255));
        midright1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        midright1.setText("-");
        add(midright1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 140, -1));

        midright2.setFont(new java.awt.Font("OCR-A BT", 1, 18)); // NOI18N
        midright2.setForeground(new java.awt.Color(255, 255, 255));
        midright2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        midright2.setText("****");
        add(midright2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 240, -1));

        botLabel2.setFont(new java.awt.Font("OCR-A BT", 1, 20)); // NOI18N
        botLabel2.setForeground(new java.awt.Color(255, 255, 255));
        botLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botLabel2.setText("BOTTOM 2");
        add(botLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 510, -1));

        topLabel.setFont(new java.awt.Font("OCR-A BT", 1, 42)); // NOI18N
        topLabel.setForeground(new java.awt.Color(255, 255, 255));
        topLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLabel.setText("TOP LABEL");
        add(topLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 510, -1));

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botLabel1;
    private javax.swing.JLabel botLabel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel midLabel;
    private javax.swing.JLabel midleft1;
    private javax.swing.JLabel midleft2;
    private javax.swing.JLabel midright1;
    private javax.swing.JLabel midright2;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass().getName().equals("java.lang.Integer")) {
            updateLabel(arg);
        }
    }

}
