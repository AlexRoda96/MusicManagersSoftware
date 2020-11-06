package com.musicmanagerssoftware.componentes.panels;

import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BandPanel extends JPanel {

    //Panel
    JPanel panel_imagen;

    //ScrollPanel
    JScrollPane scrollPane_artistas;
    JScrollPane scrollPane_discos;
    JScrollPane scrollPane_canciones;
    JScrollPane scrollPane_giras;
    JScrollPane scrollPane_conciertos;

    //List
    public JList list_artistas;
    public JList list_discos;
    public JList list_canciones;
    public JList list_conciertos;
    public JList list_giras;

    //Label
    JLabel lbl_nombre;
    public JLabel lbl_imagen;
    JLabel lbl_generoMusica;
    JLabel lbl_annoDeFormacion;
    JLabel lbl_discografica;
    JLabel lbl_artistas;
    JLabel lbl_discos;
    JLabel lbl_canciones;
    JLabel lbl_giras;
    JLabel lbl_conciertos;

    //TextField
    public CompTextFieldNoEditable textField_nombre;
    public CompTextFieldNoEditable textField_generoMusical;
    public CompTextFieldNoEditable textField_annoDeFormacion;
    public CompTextFieldNoEditable textField_discografia;

    //JButton
     public JButton button_ampliar;

    //JSeparator
    JSeparator separator;

    //Dlm
    public DefaultListModel dlmArtistas;
    public DefaultListModel dlmCanciones;
    public DefaultListModel dlmDiscos;
    public DefaultListModel dlmConciertos;
    public DefaultListModel dlmGiras;

    public BandPanel(){
        setLayout(new MigLayout("", "[][200.00,grow][200.00,grow][200.00][]", "[][][][][][][][][][27.00][27.00][][][][][][]"));
        initComponents();
        editComponents();
        initDlm();
        addComponents();

 }

    private void initComponents(){

        //JLabel
        lbl_nombre = new JLabel("Nombre");
        lbl_imagen = new JLabel();
        lbl_annoDeFormacion = new JLabel("A\u00F1o de Formaci\u00F3n");
        lbl_generoMusica = new JLabel("G\u00E9nero Musical");
        lbl_discografica = new JLabel("Discogr\u00E1fica");
        lbl_artistas = new JLabel("Art\u00EDstas");
        lbl_discos = new JLabel("Discos");
        lbl_canciones = new JLabel("Canciones");
        lbl_giras = new JLabel("Giras");
        lbl_conciertos = new JLabel("Conciertos");

        //JTextField
        textField_nombre = new CompTextFieldNoEditable();
        textField_generoMusical = new CompTextFieldNoEditable();
        textField_annoDeFormacion = new CompTextFieldNoEditable();
        textField_discografia = new CompTextFieldNoEditable();

        //JButton
        button_ampliar = new CompButton();

        //JSeparator
        separator = new JSeparator();

        //JScrollPanel
        scrollPane_conciertos = new JScrollPane();
        scrollPane_artistas = new JScrollPane();
        scrollPane_canciones = new JScrollPane();
        scrollPane_discos = new JScrollPane();
        scrollPane_giras = new JScrollPane();

        //JList
        list_artistas = new JList();
        list_discos = new JList();
        list_giras = new JList();
        list_canciones = new JList();
        list_conciertos = new JList();

        //JPanel
        panel_imagen = new JPanel();

    }

    private void editComponents(){

        panel_imagen.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_nombre.setColumns(10);
        textField_generoMusical.setColumns(10);
        textField_annoDeFormacion.setColumns(10);
        textField_discografia.setColumns(10);
        separator.setBackground(Color.BLACK);
        scrollPane_artistas.setViewportView(list_artistas);
        scrollPane_discos.setViewportView(list_discos);
        scrollPane_canciones.setViewportView(list_canciones);
        scrollPane_conciertos.setViewportView(list_conciertos);
        scrollPane_giras.setViewportView(list_giras);
        button_ampliar.setText("Ampliar");
        button_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
    }

    private void addComponents(){
        add(lbl_nombre, "cell 1 1,alignx left");
        add(panel_imagen, "cell 3 2 1 6,grow");
        add(textField_nombre, "cell 1 2 2 1,growx");
        add(lbl_annoDeFormacion, "cell 1 3,alignx left");
        add(textField_generoMusical, "cell 1 4 2 1,growx");
        add(lbl_generoMusica, "cell 1 5,alignx left");
        add(textField_annoDeFormacion, "cell 1 6 2 1,growx");
        add(lbl_discografica, "cell 1 7,alignx left");
        add(textField_discografia, "cell 1 8 2 1,growx");
        add(button_ampliar, "cell 3 8,growx,aligny center");
        add(separator, "cell 1 9 4 2,growx,aligny center");
        add(lbl_artistas, "cell 1 11");
        add(lbl_discos, "cell 1 13");
        add(lbl_canciones, "cell 2 13,alignx left");
        add(lbl_giras, "cell 1 15");
        add(lbl_conciertos, "cell 2 15");
        add(scrollPane_artistas, "cell 1 12,grow");
        add(scrollPane_canciones, "cell 2 14,grow");
        add(scrollPane_discos, "cell 1 14,grow");
        add(scrollPane_giras, "cell 1 16,grow");
        add(scrollPane_conciertos, "cell 2 16,grow");
        panel_imagen.add(lbl_imagen, BorderLayout.CENTER);
        lbl_imagen.setPreferredSize(new Dimension(200,130));
        button_ampliar.setActionCommand("Ampliar Imagen Grupo");
    }

    private void initDlm(){
        dlmArtistas= new DefaultListModel();
        list_artistas.setModel(dlmArtistas);

        dlmCanciones= new DefaultListModel();
        list_canciones.setModel(dlmCanciones);

        dlmDiscos= new DefaultListModel();
        list_discos.setModel(dlmDiscos);

        dlmConciertos= new DefaultListModel();
        list_conciertos.setModel(dlmConciertos);

        dlmGiras= new DefaultListModel();
        list_giras.setModel(dlmGiras);
    }

}
