package com.musicmanagerssoftware.componentes.panels;

import com.musicmanagerssoftware.interfaces.MethodsPanels;
import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class
PanelGira extends JPanel implements MethodsPanels {

    JPanel panel_8;

    JScrollPane scrollPane_giras;
    JScrollPane scrollPane_conciertos;

    JList list_giras;
    JList list_conciertos;

    JLabel lbl_giras;
    JLabel lbl_nombre;
    JLabel lbl_image;
    JLabel lbl_artista;
    JLabel lbl_grupo;
    JLabel lbl_fechaInico;
    JLabel lbl_fechaFin;
    JLabel lbl_presupuesto;
    JLabel lbl_coste;
    JLabel lbl_ganancia;
    JLabel lbl_conciertos;

    CompTextFieldNoEditable textField_nombre;
    CompTextFieldNoEditable textField_artista;
    CompTextFieldNoEditable textField_grupo;
    CompTextFieldNoEditable textField_fechaInico;
    CompTextFieldNoEditable textField_fechaFin;
    CompTextFieldNoEditable textField_presupuesto;
    CompTextFieldNoEditable textField_coste;
    CompTextFieldNoEditable textField_ganancia;

    JSeparator separator;

    CompButton button_ampliar;

    public PanelGira(){
        setLayout(new MigLayout("", "[][290.00,grow][][220.00][][73.00,grow][]", "[][][][][][][][][][][][][][][][][][27.00][27.00][][122.00][grow]"));
        initComponents();
        editComponents();
        addComponents();
    }

    @Override
    public void initComponents() {
        panel_8 = new JPanel();

        scrollPane_giras = new JScrollPane();
        scrollPane_conciertos = new JScrollPane();

        list_giras = new JList();
        list_conciertos = new JList();

        lbl_giras = new JLabel("Giras");
        lbl_nombre = new JLabel("Nombre");
        lbl_image = new JLabel("New label");
        lbl_artista = new JLabel("Artista");
        lbl_grupo = new JLabel("Grupo");
        lbl_fechaInico = new JLabel("Fecha de Inico");
        lbl_fechaFin = new JLabel("Fecha de Finalizaci\u00F3n");
        lbl_presupuesto = new JLabel("Presupuesto");
        lbl_coste = new JLabel("Coste");
        lbl_ganancia = new JLabel("Ganancia");
        lbl_conciertos = new JLabel("Conciertos");

        textField_nombre = new CompTextFieldNoEditable();
        textField_artista = new CompTextFieldNoEditable();
        textField_grupo = new CompTextFieldNoEditable();
        textField_fechaInico = new CompTextFieldNoEditable();
        textField_fechaFin = new CompTextFieldNoEditable();
        textField_presupuesto = new CompTextFieldNoEditable();
        textField_coste = new CompTextFieldNoEditable();
        textField_ganancia = new CompTextFieldNoEditable();

        separator = new JSeparator();

        button_ampliar = new CompButton();
    }

    @Override
    public void editComponents() {
        scrollPane_giras.setViewportView(list_giras);
        scrollPane_giras.setColumnHeaderView(lbl_giras);
        textField_nombre.setColumns(10);
        panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));

        panel_8.setLayout(new BorderLayout(0, 0));
        panel_8.add(lbl_image, BorderLayout.CENTER);
        textField_artista.setColumns(10);
        add(lbl_grupo, "cell 3 5");
        add(textField_grupo, "cell 3 6,growx");
        textField_grupo.setColumns(10);
        textField_fechaInico.setColumns(10);
        textField_fechaFin.setColumns(10);
        textField_presupuesto.setColumns(10);
        textField_coste.setColumns(10);
        textField_ganancia.setColumns(10);
        separator.setForeground(Color.BLACK);
        separator.setBackground(Color.BLACK);
        scrollPane_conciertos.setViewportView(list_conciertos);
        button_ampliar.setText("Ampliar");
        button_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
    }

    @Override
    public void addComponents() {

        add(scrollPane_giras, "cell 1 1 1 21,grow");
        add(lbl_nombre, "cell 3 1");
        add(textField_nombre, "cell 3 2,growx");
        add(panel_8, "cell 5 2 1 6,grow");
        add(lbl_artista, "cell 3 3");
        add(textField_artista, "cell 3 4,growx");
        add(lbl_fechaInico, "cell 3 7");
        add(textField_fechaInico, "cell 3 8,growx");
        add(button_ampliar, "cell 5 8,growx");
        add(lbl_fechaFin, "cell 3 9");
        add(textField_fechaFin, "cell 3 10,growx");
        add(lbl_presupuesto, "cell 3 11");
        add(textField_presupuesto, "cell 3 12,growx");
        add(lbl_coste, "cell 3 13");
        add(textField_coste, "cell 3 14,growx");
        add(lbl_ganancia, "cell 3 15");
        add(textField_ganancia, "cell 3 16,growx");
        add(separator, "cell 3 17 3 2,growx,aligny center");
        add(lbl_conciertos, "cell 3 19");
        add(scrollPane_conciertos, "cell 3 20,grow");
    }



}
