package com.musicmanagerssoftware.gui.addViews;

import ownLibs.basic.CompButton;

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
    private JTextField textField_discografica_addBand;
    private JTextField textField_spotify_addBand;
    private JTextField textField_instagram_addBand;
    private JList list_canciones_addBand;
    private JList list_conciertos_addBandlist1;
    private JList list_discos_addBand;
    private JList list_giras_addBand;
    private JLabel label_image_addBand;
    private JLabel label_nombre_addBand;
    private JLabel label_annoFormacion_addBand;
    private JLabel label_generoMusical_addBand;
    private JLabel label_web_addBand;
    private JLabel label_instagram_addBand;
    private JLabel label_youtube_addBand;
    private JLabel label_spotify_addBand;
    private JLabel label_Discografica_addBand;
    private JPanel panel_imagen_AA;
    private JTextField textField_web_addBand;
    private JTextField textField_youtube_addBand;
    private CompButton button_addImage_addBand;
    private CompButton button_addArtistas_addBand;
    private CompButton button_addDiscos_addBand;
    private CompButton button_addGiras_addBand;
    private CompButton button_addConciertos_addBand;
    private CompButton button_addCanciones_addBand;
    private JScrollPane list_artistas_addBand;

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
