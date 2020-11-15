package com.musicmanagerssoftware.gui.views.modifyViews;

import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.event.*;

public class ViewModifyCancion extends JDialog {
    private JPanel contentPane;
    private JButton buttonGuardar;
    private JButton buttonCancelar;
    private JTextField textField_titulo;
    private JTextField textField_fechaPublicacion;
    private JTextField textField_formato;
    private JTextField textField_videoclip;
    private JTextField textField_duracion;
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_artista;
    private JLabel lbl_Imagen;
    private JLabel lbl_nomArt_AA;
    private JLabel lbl_nombre_AA;
    private JLabel lbl_apellidos_AA;
    private JLabel lbl_dni_AA;
    private JLabel lbl_generoMusical_AA;
    private JLabel lbl_discografia_AA;
    private JLabel lbl_grupo_AA;
    private JLabel lbl_nacionalidad_AA;
    private JLabel lbl_fechaNacimiento_AA;
    private JPanel panel_imagen_AA;
    private JComboBox comboBox_disco;
    private JList list_canciones;
    private CompButton button_cancel;
    private CompButton button_save;
    private CompButton button_image;
    private JComboBox comboBox_generoMusical;

    public ViewModifyCancion() {
        setTitle("Modificar Canción");
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
