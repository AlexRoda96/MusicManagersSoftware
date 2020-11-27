package com.musicmanagerssoftware.gui.views.addviews;

import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Grupo;
import com.musicmanagerssoftware.base.enums.Discografica;
import com.musicmanagerssoftware.base.enums.GeneroMusical;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
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
import java.time.Year;

/**
 * Ventana para añadir un grupo a la base de datos.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class ViewAddGrupo extends JDialog implements ActionListener{

    //Panel
    private JPanel contentPane;
    //Text
    private JTextField textField_nombre;
    private JTextField textField_anno;
    //Label
    private JLabel label_image;
    //ComboBox
    private JComboBox comboBox_discografica;
    private JComboBox comboBox_generoMusical;
    //Button
    private CompButton button_addImage;
    private CompButton button_save;
    private CompButton button_cancel;
    //Modelo
    private Model model;
    //Fichero
    private File fichero;
    //DefaultComboBoxModel
    private DefaultComboBoxModel dcmDiscografica;
    private DefaultComboBoxModel dcmGenero;
    private Grupo nuevoGrupo;
    private boolean haveImagen;
    private boolean error;

    /**
     * Constructor
     */
    public ViewAddGrupo() {
        haveImagen=false;
        setTitle("Modificar Grupo");
        setContentPane(contentPane);
        setModal(true);
        initDcm();
        addActionListener(this);
        model = new Model();
        fillComboDiscogrfica();
        fillComboGenero();
        setInitialComponents();
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
     * Método que selecciona el index -1 en los combo box.
     */
    private void setInitialComponents(){
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "save":
                addData();
                if(checkEmptyFields()==true && error==false){
                    model.altaGrupo(nuevoGrupo);
                    wantContinue();
                }
                break;

            case "cancel":
                dispose();
                break;

            case "add image":
                selectImage();
                break;
        }
    }

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    private void initDcm(){
        dcmDiscografica = new DefaultComboBoxModel();
        comboBox_discografica.setModel(dcmDiscografica);
        dcmGenero= new DefaultComboBoxModel();
        comboBox_generoMusical.setModel(dcmGenero);
    }

    /**
     * Rellena el combo de discograficas
     */
    private void fillComboDiscogrfica(){
        dcmDiscografica.removeAllElements();
        for (Discografica discografica : Discografica.values()) {
            dcmDiscografica.addElement(discografica.getNombre());
        }
    }

    /**
     * Rellena el combo de generos
     */
    private void fillComboGenero(){
        dcmGenero.removeAllElements();
        for (GeneroMusical generoMusical : GeneroMusical.values()) {
            dcmGenero.addElement(generoMusical.getNombre());
        }
    }

    /**
     * Método que añade un artista a la base de datos con los datos que se encuentran en ls
     * campos de la ventana.
     */
    private void addData(){
        error=false;
        nuevoGrupo = new Grupo();
        nuevoGrupo.setNombre(textField_nombre.getText());
        try {
            nuevoGrupo.setAnnoFormacion((Integer.parseInt(textField_anno.getText())));
        }catch (NumberFormatException e){
            AlertUtil.errorAlert("Debes introducir un año valido");
            error=true;
        }

        if(comboBox_discografica.getSelectedIndex()==-1){
            nuevoGrupo.setDiscografica(Discografica.NULL.getNombre());
        }else{
            nuevoGrupo.setDiscografica(comboBox_discografica.getSelectedItem().toString());
        }

        if(comboBox_generoMusical.getSelectedIndex()==-1){
            nuevoGrupo.setGeneroMusical(GeneroMusical.NULL.getNombre());
        }else{
            nuevoGrupo.setGeneroMusical(comboBox_generoMusical.getSelectedItem().toString());
        }
        nuevoGrupo.setFoto(convertirImagenaByte());
    }

    /**
     * Limpia los campos de la vista ViewAddArtista.
     */
    private void clear(){

        textField_nombre.setText("");
        textField_anno.setText("");
        comboBox_generoMusical.setSelectedIndex(-1);
        comboBox_discografica.setSelectedIndex(-1);
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
        }else if(haveImagen==false){
            JOptionPane.showMessageDialog(null,"El campo Imagen esta vacío");
            checkOk=false;
        }

        return checkOk;
    }

    /**
     * Abre una ventana de seleccion de archivo para seleccionar la imagen que queremos añadir
     */
    private void selectImage() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        selector.setFileFilter(filtro);
        int opcion = selector.showSaveDialog(null);
        if (JFileChooser.APPROVE_OPTION == opcion) {

            fichero = selector.getSelectedFile();
            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label_image.getWidth(), label_image.getHeight(), Image.SCALE_DEFAULT));
                label_image.setIcon(icono);
                haveImagen=true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
        }
    }

    /**
     * Ventana de confirmación
     */
    private void wantContinue(){
        int answer = JOptionPane.showConfirmDialog(null,"¿Desea insertar otro Grupo?",
                " ",JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if(answer==0){
            clear();
        }else if(answer==1){
            dispose();
        }
    }

    /**
     * Convierte la imagen seleccionada a byte
     * @return data
     */
    private byte[] convertirImagenaByte() {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(fichero);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al leer la Imagen",
                    "Error", JOptionPane.WARNING_MESSAGE);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", bos );
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte [] data = bos.toByteArray();
        return data;
    }
}
