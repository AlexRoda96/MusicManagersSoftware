package com.musicmanagerssoftware.componentes.panels;

import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ConcertPanel extends JPanel {

    //ScrollPane
    JScrollPane scrollPane_conciertos;
    JScrollPane scrollPane_canciones;

    //JList
    public JList list_conciertos;
    public JList list_canciones;

    //JLabel
    JLabel Conciertos;
    JLabel lbl_nombre;
    public JLabel lbl_imagen;
    JLabel lbl_pais;
    JLabel lbl_ciudad;
    JLabel lbl_fechaConcierto;
    JLabel lbl_fechaSalidaEntradas;
    JLabel lbl_numEntradas;
    JLabel lbl_sala;
    JLabel lbl_precioEntradas;
    JLabel lbl_gira;
    JLabel lbl_horaApertura;
    JLabel lbl_artista;
    JLabel lbl_canciones;
    JLabel lbl_grupo;
    JLabel lbl_edadMinima;
    JLabel lbl_merchan;

    //JTextField
    public CompTextFieldNoEditable textField_nombre;
    public CompTextFieldNoEditable textField_pais;
    public CompTextFieldNoEditable textField_ciudad;
    public  CompTextFieldNoEditable textField_fechaSalidaEntradas;
    public CompTextFieldNoEditable textField_numEntradas;
    public CompTextFieldNoEditable textField_fechaConcierto;
    public CompTextFieldNoEditable textField_Sala;
    public CompTextFieldNoEditable textField_precioEntrada;
    public CompTextFieldNoEditable textField_edadMinima;
    public CompTextFieldNoEditable textField_gira;
    public CompTextFieldNoEditable textField_horaApertura;
    public CompTextFieldNoEditable textField_artista;
    public CompTextFieldNoEditable textField_grupo;
    public CompTextFieldNoEditable textField_merchan;

    //JPanel
    JPanel panel_imagen;

    //Jbutton
    public CompButton button_ampliar;

    //JSeparator
    JSeparator separator;

    //Dlm
    public DefaultListModel dlmConcierto;
    public DefaultListModel dlmCanciones;

    public ConcertPanel(){
        setLayout(new MigLayout("", "[][290.00,grow][][220.00][][73.00,grow][]", "[][][][][][][][][][][][][][][][][][][][][][27.00][27.00][][][][][][grow]"));
        initComponents();
        editComponents();
        addComponents();
    }

    private void initComponents(){

        //ScrollPane
        scrollPane_conciertos = new JScrollPane();
        scrollPane_canciones = new JScrollPane();

        //JList
        list_conciertos = new JList();
        list_canciones = new JList();

        //JLabel
        Conciertos = new JLabel("Conciertos");
        lbl_nombre = new JLabel("Nombre");
        lbl_imagen = new JLabel();
        lbl_pais = new JLabel("Pa\u00EDs");
        lbl_ciudad = new JLabel("Ciudad");
        lbl_fechaConcierto = new JLabel("Feha del concierto");
        lbl_fechaSalidaEntradas = new JLabel("Fecha de salida de entradas");
        lbl_numEntradas = new JLabel("N\u00FAmero de entradas");
        lbl_sala = new JLabel("Sala");
        lbl_precioEntradas = new JLabel("Precio de entrada");
        lbl_gira = new JLabel("Gira");
        lbl_horaApertura = new JLabel("Hora apertura de puertas");
        lbl_artista = new JLabel("Art\u00EDsta");
        lbl_canciones = new JLabel("PlayList(Canciones)");
        lbl_grupo = new JLabel("Grupo");
        lbl_edadMinima = new JLabel("Edad m\u00EDnima");
        lbl_merchan = new JLabel("Merchandaising")
                ;
        //JTextField
        textField_nombre = new CompTextFieldNoEditable();
        textField_pais = new CompTextFieldNoEditable();
        textField_ciudad = new CompTextFieldNoEditable();
        textField_fechaSalidaEntradas = new CompTextFieldNoEditable();
        textField_numEntradas = new CompTextFieldNoEditable();
        textField_fechaConcierto = new CompTextFieldNoEditable();
        textField_Sala = new CompTextFieldNoEditable();
        textField_precioEntrada = new CompTextFieldNoEditable();
        textField_edadMinima = new CompTextFieldNoEditable();
        textField_gira = new CompTextFieldNoEditable();
        textField_horaApertura = new CompTextFieldNoEditable();
        textField_artista = new CompTextFieldNoEditable();
        textField_grupo = new CompTextFieldNoEditable();
        textField_merchan = new CompTextFieldNoEditable();

        //JPanel
        panel_imagen = new JPanel();

        //Jbutton
        button_ampliar = new CompButton();

        //JSeparator
        separator= new JSeparator();

        //Dlm
        dlmConcierto = new DefaultListModel();
        list_conciertos.setModel(dlmConcierto);

        dlmCanciones = new DefaultListModel();
        list_canciones.setModel(dlmCanciones);

    }

    private void editComponents(){
        scrollPane_conciertos.setViewportView(list_conciertos);
        scrollPane_conciertos.setColumnHeaderView(Conciertos);
        textField_nombre.setColumns(10);
        panel_imagen.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_pais.setColumns(10);
        textField_ciudad.setColumns(10);
        textField_fechaConcierto.setColumns(10);
        textField_fechaSalidaEntradas.setColumns(10);
        textField_numEntradas.setColumns(10);
        textField_Sala.setColumns(10);
        textField_precioEntrada.setColumns(10);
        textField_gira.setColumns(10);
        textField_horaApertura.setColumns(10);
        textField_artista.setColumns(10);
        textField_edadMinima.setColumns(10);
        textField_grupo.setColumns(10);
        textField_merchan.setColumns(10);
        separator.setBackground(Color.BLACK);
        scrollPane_canciones.setViewportView(list_canciones);
        button_ampliar.setText("Ampliar");
        button_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
        button_ampliar.setActionCommand("Ampliar Imagen Concierto ");
    }

    private void addComponents(){
        add(scrollPane_conciertos, "cell 1 1 1 28,grow");
        add(lbl_nombre, "cell 3 1");
        add(textField_nombre, "cell 3 2,growx");
        add(panel_imagen, "cell 5 2 1 6,grow");
        add(lbl_pais, "cell 3 3");
        add(textField_pais, "cell 3 4,growx");
        add(lbl_ciudad, "cell 3 5");
        add(textField_ciudad, "cell 3 6,growx");
        add(lbl_fechaConcierto, "cell 3 7");
        add(textField_fechaConcierto, "cell 3 8,growx");
        add(button_ampliar, "cell 5 8,growx");
        add(lbl_fechaSalidaEntradas, "cell 3 9");
        add(textField_fechaSalidaEntradas, "cell 3 10,growx");
        add(lbl_numEntradas, "cell 3 11");
        add(lbl_sala, "cell 5 11");
        add(textField_numEntradas, "cell 3 12,growx");
        add(textField_Sala, "cell 5 12,growx");
        add(lbl_precioEntradas, "cell 3 13");
        add(lbl_gira, "cell 5 13");
        add(textField_precioEntrada, "cell 3 14,growx");
        add(textField_gira, "cell 5 14,growx");
        add(lbl_horaApertura, "cell 3 15");
        add(lbl_artista, "cell 5 15");
        add(textField_horaApertura, "cell 3 16,growx");
        add(textField_artista, "cell 5 16,growx");
        add(lbl_edadMinima, "cell 3 17");
        add(lbl_grupo, "cell 5 17");
        add(textField_edadMinima, "cell 3 18,growx");
        add(textField_grupo, "cell 5 18,growx");
        add(lbl_merchan, "cell 3 19");
        add(textField_merchan, "cell 3 20,growx");
        add(separator, "cell 3 21 3 2,growx,aligny center");
        add(lbl_canciones, "cell 3 23");
        add(scrollPane_canciones, "cell 3 24 1 4,grow");
        panel_imagen.add(lbl_imagen, BorderLayout.CENTER);
        lbl_imagen.setPreferredSize(new Dimension(200,130));
    }


}
