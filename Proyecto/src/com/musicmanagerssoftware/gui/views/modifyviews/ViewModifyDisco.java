package com.musicmanagerssoftware.gui.views.modifyviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
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

/**
 * Ventana que para modificar disco
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ViewModifyDisco extends JDialog implements ModifyMethods,ActionListener, ListSelectionListener,
        ItemListener{

    //Panel
    private JPanel contentPane;
    //Label
    private JLabel lbl_imagen;
    //ComboBox
    private JComboBox comboBox_artista;
    private JComboBox comboBox_grupo;
    private JComboBox comboBox_genero;
    //List
    private JList list_discos;
    //Button
    private CompButton button_modificar;
    private CompButton button_guardar;
    private CompButton button_cancelar;
    //Text
    private DatePicker datePicker_fecha;
    private JTextField textField_formato;
    private JTextField textField_titulo;
    private JTextField textField_precio;
    //CheckBox
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JComboBox comboBox_discografica;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmDiscografica;
    //Model
    private Model model;
    //Util
    private AlertUtil alertUtil;
    private ComboBoxUtil comboBoxUtil;
    private ListUtil listUtil;
    private ImageUtil imageUtil;
    //Cancion
    private Disco discoSeleccionado;

    /**
     * Constructor de ViewModifyDisco
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    public ViewModifyDisco(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model) {
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
        list_discos.addListSelectionListener(listener);
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
        addListSelectionListener(this);
        addActionListener(this);
        addItemListener(this);
        initDlm();
        initDcm();
        listUtil.fillListDisco(dlm,model);
        fillComboBox();
        comboBox_grupo.setEnabled(false);
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_discos.setModel(dlm);
    }

    @Override
    public void initDcm() {

        dcmGenero = new DefaultComboBoxModel();
        comboBox_genero.setModel(dcmGenero);

        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo= new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografica.setModel(dcmDiscografica);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboGenero(dcmGenero);
        comboBoxUtil.fillComboArtista(dcmArtista,model);
        comboBoxUtil.fillComboGrupo(dcmGrupo,model);
        comboBoxUtil.fillComboDiscogrfica(dcmDiscografica);
    }

    @Override
    public void showData() {
        discoSeleccionado = (Disco) list_discos.getSelectedValue();
        textField_titulo.setText(discoSeleccionado.getTitulo());
        datePicker_fecha.setDate(discoSeleccionado.getFechaPublicacion());
        textField_formato.setText(discoSeleccionado.getFormato());
        textField_precio.setText(String.valueOf(discoSeleccionado.getPrecio()));
        comboBox_genero.setSelectedItem(discoSeleccionado.getGeneroMusical());
        comboBox_artista.setSelectedItem(discoSeleccionado.getArtista());
        comboBox_grupo.setSelectedItem(discoSeleccionado.getGrupo());
        comboBox_discografica.setSelectedItem(discoSeleccionado.getDiscografica());
        lbl_imagen.setIcon(imageUtil.convertirDeByteAImage(null,null,null,discoSeleccionado,
                null,null,null,lbl_imagen));
    }

    @Override
    public void clear() {
        textField_titulo.setText("");
        datePicker_fecha.setDateToToday();
        textField_formato.setText("");
        textField_precio.setText("");
        comboBox_genero.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
        lbl_imagen.setIcon(null);
    }

    @Override
    public void modifyData() {
        if(checkEmptyFields()==true) {

            discoSeleccionado.setTitulo(textField_titulo.getText());
            discoSeleccionado.setFechaPublicacion(datePicker_fecha.getDate());
            discoSeleccionado.setFormato(textField_formato.getText());
            discoSeleccionado.setPrecio(Double.valueOf(textField_precio.getText()));

            if(comboBox_genero.isEnabled()==false){
                discoSeleccionado.setGeneroMusical(null);
            }else{
                discoSeleccionado.setGeneroMusical(comboBox_genero.getSelectedItem().toString());
            }

            if(comboBox_grupo.isEnabled()==false){
                discoSeleccionado.setGrupo(null);
            }else{
                discoSeleccionado.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
            }

            if(comboBox_artista.isEnabled()==false){
                discoSeleccionado.setArtista(null);
            }else{
                discoSeleccionado.setArtista((Artista) comboBox_artista.getSelectedItem());
            }

            if(comboBox_discografica.isEnabled()==false){
                discoSeleccionado.setDiscografica(null);
            }else{
                discoSeleccionado.setDiscografica(String.valueOf(comboBox_discografica.getSelectedItem()));
            }

            if(imageUtil.isChangeImage()==true){
                discoSeleccionado.setCaractula(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                discoSeleccionado.setCaractula(discoSeleccionado.getCaractula());
            }
            model.modificarDisco(discoSeleccionado);
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
            if(e.getSource()==list_discos){
                showData();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox_artista || e.getSource() == checkBox_grupo) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (checkBox_artista.isSelected()) {
                    comboBox_grupo.setEnabled(false);
                    comboBox_artista.setEnabled(true);
                } else if (checkBox_grupo.isSelected()) {
                    comboBox_grupo.setEnabled(true);
                    comboBox_artista.setEnabled(false);
                }
            }
        }
    }
}
