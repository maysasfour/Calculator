import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] nButtons = new JButton[10];
    JButton[] fButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 20);
    double n1 = 0, n2 = 0, result = 0;
    char op;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("←");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        fButtons[0] = addButton;
        fButtons[1] = subButton;
        fButtons[2] = mulButton;
        fButtons[3] = divButton;
        fButtons[4] = decButton;
        fButtons[5] = equButton;
        fButtons[6] = delButton;
        fButtons[7] = clrButton;
        fButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            fButtons[i].addActionListener(this);
            fButtons[i].setFont(myFont);
            fButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            nButtons[i] = new JButton(String.valueOf(i));
            nButtons[i].addActionListener(this);
            nButtons[i].setFont(myFont);
            nButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(nButtons[1]);
        panel.add(nButtons[2]);
        panel.add(nButtons[3]);
        panel.add(addButton);
        panel.add(nButtons[4]);
        panel.add(nButtons[5]);
        panel.add(nButtons[6]);
        panel.add(subButton);
        panel.add(nButtons[7]);
        panel.add(nButtons[8]);
        panel.add(nButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(nButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);

        Color darkGray = new Color(64, 64, 64);
        Color black = new Color(0, 0, 0);
        Color red = new Color(220, 0, 0);
        Color orange = new Color(255, 165, 0);
        Color equalBlack = new Color(30, 30, 30);

        for (int i = 0; i < 10; i++) {
            nButtons[i].setBackground(darkGray);
            nButtons[i].setForeground(Color.WHITE);
        }

        decButton.setBackground(darkGray);
        decButton.setForeground(Color.WHITE);

        addButton.setBackground(black);
        subButton.setBackground(black);
        mulButton.setBackground(black);
        divButton.setBackground(black);
        addButton.setForeground(Color.WHITE);
        subButton.setForeground(Color.WHITE);
        mulButton.setForeground(Color.WHITE);
        divButton.setForeground(Color.WHITE);

        equButton.setBackground(equalBlack);
        equButton.setForeground(Color.WHITE);

        clrButton.setBackground(red);
        clrButton.setForeground(Color.WHITE);

        delButton.setBackground(orange);
        delButton.setForeground(Color.WHITE);

        negButton.setBackground(darkGray);
        negButton.setForeground(Color.WHITE);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == nButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            n1 = Double.parseDouble(textField.getText());
            op = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            n1 = Double.parseDouble(textField.getText());
            op = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            n1 = Double.parseDouble(textField.getText());
            op = 'X';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            n1 = Double.parseDouble(textField.getText());
            op = '÷';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            n2 = Double.parseDouble(textField.getText());

            switch (op) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case 'X':
                    result = n1 * n2;
                    break;
                case '÷':
                    result = n1 / n2;
                    break;
            }

            textField.setText(String.valueOf(result));
            n1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String s = textField.getText();
            if (!s.isEmpty()) {
                textField.setText(s.substring(0, s.length() - 1));
            }
        }

        if (e.getSource() == negButton) {
            if (!textField.getText().isEmpty()) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
    }
}





