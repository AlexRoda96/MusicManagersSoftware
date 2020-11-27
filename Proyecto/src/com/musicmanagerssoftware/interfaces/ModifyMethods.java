package com.musicmanagerssoftware.interfaces;

import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import com.musicmanagerssoftware.util.ListUtil;

import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Interfaz que contiene métodos referidos a la modificación de elementos.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public interface ModifyMethods {

    /**
     * Inicializa la ventana
     */
    void initDialog();

    /**
     * Método que añade los ListSelectionListener a la lista.
     * @param listener
     */
    void addListSelectionListener(ListSelectionListener listener);

    /**
     * Método que añade los ActionListener a los botones.
     * @param listener
     */
    void addActionListener(ActionListener listener);

    /**
     * Método que añade los ItemListener a los chckbox.
     */
    void addItemListener(ItemListener listener);

    /**
     * Método que inicializa los parámetros.
     * @param alertUtil
     * @param comboBoxUtil
     * @param listUtil
     * @param imageUtil
     * @param model
     */
    void initParameters(AlertUtil alertUtil, ComboBoxUtil comboBoxUtil, ListUtil listUtil, ImageUtil imageUtil, Model model);

    /**
     * Configuración inicial.
     */
    void initConfig();

    /**
     * Inicializa los DefaultListModel
     */
    void initDlm();

    /**
     * Inicializa los DefaultComboBoxModel.
     */
    void initDcm();


    /**
     * Métod que rellena los comboBox
     */
    void fillComboBox();

    /**
     * Muestra los datos del elemento seleccionado en los componentes.
     */
    void showData();

    /**
     * Limpia los campos.
     */
    void clear();

    /**
     * Modifican los datos de los componentes al elemento seleccionado.
     */
    void modifyData();

    /**
     * Comprueba si hay campos vacíos.
     * @return
     */
    boolean checkEmptyFields();

    /**
     * Prgunta si se desea continuar.
     */
    void wantContinue();
}
