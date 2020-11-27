package com.musicmanagerssoftware.base.enums;

/**
 * Clase enumerada que contiene generos musicales.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public enum GeneroMusical {

    NULL("Desconocido"),
    BACHATA("Bachata"),
    BLUES("Blues"),
    CLASICA("Clásica"),
    COUNTRY("Country"),
    DISCO("Disco"),
    DUBSTEP("Dubstep"),
    ELECTRONICA("Electrónica"),
    ELECTROPOP("Electro Pop"),
    FLAMENCO("Flamenco"),
    FOLK("Folk"),
    FUNK("Funk"),
    GARAGEROCK("Garage Rock"),
    HEAVYMETAL("Heavy Metal"),
    HIPHOP("Hip Hop"),
    INDIE("Indie"),
    JAZZ("Jazz"),
    POP("Pop"),
    PUNK("Punk"),
    REGGAE("Reggae"),
    REGGAETON("Reggaeton"),
    ROCK("Rock"),
    ROCKANDROLL("Rock And Roll"),
    RUMBA("Rumba"),
    SALSA("Salsa"),
    SKA("Ska"),
    SOUL("Soul"),
    TRASHMETAL("Trash Metal"),
    TRAP("Trap");

    private String nombre;

    /**
     * Constructor de GeneroMusical
     * @param nombre
     */
    private GeneroMusical(String nombre){
        this.nombre=nombre;
    }

    /**
     * Devuelve el nombre del género musical
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
}
