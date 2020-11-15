package com.musicmanagerssoftware.gui.views.modifyViews;

import javax.swing.*;
import java.awt.event.*;

public class ViewModifyDisco extends JDialog {
    private JPanel contentPane;
    private JButton buttonGuardar;
    private JButton buttonCancelar;
    private JTextField textField_nombArt_AA;
    private JTextField textField_nombre_AA;
    private JTextField textField_apellidos_AA;
    private JTextField textField_nnacionalidad_AA;
    private JTextField textField_fechaNacimiento_AA;
    private JList list2;
    private JLabel lbl_Imagen_AnnadirArtista;
    private JLabel lbl_nomArt_AA;
    private JLabel lbl_nombre_AA;
    private JLabel lbl_apellidos_AA;
    private JLabel lbl_dni_AA;
    private JLabel lbl_nacionalidad_AA;
    private JLabel lbl_fechaNacimiento_AA;
    private JPanel panel_imagen_AA;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JList list1;

    public ViewModifyDisco() {
        setTitle("Modificar Disco");
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonGuardar);
        setResizable(false);
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
