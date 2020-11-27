package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import ownLibs.basic.CompButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Ventana para añadir un concierto a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddConcierto extends JDialog implements ActionListener, ItemListener{

    //Panel
    private JPanel contentPane;
    //List
    private JList list_artists_addViewConcert;
    //Image
    private JLabel lbl_image;
    //CheckBox
    private JCheckBox checkBox_merchan;
    //DatePicker
    private DatePicker datePicker_fecha;
    private DatePicker datePicker_FehaEntradas;
    //Spinner
    private JSpinner spinner_edadMinima;
    //Tetx
    private JTextField textField_nombre;
    private JTextField textField_numeroEntradas;
    private JTextField textField_precioEntrdas;
    //Combos
    private JComboBox comboBox_gira;
    private JComboBox comboBox_artista;
    private JComboBox comboBox_grupo;
    //TimePicker
    private TimePicker dateTime_horaConcierto;
    //Buttons
    private CompButton button_addImage;
    private CompButton button_save;
    private CompButton button_cancel;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JCheckBox checkBox_gira;
    private JComboBox comboBoxsalas;
    //Dcm
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmGira;
    private DefaultComboBoxModel dcmSala;
    //Model
    Model model;
    //Various
    private Concierto newConcierto;
    private ImageUtil imageUtil;
    private AlertUtil alertUtil;
    private boolean error;

    /**
     * Constructor de ViewAddConcierto
     */
    public ViewAddConcierto(ImageUtil imageUtil, AlertUtil alertUtil, Model model) {
        setTitle("Añadir Concierto");
        setContentPane(contentPane);
        setModal(true);
        setInitialConfiguration(imageUtil,alertUtil,model);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Realiza la configuración inicial.
     */
    private void setInitialConfiguration(ImageUtil imageUtil, AlertUtil alertUtil, Model model){
        this.imageUtil=imageUtil;
        this.model=model;
        this.alertUtil=alertUtil;
        clear();
        initDcm();
        addActionListener(this);
        addItemListener(this);
        fillAllComboBox();
    }


    /**
     * Añade los Action Listener a los botones
     * @param listener
     */
    private void addActionListener(ActionListener listener) {
        button_save.addActionListener(listener);
        button_cancel.addActionListener(listener);
        button_addImage.addActionListener(listener);
    }

    /**
     * Método que añade los ItemListener a los CheckBox
     * @param listener
     */
    private void addItemListener(ItemListener listener){
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
        checkBox_gira.addItemListener(listener);
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm() {
        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmSala= new DefaultComboBoxModel();
        comboBoxsalas.setModel(dcmSala);

        dcmGira = new DefaultComboBoxModel();
        comboBox_gira.setModel(dcmGira);
    }

    /**
     * Rellena todos los comboBox
     */
    private void fillAllComboBox(){
        ComboBoxUtil.fillComboGrupo(dcmGrupo,model);
        ComboBoxUtil.fillComboArtista(dcmArtista,model);
        ComboBoxUtil.fillComboGira(dcmGira,model);
        ComboBoxUtil.fillComboSalas(dcmSala,model);
    }

    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData() {
        newConcierto  = new Concierto();
        newConcierto.setNombre(textField_nombre.getText());
        newConcierto.setFecha(datePicker_fecha.getDate());
        newConcierto.setFechaSalidaEntradas(datePicker_FehaEntradas.getDate());
        newConcierto.setHoraApertura(dateTime_horaConcierto.getTime());

        if(comboBox_grupo.isEnabled()==false){
            newConcierto.setGrupo(null);
        }else{
            newConcierto.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
        }

        if(comboBox_artista.isEnabled()==false){
            newConcierto.setArtista(null);
        }else{
            newConcierto.setArtista((Artista) comboBox_artista.getSelectedItem());
        }

        if(comboBox_gira.isEnabled()==false){
            newConcierto.setGrupo(null);
        }else{
            newConcierto.setGira((Gira) comboBox_gira.getSelectedItem());
        }

        if(comboBoxsalas.isEnabled()==false){
            newConcierto.setSala(null);
        }else{
            newConcierto.setSala((Sala) comboBoxsalas.getSelectedItem());
        }

        newConcierto.setPais(newConcierto.getSala().getPais());
        newConcierto.setCiudad(newConcierto.getSala().getCiudad());

        if(checkBox_merchan.isSelected()){
            newConcierto.setMerchan(true);
        }else{
            newConcierto.setMerchan(false);
        }

        if(Integer.parseInt(String.valueOf(spinner_edadMinima.getValue()))<0){
            AlertUtil.errorAlert("La edad no es válida");
        }else{
            newConcierto.setEdadMinima((Integer) spinner_edadMinima.getValue());
        }

        try {
            newConcierto.setNumeroEntradas(Integer.parseInt(textField_numeroEntradas.getText()));
            newConcierto.setPrecioEntrada((double) Float.parseFloat(textField_precioEntrdas.getText()));
        }catch (NumberFormatException e){
            AlertUtil.errorAlert("El valor debe ser numérico");
            error=true;
        }
        newConcierto.setCartel(imageUtil.convertirImagenaByte());
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear() {
        textField_nombre.setText("");
        spinner_edadMinima.setValue(0);
        checkBox_merchan.setSelected(false);
        textField_numeroEntradas.setText("");
        textField_precioEntrdas.setText("");
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_gira.setSelectedIndex(-1);
        datePicker_fecha.setDate(null);
        datePicker_FehaEntradas.setDate(null);
        dateTime_horaConcierto.setTime(null);
        lbl_image.setIcon(null);
        comboBox_grupo.setEnabled(false);
    }


    /**
     * Comprueba si alguno de los campos indiacados estan vacíos
     * @return checkOk
     */
    private boolean checkEmptyFields() {

        boolean checkOk = true;

        if (textField_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre esta vacío");
            checkOk = false;
        } else if (imageUtil.isChangeImage()== false) {
            JOptionPane.showMessageDialog(null, "El campo Imagen esta vacío");
            checkOk = false;
        }else if (datePicker_fecha.getDate()==null) {
            JOptionPane.showMessageDialog(null, "El campo fecha esta vacío");
            checkOk = false;
        }else if (dateTime_horaConcierto.getTime()==null) {
            JOptionPane.showMessageDialog(null, "El campo hora esta vacío");
            checkOk = false;
        }

        return checkOk;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "save":
                addData();
                AlertUtil.messageAlert("Se ha guardado con éxito");
                if(checkEmptyFields()==true && error==false) {
                    model.altaConcierto(newConcierto);
                    if (alertUtil.wantContinue("¿Desea insertar otro Concierto?") == 0) {
                        clear();
                    } else {
                        dispose();
                    }
                }
                break;

            case "cancel":
                dispose();
                break;

            case "add image":
                imageUtil.selectImage(lbl_image);
                break;

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox_artista || e.getSource() == checkBox_grupo || e.getSource() == checkBox_gira) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (checkBox_artista.isSelected()) {
                    comboBox_grupo.setEnabled(false);
                    comboBox_artista.setEnabled(true);
                } else if (checkBox_grupo.isSelected()) {
                    comboBox_grupo.setEnabled(true);
                    comboBox_artista.setEnabled(false);
                }

                if(checkBox_gira.isSelected()){
                    comboBox_gira.setEnabled(true);
                }

            }else if(e.getStateChange() == ItemEvent.DESELECTED){
                if(checkBox_gira.isSelected()==false){
                    comboBox_gira.setEnabled(false);
                }
            }
        }
    }
}
