package com.musicmanagerssoftware.componentes.panels;

import com.musicmanagerssoftware.interfaces.MethodsPanels;
import net.miginfocom.swing.MigLayout;
import ownLibs.basic.CompButton;
import ownLibs.basic.CompTextFieldNoEditable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ArtistPanel extends JPanel implements MethodsPanels {

    //JPanel
    JPanel panel_imagen;

    //JScrollPane
    JScrollPane scrollPane_discos;
    JScrollPane scrollPane_canciones;
    JScrollPane scrollPane_giras;
    JScrollPane scrollPane_conciertos;

    //JList
    public JList list_discos;
    public JList list_canciones;
    public JList list_giras;
    public JList list_conciertos;

    //JSeparator
    JSeparator separator;

    //JButton
    public CompButton btn_ampliar;

    //TextFields
    public CompTextFieldNoEditable textField_nombre;
    public CompTextFieldNoEditable textField_nombreArtistico;
    public CompTextFieldNoEditable textField_primeriApellido;
    public CompTextFieldNoEditable textField_segundoApellido;
    public CompTextFieldNoEditable textField_dni;
    public CompTextFieldNoEditable textField_nacionalidad;
    public CompTextFieldNoEditable textField_fechaNacimiento;
    public CompTextFieldNoEditable textField_generoMusical;
    public CompTextFieldNoEditable textField_tipoMusico;
    public CompTextFieldNoEditable textField_grupo;
    public CompTextFieldNoEditable textField_numTfn;
    public CompTextFieldNoEditable textField_discografica;


    //JLabel
    private JLabel lbl_nombreArtistico;
    public JLabel lbl_imagen;
    private JLabel lbl_nombre;
    private JLabel lbl_primerApellido;
    private JLabel lbl_dni;
    private JLabel lbl_nacionalidad;
    private JLabel lbl_fechaNacimiento;
    private JLabel lbl_generoMusical;
    private JLabel lbl_grupo;
    private JLabel lbl_segundoApellido;
    private JLabel lbl_tipoMúsico;
    private JLabel lbl_numTfn;
    private JLabel lbl_discografica;
    private JLabel lbl_canciones;
    private JLabel lbl_discos;
    private JLabel lbl_giras;
    private JLabel lbl_conciertos;

    //Dlms
    public DefaultListModel dlmConciertos;
    public DefaultListModel dlmDiscos;
    public DefaultListModel dlmGiras;
    public DefaultListModel dlmCanciones;

    public ArtistPanel(){
        setLayout(new MigLayout("", "[][200.00,grow][-18.00][200.00,grow][200.00][]", "[][20.00][][21.00][][][][][][][][][][][][][][27.00][27.00][][][][]"));
        initComponents();
        editComponents();
        initDlm();
        addComponents();
    }

    @Override
    public void initComponents(){

        //JLabel
        lbl_nombreArtistico = new JLabel("Nombre Art\u00EDstico");
        lbl_imagen = new JLabel();
        lbl_nombre = new JLabel("Nombre");
        lbl_primerApellido = new JLabel("Primer Apellido");
        lbl_segundoApellido = new JLabel("Segundo Apellido");
        lbl_dni = new JLabel("DNI");
        lbl_generoMusical = new JLabel("G\u00E9nero Musical");
        lbl_nacionalidad = new JLabel("Nacionalidad");
        lbl_tipoMúsico = new JLabel("Tipo de M\u00FAsico");
        lbl_fechaNacimiento = new JLabel("Fecha de Nacimiento");
        lbl_grupo = new JLabel("Grupo");
        lbl_numTfn= new JLabel("N\u00FAmero de Tel\u00E9fono");
        lbl_discografica = new JLabel("Discogr\u00E1fica");
        lbl_canciones = new JLabel("Canciones");
        lbl_discos = new JLabel("Discos");
        lbl_giras = new JLabel("Giras");
        lbl_conciertos = new JLabel("Conciertos");

        //JTextField
        textField_nombreArtistico = new CompTextFieldNoEditable();
        textField_nombre = new CompTextFieldNoEditable();
        textField_primeriApellido = new CompTextFieldNoEditable();
        textField_segundoApellido = new CompTextFieldNoEditable();
        textField_dni = new CompTextFieldNoEditable();
        textField_generoMusical = new CompTextFieldNoEditable();
        textField_nacionalidad = new CompTextFieldNoEditable();
        textField_discografica = new CompTextFieldNoEditable();
        textField_fechaNacimiento = new CompTextFieldNoEditable();
        textField_grupo = new CompTextFieldNoEditable();
        textField_numTfn = new CompTextFieldNoEditable();
        textField_tipoMusico= new CompTextFieldNoEditable();

        //JSeparator
        separator = new JSeparator();
        //JList

        list_discos = new JList();
        list_canciones = new JList();
        list_giras = new JList();
        list_conciertos = new JList();
        //JButton

        btn_ampliar = new CompButton();

        //JPanel
        panel_imagen = new JPanel();

        //JScrollPane
        scrollPane_discos = new JScrollPane();
        scrollPane_canciones = new JScrollPane();
        scrollPane_giras = new JScrollPane();
        scrollPane_conciertos = new JScrollPane();
    }

    @Override
    public void addComponents(){
        add(lbl_nombreArtistico, "cell 1 1");
        add(panel_imagen, "cell 4 2 1 6");
        add(textField_nombreArtistico, "flowx,cell 1 2 3 1,growx");
        add(lbl_nombre,"cell 1 3");
        add(textField_nombre, "cell 1 4 3 1,growx,aligny center");
        add(lbl_primerApellido, "cell 1 5");
        add(textField_primeriApellido, "cell 1 6 3 1,growx");
        add(lbl_segundoApellido, "cell 1 7");
        add(textField_segundoApellido, "cell 1 8 3 1,growx");
        add(btn_ampliar, "cell 4 8,growx,aligny center");
        add(lbl_dni, "cell 1 9");
        add(lbl_generoMusical, "cell 4 9");
        add(textField_dni, "cell 1 10 3 1,growx");
        add(textField_generoMusical, "cell 4 10,growx");
        add(lbl_nacionalidad, "cell 1 11");
        add(lbl_tipoMúsico, "cell 4 11");
        add(textField_nacionalidad, "cell 1 12 3 1,growx");
        add(textField_tipoMusico, "cell 4 12,growx");
        add(lbl_fechaNacimiento, "cell 1 13");
        add(lbl_grupo, "cell 4 13");
        add(textField_fechaNacimiento, "cell 1 14 3 1,growx");
        add(textField_grupo, "cell 4 14,growx");
        add(lbl_numTfn, "cell 1 15");
        add(lbl_discografica, "cell 4 15");
        add(textField_numTfn, "cell 1 16 3 1,growx");
        add(textField_discografica, "cell 4 16,growx");
        add(separator, "flowx,cell 1 18 4 1");
        add(lbl_discos, "cell 1 19,alignx left");
        add(lbl_canciones, "cell 3 19,alignx left");
        add(scrollPane_discos, "cell 1 20,grow");
        add(scrollPane_canciones, "cell 3 20,grow");
        add(lbl_giras, "cell 1 21,alignx left");
        add(lbl_conciertos, "cell 3 21,alignx left");
        add(scrollPane_giras, "cell 1 22,grow");
        add(scrollPane_conciertos, "cell 3 22,grow");
        add(separator, "cell 1 17 4 2,growx,aligny center");
        panel_imagen.add(lbl_imagen, BorderLayout.CENTER);
        lbl_imagen.setPreferredSize(new Dimension(200,130));
    }
    @Override
    public void editComponents(){
        panel_imagen.setBorder(new LineBorder(new Color(0, 0, 0)));
        textField_nombreArtistico.setColumns(10);
        textField_nombre.setColumns(10);
        textField_primeriApellido.setColumns(10);
        textField_segundoApellido.setColumns(10);
        textField_dni.setColumns(10);
        textField_generoMusical.setColumns(10);
        textField_nacionalidad.setColumns(10);
        textField_discografica.setColumns(10);
        textField_fechaNacimiento.setColumns(10);
        textField_grupo.setColumns(10);
        textField_numTfn.setColumns(10);
        textField_tipoMusico.setColumns(10);
        scrollPane_discos.setViewportView(list_discos);
        scrollPane_canciones.setViewportView(list_canciones);
        scrollPane_giras.setViewportView(list_giras);
        scrollPane_conciertos.setViewportView(list_conciertos);
        separator.setBackground(Color.BLACK);
        btn_ampliar.setText("Ampliar");
        btn_ampliar.setIcon(new ImageIcon("ico\\ampliar.png\\"));
        btn_ampliar.setActionCommand("Ampliar Imagen Artista");
    }

    private void initDlm(){
        dlmConciertos= new DefaultListModel();
        list_conciertos.setModel(dlmConciertos);

        dlmDiscos = new DefaultListModel();
        list_discos.setModel(dlmDiscos);

        dlmCanciones = new DefaultListModel();
        list_canciones.setModel(dlmCanciones);

        dlmGiras= new DefaultListModel();
        list_giras.setModel(dlmGiras);
    }

}
