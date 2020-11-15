package com.musicmanagerssoftware.gui.views.modifyViews;

import ownLibs.basic.CompButton;
import ownLibs.basic.CompButtonAnimation;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 */
public class ViewModifyGrupo extends JDialog {

    private JPanel contentPane;
    private JButton buttonGuardar;
    private JButton buttonCancelar;
    private JTextField textField_nombre_addBand;
    private JTextField textField_annoFormacion_addBand;
    private JTextField textField_generoMusical_addBand;
    private JList list_discos;
    private JList list_giras;
    private JList list_conciertos;
    private JLabel label_image_addBand;
    private JLabel label_nombre_addBand;
    private JLabel label_annoFormacion_addBand;
    private JLabel label_generoMusical_addBand;
    private JLabel label_Discografica_addBand;
    private JPanel panel_imagen_AA;
    private JComboBox comboBox1;
    private JList list_canciones;
    private JList list_reuniones;
    private JList list3;
    private CompButton button_discos;
    private CompButton button_canciones;
    private CompButton button_reuniones;
    private CompButton button_conciertos;
    private CompButton button_giras;
    private CompButton button_artistas;
    private JList list_artistas;

    /**
     *
     */
    public ViewModifyGrupo() {

        setTitle("Modificar Grupo");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonGuardar);
        pack();
        setResizable(false);
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
