package com.musicmanagerssoftware.gui.views.modifyViews;

import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.event.*;

public class ViewModifyGira extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField_nombArt_AA;
    private JTextField textField_nombre_AA;
    private JTextField textField_apellidos_AA;
    private JTextField textField_dni_AA;
    private JTextField textField_nnacionalidad_AA;
    private JList list2;
    private JLabel lbl_Imagen_AnnadirArtista;
    private JLabel lbl_nomArt_AA;
    private JLabel lbl_nombre_AA;
    private JLabel lbl_apellidos_AA;
    private JLabel lbl_dni_AA;
    private JLabel lbl_nacionalidad_AA;
    private JPanel panel_imagen_AA;
    private JList list1;
    private CompButton buttonGuardar;
    private CompButton buttonCancelar;

    public ViewModifyGira() {
        setTitle("Modificar Gira");
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        buttonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
