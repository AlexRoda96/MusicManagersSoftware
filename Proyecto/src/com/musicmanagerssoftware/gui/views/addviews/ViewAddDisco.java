package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Disco;
import com.musicmanagerssoftware.base.Grupo;
import com.musicmanagerssoftware.base.enums.Discografica;
import com.musicmanagerssoftware.base.enums.Formato;
import com.musicmanagerssoftware.base.enums.GeneroMusical;
import com.musicmanagerssoftware.base.enums.TiposMusicos;
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
 * Ventana para añadir un disco a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddDisco extends JDialog implements ActionListener, ItemListener{
    //Paneles
    private JPanel contentPane;
    //TextFields
    private JTextField textField_titulo;
    private JTextField textField_formato;
    private JTextField textField_precio;
    //Imagen
    private JLabel lbl_image;
    //Combos
    private JComboBox comboBox_generoMusical;
    private JComboBox comboBox_artista;
    private JComboBox comboBox_grupo;
    //Botones
    private CompButton button_addImage;
    private CompButton button_save;
    private CompButton button_cancel;
    private DatePicker datePicker_fechaPubli;
    private JComboBox comboBox_formato;
    private JCheckBox checkBox_artista;
    private JCheckBox checkBox_grupo;
    private JComboBox comboBox_discografia;
    //DefaulComboModel
    private DefaultComboBoxModel dcmFormato;
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmArtista;
    private DefaultComboBoxModel dcmDiscografica;
    //Model
    private Model model;
    private File fichero;
    private Disco newDisco;
    private ImageUtil imageUtil;
    private AlertUtil alertUtil;
    private boolean error;

    /**
     * Constructor de ViewAddDisco
     */
    public ViewAddDisco(ImageUtil imageUtil, AlertUtil alertUtil, Model model) {
        setTitle("Añadir Disco");
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
        addActionListener(this);
        addItemListener(this);
        initDcm();
        fillAllComboBox();
        comboBox_grupo.setEnabled(false);
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
        checkBox_artista.addItemListener(listener);
        checkBox_grupo.addItemListener(listener);
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm() {
        dcmFormato= new DefaultComboBoxModel();
        comboBox_formato.setModel(dcmFormato);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);

        dcmArtista = new DefaultComboBoxModel();
        comboBox_artista.setModel(dcmArtista);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografia.setModel(dcmDiscografica);
    }

    /**
     * Rellena todos los comboBox
     */
    private void fillAllComboBox(){
        ComboBoxUtil.fillComboArtista(dcmArtista,model);
        ComboBoxUtil.fillComboGrupo(dcmGrupo,model);
        ComboBoxUtil.fillComboGenero(dcmGenero);
        ComboBoxUtil.fillComboFormato(dcmFormato);
        ComboBoxUtil.fillComboDiscogrfica(dcmDiscografica);
    }

    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData() {
        error=false;
        newDisco = new Disco();
        newDisco.setTitulo(textField_titulo.getText());
        newDisco.setFechaPublicacion(datePicker_fechaPubli.getDate());

        if(comboBox_formato.getSelectedIndex()==-1){
            newDisco.setFormato(Formato.NULL.getNombre());
        }else{
            newDisco.setFormato(comboBox_formato.getSelectedItem().toString());
        }

        try {
            newDisco.setPrecio((double) Float.parseFloat(textField_precio.getText()));
        }catch (NumberFormatException e){
            AlertUtil.errorAlert("El precio no es valido \nDebe ser númerico");
            error=true;
        }

        if(comboBox_generoMusical.getSelectedIndex()==-1){
            newDisco.setGeneroMusical(GeneroMusical.NULL.getNombre());
        }else{
            newDisco.setGeneroMusical(comboBox_generoMusical.getSelectedItem().toString());
        }

        if(comboBox_discografia.getSelectedIndex()==-1){
            newDisco.setDiscografica(Discografica.NULL.getNombre());
        }else{
            newDisco.setGeneroMusical(comboBox_discografia.getSelectedItem().toString());
        }

        if (comboBox_artista.isEnabled()) {
            newDisco.setArtista((Artista) comboBox_artista.getSelectedItem());
        }else {
            newDisco.setArtista(null);
        }

        if (comboBox_grupo.isEnabled()) {
            newDisco.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
        }else {
            newDisco.setGrupo(null);
        }
        newDisco.setCaractula(imageUtil.convertirImagenaByte());
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear() {

        textField_titulo.setText("");
        datePicker_fechaPubli.setDate(null);
        textField_precio.setText("");
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_formato.setSelectedIndex(-1);
        comboBox_artista.setSelectedIndex(-1);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_discografia.setSelectedIndex(-1);
        lbl_image.setIcon(null);
    }

    /**
     * Comprueba si alguno de los campos indiacados estan vacíos
     * @return checkOk
     */
    private boolean checkEmptyFields() {

        boolean checkOk = true;

        if (textField_titulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre esta vacío");
            checkOk = false;
        } else if (imageUtil.isChangeImage() == false) {
            JOptionPane.showMessageDialog(null, "El campo Imagen esta vacío");
            checkOk = false;
        }

        return checkOk;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "save":
                addData();
                AlertUtil.messageAlert("Se ha guardado con éxito");
                if(checkEmptyFields()==true && error==false){
                    model.altaDisco(newDisco);
                    if(alertUtil.wantContinue("¿Desea insertar otro Disco?")==0){
                        clear();
                    }else{
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
