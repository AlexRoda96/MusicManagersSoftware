/**
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */

package com.musicmanagerssoftware.util;

import com.musicmanagerssoftware.util.HibernateUtil;

/**
 * Clase DataBase.
 * Contiene los métodos de la base de datos
 */
public class DataBaseUtil {

    private boolean conectado;

    /**
     * Constructor
     */
    public DataBaseUtil() {
    }

    /**
     * Método que desconecta de la base de datos
     */
    public void desconectar() {
        HibernateUtil.closeSessionFactory();
        conectado=false;
    }

    /**
     * Método que conecta a la base de datos
     */
    public void conectar() {
        HibernateUtil.buildSessionFactory();
        conectado=true;
    }

    /**
     * Getter isConectado
     * @return conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * Setter setConectado
     * @param conectado
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}
