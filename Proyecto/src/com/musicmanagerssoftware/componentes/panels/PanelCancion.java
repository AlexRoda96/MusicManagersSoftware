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
    JList list_canciones;
    JList list_conciertos ;

    //JPane
    JPanel panel_image;

    //Jlabel
    JLabel lbl_canciones;
    JLabel lbl_titulo;
    JLabel lbl_image;
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
    CompTextFieldNoEditable textField_titulo;
    CompTextFieldNoEditable textField_fechaPublicacion;
    CompTextFieldNoEditable textField_formato;
    CompTextFieldNoEditable textField_genero;
    CompTextFieldNoEditable textField_duracion;
    CompTextFieldNoEditable textField_videoclip;
    CompTextFieldNoEditable textField_artista;
    CompTextFieldNoEditable textField_grupo;
    CompTextFieldNoEditable textField_disco;

    //Button
    CompButton button_ampliar;

    //JSeparator
    JSeparator separator;

    /**
     * Constructor panelCancion
     */
    public PanelCancion() {
        setLayout(new MigLayout("", "[][290.00,grow][][220.00][][73.00,grow][]", "[][][][][][][][][][][][][][][][][][][27.00][27.00][27.00][][][grow]"));
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

        //JPanel
        panel_image = new JPanel();

        //JLabel
        lbl_canciones = new JLabel("Canciones");
        lbl_titulo = new JLabel("T\u00EDtulo");
        lbl_image = new JLabel("New label");
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

        //Jbutton
        button_ampliar = new CompButton();

        //JSeparator
        separator = new JSeparator();
    }

    /**
     * Edita los componentes del panel
     */
    @Override
    public void editComponents() {

        textField_titulo.setColumns(10);
        panel_image.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_image.setLayout(new BorderLayout(0, 0));
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
        button_ampliar.setText("Ampliar");
        button_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
    }

    /**
     * Añade los componentes a la vista.
     */
    @Override
    public void addComponents(){

        add(lbl_titulo, "cell 3 1");
        add(textField_titulo, "flowx,cell 3 2,growx");
        add(panel_image, "cell 5 2 1 6,grow");
        panel_image.add(lbl_image, BorderLayout.CENTER);
        add(lbl_fechaPublicacion, "cell 3 3");
        add(textField_fechaPublicacion, "cell 3 4,growx");
        add(scrollPane_canciones, "cell 1 1 1 23,grow");
        add(lbl_formato, "cell 3 5");
        add(textField_formato, "cell 3 6,growx");
        add(lbl_genero, "cell 3 7");
        add(textField_genero, "cell 3 8,growx");
        add(button_ampliar, "cell 5 8,growx,aligny center");
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
