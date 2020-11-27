package com.musicmanagerssoftware.util;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.enums.*;
import com.musicmanagerssoftware.gui.Model;

import javax.swing.*;

/**
 * Contiene utilidades de los ComboBox.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ComboBoxUtil {

    /**
     * Constructor
     */
    public ComboBoxUtil(){

    }

    /**
     * Rellena el comboBoxCountry.
     * @param dcmCountry
     */
    public static void fillComboCountries(DefaultComboBoxModel dcmCountry) {
        Country country = new Country();
        dcmCountry.removeAllElements();
        for (Country countries : country.getCountries()) {
            dcmCountry.addElement(countries.getName());
        }
    }

    /**
     * Rellena el comboBox grupo.
     * @param dcmGrupo
     * @param model
     */
    public static void fillComboGrupo(DefaultComboBoxModel dcmGrupo, Model model) {
        dcmGrupo.removeAllElements();
        for (Grupo grupo : model.getGrupo()) {
            dcmGrupo.addElement(grupo);
        }
    }

    /**
     * Rellena el comboBox disco.
     * @param dcmDisco
     * @param model
     */
    public static void fillComboDisco(DefaultComboBoxModel dcmDisco, Model model) {
        dcmDisco.removeAllElements();
        for (Disco disco : model.getDisco()) {
            dcmDisco.addElement(disco);
        }
    }

    /**
     * Rellena el comboBox artísta.
     * @param dcmArtista
     * @param model
     */
    public static void fillComboArtista(DefaultComboBoxModel dcmArtista, Model model) {
        dcmArtista.removeAllElements();
        for (Artista artista : model.getArtista()) {
            dcmArtista.addElement(artista);
        }
    }

    /**
     * Rellena el comboBox género.
     * @param dcmGenero
     */
    public static void fillComboGenero(DefaultComboBoxModel dcmGenero) {
        dcmGenero.removeAllElements();
        for (GeneroMusical generoMusical : GeneroMusical.values()) {
            dcmGenero.addElement(generoMusical.getNombre());
        }
    }

    /**
     * Rellena el comboBox discográfica.
     * @param dcmDiscografica
     */
    public static void fillComboDiscogrfica(DefaultComboBoxModel dcmDiscografica) {
        dcmDiscografica.removeAllElements();
        for (Discografica discografica : Discografica.values()) {
            dcmDiscografica.addElement(discografica.getNombre());
        }
    }

    /**
     * Rellena el comboBox tipo de músico.
     * @param dcmTipo
     */
    public static void fillComboTipo(DefaultComboBoxModel dcmTipo) {
        dcmTipo.removeAllElements();
        for (TiposMusicos tiposMusicos : TiposMusicos.values()) {
            dcmTipo.addElement(tiposMusicos.getTipo());
        }
    }

    /**
     * Rellena el comboBox tipo de sala.
     * @param dcmTipoSala
     */
    public static void fillComboTipoSala(DefaultComboBoxModel dcmTipoSala) {
        dcmTipoSala.removeAllElements();
        for (TipoSala tipoSala: TipoSala.values()) {
            dcmTipoSala.addElement(tipoSala.getTipo());
        }
    }

    /**
     * Rellena el comboBox gira
     * @param dcmGira
     */
    public static void fillComboGira(DefaultComboBoxModel dcmGira,Model model) {
        dcmGira.removeAllElements();
        for (Gira gira: model.getGira()) {
            dcmGira.addElement(gira);
        }
    }

    /**
     * Rellena el combo de discograficas
     */
    public static void fillComboFormato(DefaultComboBoxModel dcmFormato) {
        dcmFormato.removeAllElements();
        for (Formato formato : Formato.values()) {
            dcmFormato.addElement(formato);
        }
    }

    /**
     * Rellena el combo de discograficas
     */
    public static void fillComboSalas(DefaultComboBoxModel dcmSala,Model model) {
        dcmSala.removeAllElements();
        for (Sala sala : model.getSala()) {
            dcmSala.addElement(sala);
        }
    }
}
