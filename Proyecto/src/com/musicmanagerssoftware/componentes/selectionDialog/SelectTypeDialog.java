package com.musicmanagerssoftware.componentes.selectionDialog;

import com.musicmanagerssoftware.gui.views.addviews.*;
import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shows a window in which the type of object that we are going to add is selected.
 */
public class SelectTypeDialog extends JDialog implements ActionListener {
    private JPanel contentPane;
    private CompButton button_addArtist_viewSelectType;
    private CompButton button_addBand_viewSelectType;
    private CompButton button_addSong_viewSelectType;
    private CompButton button_addDisc_viewSelectType;
    private CompButton button_addConcertHall_viewSelectType;
    private JLabel label_text_viewSelectType;
    private String text;

    /**
     * ViewSelectType constructor.
     */
    public SelectTypeDialog(String text) {
        this.text=text;
        setTitle("Music Managers Software");
        label_text_viewSelectType.setText(text);
        setBounds(100, 100, 1153, 826);
        setPreferredSize(new Dimension(600,200));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        addActionListener(this);
        setModal(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addActionListener(ActionListener listener){
        button_addArtist_viewSelectType.addActionListener(listener);
        button_addBand_viewSelectType.addActionListener(listener);
        button_addSong_viewSelectType.addActionListener(listener);
        button_addDisc_viewSelectType.addActionListener(listener);
        button_addConcertHall_viewSelectType.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Artist":
                ViewAddArtist viewAddArtist = new ViewAddArtist();
                dispose();
                break;

            case "Band":
                ViewAddBand viewAddBand = new ViewAddBand();
                dispose();
                break;

            case "Song":
                ViewAddSong viewAddSong = new ViewAddSong();
                dispose();
                break;

            case "Disc":
                ViewAddDisc viewAddDisc = new ViewAddDisc();
                dispose();
                break;

            case "Concert Hall":
                ViewAddConcertHall viewAddConcertHall = new ViewAddConcertHall();
                dispose();
                break;
        }
    }
}
