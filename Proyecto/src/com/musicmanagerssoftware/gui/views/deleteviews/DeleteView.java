package com.musicmanagerssoftware.gui.views.deleteviews;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;

import javax.swing.table.DefaultTableModel;

/**
 * Vista de dialogo que muestra una tabla con objetos del tipo que le pasemos por parametro y un
 * boton para eliminar.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class DeleteView extends JDialog {

    private final JPanel contentPanel = new JPanel();
    public JTable table;
    public DefaultTableModel dtm;
    Component horizontalStrut1;
    Component horizontalStrut;
    public CompButton btnNewButton;

    /**
     * Contructor de DeleteView
     */
    public DeleteView() {
        setTitle("Music Manager Software - Eliminar");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setBounds(100, 100, 400, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setResizable(false);

        contentPanel.setLayout(new MigLayout("", "[][grow][][]", "[][grow][][][grow][]"));

        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, "cell 1 1,grow");

        table = new JTable();
        scrollPane.setViewportView(table);
        dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column){
            return false;
            }
        };
        table.setModel(dtm);

        JPanel panel = new JPanel();
        contentPanel.add(panel, "cell 1 4,grow");
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        horizontalStrut = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut);


        btnNewButton = new CompButton();
        btnNewButton.setText("Eliminar");
        btnNewButton.setIcon(new ImageIcon("ico\\Eliminar.png"));
        panel_1.add(btnNewButton);

        horizontalStrut1 = Box.createHorizontalStrut(20);
        panel_1.add(horizontalStrut1);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}