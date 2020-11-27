package com.musicmanagerssoftware.gui.views.modifyviews;

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
import java.time.Year;

/**
 * Ventana de modificar grupo
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ViewModifyGrupo extends JDialog implements ModifyMethods, ActionListener,
        ListSelectionListener {

    //Panel
    private JPanel contentPane;
    //Text
    private JTextField textField_nombre;
    private JTextField textField_anno;
    //Label
    private JLabel label_image;
    //List
    private JList list_grupos;
    //ComboBox
    private JComboBox comboBox_generoMusical;
    private JComboBox comboBox_discografica;
    //Buttons
    private CompButton button_modifcar;
    private CompButton button_guardar;
    private CompButton button_cancelar;
    //Dlm
    private DefaultListModel dlm;
    //Dcm
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmDiscografica;
    //Model
    private Model model;
    //Util
    private AlertUtil alertUtil;
    private ComboBoxUtil comboBoxUtil;
    private ListUtil listUtil;
    private ImageUtil imageUtil;
    //Grupo
    Grupo grupoSeleccionado;

    /**
     * Contructor de ViewModifyGrupo
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    public ViewModifyGrupo(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil,
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
    public void addListSelectionListener(ListSelectionListener listener) {
        list_grupos.addListSelectionListener(listener);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        button_cancelar.addActionListener(listener);
        button_guardar.addActionListener(listener);
        button_modifcar.addActionListener(listener);
    }

    @Override
    public void addItemListener(ItemListener listener) {

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
    public void initConfig() {
        addListSelectionListener(this);
        addActionListener(this);
        initDlm();
        initDcm();
        listUtil.fillListGrupo(dlm,model);
        fillComboBox();
    }

    @Override
    public void initDlm() {
        dlm = new DefaultListModel();
        list_grupos.setModel(dlm);
    }

    @Override
    public void initDcm() {
        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografica.setModel(dcmDiscografica);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);
    }

    @Override
    public void fillComboBox() {
        comboBoxUtil.fillComboGenero(dcmGenero);
        comboBoxUtil.fillComboDiscogrfica(dcmDiscografica);
    }

    @Override
    public void showData() {
        grupoSeleccionado = (Grupo) list_grupos.getSelectedValue();
        textField_nombre.setText(grupoSeleccionado.getNombre());
        comboBox_generoMusical.setSelectedItem(grupoSeleccionado.getGeneroMusical());
        textField_anno.setText(String.valueOf(grupoSeleccionado.getAnnoFormacion()));
        comboBox_discografica.setSelectedItem(grupoSeleccionado.getDiscografica());
        label_image.setIcon(imageUtil.convertirDeByteAImage(null,grupoSeleccionado,null,
                null,null,null,null,label_image));
    }

    @Override
    public void clear() {
        textField_nombre.setText("");
        textField_anno.setText("");
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
        label_image.setIcon(null);
    }

    @Override
    public void modifyData() {
        if(checkEmptyFields()==true) {

            grupoSeleccionado.setNombre(textField_nombre.getText());
            grupoSeleccionado.setAnnoFormacion(Integer.parseInt(textField_anno.getText()));
            if(comboBox_discografica.getSelectedIndex()==-1){
                grupoSeleccionado.setDiscografica(null);
            }else{
                grupoSeleccionado.setDiscografica(comboBox_discografica.getSelectedItem().
                        toString());
            }
            if(comboBox_generoMusical.getSelectedIndex()==-1){
                grupoSeleccionado.setGeneroMusical(null);
            }else{
                grupoSeleccionado.setGeneroMusical(comboBox_generoMusical.getSelectedItem().
                        toString());
            }

            if(imageUtil.isChangeImage()==true){
                grupoSeleccionado.setFoto(imageUtil.convertirImagenaByte());
            }else if(imageUtil.isChangeImage()==false){
                grupoSeleccionado.setFoto(grupoSeleccionado.getFoto());
            }
            model.modificarGrupo(grupoSeleccionado);
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
        if(alertUtil.wantContinue("¿Desea modificar otro grupo?")==0){
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
                imageUtil.selectImage(label_image);
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
            if(e.getSource()==list_grupos){
                showData();
            }
        }
    }
}
