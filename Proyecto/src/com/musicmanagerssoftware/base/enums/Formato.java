package com.musicmanagerssoftware.base.enums;

/**
 * Clase enumerada que contiene formatos de disco.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public enum Formato {

    NULL("Desconocido"),
    VINILO("Vinilo");

    private String nombre;

    /**
     * Constructor de Formato
     * @param nombre
     */
    private Formato(String nombre){
        this.nombre=nombre;
    }

    /**
     * Devuelve el nombre del formato
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
}
