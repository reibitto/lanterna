/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 *
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010-2019 Martin Berglund
 */
package com.googlecode.lanterna.terminal;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author martin
 */
public class NewSwingTerminalTest extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private static final Random RANDOM = new Random();

    /**
     * Creates new form NewSwingTerminalTest
     */
    public NewSwingTerminalTest() {
        initComponents();

        final SwingTerminal leftTerminal = new SwingTerminal();
        final SwingTerminal rightTerminal = new SwingTerminal();
        splitPane.setLeftComponent(leftTerminal);
        splitPane.setRightComponent(rightTerminal);
        pack();

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawRandomHello(leftTerminal);
                drawRandomHello(rightTerminal);
            }

            private void drawRandomHello(IOSafeTerminal terminal) {
                TerminalSize size = terminal.getTerminalSize();
                if(size.getColumns() > 6 && size.getRows() > 1) {
                    int positionX = RANDOM.nextInt(size.getColumns() - 6);
                    int positionY = RANDOM.nextInt(size.getRows());

                    terminal.setCursorPosition(positionX, positionY);
                    terminal.setBackgroundColor(new TextColor.Indexed(RANDOM.nextInt(256)));
                    terminal.setForegroundColor(new TextColor.Indexed(RANDOM.nextInt(256)));
                    String hello = "Hello!";
                    for(int i = 0; i < hello.length(); i++) {
                        terminal.putCharacter(hello.charAt(i));
                    }
                    terminal.flush();
                }
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        splitPane.setDividerLocation(250);
        getContentPane().add(splitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSwingTerminalTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new NewSwingTerminalTest().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables
}
