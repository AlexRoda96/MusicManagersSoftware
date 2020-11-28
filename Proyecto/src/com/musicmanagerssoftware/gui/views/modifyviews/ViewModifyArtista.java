package com.musicmanagerssoftware.gui.views.modifyviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Grupo;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.interfaces.ModifyMethods;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import com.musicmanagerssoftware.util.ListUtil;
import ownLibs.basic.CompButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

/**
 * Ventana de modificación de Artista
 */
public class ViewModifyArtista extends JDialog implements ListSelectionListener, ActionListener,
        ModifyMethods, ItemListener {

    //Paneles
    private JPanel contentPane;
    //JTextField
    private JTextField textField_nombreArt;
    private JTextField textField_nombre;
    private JTextField textField_primerApellido;
    private JTextField textField_dni;
    private JTextField textField_numTfn;
    private JTextField textField_segundoApellido;
    //JComboBox
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_generoMusical;
    private JComboBox comboBox_tipoMusico;
    private JComboBox comboBox_discografica;
    //Imagen
    private JLabel lbl_imagen;
    //DatePicker
    private DatePicker datePicker_fechaNacimiento;
    //Buttons
    private CompButton button_guardar;
    private CompButton button_cancelar;
    private JComboBox comboBox_nacionalidad;
    private CompButton button_modificarImagen;
    //List
    private JList list_artistas;
    //CheckBox
    private JCheckBox checkBox_grupo;
    //dlm
    private DefaultListModel dlm;
    //dcm
    private DefaultComboBoxModel dcmPais;
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmTipo;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmDiscografica;
    private Artista artistaSeleccionado;
    //Model
    Model model;
    //Util
    AlertUtil alertUtil;
    ComboBoxUtil comboBoxUtil;
    ListUtil listUtil;
    ImageUtil imageUtil;

    /**
     * Constructor ViewModifyArtist
     */
    public ViewModifyArtista(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil,
                             ImageUtil imageUtil, Model model) {
        initParameters(alertUtil, comboBoxUtil, listUtil, imageUtil, model);
        initDialog();
    }

    @Override
    public void initDialog() {
        setTitle("Music Manager Software - Modificar");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setContentPane(contentPane);
        setModal(true);
        initConfig();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void initConfig(){
        addListSelectionListener(this);
        addActionListener(this);
        addItemListener(this);
        initDlm();
        initDcm();
        listUtil.fillListArtista(dlm,model);
        fillComboBox();
        clear();
    }

    @Override
    public void addListSelectionListener(ListSelectionListener listener) {
        list_artistas.addListSelectionListener(listener);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        button_guardar.addActionListener(listener);
        button_cancelar.addActionListener(listener);
        button_modificarImagen.addActionListener(listener);
    }

    @Override
    public void addItemListener(ItemListener listener) {
        checkBox_grupo.addItemListener(listener);
    }

    @Override
    public void initParameters(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil,
                               ImageUtil imageUtil, Model model) {
        this.alertUtil = alertUtil;
        this.comboBoxUtil = comboBoxUtil;
        this.listUtil = listUtil;
        this.imageUtil = imageUtil;
        this.model = model;
    }

    @Override
    public void initDlm(){
        dlm = new DefaultListModel();
        list_artistas.setModel(dlm);
    }

    @Override
    public void initDcm(){
        dcmPais = new DefaultComboBoxModel();
        comboBox_nacionalidad.setModel(dcmPais);

        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografica.setModel(dcmDiscografica);

        dcmTipo = new DefaultComboBoxModel();
        comboBox_tipoMusico.setModel(dcmTipo);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);
    }

    @Override
    public void fillComboBox(){
        comboBoxUtil.fillComboCountries(dcmPais);
        comboBoxUtil.fillComboDiscogrfica(dcmDiscografica);
        comboBoxUtil.fillComboGenero(dcmGenero);
        comboBoxUtil.fillComboGrupo(dcmGrupo,model);
        comboBoxUtil.fillComboTipo(dcmTipo);
    }

    @Override
    public void showData(){
        artistaSeleccionado = (Artista) list_artistas.getSelectedValue();
        textField_nombreArt.setText(artistaSeleccionado.getNombreArtistico());
        textField_nombre.setText(artistaSeleccionado.getNombre());
        textField_primerApellido.setText(artistaSeleccionado.getPrimerApellido());
        textField_segundoApellido.setText(artistaSeleccionado.getSegundoApellido());
        textField_dni.setText(artistaSeleccionado.getDni());
        datePicker_fechaNacimiento.setDate(artistaSeleccionado.getFechaNacimiento());
        comboBox_nacionalidad.setSelectedItem(artistaSeleccionado.getPaisNacimiento());
        textField_numTfn.setText(String.valueOf(artistaSeleccionado.getNumTelefono()));
        comboBox_generoMusical.setSelectedItem(artistaSeleccionado.getGeneroMusical());
        comboBox_tipoMusico.setSelectedItem(artistaSeleccionado.getTipoMusico());
        comboBox_grupo.setSelectedItem(artistaSeleccionado.getGrupo());
        comboBox_discografica.setSelectedItem(artistaSeleccionado.getDiscografica());
        lbl_imagen.setIcon(imageUtil.convertirDeByteAImage(artistaSeleccionado,null,null,
                null,null,null,null,lbl_imagen));
    }

    @Override
    public void clear() {

        //Dar valor vacío a los JTextField y seleccionar el item -1 en los combo box
        textField_nombreArt.setText("");
        textField_nombre.setText("");
        textField_primerApellido.setText("");
        textField_segundoApellido.setText("");
        textField_dni.setText("");
        datePicker_fechaNacimiento.setDate(null);
        textField_numTfn.setText("");
        comboBox_nacionalidad.setSelectedIndex(-1);
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_tipoMusico.setSelectedIndex(-1);
        comboBox_grupo.setEnabled(true);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
        lbl_imagen.setIcon(null);
    }

    @Override
    public void modifyData() {
        /*
        Si no existen campos vacíos, creamos un artísta recogiendo los datos de los campos de la
        vista, una vez añadido el artísta se limpian los campos de la vista.
         */
        if (checkEmptyFields() == true) {
            artistaSeleccionado.setNombreArtistico(textField_nombreArt.getText());
            artistaSeleccionado.setNombre(textField_nombre.getText());
            artistaSeleccionado.setPrimerApellido(textField_primerApellido.getText());
            artistaSeleccionado.setSegundoApellido(textField_segundoApellido.getText());
            artistaSeleccionado.setDni(textField_dni.getText());
            artistaSeleccionado.setFechaNacimiento(datePicker_fechaNacimiento.getDate());
            artistaSeleccionado.setNumTelefono(Integer.parseInt(textField_numTfn.getText()));

            if(comboBox_nacionalidad.getSelectedIndex()==-1){
                artistaSeleccionado.setPaisNacimiento(null);
            }else{
                artistaSeleccionado.setPaisNacimiento(comboBox_nacionalidad.getSelectedItem().
                        toString());
            }

            if(comboBox_generoMusical.getSelectedIndex()==-1){
                artistaSeleccionado.setGeneroMusical(null);
            }else{
                artistaSeleccionado.setGeneroMusical(comboBox_generoMusical.getSelectedItem().
                        toString());
            }

            if(comboBox_tipoMusico.getSelectedIndex()==-1){
                artistaSeleccionado.setTipoMusico(null);
            }else{
                artistaSeleccionado.setTipoMusico(comboBox_tipoMusico.getSelectedItem().
                        toString());
            }

            if (comboBox_grupo.isEnabled()) {
                artistaSeleccionado.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }else {
                artistaSeleccionado.setGrupo(null);
            }

            if(comboBox_grupo.getSelectedIndex()==-1){
                artistaSeleccionado.setDiscografica(null);
            }else{
                artistaSeleccionado.setDiscografica(comboBox_discografica.getSelectedItem().
                        toString());
            }

            if(imageUtil.isChangeImage()==true){
              artistaSeleccionado.setFoto(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                artistaSeleccionado.setFoto(artistaSeleccionado.getFoto());
            }

            model.modificarArtista(artistaSeleccionado);
        }
    }

    @Override
    public boolean checkEmptyFields() {
        //Variable que indica si la comprobación es true o false, se innicializa en true.
        boolean checkOk = true;

        /*
        Si alguno de los campos(nombreArtistico, nombre, primerApellido, Dni) están vacíos,
        la variable checkOk será fase.
         */
        if (textField_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre esta vacío");
            checkOk = false;

        } else if (textField_nombreArt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El campo Nombre Artístico esta vacío");
            checkOk = false;

        } else if (textField_primerApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El campo Apellido esta vacío");
            checkOk = false;

        } else if (textField_dni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El campo Apellido esta vacío");
            checkOk = false;
        }

        //Devolver CheckOk(True o False)
        return checkOk;
    }

    @Override
    public void wantContinue(){
        if(alertUtil.wantContinue("¿Desea modificar otro artísta?")==0){
            clear();
        }else{
            dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            if(e.getSource()==list_artistas){
                showData();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "guardar":
                modifyData();
                alertUtil.messageAlert("Se ha guardado la modificación");
                wantContinue();
                break;

            case "modificar imagen":
                imageUtil.selectImage(lbl_imagen);
                break;

            case "cancelar":
                alertUtil.messageAlert("No se han realizado cambios");
                dispose();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox_grupo) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                comboBox_grupo.setEnabled(true);
            }else if(e.getStateChange() == ItemEvent.DESELECTED){
                comboBox_grupo.setEnabled(false);
            }
        }
    }
}
