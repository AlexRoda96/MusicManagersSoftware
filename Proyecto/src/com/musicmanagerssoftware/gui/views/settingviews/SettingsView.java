package com.musicmanagerssoftware.gui.views.settingviews;

import com.musicmanagerssoftware.gui.views.MenuView;
import com.musicmanagerssoftware.util.AlertUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Ventana que muestra la ventana de preferencias.
 * @author Alejandro Roda
 * @since 13/11/202
 * @version 1.0
 */
public class SettingsView extends JDialog implements ActionListener{

    //Panel
    private JPanel contentPane;
    //Buttons
    private JButton buttonOK;
    private JButton buttonCancel;
    //CheckBox
    private JCheckBox checkBox_conectar;
    private JCheckBox menuArchivoCheckBox;
    private JCheckBox menuAccionCheckBox;
    private JCheckBox menuCuentaCheckBox;
    private JCheckBox menuAyudaCheckBox;
    //File
    private File guardar;
    //Properties
    public Properties config;
    //MenuView
    private MenuView menuView;

    /**
     * Constructor
     * @param menuView
     */
    public SettingsView(MenuView menuView) {
        this.menuView = menuView;
        createWindow();
    }

    /**
     * Crea la ventana
     */
    private void createWindow(){
        setTitle("Music Manager Software - Ajustes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setContentPane(contentPane);
        setModal(true);
        initConfiguration();
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Configuración inicial.
     */
    private void initConfiguration(){
        config = new Properties();
        createConfigurationFile();
        loadConfigurationFile();
        addActionListener(this);
    }

    /**
     * Añade los listener a los botones
     * @param listener
     */
    private void addActionListener(ActionListener listener){
        buttonOK.addActionListener(listener);
        buttonCancel.addActionListener(listener);
    }

    /**
     * Crea un archivo de configuración.
     */
    public void createConfigurationFile() {
        guardar = new File("preferencias.conf");
        if (!guardar.exists()) {
            try {
                guardar.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                AlertUtil.errorAlert("Error al crear el archivo de configuración");
            }

            config.setProperty("conectar", "true");
            config.setProperty("archivo", "true");
            config.setProperty("accion", "true");
            config.setProperty("cuenta", "true");
            config.setProperty("ayuda", "true");

            try {
                config.store(new FileWriter(guardar.getAbsolutePath()),
                        "Configuracion de preferencias");
            } catch (IOException e) {
                e.printStackTrace();
                AlertUtil.errorAlert("Error al crear el archivo de configuración");
            }
        }
    }

    /**
     * Método que actualiza el archivo de configuración.
     */
    private void updateConfigurationFile(){
        if(checkBox_conectar.isSelected()==true){
            config.setProperty("conectar","true");
        }else if(checkBox_conectar.isSelected()==false){
            config.setProperty("conectar","false");
        }
        if(menuArchivoCheckBox.isSelected()){
            config.setProperty("archivo","true");
        }else{
            config.setProperty("archivo","false");
        }
        if(menuAccionCheckBox.isSelected()){
            config.setProperty("accion","true");
        }else if(menuAccionCheckBox.isSelected()==false){
            config.setProperty("accion","false");
        }
        if(menuCuentaCheckBox.isSelected()){
            config.setProperty("herramienta","true");
        }else{
            config.setProperty("herramienta","false");
        }
        if(menuAyudaCheckBox.isSelected()){
            config.setProperty("ayuda","true");
        }else{
            config.setProperty("ayuda","false");
        }
        try {
            config.store(new FileWriter(guardar.getAbsolutePath()),
                    "Configuracion de preferencias");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método qye carga la configuración del archivo.
     */
    public void loadConfigurationFile(){
        try {
            config.load(new FileReader("preferencias.conf"));
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtil.errorAlert("Error al cargar el archivo de configuración");
        }

        if(config.getProperty("conectar").equalsIgnoreCase("true")){
            checkBox_conectar.setSelected(true);
        }else if(config.getProperty("conectar").equalsIgnoreCase("false")){
            checkBox_conectar.setSelected(false);
        }
        if(config.getProperty("archivo").equalsIgnoreCase("true")){
            menuArchivoCheckBox.setSelected(true);
        }else if(config.getProperty("archivo").equalsIgnoreCase("false")){
            menuArchivoCheckBox.setSelected(false);
        }
        if(config.getProperty("accion").equalsIgnoreCase("true")){
            menuAccionCheckBox.setSelected(true);
        }else if(config.getProperty("accion").equalsIgnoreCase("false")){
            menuAccionCheckBox.setSelected(false);
        }
        if(config.getProperty("herramienta").equalsIgnoreCase("true")){
            menuCuentaCheckBox.setSelected(true);
        }else if(config.getProperty("herramienta").equalsIgnoreCase("false")){
            menuCuentaCheckBox.setSelected(false);
        }
        if(config.getProperty("ayuda").equalsIgnoreCase("true")){
            menuAyudaCheckBox.setSelected(true);
        }else if(config.getProperty("ayuda").equalsIgnoreCase("false")){
            menuAyudaCheckBox.setSelected(false);
        }
    }

    /**
     * Oculta los menus
     */
    private void hideShowMenus(){
        hideShowAccion();
        hideShowArchivo();
        hideShowAyuda();
        hideShowHerramienta();
    }

    /**
     * Muestra o oculta el menu accion
     */
    private void hideShowAccion(){
        if(config.getProperty("accion").equalsIgnoreCase("false")){
            menuView.menuObjeto.setVisible(false);
        }else if(config.getProperty("accion").equalsIgnoreCase("true")){
            menuView.menuObjeto.setVisible(true);
        }
    }

    /**
     * Muestra u oculta el menu archivo
     */
    private void hideShowArchivo(){
        if(config.getProperty("archivo").equalsIgnoreCase("false")){
            menuView.menuArchivo.setVisible(false);
        }else if(config.getProperty("archivo").equalsIgnoreCase("true")){
            menuView.menuArchivo.setVisible(true);
        }
    }

    /**
     * Muestra u oculta el menu ayuda
     */
    private void hideShowAyuda(){
        if(config.getProperty("ayuda").equalsIgnoreCase("false")){
            menuView.menuAyuda.setVisible(false);
        }else if(config.getProperty("ayuda").equalsIgnoreCase("true")){
            menuView.menuAyuda.setVisible(true);
        }
    }

    /**
     * Muestra u oculta el menu herrameinta
     */
    private void hideShowHerramienta(){

        if(config.getProperty("herramienta").equalsIgnoreCase("false")){
            menuView.menuHerramientas.setVisible(false);
        }else if(config.getProperty("herramienta").equalsIgnoreCase("true")){
            menuView.menuHerramientas.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Guardar":
                updateConfigurationFile();
                JOptionPane.showMessageDialog(null,"Cambios Guardados");
                dispose();
                hideShowMenus();
                break;

            case "Cancelar":
                dispose();
                break;
        }
    }

}
