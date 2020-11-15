package com.musicmanagerssoftware.componentes.panels;

import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class DiscPanel extends JPanel {

    JPanel panel_imagen;

    JScrollPane scrollPane_discos;
    JScrollPane scrollPane_canciones;

    public JList list_discos;
    public JList list_canciones;

    JSeparator separator;

    JLabel lbl_titulo = new JLabel("T\u00EDtulo");
    public JLabel lbl_imagen = new JLabel();
    JLabel lbl_fechaPublicacion = new JLabel("Fecha Publiaci\u00F3n");
    JLabel lbl_generoMusical = new JLabel("G\u00E9nero Musical");
    JLabel lbl_discos = new JLabel("Discos");
    JLabel lbl_formato = new JLabel("Formato");
    JLabel lbl_artista = new JLabel("Artista");
    JLabel lbl_grupo = new JLabel("Grupo");
    JLabel lbl_discografia = new JLabel("Discogr\u00E1fica");
    JLabel lbl_precio = new JLabel("Precio");
    JLabel lbl_canciones = new JLabel("Canciones");


    public CompTextFieldNoEditable textField_titulo ;
    public CompTextFieldNoEditable textField_fechaPublicacion;
    public CompTextFieldNoEditable textField_generoMusical;
    public CompTextFieldNoEditable textField_formato;
    public CompTextFieldNoEditable textField_artista;
    public CompTextFieldNoEditable textField_grupo;
    public CompTextFieldNoEditable textField_discografica;
    public CompTextFieldNoEditable textField_precio;

    public DefaultListModel dlmDiscos;
    public DefaultListModel dlmCancion;

    public CompButton button_ampliar;

    public DiscPanel (){
        setLayout(new MigLayout("", "[][290.00,grow][][220.00][][73.00,grow][]", "[][][][][][][][][][][][][][][][][][27.00][27.00][][][grow]"));
        initComponents();
        editComponents();
        addComponents();
    }

    private void initComponents(){

        panel_imagen = new JPanel();

        scrollPane_discos = new JScrollPane();
        scrollPane_canciones = new JScrollPane();

        list_discos = new JList();
        list_canciones = new JList();

        separator = new JSeparator();

        lbl_titulo = new JLabel("T\u00EDtulo");
        lbl_imagen = new JLabel();
        lbl_fechaPublicacion = new JLabel("Fecha Publiaci\u00F3n");
        lbl_generoMusical = new JLabel("G\u00E9nero Musical");
        lbl_discos = new JLabel("Discos");
        lbl_formato = new JLabel("Formato");
        lbl_artista = new JLabel("Artista");
        lbl_grupo = new JLabel("Grupo");
        lbl_discografia = new JLabel("Discogr\u00E1fica");
        lbl_precio = new JLabel("Precio");
        lbl_canciones = new JLabel("Canciones");


        textField_titulo = new CompTextFieldNoEditable();
        textField_fechaPublicacion = new CompTextFieldNoEditable();
        textField_generoMusical = new CompTextFieldNoEditable();
        textField_formato = new CompTextFieldNoEditable();
        textField_artista = new CompTextFieldNoEditable();
        textField_grupo = new CompTextFieldNoEditable();
        textField_discografica = new CompTextFieldNoEditable();
        textField_precio = new CompTextFieldNoEditable();

        button_ampliar = new CompButton();

        dlmDiscos = new DefaultListModel();
        list_discos.setModel(dlmDiscos);

        dlmCancion = new DefaultListModel();
        list_canciones.setModel(dlmCancion);
    }

    private void editComponents(){
        panel_imagen.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_titulo.setColumns(10);
        textField_fechaPublicacion.setColumns(10);
        scrollPane_discos.setViewportView(list_discos);
        scrollPane_discos.setColumnHeaderView(lbl_discos);
        textField_generoMusical.setColumns(10);
        textField_formato.setColumns(10);
        textField_artista.setColumns(10);
        textField_grupo.setColumns(10);
        textField_discografica.setColumns(10);
        textField_precio.setColumns(10);
        separator.setBackground(Color.BLACK);
        scrollPane_canciones.setViewportView(list_canciones);
        button_ampliar.setText("Ampliar");
        button_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
        button_ampliar.setActionCommand("Ampliar Imagen Disco");
    }

    private void addComponents(){
        add(lbl_titulo, "cell 3 1,alignx left");
        add(panel_imagen, "cell 5 2 1 6,grow");
        add(textField_titulo, "cell 3 2,growx");
        add(lbl_fechaPublicacion, "cell 3 3,alignx left");
        add(textField_fechaPublicacion, "cell 3 4,growx");
        add(lbl_generoMusical, "cell 3 5,alignx left");
        add(scrollPane_discos, "cell 1 1 1 21,grow");
        add(textField_generoMusical, "cell 3 6,growx");
        add(lbl_formato, "cell 3 7,alignx left");
        add(textField_formato, "cell 3 8,growx");
        add(lbl_artista, "cell 3 9,alignx left");
        add(textField_artista, "cell 3 10,growx");
        add(lbl_grupo, "cell 3 11,alignx left");
        add(textField_grupo, "cell 3 12,growx");
        add(lbl_discografia, "cell 3 13,alignx left");
        add(textField_discografica, "cell 3 14,growx");
        add(lbl_precio, "cell 3 15,alignx left");
        add(textField_precio, "cell 3 16,growx");
        add(separator, "cell 3 17 3 2,growx,aligny center");
        add(lbl_canciones, "cell 3 19");
        add(scrollPane_canciones, "cell 3 20,grow");
        add(button_ampliar, "cell 5 8,growx,aligny center");
        panel_imagen.add(lbl_imagen, BorderLayout.CENTER);
        lbl_imagen.setPreferredSize(new Dimension(200,130));
    }
}
