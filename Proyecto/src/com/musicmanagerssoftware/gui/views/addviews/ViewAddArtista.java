package com.musicmanagerssoftware.gui.views.addviews;

import com.github.lgooddatepicker.components.DatePicker;
import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.enums.Country;
import com.musicmanagerssoftware.base.enums.Discografica;
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
 * Ventana para añadir un artísta a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class  ViewAddArtista extends JDialog implements ActionListener, ItemListener {

    //Paneles
    private JPanel contentPane;
    private JPanel panelImagen;
    //JTextField
    public JTextField textFieldNombreArt;
    public JTextField textFieldNombre;
    public JTextField textFieldPrimerApellido;
    public JTextField textFieldDni;
    public JTextField textFieldNumTfn;
    public JTextField textFieldSegundoApellido;
    //JComboBox
    public JComboBox comboBox_grupo;
    public JComboBox comboBox_generoMusical;
    public JComboBox comboBox_tipoMusico;
    public JComboBox comboBox_discografica;

    //Imagen
    public JLabel lblImagen;
    //DatePicker
    public DatePicker datePicker_fechaNacimiento;
    //Buttons
    public CompButton buttonGuardar;
    public CompButton buttonCancelar;
    public JComboBox comboBox_country;
    public CompButton button_image;
    private JCheckBox checkBox_grupo;
    //DCM
    private DefaultComboBoxModel dcmCountry;
    private DefaultComboBoxModel dcmGrupo;
    private DefaultComboBoxModel dcmGenero;
    private DefaultComboBoxModel dcmDiscografica;
    private DefaultComboBoxModel dcmTipo;

    private Model model;
    private boolean error;
    Artista nuevoArtista;
    private ImageUtil imageUtil;
    private AlertUtil alertUtil;
    private boolean haveChanges;


    /**
     * Constructor ViewAddArtist
     */
    public ViewAddArtista(ImageUtil imageUtil, AlertUtil alertUtil, Model model) {
        setTitle("Añadir Artista");
        setContentPane(contentPane);
        setModal(true);
        initConfiguration(imageUtil,alertUtil,model);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Añade los Action Listener a los botones
     *
     * @param listener
     */
    private void addActionListener(ActionListener listener) {
        buttonGuardar.addActionListener(listener);
        buttonCancelar.addActionListener(listener);
        button_image.addActionListener(listener);
    }

    private void addItemListener(ItemListener listener) {
        checkBox_grupo.addItemListener(listener);
    }

    private void initConfiguration(ImageUtil imageUtil, AlertUtil alertUtil, Model model){

        this.imageUtil=imageUtil;
        this.model=model;
        this.alertUtil=alertUtil;
        addItemListener(this);
        initDcm();
        addActionListener(this);
        fillComboBox();
        clear();
    }


    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm() {
        dcmCountry = new DefaultComboBoxModel();
        comboBox_country.setModel(dcmCountry);

        dcmGrupo = new DefaultComboBoxModel();
        comboBox_grupo.setModel(dcmGrupo);

        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografica.setModel(dcmDiscografica);

        dcmGenero = new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);

        dcmTipo = new DefaultComboBoxModel();
        comboBox_tipoMusico.setModel(dcmTipo);

    }

    /**
     * Rellena los comboBox con sus respectivos datos.
     */
    private void fillComboBox() {
        ComboBoxUtil.fillComboGrupo(dcmGrupo,model);
        ComboBoxUtil.fillComboCountries(dcmCountry);
        ComboBoxUtil.fillComboGenero(dcmGenero);
        ComboBoxUtil.fillComboDiscogrfica(dcmDiscografica);
        ComboBoxUtil.fillComboTipo(dcmTipo);
    }



    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData() {
        error=false;

        nuevoArtista = new Artista();
        nuevoArtista.setNombreArtistico(textFieldNombreArt.getText());
        nuevoArtista.setNombre(textFieldNombre.getText());
        nuevoArtista.setPrimerApellido(textFieldPrimerApellido.getText());
        nuevoArtista.setSegundoApellido(textFieldSegundoApellido.getText());
        nuevoArtista.setDni(textFieldDni.getText());
        nuevoArtista.setFechaNacimiento(datePicker_fechaNacimiento.getDate());

        try {
            nuevoArtista.setNumTelefono(Integer.parseInt(textFieldNumTfn.getText()));
        }catch (NumberFormatException e){
            AlertUtil.errorAlert("El número de telefono no es valido \nDebe ser númerico");
            error=true;
        }

        if(comboBox_country.getSelectedIndex()==-1){
            nuevoArtista.setPaisNacimiento(null);
        }else{
            nuevoArtista.setPaisNacimiento(comboBox_country.getSelectedItem().toString());
        }

        if(comboBox_generoMusical.getSelectedIndex()==-1){
            nuevoArtista.setGeneroMusical(GeneroMusical.NULL.getNombre());
        }else{
            nuevoArtista.setGeneroMusical(comboBox_generoMusical.getSelectedItem().toString());
        }

        if(comboBox_tipoMusico.getSelectedIndex()==-1){
            nuevoArtista.setGeneroMusical(TiposMusicos.NULL.getTipo());
        }else{
            nuevoArtista.setTipoMusico(comboBox_tipoMusico.getSelectedItem().toString());
        }

        if (comboBox_grupo.isEnabled()) {
            nuevoArtista.setGrupo((Grupo) comboBox_grupo.getSelectedItem());
        }else {
            nuevoArtista.setGrupo(null);
        }

        if(comboBox_discografica.getSelectedIndex()==-1){
            nuevoArtista.setDiscografica(Discografica.NULL.getNombre());
        }else{
            nuevoArtista.setDiscografica(comboBox_discografica.getSelectedItem().toString());
        }
        nuevoArtista.setFoto(imageUtil.convertirImagenaByte());
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear() {

        textFieldNombreArt.setText("");
        textFieldNombre.setText("");
        textFieldPrimerApellido.setText("");
        textFieldSegundoApellido.setText("");
        textFieldDni.setText("");
        datePicker_fechaNacimiento.setDate(null);
        textFieldNumTfn.setText("");
        comboBox_country.setSelectedIndex(-1);
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_tipoMusico.setSelectedIndex(-1);
        comboBox_grupo.setEnabled(true);
        checkBox_grupo.setSelected(true);
        comboBox_grupo.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
        lblImagen.setIcon(null);
    }

    /**
     * Comprueba si alguno de los campos indiacados estan vacíos
     *
     * @return
     */
    private boolean checkEmptyFields() {

         boolean checkOk = true;

        if (textFieldNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre esta vacío");
            checkOk = false;

        } else if (textFieldNombreArt.getText().isEmpty()) {
            AlertUtil.messageAlert("El campo nombre artístico esta vacío.");
            checkOk = false;

        } else if (textFieldPrimerApellido.getText().isEmpty()) {
            AlertUtil.messageAlert("El campo primer apellido esta vacío");
            checkOk = false;

        } else if (textFieldDni.getText().isEmpty()) {
            AlertUtil.messageAlert("El campo Dni esta vacío");
            checkOk = false;
        } else if(comboBox_country.getSelectedIndex()==-1){
            AlertUtil.messageAlert("Debe seleccionar un país de nacimiento.");
            checkOk = false;
        }
        return checkOk;
    }


    /**
     * Devuelve si se han realizado cambios
     * @return have changes
     */
    public boolean isHaveChanges() {
        return haveChanges;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "Save":
                addData();
                AlertUtil.messageAlert("Se ha guardado con éxito");
                haveChanges = true;
                if(checkEmptyFields()==true && error==false) {
                    model.altaArtista(nuevoArtista);
                    if (alertUtil.wantContinue("¿Desea insertar otro Artísta?") == 0) {
                        clear();
                    } else {
                        dispose();
                    }
                }

                break;

            case "Cancel":
                dispose();
                break;

            case "Select Image":
                imageUtil.selectImage(lblImagen);
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkBox_grupo) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                comboBox_grupo.setEnabled(true);
            }else if(e.getStateChange() == ItemEvent.DESELECTED){
                comboBox_grupo.setEnabled(false);
            }
        }
    }
}
