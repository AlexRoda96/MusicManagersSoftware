package com.musicmanagerssoftware.gui.controllers;

import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.views.settingviews.AccountView;
import com.musicmanagerssoftware.util.DataBaseUtil;
import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.components.ImagenAmpliadaView;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.views.MainView;
import com.musicmanagerssoftware.gui.views.addviews.*;
import com.musicmanagerssoftware.gui.views.deleteviews.DeleteView;
import com.musicmanagerssoftware.gui.views.modifyviews.*;
import com.musicmanagerssoftware.gui.views.settingviews.SettingsView;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import com.musicmanagerssoftware.util.ImageUtil;
import com.musicmanagerssoftware.util.ListUtil;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;


/**
 * MainController
 * Controlador de la vista principal.
 */
public class MainViewController implements  MouseListener, ListSelectionListener, ActionListener {

    private MainView mainView;
    private Model model;
    private DataBaseUtil dataBaseUtil;
    private DeleteViewController deleteViewController;
    private ImagenAmpliadaView imageView;
    private final String rutaDefaultImage = "ico\\NoImage.png";
    private Artista artistaSeleccionado;
    private Disco discoSeleccionado;
    private Cancion cancionSeleccionada;
    private Concierto conciertoSeleccionado;
    private Gira giraSeleccionada;
    private DeleteView deleteView;
    File guardar;
    Properties config;
    ComboBoxUtil comboBoxUtil;
    ListUtil listUtil;
    AlertUtil alertUtil;
    ImageUtil imageUtil;
    private String rol;
    User usuarioActual;


    /**
     * Constructor
     * @param mainView vista principal
     * @param model modelo
     */
    public MainViewController(MainView mainView, Model model,String rol, User usuarioActual) {
        this.model = model;
        this.rol = rol;
        this.mainView = mainView;
        this.usuarioActual=usuarioActual;
        comprobarRol();
        initUtil();
        config = new Properties();
        createConfigurationFile();
        loadConfigurationFile();
        comprobarConexionInical();
        addListeners();
        setImageAllDefaultImage();
    }

    public MainViewController(MainView vista, Model modelo, User user) {
    }

    public MainViewController() {
    }

    private void initUtil(){
        comboBoxUtil = new ComboBoxUtil();
        listUtil = new ListUtil();
        alertUtil = new AlertUtil();
        imageUtil = new ImageUtil();
        dataBaseUtil = new DataBaseUtil();
    }

    private void comprobarRol(){
        if(rol.equalsIgnoreCase("Lector")){
            mainView.menuView.menuAdd.setEnabled(false);
            mainView.menuView.menuModify.setEnabled(false);
            mainView.menuView.menuDelete.setEnabled(false);
            mainView.menuView.menuItemGestionCuenta.setEnabled(false);
        }else if(rol.equalsIgnoreCase("Editor")){
            mainView.menuView.menuAdd.setEnabled(true);
            mainView.menuView.menuModify.setEnabled(true);
            mainView.menuView.menuDelete.setEnabled(true);
            mainView.menuView.menuItemGestionCuenta.setEnabled(false);
        }else if(rol.equalsIgnoreCase("Admin")){
            mainView.menuView.menuItemGestionCuenta.setEnabled(true);
            mainView.menuView.menuAdd.setEnabled(true);
            mainView.menuView.menuModify.setEnabled(true);
            mainView.menuView.menuDelete.setEnabled(true);
        }
    }

    private void comprobarConexionInical(){
        if(config.getProperty("conectar").equalsIgnoreCase("true")){
            dataBaseUtil.conectar();
            cargarArtistas();
            mainView.menuView.menuItemConecct.setVisible(false);
        }else if(config.getProperty("conectar").equalsIgnoreCase("false")){
            mainView.menuView.menuItemDisconnect.setVisible(false);
        }
    }

    private  void addListeners(){
        addMouseListener(this);
        addSelectionListListener(this);
        addActionListener(this);
    }