//
//import javax.swing.JOptionPane;
//
//public class Calculator {
//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewJFrame().setVisible(true);
//            }
//        });
//    }
//
//}
//
//class NewJFrame extends javax.swing.JFrame {
//    double val=0,operator,set=0,turn=1;
//    String calc="";
//    public NewJFrame() {
//        initComponents();
//    }
//    @SuppressWarnings("unchecked")
//
//    private void initComponents() {
//
//        jPanel1 = new javax.swing.JPanel();
//        jPanel2 = new javax.swing.JPanel();
//        jButton1 = new javax.swing.JButton();
//        jButton2 = new javax.swing.JButton();
//        jButton3 = new javax.swing.JButton();
//        jButton6 = new javax.swing.JButton();
//        jButton5 = new javax.swing.JButton();
//        jButton4 = new javax.swing.JButton();
//        jButton7 = new javax.swing.JButton();
//        jButton8 = new javax.swing.JButton();
//        jButton9 = new javax.swing.JButton();
//        jButton15 = new javax.swing.JButton();
//        jTextField1 = new javax.swing.JTextField();
//        jPanel3 = new javax.swing.JPanel();
//        jButton10 = new javax.swing.JButton();
//        jButton11 = new javax.swing.JButton();
//        jButton12 = new javax.swing.JButton();
//        jButton13 = new javax.swing.JButton();
//        jButton14 = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CALCULATOR"));
//
//        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
//
//        jButton1.setText("1");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        jButton2.setText("2");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
//
//        jButton3.setText("3");
//        jButton3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton3ActionPerformed(evt);
//            }
//        });
//
//        jButton6.setText("6");
//        jButton6.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton6ActionPerformed(evt);
//            }
//        });
//
//        jButton5.setText("5");
//        jButton5.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton5ActionPerformed(evt);
//            }
//        });
//
//        jButton4.setText("4");
//        jButton4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton4ActionPerformed(evt);
//            }
//        });
//
//        jButton7.setText("7");
//        jButton7.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton7ActionPerformed(evt);
//            }
//        });
//
//        jButton8.setText("8");
//        jButton8.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton8ActionPerformed(evt);
//            }
//        });
//
//        jButton9.setText("9");
//        jButton9.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton9ActionPerformed(evt);
//            }
//        });
//
//        jButton15.setText("RESET");
//        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
//        jButton15.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton15ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addGap(39, 39, 39)
//                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                .addGap(18, 18, 18)
//                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addContainerGap())
//        );
//        jPanel2Layout.setVerticalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
//                                                .addGap(0, 0, Short.MAX_VALUE)
//                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addContainerGap())
//        );
//
//        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
//
//        jButton10.setText("+");
//        jButton10.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton10ActionPerformed(evt);
//            }
//        });
//
//        jButton11.setText("-");
//        jButton11.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton11ActionPerformed(evt);
//            }
//        });
//
//        jButton12.setText("*");
//        jButton12.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton12ActionPerformed(evt);
//            }
//        });
//
//        jButton13.setText("/");
//        jButton13.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton13ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addGap(58, 58, 58)
//                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(62, Short.MAX_VALUE))
//        );
//        jPanel3Layout.setVerticalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addContainerGap())
//        );
//
//        jButton14.setText("=");
//        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
//        jButton14.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton14ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(20, 20, 20)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(18, 18, 18)
//                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addContainerGap())
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(21, 21, 21)
//                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(23, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(25, Short.MAX_VALUE))
//        );
//
//        pack();
//    }
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 1";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+1;
//                else if(operator==2)
//                    val=val-1;
//                else if(operator==3)
//                    val=val*1;
//                else if(operator==4)
//                    val=val/1;
//            }
//            else
//                val=1;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 2";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+2;
//                else if(operator==2)
//                    val=val-2;
//                else if(operator==3)
//                    val=val*2;
//                else if(operator==4)
//                    val=val/2;
//            }
//            else
//                val=2;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 3";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+3;
//                else if(operator==2)
//                    val=val-3;
//                else if(operator==3)
//                    val=val*3;
//                else if(operator==4)
//                    val=val/3;
//            }
//            else
//                val=3;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 4";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+4;
//                else if(operator==2)
//                    val=val-4;
//                else if(operator==3)
//                    val=val*4;
//                else if(operator==4)
//                    val=val/4;
//            }
//            else
//                val=4;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 5";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+5;
//                else if(operator==2)
//                    val=val-5;
//                else if(operator==3)
//                    val=val*5;
//                else if(operator==4)
//                    val=val/5;
//            }
//            else
//                val=5;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 6";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+6;
//                else if(operator==2)
//                    val=val-6;
//                else if(operator==3)
//                    val=val*6;
//                else if(operator==4)
//                    val=val/6;
//            }
//            else
//                val=6;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 7";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+7;
//                else if(operator==2)
//                    val=val-7;
//                else if(operator==3)
//                    val=val*7;
//                else if(operator==4)
//                    val=val/7;
//            }
//            else
//                val=7;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 8";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+8;
//                else if(operator==2)
//                    val=val-8;
//                else if(operator==3)
//                    val=val*8;
//                else if(operator==4)
//                    val=val/8;
//            }
//            else
//                val=8;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==1) {
//            calc=calc+" 9";
//            jTextField1.setText(calc);
//            turn++;
//            if(set==1) {
//                if(operator==1)
//                    val=val+9;
//                else if(operator==2)
//                    val=val-9;
//                else if(operator==3)
//                    val=val*9;
//                else if(operator==4)
//                    val=val/9;
//            }
//            else
//                val=9;
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
//        if(turn%2==0)
//            jTextField1.setText(" ANSWER IS : "+Double.toString(val));
//        else
//            JOptionPane.showMessageDialog(this, "Last character is a operator...");
//    }//GEN-LAST:event_jButton14ActionPerformed
//
//    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
//        reset();
//    }
//
//    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
//
//        if(turn%2==0) {
//            if(set==0 || operator==1) {
//                calc=calc+" +";
//                turn++;
//                jTextField1.setText(calc);
//                operator=1;
//                set=1;
//            }
//            else
//                JOptionPane.showMessageDialog(this, "Can't use more than one operator at a time...");
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
//
//        if(turn%2==0) {
//            if(set==0 || operator==2) {
//                calc=calc+" -";
//                turn++;
//                jTextField1.setText(calc);
//                operator=2;
//                set=1;
//            }
//            else
//                JOptionPane.showMessageDialog(this, "Can't use more than one operator at a time...");
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//
//    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
//
//        if(turn%2==0) {
//            if(set==0 || operator==3) {
//                calc=calc+" *";
//                turn++;
//                jTextField1.setText(calc);
//                operator=3;
//                set=1;
//            }
//            else
//                JOptionPane.showMessageDialog(this, "Can't use more than one operator at a time...");
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
//
//        if(turn%2==0) {
//            if(set==0 || operator==4) {
//                calc=calc+" /";
//                turn++;
//                jTextField1.setText(calc);
//                operator=4;
//                set=1;
//            }
//            else
//                JOptionPane.showMessageDialog(this, "Can't use more than one operator at a time...");
//        }
//        else
//            JOptionPane.showMessageDialog(this, "Wrong key pressed...");
//    }
//    private void reset() {
//        jTextField1.setText("");
//        val=0;
//        operator=0;
//        set=0;
//        calc="";
//        turn=1;
//    }
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewJFrame().setVisible(true);
//            }
//        });
//    }
//
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton10;
//    private javax.swing.JButton jButton11;
//    private javax.swing.JButton jButton12;
//    private javax.swing.JButton jButton13;
//    private javax.swing.JButton jButton14;
//    private javax.swing.JButton jButton15;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JButton jButton4;
//    private javax.swing.JButton jButton5;
//    private javax.swing.JButton jButton6;
//    private javax.swing.JButton jButton7;
//    private javax.swing.JButton jButton8;
//    private javax.swing.JButton jButton9;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JPanel jPanel2;
//    private javax.swing.JPanel jPanel3;
//    private javax.swing.JTextField jTextField1;
//
//}