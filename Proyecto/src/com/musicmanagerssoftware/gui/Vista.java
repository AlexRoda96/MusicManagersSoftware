package com.musicmanagerssoftware.gui;

import com.musicmanagerssoftware.componentes.BarraMenu;

import javax.swing.*;
import java.awt.*;


public class Vista extends JFrame{

    private JPanel panel1;

    public Vista() {
        setFont(new Font("Consolas", Font.BOLD, 12));

        setTitle("Music Managers Software");
        setBounds(100, 100, 1153, 826);
        panel1 = new JPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void menu() {
        BarraMenu menuBar = new BarraMenu();
        setJMenuBar(menuBar);
    }

}