    public void createConfigurationFile() {
        guardar = new File("preferencias.conf");
        if (!guardar.exists()) {
            try {
                guardar.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al crear el archivo de configuración");
            }

            config.setProperty("conectar", "true");
            config.setProperty("archivo", "true");
            config.setProperty("accion", "true");
            config.setProperty("herramienta", "true");
            config.setProperty("ayuda", "true");
            try {
                config.store(new FileWriter(guardar.getAbsolutePath()),
                        "Configuracion de preferencias");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadConfigurationFile(){
        try {
            config.load(new FileReader("preferencias.conf"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar el archivo de configuración");
        }

        if(config.getProperty("conectar").equalsIgnoreCase("true")){

        }else if(config.getProperty("conectar").equalsIgnoreCase("false")){

        }

        if(config.getProperty("archivo").equalsIgnoreCase("true")){

        }else if(config.getProperty("archivo").equalsIgnoreCase("false")){

        }

        if(config.getProperty("accion").equalsIgnoreCase("true")){
            mainView.menuView.menuObjeto.setVisible(true);
        }else if(config.getProperty("accion").equalsIgnoreCase("false")){
            mainView.menuView.menuObjeto.setVisible(false);
        }

        if(config.getProperty("herramienta").equalsIgnoreCase("true")){

        }else if(config.getProperty("herramienta").equalsIgnoreCase("false")){

        }

        if(config.getProperty("ayuda").equalsIgnoreCase("true")){

        }else if(config.getProperty("ayuda").equalsIgnoreCase("false")){

        }
    }

    private void setImageAllDefaultImage(){
        mainView.panelArtista.lbl_imagen.setIcon(defaultImagePanels("artista"));
        mainView.panelGrupo.lbl_imagen.setIcon(defaultImagePanels("grupo"));
        mainView.panelDisco.lbl_imagen.setIcon(defaultImagePanels("disco"));
        mainView.panelConcierto.lbl_imagen.setIcon(defaultImagePanels("concierto"));
        mainView.panelGira.lbl_imagen.setIcon(defaultImagePanels("gira"));
    }

    private void seleccionarArtistaTabla() {

        int fila = mainView.tabla.getSelectedRow();
        String nombreArtistico = (String) mainView.tabla.getValueAt(fila, 0);
        for (Artista artista : model.getArtista()) {
            if (artista.getNombreArtistico().equalsIgnoreCase(nombreArtistico)) {
                artistaSeleccionado = artista;
            }
        }
    }

    private void seleccionarDiscoLista() {
      discoSeleccionado= (Disco) mainView.panelDisco.list_discos.getSelectedValue();
    }

    private void seleccionarCancionLista(){
        cancionSeleccionada = (Cancion) mainView.panelCancion.list_canciones.getSelectedValue();
    }

    private void seleccionarConciertoLista(){
        conciertoSeleccionado = (Concierto) mainView.panelConcierto.list_conciertos.getSelectedValue();
    }

    private void seleccionarGiraLista(){
        giraSeleccionada = (Gira) mainView.panelGira.list_giras.getSelectedValue();
    }

    private void mostrarDatosArtista() {

        mainView.panelArtista.textField_nombreArtistico.setText(artistaSeleccionado.getNombreArtistico());
        mainView.panelArtista.textField_nombre.setText(artistaSeleccionado.getNombre());
        mainView.panelArtista.textField_primeriApellido.setText(artistaSeleccionado.getPrimerApellido());
        mainView.panelArtista.textField_segundoApellido.setText(artistaSeleccionado.getSegundoApellido());
        mainView.panelArtista.textField_dni.setText(artistaSeleccionado.getDni());
        if(artistaSeleccionado.getFechaNacimiento()==null){

        }else {
            mainView.panelArtista.textField_fechaNacimiento.setText(artistaSeleccionado.getFechaNacimiento().toString());
        }
        if(artistaSeleccionado.getGrupo()==null){
            mainView.panelArtista.textField_grupo.setText("Sin Grupo");
        }else {
            mainView.panelArtista.textField_grupo.setText(artistaSeleccionado.getGrupo().getNombre());
        }
        mainView.panelArtista.textField_nacionalidad.setText(artistaSeleccionado.getPaisNacimiento());
        mainView.panelArtista.textField_numTfn.setText(String.valueOf(artistaSeleccionado.getNumTelefono()));
        mainView.panelArtista.textField_generoMusical.setText(artistaSeleccionado.getGeneroMusical());
        mainView.panelArtista.textField_tipoMusico.setText(artistaSeleccionado.getTipoMusico());
        mainView.panelArtista.textField_discografica.setText(artistaSeleccionado.getDiscografica());
        if (artistaSeleccionado.getFoto() == null) {
            defaultImagePanels("artista");
        }else {
            mainView.panelArtista.lbl_imagen.setIcon(convertirDeByteAImage(0));
        }
        listarDiscosdeArtista();
        listarConciertosdeArtista(artistaSeleccionado);
        listarGirasdeArtista(artistaSeleccionado);
        listarCancionesdeArtista(artistaSeleccionado);
    }


    private void mostrarDatosGrupo(){

        mainView.panelGrupo.textField_nombre.setText(artistaSeleccionado.getGrupo().getNombre());
        mainView.panelGrupo.textField_generoMusical.setText(artistaSeleccionado.getGrupo().getGeneroMusical());
        mainView.panelGrupo.textField_annoDeFormacion.setText(String.valueOf(artistaSeleccionado.getGrupo().getAnnoFormacion()));
        mainView.panelGrupo.textField_discografia.setText(artistaSeleccionado.getGrupo().getDiscografica());
        if (artistaSeleccionado.getGrupo().getFoto() == null) {
            defaultImagePanels("grupo");
        }else {
            mainView.panelGrupo.lbl_imagen.setIcon(convertirDeByteAImage(1));
        }
        listarArtistasdeGrupo(artistaSeleccionado);
        listarCancionesdeGrupo(artistaSeleccionado);
        listarDiscosdeGrupo(artistaSeleccionado);
        listarConciertosdeGrupo(artistaSeleccionado);
        listarGirasdeGrupo(artistaSeleccionado);
    }

    private void mostrarDatosDisco(){

        mainView.panelDisco.textField_titulo.setText(discoSeleccionado.getTitulo());
        mainView.panelDisco.textField_artista.setText(discoSeleccionado.getArtista().toString());
        if(discoSeleccionado.getGrupo()==null){
            mainView.panelDisco.textField_grupo.setText("Sin Grupo");
        }else {
            mainView.panelDisco.textField_grupo.setText(discoSeleccionado.getGrupo().getNombre());
        }
        mainView.panelDisco.textField_fechaPublicacion.setText(discoSeleccionado.getFechaPublicacion().toString());
        mainView.panelDisco.textField_generoMusical.setText(discoSeleccionado.getGeneroMusical());
        mainView.panelDisco.textField_formato.setText(discoSeleccionado.getFormato());
        mainView.panelDisco.textField_precio.setText(discoSeleccionado.getPrecio().toString());

        if (discoSeleccionado.getCaractula() == null) {
            defaultImagePanels("disco");
        }else {
            mainView.panelDisco.lbl_imagen.setIcon(convertirDeByteAImage(2));
        }
        listarCancionesDeDisco();
    }

    private void mostrarDatosCancion(){
        mainView.panelCancion.textField_titulo.setText(cancionSeleccionada.getTitulo());
        mainView.panelCancion.textField_fechaPublicacion.setText(cancionSeleccionada.getFechaPublicacion().toString());
        mainView.panelCancion.textField_formato.setText(cancionSeleccionada.getFormato());
        mainView.panelCancion.textField_genero.setText(cancionSeleccionada.getGenero());
        mainView.panelCancion.textField_duracion.setText(String.valueOf(cancionSeleccionada.getDuracion()));
        mainView.panelCancion.textField_videoclip.setText(cancionSeleccionada.getVideoclip());

        if(cancionSeleccionada.getArtista()==null){
            mainView.panelCancion.textField_artista.setText("Sin Artista");
        }else {
            mainView.panelCancion.textField_artista.setText(cancionSeleccionada.getArtista().getNombreArtistico());
        }
        if(cancionSeleccionada.getGrupo()==null){
            mainView.panelCancion.textField_grupo.setText("Sin grupo");
        }else {
            mainView.panelCancion.textField_grupo.setText(cancionSeleccionada.getGrupo().getNombre());
        }
        if(cancionSeleccionada.getDisco()==null){
            mainView.panelCancion.textField_disco.setText("Sin Disco");
        }else {
            mainView.panelCancion.textField_disco.setText(cancionSeleccionada.getDisco().getTitulo());
        }
        listarConciertosDeCancion();
    }

    private void mostrarDatosConciertos(){
        mainView.panelConcierto.textField_nombre.setText(conciertoSeleccionado.getNombre());
        mainView.panelConcierto.textField_fechaConcierto.setText(conciertoSeleccionado.getFecha().toString());
        mainView.panelConcierto.textField_fechaSalidaEntradas.setText(conciertoSeleccionado.getFechaSalidaEntradas().toString());
        mainView.panelConcierto.textField_precioEntrada.setText(conciertoSeleccionado.getPrecioEntrada().toString());
        mainView.panelConcierto.textField_horaApertura.setText(String.valueOf(conciertoSeleccionado.getHoraApertura()));
        mainView.panelConcierto.textField_edadMinima.setText(conciertoSeleccionado.getEdadMinima().toString());
        mainView.panelConcierto.textField_numEntradas.setText(conciertoSeleccionado.getNumeroEntradas().toString());
        if(conciertoSeleccionado.getMerchan()==true){
            mainView.panelConcierto.textField_merchan.setText("Sí");
        }else{
            mainView.panelConcierto.textField_merchan.setText("No");
        }
        if(conciertoSeleccionado.getGira()==null){
            mainView.panelConcierto.textField_gira.setText("");
        }else {
            mainView.panelConcierto.textField_gira.setText(conciertoSeleccionado.getGira().toString());
        }

        if(conciertoSeleccionado.getArtista()==null){
            mainView.panelConcierto.textField_artista.setText("");
        }else {
            mainView.panelConcierto.textField_artista.setText(conciertoSeleccionado.getArtista().toString());
        }

        if(conciertoSeleccionado.getGrupo()==null){
            mainView.panelConcierto.textField_grupo.setText("");
        }else {
            mainView.panelConcierto.textField_grupo.setText(conciertoSeleccionado.getGrupo().toString());
        }

        if(conciertoSeleccionado.getSala()==null){
            mainView.panelConcierto.textField_Sala.setText("");
        }else {
            mainView.panelConcierto.textField_Sala.setText(conciertoSeleccionado.getSala().toString());
        }

        if(conciertoSeleccionado.getCartel()==null){
            defaultImagePanels("concierto");
        }else {
            mainView.panelConcierto.lbl_imagen.setIcon(convertirDeByteAImage(3));
        }

        mainView.panelConcierto.textField_pais.setText(conciertoSeleccionado.getSala().getPais());
        mainView.panelConcierto.textField_ciudad.setText(conciertoSeleccionado.getSala().getCiudad());

    }

    private void mostrarDatosGiras(){
        mainView.panelGira.textField_nombre.setText(giraSeleccionada.getNombre());
        if(giraSeleccionada.getArtista()==null){
            mainView.panelGira.textField_artista.setText("");
        }else {
            mainView.panelGira.textField_artista.setText(giraSeleccionada.getArtista().toString());
        }

        if(giraSeleccionada.getGrupo()==null){
            mainView.panelGira.textField_grupo.setText("");
        }else {
            mainView.panelGira.textField_grupo.setText(giraSeleccionada.getGrupo().toString());
        }

        mainView.panelGira.textField_fechaInico.setText(giraSeleccionada.getFechaInicio().toString());
        mainView.panelGira.textField_fechaFin.setText(giraSeleccionada.getFechaFin().toString());

        if(giraSeleccionada.getCartel()==null){
            defaultImagePanels("gira");
        }else{
            mainView.panelGira.lbl_imagen.setIcon(convertirDeByteAImage(4));
        }
        listarConciertosDeGira();
    }


    private void listarConciertosdeArtista(Artista artistaSeleccionado) {

        List<Concierto> listaConciertos;
        Artista artista = artistaSeleccionado;
        listaConciertos=artista.getConciertos();
        mainView.panelArtista.dlmConciertos.clear();
        mainView.panelConcierto.dlmConcierto.clear();
        for (Concierto concierto : listaConciertos) {
            mainView.panelArtista.dlmConciertos.addElement(concierto);
            mainView.panelConcierto.dlmConcierto.addElement(concierto);
        }
    }

    private void listarDiscosdeArtista() {

        List<Disco> listaDiscos;
        listaDiscos=artistaSeleccionado.getDiscos();
        mainView.panelArtista.dlmDiscos.clear();
        for (Disco disco : listaDiscos) {
            mainView.panelArtista.dlmDiscos.addElement(disco);
            mainView.panelDisco.dlmDiscos.addElement(disco);
        }
    }


    private void listarCancionesdeArtista(Artista artistaSeleccionado) {

        List<Cancion> listaCanciones;
        Artista artista = artistaSeleccionado;
        listaCanciones=artista.getCanciones();
        mainView.panelArtista.dlmCanciones.clear();
        mainView.panelCancion.dlmCanciones.clear();
        for (Cancion cancion : listaCanciones) {
            mainView.panelArtista.dlmCanciones.addElement(cancion);
            mainView.panelCancion.dlmCanciones.addElement(cancion);
        }
    }

    private void listarGirasdeArtista(Artista artistaSeleccionado) {

        List<Gira> listaGiras;
        Artista artista = artistaSeleccionado;
        listaGiras=artista.getGiras();
        mainView.panelArtista.dlmGiras.clear();
        mainView.panelGira.dlmGira.clear();
        for (Gira gira : listaGiras) {
            mainView.panelArtista.dlmGiras.addElement(gira);
            mainView.panelGira.dlmGira.addElement(gira);
        }
    }

    private void listarCancionesdeGrupo(Artista artistaSeleccionado) {

            List<Cancion> listaCanciones;
            Grupo grupo = artistaSeleccionado.getGrupo();
            listaCanciones=grupo.getCanciones();
            mainView.panelGrupo.dlmCanciones.clear();
            for (Cancion cancion : listaCanciones) {
                mainView.panelGrupo.dlmCanciones.addElement(cancion);

        }
    }

    private void listarDiscosdeGrupo(Artista artistaSeleccionado) {

        List<Disco> listaDiscos;
        Grupo grupo = artistaSeleccionado.getGrupo();
        listaDiscos=grupo.getDiscos();
        mainView.panelGrupo.dlmDiscos.clear();
        for (Disco disco : listaDiscos) {
            mainView.panelGrupo.dlmDiscos.addElement(disco);

        }
    }

    private void listarConciertosdeGrupo(Artista artistaSeleccionado) {

        List<Concierto> listaConciertos;
        Grupo grupo = artistaSeleccionado.getGrupo();
        listaConciertos=grupo.getConciertos();
        mainView.panelGrupo.dlmConciertos.clear();
        for (Concierto concierto : listaConciertos) {
            mainView.panelGrupo.dlmConciertos.addElement(concierto);

        }
    }

    private void listarGirasdeGrupo(Artista artistaSeleccionado) {

        List<Gira> listaGiras;
        Grupo grupo = artistaSeleccionado.getGrupo();
        listaGiras=grupo.getGiras();
        mainView.panelGrupo.dlmGiras.clear();
        for (Gira gira : listaGiras) {
            mainView.panelGrupo.dlmGiras.addElement(gira);

        }
    }

    private void listarArtistasdeGrupo(Artista artistaSeleccionado) {

        List<Artista> listaArtistas;
        Grupo grupo = artistaSeleccionado.getGrupo();
        listaArtistas=grupo.getArtistas();
        mainView.panelGrupo.dlmArtistas.clear();
        for (Artista artista : listaArtistas) {
            mainView.panelGrupo.dlmArtistas.addElement(artista);

        }
    }

    private void listarCancionesDeDisco(){
        List<Cancion> listaCanciones;
        Disco disco = discoSeleccionado;
        listaCanciones=disco.getCanciones();
        mainView.panelDisco.dlmCancion.clear();
        for (Cancion cancion : listaCanciones) {
            mainView.panelDisco.dlmCancion.addElement(cancion);

        }
    }

    private void listarConciertosDeCancion(){
        List<Concierto> listaConciertos;
        Cancion cancion = cancionSeleccionada;
        listaConciertos=cancion.getConcierto();
        mainView.panelCancion.dlmConciertos.clear();
        for (Concierto concierto : listaConciertos) {
            mainView.panelCancion.dlmConciertos.addElement(concierto);
        }
    }

    private void listarCancionesDeConcierto(){
        List<Cancion> listaCanciones;
        Concierto concierto = conciertoSeleccionado;
        listaCanciones=concierto.getCanciones();
        mainView.panelConcierto.dlmCanciones.clear();
        for (Cancion cancion : listaCanciones) {
            mainView.panelConcierto.dlmCanciones.addElement(cancion);
        }
    }

    private void listarConciertosDeGira(){
        List<Concierto> listaConciertos;
        Gira gira = giraSeleccionada;
        listaConciertos=gira.getConciertos();
        mainView.panelGira.dlmConcierto.clear();
        for (Concierto concierto : listaConciertos) {
            mainView.panelGira.dlmConcierto.addElement(concierto);
        }
    }

    private Icon defaultImagePanels(String panelSelected){
        ImageIcon icon = new ImageIcon(rutaDefaultImage);
        Icon icono = null;
        if(panelSelected.equalsIgnoreCase("artista")){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelArtista.lbl_imagen.getWidth(), mainView.panelArtista.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelArtista.lbl_imagen.setIcon(icono);
        }else if(panelSelected.equalsIgnoreCase("grupo")){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGrupo.lbl_imagen.getWidth(), mainView.panelGrupo.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelGrupo.lbl_imagen.setIcon(icono);
        }else if(panelSelected.equalsIgnoreCase("disco")){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelDisco.lbl_imagen.getWidth(), mainView.panelDisco.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelDisco.lbl_imagen.setIcon(icono);
        }else if(panelSelected.equalsIgnoreCase("concierto")){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelConcierto.lbl_imagen.getWidth(), mainView.panelConcierto.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelConcierto.lbl_imagen.setIcon(icono);
        }else if(panelSelected.equalsIgnoreCase("gira")){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGira.lbl_imagen.getWidth(), mainView.panelGira.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelGira.lbl_imagen.setIcon(icono);
        }
        return icono;
    }

    /**
     * Método que devuelve un Icon con la imagen defaultImage
     * @return Icon icono
     */
    private Icon defaultImageView(){

        ImageIcon icon = new ImageIcon(rutaDefaultImage);
        Icon icono = null;

        icono = new ImageIcon(icon.getImage().getScaledInstance(imageView.lbl_image.getWidth(), imageView.lbl_image.getHeight(),
                Image.SCALE_DEFAULT));

        return icono;
    }

    /**
     * Limpia los campos de todos los paneles
     */
    private void limpiarCampos(){
        limpiarCamposArtista();
        limpiarCamposGrupo();
        limpiarCamposDisco();
        limpiarCamposCancion();
        limpiarCamposConcierto();
        limpiarCamposGira();
    }

    /**
     * Limpia los campos del panel artistas
     */
    private void limpiarCamposArtista(){

        //Limpiar los campos de texto
        mainView.panelArtista.textField_nombreArtistico.setText("");
        mainView.panelArtista.textField_nombre.setText("");
        mainView.panelArtista.textField_primeriApellido.setText("");
        mainView.panelArtista.textField_segundoApellido.setText("");
        mainView.panelArtista.textField_dni.setText("");
        mainView.panelArtista.textField_fechaNacimiento.setText("");
        mainView.panelArtista.textField_nacionalidad.setText("");
        mainView.panelArtista.textField_numTfn.setText("");
        mainView.panelArtista.textField_grupo.setText("");
        mainView.panelArtista.textField_generoMusical.setText("");
        mainView.panelArtista.textField_tipoMusico.setText("");
        mainView.panelArtista.dlmCanciones.clear();
        mainView.panelArtista.dlmDiscos.clear();
        mainView.panelArtista.dlmConciertos.clear();
        mainView.panelArtista.dlmGiras.clear();
        mainView.panelArtista.lbl_imagen.setIcon(defaultImagePanels("artista"));
    }

    /**
     * Limpia los campos del panel grupo
     */
    private void limpiarCamposGrupo(){
        mainView.panelGrupo.textField_nombre.setText("");
        mainView.panelGrupo.textField_annoDeFormacion.setText("");
        mainView.panelGrupo.textField_discografia.setText("");
        mainView.panelGrupo.textField_generoMusical.setText("");
        mainView.panelGrupo.dlmCanciones.clear();
        mainView.panelGrupo.dlmDiscos.clear();
        mainView.panelGrupo.dlmConciertos.clear();
        mainView.panelGrupo.dlmGiras.clear();
        mainView.panelGrupo.lbl_imagen.setIcon(defaultImagePanels("grupo"));
    }

    private void limpiarCamposDisco(){
        mainView.panelDisco.textField_titulo.setText("");
        mainView.panelDisco.textField_artista.setText("");
        mainView.panelDisco.textField_grupo.setText("");
        mainView.panelDisco.textField_fechaPublicacion.setText("");
        mainView.panelDisco.textField_generoMusical.setText("");
        mainView.panelDisco.textField_formato.setText("");
        mainView.panelDisco.textField_precio.setText("");
        mainView.panelDisco.dlmDiscos.clear();
        mainView.panelDisco.lbl_imagen.setIcon(defaultImagePanels("disco"));
    }

    private void limpiarCamposCancion(){
        mainView.panelCancion.textField_titulo.setText("");
        mainView.panelCancion.textField_fechaPublicacion.setText("");
        mainView.panelCancion.textField_formato.setText("");
        mainView.panelCancion.textField_genero.setText("");
        mainView.panelCancion.textField_duracion.setText("");
        mainView.panelCancion.textField_videoclip.setText("");
        mainView.panelCancion.textField_artista.setText("");
        mainView.panelCancion.textField_grupo.setText("");
        mainView.panelCancion.textField_disco.setText("");
        mainView.panelDisco.lbl_imagen.setIcon(defaultImagePanels("cancion"));
        mainView.panelCancion.dlmConciertos.clear();
    }

    private void limpiarCamposGira(){
        mainView.panelGira.textField_nombre.setText("");
        mainView.panelGira.textField_artista.setText("");
        mainView.panelGira.textField_grupo.setText("");
        mainView.panelGira.textField_fechaFin.setText("");
        mainView.panelGira.textField_fechaInico.setText("");
        mainView.panelGira.lbl_imagen.setIcon(defaultImagePanels("gira"));
        mainView.panelGira.dlmConcierto.clear();
    }

    private void limpiarCamposConcierto(){
        mainView.panelConcierto.textField_nombre.setText("");
        mainView.panelConcierto.textField_pais.setText("");
        mainView.panelConcierto.textField_ciudad.setText("");
        mainView.panelConcierto.textField_fechaConcierto.setText("");
        mainView.panelConcierto.textField_numEntradas.setText("");
        mainView.panelConcierto.textField_fechaSalidaEntradas.setText("");
        mainView.panelConcierto.textField_precioEntrada.setText("");
        mainView.panelConcierto.textField_horaApertura.setText("");
        mainView.panelConcierto.textField_merchan.setText("");
        mainView.panelConcierto.textField_edadMinima.setText("");
        mainView.panelConcierto.textField_Sala.setText("");
        mainView.panelConcierto.textField_gira.setText("");
        mainView.panelConcierto.textField_grupo.setText("");
        mainView.panelConcierto.textField_artista.setText("");
        mainView.panelConcierto.lbl_imagen.setIcon(defaultImagePanels("concierto"));
        mainView.panelCancion.dlmConciertos.clear();
    }

    private Icon convertirDeByteAImage(int panel){

        ByteArrayInputStream bis = null;

        if(panel==0){

            bis = new ByteArrayInputStream(artistaSeleccionado.getFoto());
        }else if(panel==1){

            bis = new ByteArrayInputStream(artistaSeleccionado.getGrupo().getFoto());
        }else if(panel==2) {

            bis = new ByteArrayInputStream(discoSeleccionado.getCaractula());
        }else if(panel==3) {

            bis = new ByteArrayInputStream(conciertoSeleccionado.getCartel());
        }else if(panel==4) {

            bis = new ByteArrayInputStream(giraSeleccionada.getCartel());
        }


        BufferedImage bImage2 = null;
        try {
            bImage2 = ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon icon = new ImageIcon(bImage2);
        Icon icono = null;
        if(panel==0) {
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelArtista.lbl_imagen.getWidth(), mainView.panelArtista.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }else if(panel==1){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGrupo.lbl_imagen.getWidth(), mainView.panelGrupo.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }else if(panel==2){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelDisco.lbl_imagen.getWidth(), mainView.panelDisco.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }else if(panel==3){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelConcierto.lbl_imagen.getWidth(), mainView.panelConcierto.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }else if(panel==4){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGira.lbl_imagen.getWidth(), mainView.panelGira.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }
        return icono;
    }



    /**
     * Inicia la tabla artista
     */
    private void iniciarTablaArtista() {
        mainView.dtmArtistas.setRowCount(0);
        //Creamos un array de String con los headers de los atributos
        String[] headers = {"Nombre Artístico", "Nombre", "Primer Apellido", "Segundo Apellido"};
        //Añadimos los headers de los atributos
        mainView.dtmArtistas.setColumnIdentifiers(headers);
    }

    /**
     * Carga los artistas a la tabla
     */
    public void cargarArtistas() {
        iniciarTablaArtista();
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
                mainView.dtmArtistas.addRow(datos);
            }
        }
    }

    private void addMouseListener(MouseListener listener) {
        mainView.tabla.addMouseListener(listener);
        mainView.panelDisco.list_discos.addMouseListener(listener);
        mainView.panelCancion.list_canciones.addMouseListener(listener);
        mainView.panelConcierto.list_conciertos.addMouseListener(listener);
        mainView.panelGira.list_giras.addMouseListener(listener);
    }

    private void addSelectionListListener(ListSelectionListener listener){
        mainView.panelGrupo.list_artistas.addListSelectionListener(listener);
        mainView.panelArtista.list_conciertos.addListSelectionListener(listener);
        mainView.panelArtista.list_discos.addListSelectionListener(listener);
        mainView.panelArtista.list_canciones.addListSelectionListener(listener);
        mainView.panelArtista.list_giras.addListSelectionListener(listener);
        mainView.panelDisco.list_discos.addListSelectionListener(listener);
    }

    private void addActionListener(ActionListener listener){
        //Ampliar
        mainView.panelArtista.btn_ampliar.addActionListener(listener);
        mainView.panelGrupo.button_ampliar.addActionListener(listener);
        mainView.panelDisco.button_ampliar.addActionListener(listener);
        mainView.panelGira.button_ampliar.addActionListener(listener);
        mainView.panelConcierto.button_ampliar.addActionListener(listener);
        //Add
        mainView.menuView.addItemArtista.addActionListener(listener);
        mainView.menuView.addItemGrupo.addActionListener(listener);
        mainView.menuView.addItemDisco.addActionListener(listener);
        mainView.menuView.addItemCancion.addActionListener(listener);
        mainView.menuView.addItemGira.addActionListener(listener);
        mainView.menuView.addItemConcierto.addActionListener(listener);
        mainView.menuView.addItemSala.addActionListener(listener);
        //Delete
        mainView.menuView.deleteItemArtista.addActionListener(listener);
        mainView.menuView.deleteItemGrupo.addActionListener(listener);
        mainView.menuView.deleteItemCancion.addActionListener(listener);
        mainView.menuView.deleteItemDisco.addActionListener(listener);
        mainView.menuView.deleteItemConcierto.addActionListener(listener);
        mainView.menuView.deleteItemGira.addActionListener(listener);
        mainView.menuView.deleteItemSala.addActionListener(listener);
        //Modify
        mainView.menuView.modifyItemArtista.addActionListener(listener);
        mainView.menuView.modifyItemGrupo.addActionListener(listener);
        mainView.menuView.modifyItemCancion.addActionListener(listener);
        mainView.menuView.modifyItemDisco.addActionListener(listener);
        mainView.menuView.modifyItemConcierto.addActionListener(listener);
        mainView.menuView.modifyItemGira.addActionListener(listener);
        mainView.menuView.modifyItemSala.addActionListener(listener);
        //Menu
        mainView.menuView.menuAdd.addActionListener(listener);
        mainView.menuView.menuItemPreferencias.addActionListener(listener);
        mainView.menuView.menuItemConecct.addActionListener(listener);
        mainView.menuView.menuItemDisconnect.addActionListener(listener);
        mainView.menuView.menuItemCuenta.addActionListener(listener);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == mainView.tabla) {

            seleccionarArtistaTabla();
            mainView.dtmArtistas.isCellEditable(mainView.tabla.getSelectedRow(),mainView.tabla.getSelectedColumn());
            mainView.tabbedPane.setSelectedIndex(0);
            limpiarCampos();
            mostrarDatosArtista();
            mostrarDatosGrupo();

        }else if(e.getSource()==mainView.panelGrupo){

            if(artistaSeleccionado.getGrupo()==null){

            }else {
                mostrarDatosGrupo();
            }


        }else if(e.getSource()==mainView.panelDisco.list_discos){

            if(artistaSeleccionado.getDiscos().isEmpty()){

            }else {

                seleccionarDiscoLista();
                mostrarDatosDisco();
            }

        }else if(e.getSource()==mainView.panelCancion.list_canciones) {

            if (artistaSeleccionado.getCanciones().isEmpty()) {

            } else {

                seleccionarCancionLista();
                mostrarDatosCancion();
            }
        }else if(e.getSource()==mainView.panelConcierto.list_conciertos) {

            if (artistaSeleccionado.getConciertos().isEmpty()) {

            } else {

                seleccionarConciertoLista();
                mostrarDatosConciertos();
            }
        }else if(e.getSource()==mainView.panelGira.list_giras) {

            if (artistaSeleccionado.getGiras().isEmpty()) {

            } else {

                seleccionarGiraLista();
                mostrarDatosGiras();
            }
        }
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

    @Override
    public void valueChanged(ListSelectionEvent e) {


    }

    private Icon ampliar(String panel){
        ByteArrayInputStream bis = null;

        if (panel.equalsIgnoreCase("artista")) {
            bis = new ByteArrayInputStream(artistaSeleccionado.getFoto());
        } else if (panel.equalsIgnoreCase("grupo")) {
            bis = new ByteArrayInputStream(artistaSeleccionado.getGrupo().getFoto());
        }else if (panel.equalsIgnoreCase("disco")) {
            bis = new ByteArrayInputStream(discoSeleccionado.getCaractula());
        }else if (panel.equalsIgnoreCase("gira")) {
            bis = new ByteArrayInputStream(giraSeleccionada.getCartel());
        }else if (panel.equalsIgnoreCase("concierto")) {
            bis = new ByteArrayInputStream(conciertoSeleccionado.getCartel());
        }

        BufferedImage bImage2 = null;
        try {
            bImage2 = ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon icon = new ImageIcon(bImage2);
        Icon icono = null;
        icono = new ImageIcon(icon.getImage().getScaledInstance(imageView.lbl_image.getWidth(), imageView.lbl_image.getHeight(),
                Image.SCALE_DEFAULT));

        return icono;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Ampliar Imagen Artista":
                imageView = new ImagenAmpliadaView();
                if(artistaSeleccionado.getFoto()==null){
                    imageView.lbl_image.setIcon(defaultImageView());
                }else {
                    imageView.lbl_image.setIcon(ampliar("artista"));
                    imageView.setTitle(artistaSeleccionado.getNombreArtistico());
                }
                break;

            case "Ampliar Imagen Grupo":
                imageView = new ImagenAmpliadaView();
                if(artistaSeleccionado.getGrupo().getFoto()==null){
                    imageView.lbl_image.setIcon(defaultImageView());
                }else{
                imageView.lbl_image.setIcon(ampliar("grupo"));
                imageView.setTitle(artistaSeleccionado.getGrupo().getNombre());
            }
                break;

            case "Ampliar Imagen Disco":
                imageView = new ImagenAmpliadaView();
                if(discoSeleccionado.getCaractula()==null){
                    imageView.lbl_image.setIcon(defaultImageView());
                }else{
                    imageView.lbl_image.setIcon(ampliar("disco"));
                    imageView.setTitle(discoSeleccionado.getTitulo());
                }
                break;

            case "Ampliar Imagen Concierto":
                imageView = new ImagenAmpliadaView();
                if(conciertoSeleccionado.getCartel()==null){
                    imageView.lbl_image.setIcon(defaultImageView());
                }else{
                    imageView.lbl_image.setIcon(ampliar("concierto"));
                    imageView.setTitle(conciertoSeleccionado.getCiudad() + " " + conciertoSeleccionado.getFecha());
                }
                break;

            case "Ampliar Imagen Gira":
                imageView = new ImagenAmpliadaView();
                if(giraSeleccionada.getCartel()==null){
                    imageView.lbl_image.setIcon(defaultImageView());
                }else{
                    imageView.lbl_image.setIcon(ampliar("gira"));
                    imageView.setTitle(giraSeleccionada.getNombre());
                }
                break;

            case "Add Artista":
                ViewAddArtista viewAddArtista = new ViewAddArtista(imageUtil,alertUtil,model);
                if(viewAddArtista.isHaveChanges()==true) {
                   cargarArtistas();
                }
                break;

            case "Add Grupo":
                ViewAddGrupo viewAddGrupo = new ViewAddGrupo();
                break;

            case "Add Disco":
                ViewAddDisco viewAddDisco = new ViewAddDisco(imageUtil,alertUtil,model);
                break;

            case "Add Cancion":
                ViewAddCancion viewAddCancion = new ViewAddCancion(alertUtil,model);
                break;

            case "Add Gira":
                ViewAddGira musicGira = new ViewAddGira(imageUtil,alertUtil,model);
                break;

            case "Add Concierto":
                ViewAddConcierto viewAddConcierto = new ViewAddConcierto(imageUtil,alertUtil,model);
                break;

            case "Add Sala":
                ViewAddSala viewAddSala = new ViewAddSala(imageUtil,alertUtil,model);
                break;

            case "Delete Artista":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,0,this);
                if(deleteViewController.isHaveChanges()==true){
                    cargarArtistas();
                }
                break;

            case "Delete Grupo":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,1,this);
              break;

            case "Delete Cancion":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,2,this);
                break;

            case "Delete Disco":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,3,this);
                break;

            case "Delete Gira":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,4,this);
                break;

            case "Delete Concierto":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,5,this);
                break;

