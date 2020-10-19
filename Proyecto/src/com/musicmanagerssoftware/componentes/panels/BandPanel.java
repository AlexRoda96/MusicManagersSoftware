package com.musicmanagerssoftware.componentes.panels;

import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import java.awt.*;

public class BandPanel extends JPanel {

    //Panel
    JPanel panel_1;

    //ScrollPanel
    JScrollPane scrollPane_artistas_grupo;
    JScrollPane scrollPane_discos_grupo;
    JScrollPane scrollPane_canciones_grupo;
    JScrollPane giras_grupo;

    //List
    JList list_artista_grupo;
    JList list_discos_grupo;
    JList list_canciones_grupo;

    //Label
    JLabel lbl_nombre_grupo;
    JLabel lbl_imagen_grupo;
    JLabel lbl_generoMusica_grupo;
    JLabel lbl_annoDeFormacion_grupo;
    JLabel lbl_discografica_grupo;
    JLabel lbl_paginaWeb_grupo;
    JLabel lbl_youtube_grupo;
    JLabel lbl_spotify_grupo;
    JLabel lbl_instagram_grupo;
    JLabel lbl_artistas_grupo;
    JLabel lbl_discos_grupo;
    JLabel lbl_canciones_grupo;
    JLabel lbl_giras_grupo;

    //TextField
    private CompTextFieldNoEditable textField_nombre_grupo;
    private CompTextFieldNoEditable textField_generoMusical_grupo ;
    private CompTextFieldNoEditable textField_annoDeFormacion_grupo;
    private CompTextFieldNoEditable textField_discografia_grupo;
    private CompTextFieldNoEditable textField_paginaWeb_grupo;
    private CompTextFieldNoEditable textField_youtube_grupo;
    private CompTextFieldNoEditable textField_spotify_grupo;
    private CompTextFieldNoEditable textField_instagram_grupo;

    public BandPanel(){
        setLayout(new MigLayout("", "[][grow][grow]", "[][][][][][][][][][][][grow][][grow][][grow]"));
        iniciarComponentes();
        formatoComponentes();
        annadirComponentes();
    }

    private void iniciarComponentes(){

        //Panel
        panel_1 = new JPanel();

        //ScrollPanel
        scrollPane_artistas_grupo = new JScrollPane();
        scrollPane_discos_grupo = new JScrollPane();
        scrollPane_canciones_grupo = new JScrollPane();
        giras_grupo = new JScrollPane();

        //List
        list_artista_grupo= new JList();
        list_discos_grupo= new JList();
        list_canciones_grupo = new JList();

        //Label
        lbl_nombre_grupo = new JLabel("Nombre");
        lbl_imagen_grupo = new JLabel("New label");
        lbl_generoMusica_grupo = new JLabel("G\u00E9nero Musical");
        lbl_annoDeFormacion_grupo = new JLabel("A\u00F1o de Formaci\u00F3n");
        lbl_discografica_grupo = new JLabel("Discogr\u00E1fica");
        lbl_paginaWeb_grupo = new JLabel("P\u00E1gina Web");
        lbl_youtube_grupo= new JLabel("YouTube");
        lbl_spotify_grupo = new JLabel("Spotify");
        lbl_instagram_grupo = new JLabel("Instagram");
        lbl_artistas_grupo = new JLabel("Art\u00EDstas");
        lbl_discos_grupo = new JLabel("Discos");
        lbl_canciones_grupo = new JLabel("Canciones");
        lbl_giras_grupo = new JLabel("Giras");

        //TextField
        textField_nombre_grupo = new CompTextFieldNoEditable();
        textField_generoMusical_grupo = new CompTextFieldNoEditable();
        textField_annoDeFormacion_grupo = new CompTextFieldNoEditable();
        textField_discografia_grupo = new CompTextFieldNoEditable();
        textField_paginaWeb_grupo = new CompTextFieldNoEditable();
        textField_youtube_grupo = new CompTextFieldNoEditable();
        textField_spotify_grupo = new CompTextFieldNoEditable();
        textField_instagram_grupo = new CompTextFieldNoEditable();
    }

    private void annadirComponentes(){
        add(lbl_nombre_grupo, "cell 0 0,alignx left");
        add(textField_nombre_grupo, "cell 1 0,growx");
        add(panel_1, "cell 2 0 1 9,grow");
        panel_1.add(lbl_imagen_grupo);
        add(lbl_generoMusica_grupo, "cell 0 1,alignx left");
        add(textField_generoMusical_grupo, "cell 1 1,growx");
        add(lbl_annoDeFormacion_grupo, "cell 0 2,alignx left");
        add(textField_annoDeFormacion_grupo, "cell 1 2,growx");
        add(lbl_discografica_grupo, "cell 0 3,alignx left");
        add(textField_discografia_grupo, "cell 1 3,growx");
        add(lbl_paginaWeb_grupo, "cell 0 5,alignx left");
        add(textField_paginaWeb_grupo, "cell 1 5,growx");
        add(lbl_youtube_grupo, "cell 0 6,alignx left");
        add(textField_youtube_grupo, "cell 1 6,growx");
        add(lbl_spotify_grupo, "cell 0 7,alignx left");
        add(textField_spotify_grupo, "cell 1 7,growx");
        add(lbl_instagram_grupo, "cell 0 8,alignx left");
        add(textField_instagram_grupo, "cell 1 8,growx");
        add(lbl_artistas_grupo, "cell 1 10");
        add(lbl_discos_grupo, "cell 2 10");
        add(scrollPane_artistas_grupo, "cell 1 11,grow");
        scrollPane_artistas_grupo.setViewportView(list_artista_grupo);
        add(scrollPane_discos_grupo, "cell 2 11,grow");
        scrollPane_discos_grupo.setViewportView(list_discos_grupo);
        add(lbl_canciones_grupo, "cell 1 12");
        add(lbl_giras_grupo, "cell 2 12");
        add(scrollPane_canciones_grupo, "cell 1 13,grow");
        scrollPane_canciones_grupo.setViewportView(list_canciones_grupo);
        add(giras_grupo, "cell 2 13,grow");
    }

    public void formatoComponentes(){
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));
    }


}
