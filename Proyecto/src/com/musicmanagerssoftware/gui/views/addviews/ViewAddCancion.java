package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.enums.Formato;
import com.musicmanagerssoftware.base.enums.GeneroMusical;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import javafx.scene.control.Alert;
import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.event.*;

/**
 * Ventana para añadir una canción a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddCancion extends JDialog implements ActionListener,ItemListener{
    private JPanel contentPane;
    //Tetx
    private JTextField textField_titulo;
    private JTextField textField_videoclip;
    private JTextField textField_duracion;
    //Button
    private CompButton button_cancel;
    private CompButton button_save;
    //Combo
    private JComboBox comboBox_disco;
    private JComboBox comboBox_generoMusical;
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_artista;
    //DtePicker
    private DatePicker datePicker_fechaPubli;
    //CheckBox
    private JCheckBox checkBox_disco;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JComboBox comboBox_formato;
    //Dcm
    private DefaultComboBoxModel dcmDisco;
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmFormato;
    //Various
    private Model model;
    private boolean error;
    Cancion nuevaCancion;
    private AlertUtil alertUtil;

    /**
     * Constructor de ViewAddCancion
     */
    public ViewAddCancion(AlertUtil alertUtil, Model model) {
        setTitle("Modificar Canción");
        setContentPane(contentPane);
        setModal(true);
        initialConfiguration(alertUtil,model);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Configuracion inicial.
     */
    private void initialConfiguration(AlertUtil alertUtil, Model model){

        this.model=model;
        this.alertUtil=alertUtil;
        initDcm();
        addActionListener(this);
        addItemListener(this);
        fillaAllCombobox();
        setInitialComboBox();
        clear();
    }

    /**
     * Añade los Action Listener a los botones
     * @param listener
     */
    private void addActionListener(ActionListener listener){
        button_save.addActionListener(listener);
        button_cancel.addActionListener(listener);
    }
    
    /**
     * Método que añade los ItemListener a los CheckBox
     * @param listener
     */
    private void addItemListener(ItemListener listener){
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
        checkBox_disco.addItemListener(listener);
    }

    /**
     * Método que pone los combobox a su configuración inicial.
     */
    private void setInitialComboBox(){
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_artista.setEnabled(true);
        comboBox_grupo.setEnabled(false);
        comboBox_disco.setEnabled(true);
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm(){
        dcmDisco = new DefaultComboBoxModel();
        comboBox_disco.setModel(dcmDisco);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);

        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmFormato= new DefaultComboBoxModel();
        comboBox_formato.setModel(dcmFormato);
    }

    /**
     * Rellena todos los comboBox
     */
    private void fillaAllCombobox(){

        ComboBoxUtil.fillComboGenero(dcmGenero);
        ComboBoxUtil.fillComboDisco(dcmDisco,model);
        ComboBoxUtil.fillComboGrupo(dcmGrupo,model);
        ComboBoxUtil.fillComboArtista(dcmArtista,model);
        ComboBoxUtil.fillComboFormato(dcmFormato);
    }


    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData(){

            error=false;

            nuevaCancion = new Cancion();
            nuevaCancion.setTitulo(textField_titulo.getText());
            nuevaCancion.setFechaPublicacion(datePicker_fechaPubli.getDate());

            if(comboBox_formato.getSelectedIndex()==-1){
                nuevaCancion.setFormato(Formato.NULL.getNombre());
            }else{
                nuevaCancion.setFormato(comboBox_formato.getSelectedItem().toString());
            }

            nuevaCancion.setVideoclip(textField_videoclip.getText());

            try {
                nuevaCancion.setDuracion(Float.parseFloat(textField_duracion.getText()));
            }catch (NumberFormatException e){
                AlertUtil.errorAlert("La duración no es válida");
                error=true;
            }

            if(comboBox_generoMusical.getSelectedIndex()==-1){
                nuevaCancion.setGenero(GeneroMusical.NULL.getNombre());
            }else{
                nuevaCancion.setGenero(comboBox_generoMusical.getSelectedItem().toString());
            }

            if(comboBox_disco.isEnabled()==false){
                nuevaCancion.setDisco(null);
            }else{
                nuevaCancion.setDisco((Disco) comboBox_disco.getSelectedItem());
            }

            if(comboBox_grupo.isEnabled()==false){
                nuevaCancion.setGrupo(null);
            }else{
                nuevaCancion.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }

            if(comboBox_artista.isEnabled()==false){
                nuevaCancion.setArtista(null);
            }else{
                nuevaCancion.setArtista((Artista) comboBox_artista.getSelectedItem());
            }
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear(){

        setInitialComboBox();
        textField_titulo.setText("");
        datePicker_fechaPubli.setDateToToday();
        textField_videoclip.setText("");
        textField_duracion.setText("");
        textField_duracion.setText("");
        datePicker_fechaPubli.setDate(null);
        comboBox_formato.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_disco.setSelectedIndex(-1);
    }

    /**
     * Comprueba si alguno de los campos indiacados estan vacíos
     * @return
     */
    private boolean checkEmptyFields(){

        boolean checkOk=true;

        if(textField_titulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre esta vacío");
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
                if (checkEmptyFields() == true && error == false) {
                    model.altaCancion(nuevaCancion);
                    if (alertUtil.wantContinue("¿Desea insertar otra Canción?") == 0) {
                        clear();
                    } else {
                        dispose();
                    }
                }
                break;

            case "cancel":
                dispose();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox_artista || e.getSource() == checkBox_grupo || e.getSource() == checkBox_disco) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (checkBox_artista.isSelected()) {
                    comboBox_grupo.setEnabled(false);
                    comboBox_artista.setEnabled(true);
                } else if (checkBox_grupo.isSelected()) {
                    comboBox_grupo.setEnabled(true);
                    comboBox_artista.setEnabled(false);
                }

                if(checkBox_disco.isSelected()){
                    comboBox_disco.setEnabled(true);
                }

            }else if(e.getStateChange() == ItemEvent.DESELECTED){
                if(checkBox_disco.isSelected()==false){
                    comboBox_disco.setEnabled(false);
                }
            }
        }
    }
}