            case "Delete Sala":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,6,this);
                break;

            case "Modify Artista":
                ViewModifyArtista viewModifyArtista = new ViewModifyArtista(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                cargarArtistas();
                break;

            case "Modify Grupo":
                ViewModifyGrupo viewModifyGrupo = new ViewModifyGrupo(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Modify Cancion":
                ViewModifyCancion viewModifyCancion = new ViewModifyCancion(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Modify Disco":
                ViewModifyDisco viewModifyDisco = new ViewModifyDisco(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Modify Gira":
                ViewModifyGira viewModifyGira= new ViewModifyGira(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Modify Concierto":
                ViewModifyConcierto viewModifyConcierto = new ViewModifyConcierto(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Modify Sala":
                ViewModifySala viewModifySala = new ViewModifySala(alertUtil,comboBoxUtil,listUtil,imageUtil,model);
                mainView.tabbedPane.setSelectedIndex(0);
                limpiarCampos();
                break;

            case "Menu Connect":
                dataBaseUtil = new DataBaseUtil();
                dataBaseUtil.conectar();
                cargarArtistas();
                mainView.menuView.menuItemConecct.setVisible(false);
                mainView.menuView.menuItemDisconnect.setVisible(true);
                break;

            case "Menu Disconnect":
                dataBaseUtil = new DataBaseUtil();
                dataBaseUtil.desconectar();
                mainView.menuView.menuItemDisconnect.setVisible(false);
                mainView.menuView.menuItemConecct.setVisible(true);
                mainView.dtmArtistas.setRowCount(0);
                break;

            case "Account":
                AccountView accountView = new AccountView(usuarioActual);
                break;


        }
    }

}
