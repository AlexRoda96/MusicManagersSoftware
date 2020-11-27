package com.musicmanagerssoftware.gui.views.modifyviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Gira;
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
import java.awt.event.*;

/**
 * Ventana para modificar giras
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ViewModifyGira extends JDialog implements ModifyMethods,ActionListener, ListSelectionListener, ItemListener {
    //Panel
    private JPanel contentPane;
    //Text
    private JTextField textField_nombre;
    private JTextField textField_fechaInicio;
    private JTextField textField_fechaFin;
    //JLabel
    private JLabel lbl_imagen;
    //List
    private JList list_gira;
    //Button
    private CompButton button_guardar;
    private CompButton button_cancelar;
    private CompButton button_modificar;
    //ComboBox
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_artista;
    private DatePicker datePicker_fechaIncio;
    private DatePicker datePicker_fechaFin;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmGrupo;
    //Model
    private Model model;
    //Util
    private AlertUtil alertUtil;
    private ComboBoxUtil comboBoxUtil;
    private ListUtil listUtil;
    private ImageUtil imageUtil;
    //Cancion
    private Gira giraSeleccionada;

    /**
     * Constructor ViewModifyGira
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    public ViewModifyGira(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
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
        list_gira.addListSelectionListener(listener);
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
        listUtil.fillListGira(dlm,model);
        fillComboBox();
        comboBox_grupo.setEnabled(false);
        clear();
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_gira.setModel(dlm);
    }

    @Override
    public void initDcm() {
        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo= new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboArtista(dcmArtista,model);
        comboBoxUtil.fillComboGrupo(dcmGrupo,model);
    }

    @Override
    public void showData() {
        giraSeleccionada = (Gira) list_gira.getSelectedValue();
        textField_nombre.setText(giraSeleccionada.getNombre());
        if(giraSeleccionada.getArtista()==null){
            comboBox_artista.setSelectedIndex(-1);
        }else {
            comboBox_artista.setSelectedItem(giraSeleccionada.getArtista());
        }

        if(giraSeleccionada.getGrupo()==null){
            comboBox_grupo.setSelectedIndex(-1);
        }else{
            comboBox_grupo.setSelectedItem(giraSeleccionada.getGrupo());
        }
        datePicker_fechaIncio.setDate(giraSeleccionada.getFechaInicio());
        datePicker_fechaFin.setDate(giraSeleccionada.getFechaFin());
        lbl_imagen.setIcon(imageUtil.convertirDeByteAImage(null,null,null,null,giraSeleccionada,null,null,lbl_imagen));
    }

    @Override
    public void clear() {
        textField_nombre.setText("");
        datePicker_fechaIncio.setText("");
        datePicker_fechaFin.setText("");
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        lbl_imagen.setIcon(null);
    }

    @Override
    public void modifyData() {
        if (checkEmptyFields() == true) {

            giraSeleccionada.setNombre(textField_nombre.getText());
            giraSeleccionada.setArtista((Artista) comboBox_artista.getSelectedItem());
            if(comboBox_artista.isEnabled()){

                giraSeleccionada.setArtista((Artista) comboBox_artista.getSelectedItem());
                giraSeleccionada.setGrupo(null);

            }else if(comboBox_grupo.isEnabled()==true){
                giraSeleccionada.setArtista(null);
                giraSeleccionada.setGrupo((Grupo) comboBox_grupo.getSelectedItem());

            }
            giraSeleccionada.setFechaInicio(datePicker_fechaIncio.getDate());
            giraSeleccionada.setFechaFin(datePicker_fechaFin.getDate());

            if(imageUtil.isChangeImage()==true){
                giraSeleccionada.setCartel(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                giraSeleccionada.setCartel(giraSeleccionada.getCartel());
            }
            model.modificarGira(giraSeleccionada);
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
        if(alertUtil.wantContinue("¿Desea modificar otra gira?")==0){
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
            if(e.getSource()==list_gira){
                showData();
            }
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
