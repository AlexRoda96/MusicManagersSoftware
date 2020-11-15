package com.musicmanagerssoftware.gui.views.modifyViews;

import com.github.lgooddatepicker.components.DatePicker;
import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.event.*;

/**
 * Ventana para añadir un artísta a la base de datos.
 */
public class ViewModifyArtista extends JDialog {

    //Paneles
    private JPanel contentPane;
    private JPanel panelImagen;
    //JTextField
    private JTextField textFieldNombreArt;
    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JTextField textFieldDni;
    private JTextField textFieldNacionalidad;
    private JTextField textFieldNumTfn;
    private JTextField textFieldSegundoApellido;
    //JComboBox
    private JComboBox comboBoxGrupo;
    private JComboBox comboBoxGeneroMusical;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    //JList
    private JList listCanciones;
    private JList listConciertos;
    private JList listDiscos;
    private JList listGiras;
    //Imagen
    private JLabel lblImagen;
    //DatePicker
    private DatePicker datePickerFechaNacimiento;
    //Buttons
    private CompButton buttonGuardar;
    private CompButton buttonCancelar;
    private JList list1;
    private JScrollPane scrollPaneList;

    /**
     * Constructor ViewAddArtist
     */
    public ViewModifyArtista() {

        setTitle("Modificar Artista");
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
            @Override
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
