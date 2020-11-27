package com.musicmanagerssoftware.gui.views.helpviews;

import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que muestra una ventana en la que se muestra la informacion de contacto.
 * @author Alejandro Roda
 * @version 1.0.0
 * @since 11/11/2020
 */
public class AboutViews extends JDialog {
    //Atributos
    private JPanel contentPane;
    private JTextField jTextField_version;
    private JTextField jTextField_mail;
    private JTextField jTextField_tfn;
    private JTextPane jTextArea_descripcion;
    private CompButton button;

    /**
     * Constructor de AboutView
     */
    public AboutViews() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\icono.png"));
        setTitle("Music Manager Sofrware - Acerca de");
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jTextArea_descripcion.setText("Music Managers Software es un software de gestión de" +
                " artistas musicales. Esta enfocado para un público muy" +
                " específico, los managers de artistas musicales. " +
                "El programa permitirá tener a su disposición los artistas con los que trabaja" +
                " el manager, editar sus datos, calcular presupuestos de conciertos, giras, ver" +
                " estadísticas, etc…");
        jTextArea_descripcion.setEditable(false);;
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }

}
