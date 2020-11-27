package com.musicmanagerssoftware.base.enums;

/**
 * Clase enumerada que contiene discográficas.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public enum Discografica {

    NULL("Sin Discográfica"),
    SONYMUSIC("Sony Music"),
    WARNERMUSIC("Warner Music"),
    UNIVERSALMUSIC("Universal Music"),
    EPICRECORDS("Epic Records"),
    DEATHROWRECORDS("Death Row Records"),
    RUTHLESSRECORDS("Ruthless Records"),
    BADBOYRECORDS("Bad Boy Records"),
    AFTERMATHENTRETAINMENT("Aftermath Records"),
    SHADYRECORDS("Shady Records"),
    RAPSOLO("Rapsolo"),
    BOA("BOA Music");

    private String nombre;

    /**
     * Constructor de Discográfica
     * @param nombre
     */
    private Discografica(String nombre){
        this.nombre=nombre;
    }

    /**
     * Devuelve el nombre de la discofrafica
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
}
