package com.musicmanagerssoftware;

import com.musicmanagerssoftware.util.HibernateUtil;

public class DataBase {

    private boolean conectado;

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

}
