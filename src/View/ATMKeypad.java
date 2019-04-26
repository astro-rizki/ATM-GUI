/*
 * Copyright March - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package View;

/**
 *
 * @author ASUS
 */
public class ATMKeypad extends javax.swing.JPanel {
    
    private static KeypadAdapter keypadAdapter ;
    
    public ATMKeypad(KeypadAdapter ka) {
        initComponents();
        keypadAdapter = ka;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empt_left = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        empt_right = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn_del = new java.awt.Button();
        btn_ok = new java.awt.Button();
        btn_ccl = new java.awt.Button();
        btn_clr = new java.awt.Button();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(350, 220));
        setMinimumSize(new java.awt.Dimension(350, 220));
        setPreferredSize(new java.awt.Dimension(350, 220));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empt_left.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        empt_left.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empt_left.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empt_left.setMultiClickThreshhold(1);
        add(empt_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 50));

        btn1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setMultiClickThreshhold(1);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 50));

        btn4.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setMultiClickThreshhold(1);
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 50));

        btn7.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn7.setMultiClickThreshhold(1);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, -1));

        btn0.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn0.setText("0");
        btn0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn0.setMultiClickThreshhold(1);
        btn0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn0MouseClicked(evt);
            }
        });
        add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 60, 50));

        btn2.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setMultiClickThreshhold(1);
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 60, 50));

        btn5.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn5.setMultiClickThreshhold(1);
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, 50));

        btn8.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn8.setMultiClickThreshhold(1);
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 60, -1));

        empt_right.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        empt_right.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        empt_right.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empt_right.setMultiClickThreshhold(1);
        add(empt_right, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 60, 50));

        btn3.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setMultiClickThreshhold(1);
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, 50));

        btn6.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn6.setMultiClickThreshhold(1);
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, 50));

        btn9.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn9.setMultiClickThreshhold(1);
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, -1));

        btn_del.setBackground(new java.awt.Color(204, 204, 0));
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_del.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        btn_del.setLabel("DELETE");
        btn_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delMouseClicked(evt);
            }
        });
        add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 110, 50));

        btn_ok.setBackground(new java.awt.Color(0, 204, 51));
        btn_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ok.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        btn_ok.setLabel("OK");
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
        });
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 110, 50));

        btn_ccl.setBackground(new java.awt.Color(204, 0, 0));
        btn_ccl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ccl.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        btn_ccl.setLabel("CANCEL");
        btn_ccl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cclMouseClicked(evt);
            }
        });
        btn_ccl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cclActionPerformed(evt);
            }
        });
        add(btn_ccl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 110, 50));

        btn_clr.setBackground(new java.awt.Color(51, 153, 255));
        btn_clr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_clr.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        btn_clr.setLabel("CLEAR");
        btn_clr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clrMouseClicked(evt);
            }
        });
        add(btn_clr, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 110, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        keypadAdapter.setSelected_num(1);
    }//GEN-LAST:event_btn1MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        keypadAdapter.setSelected_num(2);
    }//GEN-LAST:event_btn2MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        keypadAdapter.setSelected_num(3);
    }//GEN-LAST:event_btn3MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        keypadAdapter.setSelected_num(4);
    }//GEN-LAST:event_btn4MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        keypadAdapter.setSelected_num(5);
    }//GEN-LAST:event_btn5MouseClicked

    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
        keypadAdapter.setSelected_num(6);
    }//GEN-LAST:event_btn6MouseClicked

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        keypadAdapter.setSelected_num(7);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        keypadAdapter.setSelected_num(8);
    }//GEN-LAST:event_btn8MouseClicked

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        keypadAdapter.setSelected_num(9);
    }//GEN-LAST:event_btn9MouseClicked

    private void btn0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn0MouseClicked
        keypadAdapter.setSelected_num(10);
    }//GEN-LAST:event_btn0MouseClicked

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
        keypadAdapter.setSelected_num(12);
    }//GEN-LAST:event_btn_okMouseClicked

    private void btn_delMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delMouseClicked
        keypadAdapter.setSelected_num(14);
    }//GEN-LAST:event_btn_delMouseClicked

    private void btn_clrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clrMouseClicked
        keypadAdapter.setSelected_num(11);
    }//GEN-LAST:event_btn_clrMouseClicked

    private void btn_cclMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cclMouseClicked
        keypadAdapter.setSelected_num(13);
    }//GEN-LAST:event_btn_cclMouseClicked

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_cclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cclActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cclActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private java.awt.Button btn_ccl;
    private java.awt.Button btn_clr;
    private java.awt.Button btn_del;
    private java.awt.Button btn_ok;
    private javax.swing.JButton empt_left;
    private javax.swing.JButton empt_right;
    // End of variables declaration//GEN-END:variables
}
