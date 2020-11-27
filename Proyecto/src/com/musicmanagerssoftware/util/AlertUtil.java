
package com.musicmanagerssoftware.util;

import javax.swing.*;

/**
 * Contiene utilidades de alertas.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class AlertUtil {

    /**
     * Constructor
     */
    public AlertUtil(){

    }


    /**
     * Muestra un OptionPane de confirmación para decidir si se desea continuar o no.
     * @param text Texto que mostrará la ventana
     * @return answer Si es 0 = Yes, Si es 1 == NO.
     */
    public int wantContinue(String text){

        int answer = JOptionPane.showConfirmDialog(null,text,
                " ",JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        return answer;
    }

    /**
     * Muestra un OptionPane con un mensaje de alerta.
     * @param text Texto de alerta que mostrará.
     */
    public static void messageAlert(String text){
        JOptionPane.showMessageDialog(null,text);
    }

    /**
     * Muestra un OptionPane de error.
     * @param text Texto de error que se mostrará.
     */
    public static void errorAlert(String text){
        JOptionPane.showMessageDialog(null, text,"Error", JOptionPane.ERROR_MESSAGE);
    }

}
