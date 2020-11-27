package com.musicmanagerssoftware.gui.views.helpviews;

import ownLibs.basic.CompButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

/**
 * Clase que muestra una ventana en la que se visualizarán las versiones existentes del software.
 * @author Alejandro Rdoa
 * @version 1.0.0
 * @since 11/11/2020
 */
public class VersionsView extends JDialog {

    JPanel panel;
    JPanel panel1;
    JTextPane textPane;
    CompButton btnNewButton;
    private final JPanel contentPanel = new JPanel();

    /**
     * Constructor de VersionsView
     */
    public VersionsView() {
        initView();
        initComponents();
        editComponents();
        addComponents();

            btnNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
                });
    }

    /**
     * Método que inicializa la ventana VersionsView
     */
    private void initView(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setTitle("Music Manager Software - Versiones");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método que inicializa los componentes
     */
    private void initComponents(){
       panel = new JPanel();
       panel1 = new JPanel();
       textPane = new JTextPane();
       btnNewButton = new CompButton();
    }

    /**
     * Método que añade los componentes a las vistas
     */
    private void addComponents(){
        contentPanel.add(panel1);
        panel1.add(btnNewButton);
        contentPanel.add(panel);
        panel.add(textPane);
    }

    /**
     * Método que edita los componentes
     */
    private void editComponents(){
        panel1.setBounds(10, 210, 414, 40);
        panel1.setLayout(null);

        btnNewButton.setBounds(160, 11, 89, 23);
        btnNewButton.setText("Aceptar");

        panel.setBounds(10, 11, 414, 192);
        panel.setLayout(null);

        textPane.setEditable(false);
        textPane.setText(" - Versión 1.0.0 - Release 29/11/2020");
        textPane.setBounds(10, 10, 394, 172);
    }
}
