package com.musicmanagerssoftware.gui.views.addviews;

import ownLibs.basic.CompButtonAnimation;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
public class ViewAddBand extends JDialog {

    private JPanel contentPane;
    private JButton button_save_addBand;
    private JButton button_cancel_addBand;
    private JTextField textField_nombre_addBand;
    private JTextField textField_annoFormacion_addBand;
    private JTextField textField_generoMusical_addBand;
    private JList list_canciones_addBand;
    private JList list_conciertos_addBandlist1;
    private JList list_discos_addBand;
    private JLabel label_image_addBand;
    private JLabel label_nombre_addBand;
    private JLabel label_annoFormacion_addBand;
    private JLabel label_generoMusical_addBand;
    private JLabel label_Discografica_addBand;
    private JPanel panel_imagen_AA;
    private JComboBox comboBox1;
    private JList list1;
    private JList list2;

    /**
     *
     */
    public ViewAddBand() {

        setTitle("AÑADIR GRUPO");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(button_save_addBand);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        button_save_addBand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        button_cancel_addBand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     *
     */
    private void onOK() {
        // add your code here
        dispose();
    }

    /**
     *
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}