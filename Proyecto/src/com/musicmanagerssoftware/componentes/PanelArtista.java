package com.musicmanagerssoftware.componentes;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelArtista extends JPanel {

    //JPanel
    JPanel panel_imagen;

    //JScrollPane
    JScrollPane scrollPane_discos;
    JScrollPane scrollPane_canciones;
    JScrollPane scrollPane_giras;
    JScrollPane scrollPane_conciertos;

    //JList
    JList list_discos;
    JList list_canciones;
    JList list_giras;
    JList list_conciertos;


    //TextFields
    private JTextField textField_nombre;
    private JTextField textField_nombreArtistico;
    private JTextField textField_apellidos;
    private JTextField textField_dni;
    private JTextField textField_nacionalidad;
    private JTextField textField_fechaNacimiento;
    private JTextField textField_generoMusical;
    private JTextField textField_discografica;
    private JTextField textField_grupo;
    private JTextField textField_paginaWeb;
    private JTextField textField_youTube;
    private JTextField textField_instagram;
    private JTextField textField_spotify;

    //JLabel
    private JLabel lbl_nombreArtistico;
    private JLabel lbl_imagen;
    private JLabel lbl_nombre;
    private JLabel lbl_apellidos;
    private JLabel lbl_dni;
    private JLabel lbl_nacionalidad;
    private JLabel lbl_fechaNacimiento;
    private JLabel lbl_generoMusical;
    private JLabel lbl_discografia;
    private JLabel lbl_grupo;
    private JLabel lbl_paginaWeb;
    private JLabel lbl_instagram;
    private JLabel lbl_youTube;
    private JLabel lbl_spotify;
    private JLabel lbl_canciones;
    private JLabel lbl_discos;
    private JLabel lbl_giras;
    private JLabel lbl_conciertos;

    public PanelArtista(){
        setLayout(new MigLayout("", "[][][186.00,grow][21.00][198.00,grow]", "[20.00][21.00][][][][][][][][][20.00][][17.00][][23.00][][grow][][][grow][]"));
        iniciarComponentes();
        formatoComponentes();
        annadirComponentes();
    }

    public void iniciarComponentes(){

        //JLabel
        lbl_nombreArtistico = new JLabel("Nombre Art\u00EDstico");
        lbl_imagen = new JLabel("New label");
        lbl_nombre = new JLabel("Nombre");
        lbl_apellidos = new JLabel("Apellidos");
        lbl_dni = new JLabel("DNI");
        lbl_nacionalidad = new JLabel("Nacionalidad");
        lbl_fechaNacimiento = new JLabel("Fecha de Nacimiento");
        lbl_generoMusical = new JLabel("G\u00E9nero Musical");
        lbl_discografia = new JLabel("Discogr\u00E1fica");
        lbl_grupo = new JLabel("Grupo");
        lbl_paginaWeb = new JLabel("P\u00E1gina Web");
        lbl_instagram = new JLabel("Instagram");
        lbl_youTube = new JLabel("YouTube");
        lbl_spotify = new JLabel("Spotify");
        lbl_discos = new JLabel("Discos");
        lbl_canciones = new JLabel("Canciones");
        lbl_giras = new JLabel("Giras");
        lbl_conciertos = new JLabel("Conciertos");

        //JTextField
        textField_nombreArtistico = new JTextField();
        textField_nombre = new JTextField();
        textField_apellidos = new JTextField();
        textField_dni = new JTextField();
        textField_nacionalidad = new JTextField();
        textField_fechaNacimiento = new JTextField();
        textField_generoMusical = new JTextField();
        textField_discografica = new JTextField();
        textField_grupo = new JTextField();
        textField_paginaWeb = new JTextField();
        textField_instagram = new JTextField();
        textField_youTube = new JTextField();
        textField_spotify = new JTextField();

        //JPanel
        panel_imagen = new JPanel();

        //JScrollPane
        scrollPane_discos = new JScrollPane();
        scrollPane_canciones = new JScrollPane();
        scrollPane_giras = new JScrollPane();
        scrollPane_conciertos = new JScrollPane();

        //JList
        list_discos = new JList();
        list_canciones = new JList();
        list_giras = new JList();
        list_conciertos = new JList();
    }


    public void annadirComponentes(){
        add(lbl_nombreArtistico, "cell 0 0");
        add(textField_nombreArtistico, "flowx,cell 2 0,growx");
        add(textField_nombreArtistico, "flowx,cell 2 0,growx");
        add(panel_imagen, "cell 4 0 1 9,grow");
        panel_imagen.add(lbl_imagen);
        add(lbl_nombre, "cell 0 1");
        add(textField_nombre, "cell 2 1,growx,aligny center");
        add(lbl_apellidos, "cell 0 2");
        add(textField_apellidos, "cell 2 2,growx");
        add(lbl_dni, "cell 0 3");
        add(textField_dni, "cell 2 3,growx");
        add(lbl_nacionalidad, "cell 0 4");
        add(textField_nacionalidad, "cell 2 4,growx");
        add(lbl_fechaNacimiento, "cell 0 5");
        add(textField_fechaNacimiento, "cell 2 5,growx");
        add(lbl_generoMusical, "cell 0 6");
        add(textField_generoMusical, "cell 2 6,growx");
        add(lbl_discografia, "cell 0 7");
        add(textField_discografica, "cell 2 7,growx");
        add(lbl_grupo, "cell 0 8");
        add(textField_grupo, "cell 2 8,growx");
        add(lbl_paginaWeb, "cell 0 11");
        add(textField_paginaWeb, "cell 2 11,growx");
        add(lbl_instagram, "cell 0 12");
        add(textField_instagram, "cell 2 12,growx");
        add(lbl_youTube, "cell 0 13");
        add(textField_youTube, "cell 2 13,growx");
        add(lbl_spotify, "cell 0 14");
        add(textField_spotify, "cell 2 14,growx");
        add(lbl_discos, "cell 2 15,alignx left");
        add(lbl_canciones, "cell 4 15,alignx left");
        add(scrollPane_discos, "cell 2 16,grow");
        scrollPane_discos.setViewportView(list_discos);
        add(scrollPane_canciones, "cell 4 16,grow");
        scrollPane_canciones.setViewportView(list_canciones);
        add(lbl_giras, "cell 2 18,alignx left");
        add(lbl_conciertos, "cell 4 18,alignx left");
        add(scrollPane_giras, "cell 2 19,grow");
        scrollPane_giras.setViewportView(list_giras);
        add(scrollPane_conciertos, "cell 4 19,grow");
        scrollPane_conciertos.setViewportView(list_conciertos);
    }

	public void formatoComponentes(){
        textField_nombreArtistico.setColumns(10);
        panel_imagen.setLayout(new GridLayout(0, 2, 0, 0));
        textField_nombre.setColumns(10);
        textField_apellidos.setColumns(10);
        textField_dni.setColumns(10);
        textField_nacionalidad.setColumns(10);
        textField_fechaNacimiento.setColumns(10);
        textField_generoMusical.setColumns(10);
        textField_discografica.setColumns(10);
        textField_grupo.setColumns(10);
        textField_paginaWeb.setColumns(10);
        textField_instagram.setColumns(10);
        textField_youTube.setColumns(10);
        textField_spotify.setColumns(10);

    }




}
