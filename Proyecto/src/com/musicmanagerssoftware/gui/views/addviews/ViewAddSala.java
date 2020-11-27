package com.musicmanagerssoftware.gui.views.addviews;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.enums.Country;
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

/**
 * Ventana para añadir una sala a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddSala extends JDialog implements ActionListener{
    //Panel
    private JPanel contentPane;
    //Tetx
    private JTextField textField_nombre;
    private JTextField textField_numeroTelefono;
    private JTextField textField_direccion;
    private JTextField textField_precioAlquiler;
    private JTextField textField_ciudad;
    private JTextField textField_aforoMax;
    //Image
    private JLabel lbl_image;
    //ComboBox
    private JComboBox comboBox_pais;
    private JComboBox comboBox_tipoSala;
    //Button
    private CompButton button_save;
    private CompButton button_cancel;
    private CompButton button_addImage;
    //Dcm
    private DefaultComboBoxModel dcmPais;
    private DefaultComboBoxModel dcmTipo;
    //Varios
    Sala newSala;
    private boolean error;
    private ImageUtil imageUtil;
    private AlertUtil alertUtil;
    Model model;

    /**
     * Constructor ViewAddSala
     */
    public ViewAddSala(ImageUtil imageUtil, AlertUtil alertUtil, Model model) {
        setTitle("Modificar Sala");
        setContentPane(contentPane);
        setModal(true);
        initialConfiguration(imageUtil,alertUtil,model);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Configuracion inicial.
     */
    private void initialConfiguration(ImageUtil imageUtil, AlertUtil alertUtil, Model model){
        this.imageUtil=imageUtil;
        this.model=model;
        this.alertUtil=alertUtil;
        initDcm();
        addActionListener(this);
        fillaAllCombobox();
        clear();
    }

    /**
     * Añade los Action Listener a los botones
     * @param listener
     */
    private void addActionListener(ActionListener listener){
        button_save.addActionListener(listener);
        button_cancel.addActionListener(listener);
        button_addImage.addActionListener(listener);
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm(){
        dcmPais = new DefaultComboBoxModel();
        comboBox_pais.setModel(dcmPais);

        dcmTipo = new DefaultComboBoxModel();
        comboBox_tipoSala.setModel(dcmTipo);
    }

    /**
     * Rellena todos los comboBox
     */
    private void fillaAllCombobox(){
        ComboBoxUtil.fillComboTipoSala(dcmTipo);
        ComboBoxUtil.fillComboCountries(dcmPais);
    }


    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData(){
        error=false;

        newSala = new Sala();
        newSala.setNombre(textField_nombre.getText());
        newSala.setCiudad(textField_ciudad.getText());
        newSala.setDireccion(textField_direccion.getText());

        if(comboBox_pais.isEnabled()==false){
            newSala.setPais(null);
        }else{
            newSala.setPais(comboBox_pais.getSelectedItem().toString());
        }
        newSala.setTipoSala(comboBox_tipoSala.getSelectedItem().toString());
        try {
            newSala.setNumeroTelef(Integer.parseInt(textField_numeroTelefono.getText()));
            newSala.setAforoMax(Integer.parseInt(textField_aforoMax.getText()));
            newSala.setPrecioAlquiler((double) Float.parseFloat(textField_precioAlquiler.getText()));
        }catch (NumberFormatException e){
            AlertUtil.errorAlert("El dato no es válido");
            error=true;
        }


        newSala.setFoto(imageUtil.convertirImagenaByte());
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear(){

        textField_nombre.setText("");
        textField_numeroTelefono.setText("");
        textField_direccion.setText("");
        textField_aforoMax.setText("");
        textField_precioAlquiler.setText("");
        textField_ciudad.setText("");
        comboBox_tipoSala.setSelectedIndex(-1);
        comboBox_pais.setSelectedIndex(-1);
        lbl_image.setIcon(null);
    }


    /**
     * Comprueba si alguno de los campos indiacados estan vacíos
     * @return
     */
    private boolean checkEmptyFields(){

        boolean checkOk=true;

        if(textField_nombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo Nombre esta vacío");
            checkOk=false;
        }else if(imageUtil.isChangeImage()==false){
            JOptionPane.showMessageDialog(null,"El campo Imagen esta vacío");
            checkOk=false;
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
                    model.altaSala(newSala);
                    if (alertUtil.wantContinue("¿Desea insertar otra Sala?") == 0) {
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
}
