package com.musicmanagerssoftware.gui.views.modifyviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Cancion;
import com.musicmanagerssoftware.base.Disco;
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

public class ViewModifyCancion extends JDialog implements ModifyMethods,ActionListener, ListSelectionListener,
        ItemListener {
    //Panel
    private JPanel contentPane;
    //Text
    private JTextField textField_titulo;
    private JTextField textField_formato;
    private JTextField textField_videoclip;
    private JTextField textField_duracion;
    private DatePicker datePicker_fecha;

    //ComboBox
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_artista;
    private JComboBox comboBox_disco;
    private JComboBox comboBox_generoMusical;
    //Label
    private JLabel lbl_imagen;
    //List
    private JList list_canciones;
    //Button
    private CompButton button_cancel;
    private CompButton button_save;
    private CompButton button_image;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JCheckBox checkBox_disco;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmDisco;
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
    private Cancion cancionSeleccionada;


    public ViewModifyCancion(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
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
    public void addListSelectionListener(ListSelectionListener listener) {
        list_canciones.addListSelectionListener(listener);

    }

    @Override
    public void addActionListener(ActionListener listener) {
        button_cancel.addActionListener(listener);
        button_save.addActionListener(listener);
        button_image.addActionListener(listener);
    }

    @Override
    public void addItemListener(ItemListener listener) {
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
        checkBox_disco.addItemListener(listener);
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
        addListSelectionListener(this);
        addActionListener(this);
        initDlm();
        initDcm();
        listUtil.fillListCancion(dlm,model);
        fillComboBox();
        comboBox_grupo.setEnabled(false);
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_canciones.setModel(dlm);
    }

    @Override
    public void initDcm() {

        dcmDisco = new DefaultComboBoxModel();
        comboBox_disco.setModel(dcmDisco);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);

        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo= new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboGenero(dcmGenero);
        comboBoxUtil.fillComboDisco(dcmDisco,model);
        comboBoxUtil.fillComboArtista(dcmArtista,model);
        comboBoxUtil.fillComboGrupo(dcmGrupo,model);
    }

    @Override
    public void showData() {
        cancionSeleccionada = (Cancion) list_canciones.getSelectedValue();
        textField_titulo.setText(cancionSeleccionada.getTitulo());
        datePicker_fecha.setDate(cancionSeleccionada.getFechaPublicacion());
        textField_formato.setText(cancionSeleccionada.getFormato());
        textField_duracion.setText(String.valueOf(cancionSeleccionada.getDuracion()));
        textField_videoclip.setText(cancionSeleccionada.getVideoclip());
        comboBox_generoMusical.setSelectedItem(cancionSeleccionada.getGenero());
        comboBox_artista.setSelectedItem(cancionSeleccionada.getArtista());
        comboBox_grupo.setSelectedItem(cancionSeleccionada.getGrupo());
        comboBox_disco.setSelectedItem(cancionSeleccionada.getDisco());
        lbl_imagen.setIcon(imageUtil.convertirDeByteAImage(null,null,cancionSeleccionada,null,null,null,null,lbl_imagen));
    }

    @Override
    public void clear() {
        textField_titulo.setText("");
        datePicker_fecha.setDateToToday();
        textField_formato.setText("");
        textField_videoclip.setText("");
        textField_duracion.setText("");
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_disco.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_grupo.setSelectedIndex(-1);
        lbl_imagen.setIcon(null);
    }

    @Override
    public void modifyData() {
        if(checkEmptyFields()==true) {

            cancionSeleccionada.setTitulo(textField_titulo.getText());
            cancionSeleccionada.setFechaPublicacion(datePicker_fecha.getDate());
            cancionSeleccionada.setFormato(textField_formato.getText());
            cancionSeleccionada.setVideoclip(textField_videoclip.getText());
            cancionSeleccionada.setDuracion(Float.parseFloat(textField_duracion.getText()));
            cancionSeleccionada.setGenero(comboBox_generoMusical.getSelectedItem().toString());
            if(comboBox_disco.isEnabled()==false){
                cancionSeleccionada.setDisco(null);
            }else{
                cancionSeleccionada.setDisco((Disco) comboBox_disco.getSelectedItem());
            }

            if(comboBox_grupo.isEnabled()==false){
                cancionSeleccionada.setGrupo(null);
            }else{
                cancionSeleccionada.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }

            if(comboBox_artista.isEnabled()==false){
                cancionSeleccionada.setArtista(null);
            }else{
                cancionSeleccionada.setArtista((Artista) comboBox_artista.getSelectedItem());
            }
            if(imageUtil.isChangeImage()==true){
                cancionSeleccionada.setImagen(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                cancionSeleccionada.setImagen(cancionSeleccionada.getImagen());
            }
            model.modificarCancion(cancionSeleccionada);
        }
    }

    @Override
    public boolean checkEmptyFields() {
        boolean checkOk=true;
        if(textField_titulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo Nombre esta vacío");
            checkOk=false;
        }

        return checkOk;
    }

    @Override
    public void wantContinue() {
        if(alertUtil.wantContinue("¿Desea modificar otra canción?")==0){
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
            if(e.getSource()==list_canciones){
                showData();
            }
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
