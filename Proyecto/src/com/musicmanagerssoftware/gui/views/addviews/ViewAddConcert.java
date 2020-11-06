package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import ownLibs.basic.CompButtonAnimation;


import javax.swing.*;
import java.awt.event.*;

public class ViewAddConcert extends JDialog {

    private JPanel contentPane;
    private JButton button_save_addViewConcert;
    private JButton button_cancel_addViewConcert;
    private CompButtonAnimation button_addArtist_addViewConcert;
    private CompButtonAnimation button_addImage_addViewConcert;
    private JTextField textField_numberEntries_addViewConcert;
    private JTextField textField_entryPrice_addViewConcert;
    private JList list_artists_addViewConcert;
    private JLabel lbl_image_addViewConcert;
    private JLabel lbl_dateTicket_addViewConcert;
    private JLabel lbl_concertTime_addViewConcert;
    private JLabel lbl_ticketPrice_addViewConcert;
    private JLabel lbl_minimunAge_addViewConcert;
    private JLabel lbl_numberEntries_addViewConcert;
    private JLabel lbl_concertDate_addViewConcert;
    private JPanel panel_image_addViewConcert;
    private JCheckBox checkBox_merchan_addViewConcert;
    private JComboBox comboBox_musicalTour_addViewConcert;
    private JScrollPane scrollPane_artists_addViewConcert;
    private DatePicker datePicker_dateTickets_addViewConcert;
    private TimePicker dateTime_concertTime_addViewConcert;
    private DatePicker datePicker_concertDate_addViewConcert;
    private JLabel lbl_band_addViewConcert;
    private JSpinner spinner1;

    public ViewAddConcert() {

        setTitle("AÑADIR CONCIERTO");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(button_save_addViewConcert);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        button_addArtist_addViewConcert = new  CompButtonAnimation();
      button_addImage_addViewConcert = new CompButtonAnimation();

        button_save_addViewConcert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        button_cancel_addViewConcert.addActionListener(new ActionListener() {
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
