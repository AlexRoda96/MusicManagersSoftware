package com.musicmanagerssoftware.gui.views.modifyviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.musicmanagerssoftware.base.*;
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
 * Ventana de modificacion de conciertos
 * @author Aleandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ViewModifyConcierto extends JDialog implements ModifyMethods,ActionListener, ListSelectionListener,
        ItemListener{

    //Panel
    private JPanel contentPane;
    //Button
    private CompButton button_guardar;
    private CompButton button_cancelar;
    private CompButton button_modificar;
    //Text
    private JTextField textField_numEntradas;
    private JTextField textField_precio;
    private JTextField textField_nombre;
    private DatePicker datePicker_fechaSalida;
    private TimePicker dateTime_horaConcierto;
    private DatePicker datePicker_fechaConcierto;
    private JList list_concierto;
    //Label
    private JLabel lbl_image;
    //CheckBox
    private JCheckBox checkBox_merchan;
    //Spinner
    private JSpinner spinner_edad;
    //ComboBox
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_artista;
    private JComboBox comboBox_gira;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JCheckBox checkBox_gira;
    private JComboBox comboBox_sala;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmGira;
    private DefaultComboBoxModel dcmSala;
    //Model
    private Model model;
    //Util
    private AlertUtil alertUtil;
    private ComboBoxUtil comboBoxUtil;
    private ListUtil listUtil;
    private ImageUtil imageUtil;
    //Cancion
    private Concierto conciertoSeleccionado;

    /**
     * Constructor ViewModifyConcierto
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    public ViewModifyConcierto(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
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
        list_concierto.addListSelectionListener(listener);

    }

    @Override
    public void addActionListener(ActionListener listener) {
        button_cancelar.addActionListener(listener);
        button_guardar.addActionListener(listener);
        button_modificar.addActionListener(listener);
    }

    @Override
    public void addItemListener(ItemListener listener) {
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
        checkBox_gira.addItemListener(listener);
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
        addItemListener(this);
        initDlm();
        initDcm();
        listUtil.fillListConcierto(dlm,model);
        fillComboBox();
        comboBox_grupo.setEnabled(false);
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_concierto.setModel(dlm);
    }

    @Override
    public void initDcm() {

        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo= new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmSala= new DefaultComboBoxModel();
        comboBox_sala.setModel(dcmSala);

        dcmGira= new DefaultComboBoxModel();
        comboBox_gira.setModel(dcmGira);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboArtista(dcmArtista,model);
        comboBoxUtil.fillComboGrupo(dcmGrupo,model);
        comboBoxUtil.fillComboGira(dcmGira,model);
        comboBoxUtil.fillComboSalas(dcmSala,model);
    }

    @Override
    public void showData() {
        conciertoSeleccionado = (Concierto) list_concierto.getSelectedValue();
        textField_nombre.setText(conciertoSeleccionado.getNombre());
        datePicker_fechaConcierto.setDate(conciertoSeleccionado.getFecha());
        datePicker_fechaSalida.setDate(conciertoSeleccionado.getFechaSalidaEntradas());
        textField_precio.setText(conciertoSeleccionado.getPrecioEntrada().toString());
        spinner_edad.setValue(conciertoSeleccionado.getEdadMinima());
        dateTime_horaConcierto.setTime(conciertoSeleccionado.getHoraApertura());
        textField_numEntradas.setText(conciertoSeleccionado.getNumeroEntradas().toString());
        if(conciertoSeleccionado.getMerchan()){
            checkBox_merchan.setSelected(true);
        }else{
            checkBox_merchan.setSelected(false);
        }
        comboBox_sala.setSelectedItem(conciertoSeleccionado.getSala());
        comboBox_artista.setSelectedItem(conciertoSeleccionado.getArtista());
        comboBox_gira.setSelectedItem(conciertoSeleccionado.getGira());
        comboBox_grupo.setSelectedItem(conciertoSeleccionado.getGrupo());
        lbl_image.setIcon(imageUtil.convertirDeByteAImage(null,null,null,null,null,conciertoSeleccionado,null,lbl_image));
    }

    @Override
    public void clear() {
        textField_nombre.setText("");
        spinner_edad.setValue(-1);
        checkBox_merchan.setSelected(false);
        textField_numEntradas.setText("");
        textField_precio.setText("");
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_gira.setSelectedIndex(-1);
        datePicker_fechaConcierto.setDateToToday();
        datePicker_fechaSalida.setDateToToday();
        dateTime_horaConcierto.setTimeToNow();
        comboBox_sala.setSelectedIndex(-1);
        lbl_image.setIcon(null);
    }

    @Override
    public void modifyData() {
        if (checkEmptyFields() == true) {
            conciertoSeleccionado.setNombre(textField_nombre.getText());
            conciertoSeleccionado.setFecha(datePicker_fechaConcierto.getDate());
            conciertoSeleccionado.setFechaSalidaEntradas(datePicker_fechaSalida.getDate());
            conciertoSeleccionado.setHoraApertura(dateTime_horaConcierto.getTime());

            if(comboBox_artista.isEnabled()){
                conciertoSeleccionado.setArtista((Artista) comboBox_artista.getSelectedItem());
                conciertoSeleccionado.setGrupo(null);

            }else if(comboBox_grupo.isEnabled()==true){
                conciertoSeleccionado.setArtista(null);
                conciertoSeleccionado.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }

            if(comboBox_gira.isEnabled()){
                conciertoSeleccionado.setGira((Gira) comboBox_gira.getSelectedItem());
            }else{
                conciertoSeleccionado.setGira(null);
            }

            conciertoSeleccionado.setGira((Gira) comboBox_gira.getSelectedItem());
            conciertoSeleccionado.setHoraApertura(dateTime_horaConcierto.getTime());
            if(checkBox_merchan.isSelected()){
                conciertoSeleccionado.setMerchan(true);
            }else{
                conciertoSeleccionado.setMerchan(false);
            }
            conciertoSeleccionado.setEdadMinima((Integer) spinner_edad.getValue());
            conciertoSeleccionado.setNumeroEntradas(Integer.parseInt(textField_numEntradas.getText()));
            conciertoSeleccionado.setPrecioEntrada((double) Float.parseFloat(textField_precio.getText()));
            if(imageUtil.isChangeImage()==true){
                conciertoSeleccionado.setCartel(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                conciertoSeleccionado.setCartel(conciertoSeleccionado.getCartel());
            }
            model.modificarConcierto(conciertoSeleccionado);
            clear();
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
        if(alertUtil.wantContinue("¿Desea modificar otro concierto?")==0){
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
                imageUtil.selectImage(lbl_image);
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
            if(e.getSource()==list_concierto){
                showData();
            }
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
