package com.musicmanagerssoftware.gui.controllers;

import com.musicmanagerssoftware.base.*;

import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.views.deleteviews.DeleteView;
import com.musicmanagerssoftware.util.AlertUtil;
import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Clase que controla el DeleteView
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class DeleteViewController {

    private DeleteView deleteView;
    Model model;
    private int type;
    private boolean haveChanges;
    private MainViewController mainViewController;

    /**
     * Constructor de DeleteViewController
     * @param deleteView
     * @param type
     */
    public DeleteViewController(DeleteView deleteView, int type, MainViewController mainViewController){
        this.mainViewController=mainViewController;
        haveChanges =false;
        this.deleteView = deleteView;
        this.type = type;
        model = new Model();
        addActionListener();
        addMouseListener();
        checkType();
    }

    /**
     * Método que devuelve el artista seleccionado en la tabla de la vista deleteView
     * @return artistaSeleccioando
     */
    private Artista getSelectRowArtista(){

        Artista artistaSeleccionado = null;

        int fila = deleteView.table.getSelectedRow();

        String firstValue = (String) deleteView.table.getValueAt(fila, 0);

        for (Artista artista : model.getArtista()) {
            if (artista.getNombreArtistico().equalsIgnoreCase(firstValue)) {
                artistaSeleccionado = artista;
            }
        }

        return artistaSeleccionado;
    }

    /**
     * Método que devuelve el grupo seleccionado en la tabla deleteView
     * @return grupoSeleccionado
     */
    private Grupo getSelectRowGrupo(){

        Grupo grupoSeleccionado = null;
        int fila = deleteView.table.getSelectedRow();
        String nombre = (String) deleteView.table.getValueAt(fila, 0);

        for (Grupo grupo : model.getGrupo()) {
            if (grupo.getNombre().equalsIgnoreCase(nombre)) {
                grupoSeleccionado = grupo;
            }
        }
        return grupoSeleccionado;
    }

    /**
     * Método que devuelve la cancion seleccionado en la tabla deleteView
     * @return cancionSeleccionada
     */
    private Cancion getSelectRowCancion(){

        Cancion cancionSeleccionada = null;
        int fila = deleteView.table.getSelectedRow();
        String titulo= (String) deleteView.table.getValueAt(fila, 0);

        for (Cancion cancion : model.getCancion()) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                cancionSeleccionada = cancion;
            }
        }
        return cancionSeleccionada;
    }

    /**
     * Método que devuelve el disco seleccionado en la tabla deleteView
     * @return discoSeleccionado
     */
    private Disco getSelectRowDisco(){

        Disco discoSeleccionado = null;
        int fila = deleteView.table.getSelectedRow();
        String titulo = (String) deleteView.table.getValueAt(fila, 0);

        for (Disco disco : model.getDisco()) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                discoSeleccionado = disco;
            }
        }
        return discoSeleccionado;
    }

    /**
     * Método que devuelve el concierto seleccionado en la tabla deleteView
     * @return conciertoSeleccionado
     */
    private Concierto getSelectRowConcierto(){

        Concierto conciertoSeleccionado = null;

        int fila = deleteView.table.getSelectedRow();
        String nombre = (String) deleteView.table.getValueAt(fila, 0);
        for (Concierto concierto : model.getConcierto()) {
            if (concierto.getNombre().equalsIgnoreCase(nombre)) {
                conciertoSeleccionado = concierto;
            }
        }
        return conciertoSeleccionado;
    }

    /**
     * Método que devuelve la gira seleccionado en la tabla deleteView
     * @return giraSeleccionada
     */
    private Gira getSelectRowGira(){

        Gira giraSeleccionada = null;
        int fila = deleteView.table.getSelectedRow();
        String nombre = (String) deleteView.table.getValueAt(fila, 0);

        for (Gira gira : model.getGira()) {
            if (gira.getNombre().equalsIgnoreCase(nombre)) {
                giraSeleccionada = gira;
            }
        }
        return giraSeleccionada;
    }

    /**
     * Método que devuelve la seleccionado en la tabla deleteView
     * @return salaSeleccionada
     */
    private Sala getSelectRowSala(){

        Sala salaSeleccionada = null;
        int fila = deleteView.table.getSelectedRow();
        String nombre = (String) deleteView.table.getValueAt(fila, 0);

        for (Sala sala : model.getSala()) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                salaSeleccionada = sala;
            }
        }
        return salaSeleccionada;
    }

    /**
     * Inicia la cabecera de la tabla artista
     */
    private void initHeaderArtista() {

        //Creamos un array de String con los headers de los atributos
        String[] headers = {"Nombre Artístico", "Nombre", "Primer Apellido", "Segundo Apellido"};
        //Añadimos los headers de los atributos
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla grupo
     */
    private void initHeaderGrupo() {

        String[] headers = {"Nombre", "Año de Formación", "Discográfica", "Género Músical"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla disco
     */
    private void initHeaderDisco() {

        String[] headers = {"Título", "Artista", "Grupo","Género Músical", "Fecha de Publicación"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla cancion
     */
    private void initHeaderCancion() {

        String[] headers = {"Título", "Artista", "Grupo", "Fecha de Publicación","Género Músical"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla gira
     */
    private void initHeaderGira() {

        String[] headers = {"Nombre", "Fecha de Inico", "Fecha de Fin", "Artista","Grupo"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla Concierto
     */
    private void initHeaderConcierto() {

        String[] headers = {"Nombre", "País", "Ciudad", "Fecha","Edad mínima"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Inicia la cabecera de la tabla Concierto
     */
    private void initHeaderSala() {

        String[] headers = {"Nombre", "Dirección", "Número Tfn", "Aforo máximo","Tipo Sala"};
        deleteView.dtm.setColumnIdentifiers(headers);
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadArtista() {

        deleteView.dtm.setRowCount(0);
        List<Artista> artistas = model.getArtista();
        if (artistas.size() > 0) {
            Iterator consulta = artistas.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Artista fila = (Artista) consulta.next();
                datos.add(fila.getNombreArtistico());
                datos.add(fila.getNombre());
                datos.add(fila.getPrimerApellido());
                datos.add(fila.getSegundoApellido());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadGrupo() {
        deleteView.dtm.setRowCount(0);
        List<Grupo> grupo = model.getGrupo();
        if (grupo.size() > 0) {
            Iterator consulta = grupo.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Grupo fila = (Grupo) consulta.next();
                datos.add(fila.getNombre());
                datos.add(fila.getAnnoFormacion());
                datos.add(fila.getDiscografica());
                datos.add(fila.getGeneroMusical());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadDisco() {
        deleteView.dtm.setRowCount(0);
        List<Disco> disco = model.getDisco();
        if (disco.size() > 0) {
            Iterator consulta = disco.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Disco fila = (Disco) consulta.next();
                datos.add(fila.getTitulo());
                datos.add(fila.getArtista());
                datos.add(fila.getGrupo());
                datos.add(fila.getGeneroMusical());
                datos.add(fila.getFechaPublicacion());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadCancion() {
        deleteView.dtm.setRowCount(0);
        List<Cancion> cancion = model.getCancion();
        if (cancion.size() > 0) {
            Iterator consulta = cancion.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Cancion fila = (Cancion) consulta.next();
                datos.add(fila.getTitulo());
                datos.add(fila.getArtista());
                datos.add(fila.getGrupo());
                datos.add(fila.getFechaPublicacion());
                datos.add(fila.getGenero());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadGira() {
        deleteView.dtm.setRowCount(0);
        List<Gira> gira = model.getGira();
        if (gira.size() > 0) {
            Iterator consulta = gira.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Gira fila = (Gira) consulta.next();
                datos.add(fila.getNombre());
                datos.add(fila.getFechaInicio());
                datos.add(fila.getFechaFin());
                datos.add(fila.getArtista());
                datos.add(fila.getGrupo());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadConcierto() {
        deleteView.dtm.setRowCount(0);
        List<Concierto> concierto = model.getConcierto();
        if (concierto.size() > 0) {
            Iterator consulta = concierto.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Concierto fila = (Concierto) consulta.next();
                datos.add(fila.getNombre());
                datos.add(fila.getPais());
                datos.add(fila.getCiudad());
                datos.add(fila.getFecha());
                datos.add(fila.getEdadMinima());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Carga los artistas a la tabla
     */
    private void loadSala() {
        deleteView.dtm.setRowCount(0);
        List<Sala> sala = model.getSala();
        if (sala.size() > 0) {
            Iterator consulta = sala.iterator();
            while (consulta.hasNext()) {
                Vector datos = new Vector();
                Sala fila = (Sala) consulta.next();
                datos.add(fila.getNombre());
                datos.add(fila.getDireccion());
                datos.add(fila.getNumeroTelef());
                datos.add(fila.getAforoMax());
                datos.add(fila.getTipoSala());
                deleteView.dtm.addRow(datos);
            }
        }
    }

    /**
     * Comprueba que tipo de objeto cargaremos en la tabla
     * Inicia la cabecera de la tabla y carga las filas de la tabla
     */
    private void checkType(){

        /*
        Si type es (0) == Artista || Si type es (1) == Grupo || Si type es (2) == Disco ||
        Si type (3) == Canción || Si type es (4) == Gira || Si type es (5) == Concierto ||
        Si type (6) == Sala.
         */
        if(type==0){

            deleteView.setTitle("Eliminar Artísta");
            initHeaderArtista();
            loadArtista();

        }else if(type==1){
            deleteView.setTitle("Eliminar Grupo");
            initHeaderGrupo();
            loadGrupo();

        }else if(type==2){
            deleteView.setTitle("Eliminar Canción");
            initHeaderCancion();
            loadCancion();

        }else if(type==3){
            deleteView.setTitle("Eliminar Disco");
            initHeaderDisco();
            loadDisco();

        }else if(type==4){
            deleteView.setTitle("Eliminar Gira");
            initHeaderGira();
            loadGira();

        }else if(type==5){
            deleteView.setTitle("Eliminar Concierto");
            initHeaderConcierto();
            loadConcierto();

        }else if(type==6){
            deleteView.setTitle("Eliminar Sala");
            initHeaderSala();
            loadSala();
        }
    }

    /**
     * Método que añade el MouseListener a la tabla.
     */
    private void addMouseListener(){

        deleteView.table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteView.dtm.isCellEditable(deleteView.table.getSelectedRow(),
                        deleteView.table.getSelectedColumn());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * Listener del bóton eliminar de la deleteView el cual ejecuta un JOPtionPane de confirmación
     * de eliminación y la elimnación del objetos seleccionado en la tabla
     */
    private void addActionListener(){

        deleteView.btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int answer = JOptionPane.showConfirmDialog(null,"¿CONFIRMA LA ELIMINACIÓN?",
                        "Confirmación de eliminación",JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if(answer==0){
                    selectDelete();
                    mainViewController.cargarArtistas();
                    deleteView.dispose();
                }else{

                }
            }
        });
    }

    private void selectDelete(){
        if(type==0){
            model.deleteArtista(getSelectRowArtista());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadArtista();
            haveChanges=true;
        }else if(type==1){
            model.deleteGrupo(getSelectRowGrupo());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadGrupo();
        }else if(type==2){
            model.deleteCancion(getSelectRowCancion());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadCancion();
        }else if(type==3){
            model.deleteDisco(getSelectRowDisco());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadDisco();
        }else if(type==4){
            model.deleteGira(getSelectRowGira());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadGira();
        }else if(type==5){
            model.deleteConcierto(getSelectRowConcierto());
            AlertUtil.messageAlert("Se ha eliminado con éxito");
            loadConcierto();
        }
    }

    public boolean isHaveChanges() {
        return haveChanges;
    }
}
