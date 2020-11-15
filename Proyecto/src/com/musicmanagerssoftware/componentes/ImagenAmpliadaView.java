package com.musicmanagerssoftware.componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ImagenAmpliadaView extends JDialog {

    private final JPanel contentPanel = new JPanel();
    public JLabel lbl_image;

    public ImagenAmpliadaView(){
        setResizable(false);
        setBounds(100, 100, 700, 500);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        lbl_image = new JLabel();
        lbl_image.setPreferredSize(new Dimension(700,500));
        contentPanel.add(lbl_image, BorderLayout.CENTER);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
