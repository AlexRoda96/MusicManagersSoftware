package com.musicmanagerssoftware.componentes.panels;

import com.musicmanagerssoftware.interfaces.MethodsPanels;
import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Clase PanelCancion
 * Panel donde se muestra la información de la cancion seleccionada.
 */
public class PanelCancion extends JPanel implements MethodsPanels {

    //ScrollPane
    JScrollPane scrollPane_canciones;
    JScrollPane scrollPane_conciertos;

    //Jlist
    public JList list_canciones;
    public JList list_conciertos ;


    //Jlabel
    JLabel lbl_canciones;
    JLabel lbl_titulo;
    JLabel lbl_fechaPublicacion;
    JLabel lbl_formato;
    JLabel lbl_genero;
    JLabel lbl_duracion;
    JLabel lbl_videoclip;
    JLabel lbl_artistas;
    JLabel lbl_grupo;
    JLabel lbl_disco;
    JLabel lbl_conciertos;

    //JText
    public CompTextFieldNoEditable textField_titulo;
    public CompTextFieldNoEditable textField_fechaPublicacion;
    public CompTextFieldNoEditable textField_formato;
    public CompTextFieldNoEditable textField_genero;
    public CompTextFieldNoEditable textField_duracion;
    public CompTextFieldNoEditable textField_videoclip;
    public CompTextFieldNoEditable textField_artista;
    public CompTextFieldNoEditable textField_grupo;
    public CompTextFieldNoEditable textField_disco;


    //JSeparator
    JSeparator separator;

    //Dlm
    public DefaultListModel dlmCanciones;
    public DefaultListModel dlmConciertos;

    /**
     * Constructor panelCancion
     */
    public PanelCancion() {
        setLayout(new MigLayout("", "[][290.00,grow][][220.00,grow][]", "[][][][][][][][][][][][][][][][][][][27.00][27.00][27.00][][][grow]"));
        initComponents();
        editComponents();
        addComponents();
    }

    /**
     * Método que inicia los componentes.
     */
    @Override
    public void initComponents() {

        //JScroll

        scrollPane_canciones = new JScrollPane();
        scrollPane_conciertos = new JScrollPane();

        //JList

        list_canciones = new JList();
        list_conciertos = new JList();

        //JLabel
        lbl_canciones = new JLabel("Canciones");
        lbl_titulo = new JLabel("T\u00EDtulo");
        lbl_fechaPublicacion = new JLabel("Fecha Publicaci\u00F3n");
        lbl_formato = new JLabel("Formato");
        lbl_genero = new JLabel("G\u00E9nero");
        lbl_duracion = new JLabel("Duraci\u00F3n");
        lbl_videoclip = new JLabel("Videoclip");
        lbl_artistas = new JLabel("Art\u00EDsta");
        lbl_grupo = new JLabel("Grupo");
        lbl_disco = new JLabel("Disco");
        lbl_conciertos = new JLabel("Conciertos");

        //TetxField
        textField_titulo = new CompTextFieldNoEditable();
        textField_fechaPublicacion = new CompTextFieldNoEditable();
        textField_formato = new CompTextFieldNoEditable();
        textField_genero = new CompTextFieldNoEditable();
        textField_duracion = new CompTextFieldNoEditable();
        textField_videoclip = new CompTextFieldNoEditable();
        textField_artista = new CompTextFieldNoEditable();
        textField_grupo = new CompTextFieldNoEditable();
        textField_disco = new CompTextFieldNoEditable();

        //JSeparator
        separator = new JSeparator();

        //Dlm
        dlmCanciones = new DefaultListModel();
        list_canciones.setModel(dlmCanciones);

        dlmConciertos = new DefaultListModel();
        list_conciertos.setModel(dlmConciertos);
    }

    /**
     * Edita los componentes del panel
     */
    @Override
    public void editComponents() {

        textField_titulo.setColumns(10);
        textField_fechaPublicacion.setColumns(10);
        scrollPane_canciones.setViewportView(list_canciones);
        scrollPane_canciones.setColumnHeaderView(lbl_canciones);
        textField_formato.setColumns(10);
        textField_genero.setColumns(10);
        textField_duracion.setColumns(10);
        textField_videoclip.setColumns(10);
        textField_artista.setColumns(10);
        textField_grupo.setColumns(10);
        textField_disco.setColumns(10);
        separator.setForeground(Color.BLACK);
        separator.setBackground(Color.BLACK);
        scrollPane_conciertos.setViewportView(list_conciertos);
    }

    /**
     * Añade los componentes a la vista.
     */
    @Override
    public void addComponents(){

        add(lbl_titulo, "cell 3 1");
        add(textField_titulo, "flowx,cell 3 2,growx");
        add(lbl_fechaPublicacion, "cell 3 3");
        add(textField_fechaPublicacion, "cell 3 4,growx");
        add(scrollPane_canciones, "cell 1 1 1 23,grow");
        add(lbl_formato, "cell 3 5");
        add(textField_formato, "cell 3 6,growx");
        add(lbl_genero, "cell 3 7");
        add(textField_genero, "cell 3 8,growx");
        add(lbl_duracion, "cell 3 9");
        add(textField_duracion, "cell 3 10,growx");
        add(lbl_videoclip, "cell 3 11");
        add(textField_videoclip, "cell 3 12,growx");
        add(lbl_artistas, "cell 3 13");
        add(textField_artista, "cell 3 14,growx");
        add(lbl_grupo, "cell 3 15");
        add(textField_grupo, "cell 3 16,growx");
        add(lbl_disco, "cell 3 17");
        add(textField_disco, "cell 3 18,growx,aligny center");
        add(separator, "cell 3 19 3 2,growx,aligny center");
        add(lbl_conciertos, "cell 3 21");
        add(scrollPane_conciertos, "cell 3 22,grow");
    }
}
