package com.musicmanagerssoftware.util;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.gui.Model;

import javax.swing.*;

/**
 * Utilidades para las listas.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ListUtil {

    /**
     * Constructor
     */
    public void ListUtil(){

    }

    /**
     * Rellena la lista con los artistas.
     */
    public void fillListArtista(DefaultListModel dlmArtista, Model model){
        for (Artista artista : model.getArtista()) {
            dlmArtista.addElement(artista);
        }
    }

    /**
     * Rellena la lista con los grupos.
     */
    public void fillListGrupo(DefaultListModel dlmGrupo, Model model){
        for (Grupo grupo : model.getGrupo()) {
            dlmGrupo.addElement(grupo);
        }
    }

    /**
     * Rellena la lista con las canciones.
     */
    public void fillListCancion(DefaultListModel dlmCancion, Model model){
        for (Cancion cancion : model.getCancion()) {
            dlmCancion.addElement(cancion);
        }
    }

    /**
     * Rellena la lista con los discos.
     */
    public void fillListDisco(DefaultListModel dlmDisco, Model model){
        for (Disco disco : model.getDisco()) {
            dlmDisco.addElement(disco);
        }
    }

    /**
     * Rellena la lista con las sala.
     */
    public void fillListSala(DefaultListModel dlmSala, Model model){
        for (Sala sala : model.getSala()) {
            dlmSala.addElement(sala);
        }
    }

    /**
     * Rellena la lista con los concierto.
     */
    public void fillListConcierto(DefaultListModel dlmConcierto, Model model){
        for (Concierto concierto : model.getConcierto()) {
            dlmConcierto.addElement(concierto);
        }
    }

    /**
     * Rellena la lista con las gira.
     */
    public void fillListGira(DefaultListModel dlmGira, Model model){
        for (Gira gira : model.getGira()) {
            dlmGira.addElement(gira);
        }
    }
}
