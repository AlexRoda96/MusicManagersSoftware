package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Disco;
import com.musicmanagerssoftware.base.Gira;
import com.musicmanagerssoftware.base.Grupo;
import com.musicmanagerssoftware.base.enums.Formato;
import com.musicmanagerssoftware.base.enums.GeneroMusical;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import com.musicmanagerssoftware.util.ListUtil;
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

/**
 * Ventana para añadir una gira a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddGira extends JDialog implements ActionListener, ItemListener{

    //Panel
    private JPanel contentPane;
    //Label
    private JLabel lbl_image;
    //Text
    private JTextField textField_nombre;
    //Combos
    private JComboBox comboBox_artista;
    private JComboBox comboBox_grupo;
    //ChecKBox
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    //Buttons
    private CompButton button_addImage;
    private CompButton button_save;
    private CompButton button_cancel;
    //DatePicker
    private DatePicker datePicker_fechaInico;
    private DatePicker datePicker_fechaFinal;
    //Dcm
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmArtista;
    //Model
    private Model model;
    //Various
    private Gira newGira;
    private ImageUtil imageUtil;
    private AlertUtil alertUtil;
    private boolean error;

    /**
     * Constructor de ViewAddGira
     */
    public ViewAddGira(ImageUtil imageUtil, AlertUtil alertUtil, Model model) {
        setTitle("Modificar Gira");
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
        initDcm();
        addActionListener(this);
        addItemListener(this);
        fillAllComboBox();
        clear();
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

    private void addItemListener(ItemListener listener){
        comboBox_artista.addItemListener(listener);
        comboBox_grupo.addItemListener(listener);
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm() {
        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);
    }

    /**
     * Rellena todos los comboBox
     */
    private void fillAllComboBox(){
        ComboBoxUtil.fillComboGrupo(dcmGrupo,model);
        ComboBoxUtil.fillComboArtista(dcmArtista,model);
    }

    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData() {

        if (checkEmptyFields() == true) {
            newGira = new Gira();
            newGira.setNombre(textField_nombre.getText());
            newGira.setFechaInicio(datePicker_fechaInico.getDate());
            newGira.setFechaFin(datePicker_fechaFinal.getDate());

            if(comboBox_grupo.isEnabled()==false){
                newGira.setGrupo(null);
            }else{
                newGira.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }

            if(comboBox_artista.isEnabled()==false){
                newGira.setArtista(null);
            }else{
                newGira.setArtista((Artista) comboBox_artista.getSelectedItem());
            }
            newGira.setCartel(imageUtil.convertirImagenaByte());
        }
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear() {
        textField_nombre.setText("");
        datePicker_fechaFinal.setDate(null);
        datePicker_fechaInico.setDate(null);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        checkBox_artista.setSelected(true);
        comboBox_grupo.setEnabled(false);
        lbl_image.setIcon(null);
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
        } else if (imageUtil.isChangeImage() == false) {
            JOptionPane.showMessageDialog(null, "El campo Imagen esta vacío");
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
                    model.altaGira(newGira);
                    if (alertUtil.wantContinue("¿Desea insertar otra Gira?") == 0) {
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
        if (e.getSource() == checkBox_artista || e.getSource() ==checkBox_grupo) {
            if (e.getStateChange() == ItemEvent.SELECTED) {

                if (checkBox_artista.isSelected()) {
                    comboBox_grupo.setEnabled(false);
                    comboBox_artista.setEnabled(true);
                }else if(checkBox_grupo.isSelected()){
                    comboBox_grupo.setEnabled(true);
                    comboBox_artista.setEnabled(false);

                }
            }
        }
    }
}
