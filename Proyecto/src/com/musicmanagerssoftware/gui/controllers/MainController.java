package com.musicmanagerssoftware.gui.controllers;

import com.musicmanagerssoftware.DataBase;
import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.componentes.ImagenAmpliadaView;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.views.MainView;

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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class MainController implements  MouseListener, ListSelectionListener, ActionListener {

    private MainView mainView;
    private Model model;
    private DataBase dataBase;
    private ImagenAmpliadaView imageView;

    public MainController(MainView mainView, Model model) {
        this.mainView = mainView;
        this.model = model;
        dataBase = new DataBase();
        dataBase.conectar();
        addMouseListener(this);
        addSelectionListListener(this);
        addActionListener(this);
        iniciarTablaArtista();
        cargarArtistas();
    }

    private Artista seleccionarArtistaLista() {
        Artista artistaSeleccionado = null;

        int fila = mainView.tabla.getSelectedRow();
        String nombreArtistico = (String) mainView.tabla.getValueAt(fila, 0);
        for (Artista artista : model.getArtista()) {
            if (artista.getNombreArtistico().equalsIgnoreCase(nombreArtistico)) {
                artistaSeleccionado = artista;
            }
        }
        return artistaSeleccionado;
    }

    private void mostrarDatosArtista() {
        Artista artistaSeleccionado;

        artistaSeleccionado=seleccionarArtistaLista();
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
        mainView.panelArtista.textField_numTfn.setText(artistaSeleccionado.getNumTelefono());
        mainView.panelArtista.textField_generoMusical.setText(artistaSeleccionado.getGeneroMusical());
        mainView.panelArtista.textField_tipoMusico.setText(artistaSeleccionado.getTipoMusico());
        if (artistaSeleccionado.getFoto() == null) {
            defaultImage(0);
        }else {
            mainView.panelArtista.lbl_imagen.setIcon(convertirDeByteAImage(0,artistaSeleccionado));
        }
        listarConciertosdeArtista(artistaSeleccionado);
        listarDiscosdeArtista(artistaSeleccionado);
        listarGirasdeArtista(artistaSeleccionado);
        listarCancionesdeArtista(artistaSeleccionado);
    }


    private void mostrarDatosGrupo(){
        Artista artistaSeleccionado;

        artistaSeleccionado=seleccionarArtistaLista();
        mainView.panelGrupo.textField_nombre.setText(artistaSeleccionado.getGrupo().getNombre());
        mainView.panelGrupo.textField_generoMusical.setText(artistaSeleccionado.getGrupo().getGeneroMusical());
        mainView.panelGrupo.textField_annoDeFormacion.setText(artistaSeleccionado.getGrupo().getAnnoFormacion());
        mainView.panelGrupo.textField_discografia.setText(artistaSeleccionado.getGrupo().getDiscografica());
        if (artistaSeleccionado.getGrupo().getFoto() == null) {
            defaultImage(1);
        }else {
            mainView.panelGrupo.lbl_imagen.setIcon(convertirDeByteAImage(1,artistaSeleccionado));
        }
        listarArtistasdeGrupo(artistaSeleccionado);
        listarCancionesdeGrupo(artistaSeleccionado);
        listarDiscosdeGrupo(artistaSeleccionado);
        listarConciertosdeGrupo(artistaSeleccionado);
        listarGirasdeGrupo(artistaSeleccionado);
    }

    private void listarConciertosdeArtista(Artista artistaSeleccionado) {

        List<Concierto> listaConciertos;
        Artista artista = artistaSeleccionado;
        listaConciertos=artista.getConciertos();
        mainView.panelArtista.dlmConciertos.clear();
        for (Concierto concierto : listaConciertos) {
            mainView.panelArtista.dlmConciertos.addElement(concierto);
        }
    }

    private void listarDiscosdeArtista(Artista artistaSeleccionado) {

        List<Disco> listaDiscos;
        Artista artista = artistaSeleccionado;
        listaDiscos=artista.getDiscos();
        mainView.panelArtista.dlmDiscos.clear();
        for (Disco disco : listaDiscos) {
            mainView.panelArtista.dlmDiscos.addElement(disco);
        }
    }

    private void listarCancionesdeArtista(Artista artistaSeleccionado) {

        List<Cancion> listaCanciones;
        Artista artista = artistaSeleccionado;
        listaCanciones=artista.getCanciones();
        mainView.panelArtista.dlmCanciones.clear();
        for (Cancion cancion : listaCanciones) {
            mainView.panelArtista.dlmCanciones.addElement(cancion);
        }
    }

    private void listarGirasdeArtista(Artista artistaSeleccionado) {

        List<Gira> listaGiras;
        Artista artista = artistaSeleccionado;
        listaGiras=artista.getGiras();
        mainView.panelArtista.dlmGiras.clear();
        for (Gira gira : listaGiras) {
            mainView.panelArtista.dlmGiras.addElement(gira);
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


    private Icon defaultImage(int panel){
        ImageIcon icon = new ImageIcon("ico\\NoImage.png");
        Icon icono = null;
        if(panel==0){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelArtista.lbl_imagen.getWidth(), mainView.panelArtista.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelArtista.lbl_imagen.setIcon(icono);
        }else if(panel==1){
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGrupo.lbl_imagen.getWidth(), mainView.panelGrupo.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
            mainView.panelGrupo.lbl_imagen.setIcon(icono);
        }else if(panel==2) {
            icono = new ImageIcon(icon.getImage().getScaledInstance(mainView.panelGrupo.lbl_imagen.getWidth(), mainView.panelGrupo.lbl_imagen.getHeight(),
                    Image.SCALE_DEFAULT));
        }else if(panel==10) {
            icono = new ImageIcon(icon.getImage().getScaledInstance(imageView.lbl_image.getWidth(), imageView.lbl_image.getHeight(),
                    Image.SCALE_DEFAULT));
        }
        return icono;

    }

    private void limpiarCamposArtista(){
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
        defaultImage(0);
    }

    private Icon convertirDeByteAImage(int panel,Artista artista){

        ByteArrayInputStream bis = null;

        if(panel==0){

            bis = new ByteArrayInputStream(artista.getFoto());
        }else if(panel==1){

            bis = new ByteArrayInputStream(artista.getGrupo().getFoto());
        }else if(panel==2) {

            bis = new ByteArrayInputStream(artista.getFoto());
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
            icono = new ImageIcon(icon.getImage().getScaledInstance(imageView.lbl_image.getWidth(), imageView.lbl_image.getHeight(),
                    Image.SCALE_DEFAULT));
        }
        return icono;
    }


    private void iniciarTablaArtista() {
//Creamos un array de String con los headers de los atributos
        String[] headers = {"Nombre Artístico", "Nombre", "Primer Apellido", "Segundo Apellido"};
        //Añadimos los headers de los atributos
        mainView.dtmArtistas.setColumnIdentifiers(headers);
    }

    private void cargarArtistas() {

        mainView.dtmArtistas.setRowCount(0);
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
    }

    private void addSelectionListListener(ListSelectionListener listener){
        mainView.panelGrupo.list_artistas.addListSelectionListener(listener);
        mainView.panelArtista.list_conciertos.addListSelectionListener(listener);
        mainView.panelArtista.list_discos.addListSelectionListener(listener);
        mainView.panelArtista.list_canciones.addListSelectionListener(listener);
        mainView.panelArtista.list_giras.addListSelectionListener(listener);
    }

    private void addActionListener(ActionListener listener){
        mainView.panelArtista.btn_ampliar.addActionListener(listener);
        mainView.panelGrupo.button_ampliar.addActionListener(listener);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == mainView.tabla) {
            mainView.dtmArtistas.isCellEditable(mainView.tabla.getSelectedRow(),mainView.tabla.getSelectedColumn());
            mainView.tabbedPane.setSelectedIndex(0);
            limpiarCamposArtista();
            mostrarDatosArtista();
            mostrarDatosGrupo();

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

    private Icon ampliar(int panel){
        ByteArrayInputStream bis = null;

        if(panel==0){
            if(seleccionarArtistaLista().getFoto()==null){
                imageView.lbl_image.setIcon(defaultImage(10));
                imageView.setTitle("Imagen no encontrada");
            }else {
                bis = new ByteArrayInputStream(seleccionarArtistaLista().getFoto());
            }
        }else if(panel==1) {
            if(seleccionarArtistaLista().getGrupo().getFoto()==null){
                imageView.lbl_image.setIcon(defaultImage(10));
                imageView.setTitle("Imagen no encontrada");
            }else {
                bis = new ByteArrayInputStream(seleccionarArtistaLista().getGrupo().getFoto());
            }
        }else if(panel==2) {
            bis = new ByteArrayInputStream(seleccionarArtistaLista().getGrupo().getFoto());
        }else if(panel==3) {
            bis = new ByteArrayInputStream(seleccionarArtistaLista().getGrupo().getFoto());
        }else if(panel==4) {
            bis = new ByteArrayInputStream(seleccionarArtistaLista().getGrupo().getFoto());
        }else if(panel==5) {
            bis = new ByteArrayInputStream(seleccionarArtistaLista().getGrupo().getFoto());
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
                imageView.lbl_image.setIcon(ampliar(0));
                imageView.setTitle(seleccionarArtistaLista().getNombreArtistico());
                break;

            case "Ampliar Imagen Grupo":
                imageView = new ImagenAmpliadaView();
                imageView.lbl_image.setIcon(ampliar(1));
                imageView.setTitle(seleccionarArtistaLista().getGrupo().getNombre());
                break;

            case "Ampliar Imagen Cancion":
                imageView = new ImagenAmpliadaView();
                imageView.lbl_image.setIcon(ampliar(2));
                imageView.setTitle(seleccionarArtistaLista().getGrupo().getNombre());
                break;

            case "Ampliar Imagen Disco":
                imageView = new ImagenAmpliadaView();
                imageView.lbl_image.setIcon(ampliar(3));
                imageView.setTitle(seleccionarArtistaLista().getGrupo().getNombre());
                break;

            case "Ampliar Imagen Concierto":
                imageView = new ImagenAmpliadaView();
                imageView.lbl_image.setIcon(ampliar(4));
                imageView.setTitle(seleccionarArtistaLista().getGrupo().getNombre());
                break;

            case "Ampliar Imagen Gira":
                imageView = new ImagenAmpliadaView();
                imageView.lbl_image.setIcon(ampliar(5));
                imageView.setTitle(seleccionarArtistaLista().getGrupo().getNombre());
                break;
        }
    }
}
