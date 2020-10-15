package com.musicmanagerssoftware.gui;

import com.musicmanagerssoftware.componentes.menu.BarraMenu;
import com.musicmanagerssoftware.componentes.paneles.PanelArtista;
import com.musicmanagerssoftware.componentes.paneles.PanelGrupo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Vista extends JFrame{

    private JPanel contentPane;

    public Vista() {
        setFont(new Font("Consolas", Font.BOLD, 12));
        setTitle("Music Managers Software");
        setBounds(100, 100, 1153, 826);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        menu();
        componentes();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void menu() {
        BarraMenu menuBar = new BarraMenu();
        setJMenuBar(menuBar);
    }

    private void componentes(){
        JSplitPane splitPaneGeneral = new JSplitPane();//SplitPanel General
        splitPaneGeneral.setOneTouchExpandable(true);
        splitPaneGeneral.setResizeWeight(0.4);
        contentPane.add(splitPaneGeneral);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new java.awt.Dimension(200, 200));
        splitPaneGeneral.setLeftComponent(scrollPane);

        JList list = new JList();
        list.setValueIsAdjusting(true);
        scrollPane.setViewportView(list);

        JScrollBar scrollBar = new JScrollBar();
        scrollPane.setRowHeaderView(scrollBar);

        JLabel lblNewLabel = new JLabel("ART\u00CDSTAS");
        scrollPane.setColumnHeaderView(lblNewLabel);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        splitPaneGeneral.setRightComponent(tabbedPane);

        PanelArtista panelArtista = new PanelArtista();
        tabbedPane.addTab("Art\u00EDsta", null, panelArtista, null);

        PanelGrupo panelGrupo = new PanelGrupo();
        tabbedPane.addTab("Grupo", null, panelGrupo, null);
    }
}
