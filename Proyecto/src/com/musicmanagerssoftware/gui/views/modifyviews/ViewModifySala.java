package com.musicmanagerssoftware.gui.views.modifyviews;

import com.musicmanagerssoftware.base.Sala;
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
import java.awt.event.*;

/**
 * Ventana que modifica una sala
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ViewModifySala extends JDialog implements ModifyMethods,ActionListener, ListSelectionListener {
    private JPanel contentPane;
    //Label
    private JLabel lbl_imagen;
    //Text
    private JTextField textField_nombre;
    private JTextField textField_numTlfn;
    private JTextField textField_direccion;
    private JTextField textField_precio;
    private JTextField textField_aforo;
    private JTextField textField_ciudad;
    //Combo
    private JComboBox comboBox_tipoSala;
    private JComboBox comboBox_pais;
    //Button
    private CompButton button_guardar;
    private CompButton button_cancelar;
    private CompButton button_modificar;
    //List
    private JList list_sala;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmPais;
    private DefaultComboBoxModel dcmTipo;
    //Model
    private Model model;
    //Util
    private AlertUtil alertUtil;
    private ComboBoxUtil comboBoxUtil;
    private ListUtil listUtil;
    private ImageUtil imageUtil;
    //Cancion
    private Sala salaSeleccionada;

    /**
     * Constructor de ViewModifySala
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    public ViewModifySala(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
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
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void addListSelectionListener(ListSelectionListener listener) {
        list_sala.addListSelectionListener(listener);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        button_cancelar.addActionListener(listener);
        button_guardar.addActionListener(listener);
        button_modificar.addActionListener(listener);
    }

    @Override
    public void addItemListener(ItemListener listener) {

    }

    @Override
    public void initParameters(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
        this.alertUtil = alertUtil;
        this.comboBoxUtil = comboBoxUtil;
        this.listUtil = listUtil;
        this.imageUtil = imageUtil;
        this.model = model;
    }

    @Override
    public void initConfig() {
        addActionListener(this);
        addListSelectionListener(this);
        initDlm();
        initDcm();
        listUtil.fillListSala(dlm,model);
        fillComboBox();
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_sala.setModel(dlm);
    }

    @Override
    public void initDcm() {
        dcmPais = new DefaultComboBoxModel();
        comboBox_pais.setModel(dcmPais);

        dcmTipo= new DefaultComboBoxModel();
        comboBox_tipoSala.setModel(dcmTipo);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboCountries(dcmPais);
        comboBoxUtil.fillComboTipoSala(dcmTipo);
    }

    @Override
    public void showData() {
        salaSeleccionada = (Sala) list_sala.getSelectedValue();
        textField_nombre.setText(salaSeleccionada.getNombre());
        textField_ciudad.setText(salaSeleccionada.getCiudad());
        comboBox_pais.setSelectedItem(salaSeleccionada.getPais());
        textField_precio.setText(salaSeleccionada.getPrecioAlquiler().toString());
        textField_numTlfn.setText(salaSeleccionada.getNumeroTelef().toString());
        textField_aforo.setText(salaSeleccionada.getAforoMax().toString());
        comboBox_tipoSala.setSelectedItem(salaSeleccionada.getTipoSala());
        lbl_imagen.setIcon(imageUtil.convertirDeByteAImage(null,null,null,null,null,null,salaSeleccionada,lbl_imagen));
    }

    @Override
    public void clear() {
        textField_nombre.setText("");
        textField_numTlfn.setText("");
        textField_direccion.setText("");
        textField_aforo.setText("");
        textField_precio.setText("");
        textField_ciudad.setText("");
        comboBox_tipoSala.setSelectedIndex(-1);
        comboBox_pais.setSelectedIndex(-1);
        lbl_imagen.setIcon(null);
    }

    @Override
    public void modifyData() {

        if(checkEmptyFields()==true) {

            salaSeleccionada.setNombre(textField_nombre.getText());
            salaSeleccionada.setCiudad(textField_ciudad.getText());
            salaSeleccionada.setNumeroTelef(Integer.parseInt(textField_numTlfn.getText()));
            salaSeleccionada.setDireccion(textField_direccion.getText());
            salaSeleccionada.setAforoMax(Integer.parseInt(textField_aforo.getText()));
            salaSeleccionada.setPrecioAlquiler((double) Float.parseFloat(textField_precio.getText()));
            if(comboBox_pais.isEnabled()==false){
                salaSeleccionada.setPais(null);
            }else{
                salaSeleccionada.setPais(comboBox_pais.getSelectedItem().toString());
            }
                salaSeleccionada.setTipoSala(comboBox_tipoSala.getSelectedItem().toString());

            if(imageUtil.isChangeImage()==true){
                salaSeleccionada.setFoto(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                salaSeleccionada.setFoto(salaSeleccionada.getFoto());
            }
            model.modificarSala(salaSeleccionada);
        }
    }

    @Override
    public boolean checkEmptyFields() {
        boolean checkOk=true;
        if(textField_nombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo Nombre esta vacío");
            checkOk=false;
        }

        return checkOk;
    }

    @Override
    public void wantContinue() {
        if(alertUtil.wantContinue("¿Desea modificar otro disco?")==0){
            clear();
        }else{
            dispose();
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
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            if(e.getSource()==list_sala){
                showData();
            }
        }
    }
}
