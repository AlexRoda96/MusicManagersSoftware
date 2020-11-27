package com.musicmanagerssoftware.gui.views.searchviews;


import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.util.HibernateUtil;

import javax.persistence.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Ventana para buscar.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class SearchView extends JDialog {

    //Panel
    private JPanel contentPane;
    //Text
    private JTextField textField1;
    //List
    private JList list1;
    //Button
    private JButton buscarButton;
    //DefaultListModel
    private DefaultListModel dlmLista;
    //DefaultComboBoxModel
    private DefaultComboBoxModel dcmTipo;
    //ComboBox
    private JComboBox comboBox_tipo;


    /**
     * Constructor
     */
    public SearchView() {
        setTitle("Movie Manager - Buscar");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setContentPane(contentPane);
        setModal(true);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        setResizable(false);
        initModels();
        fillComboTipo();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicializa los modelos
     */
    private void initModels(){
        dcmTipo = new DefaultComboBoxModel();
        comboBox_tipo.setModel(dcmTipo);

        dlmLista = new DefaultListModel();
        list1.setModel(dlmLista);
    }

    /**
     * Rellena el combo de tipo
     */
    private void fillComboTipo() {
        dcmTipo.removeAllElements();
        dcmTipo.addElement("Artista");
        dcmTipo.addElement("Grupo");
        dcmTipo.addElement("Disco");
        dcmTipo.addElement("Cancion");
        dcmTipo.addElement("Gira");
        dcmTipo.addElement("Concierto");
        dcmTipo.addElement("Sala");
    }

    /**
     * Método buscar
     */
    private void buscar(){
        dlmLista.clear();
        if (comboBox_tipo.getSelectedIndex() == 0) {
            buscarArtista();
        }else if (comboBox_tipo.getSelectedIndex() == 1) {
            buscarGrupo();
        }else if (comboBox_tipo.getSelectedIndex() == 2) {
            buscarDisco();
        }else if (comboBox_tipo.getSelectedIndex() == 3) {
            buscarCancion();
        }else if (comboBox_tipo.getSelectedIndex() == 4) {
            buscarGira();
        }else if (comboBox_tipo.getSelectedIndex() == 5) {
            buscarConcierto();
        }else if (comboBox_tipo.getSelectedIndex() == 6) {
            buscarSala();
        }
    }

    /**
     * Busca un artísta y lo muestra en la lista
     */
    private void buscarArtista(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Artista c WHERE c.nombreArtistico= :nombreArtistico");
        query.setParameter("nombreArtistico", textField1.getText());
        ArrayList<Artista> artistas = (ArrayList<Artista>)
                ((org.hibernate.query.Query) query).list();
        for (Artista artista : artistas){
            dlmLista.addElement(artista);
        }
    }

    /**
     * Buscan un grupo y lo muestra en la lista
     */
    private void buscarGrupo(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Grupo c WHERE c.nombre = :nombre");
        query.setParameter("nombre", textField1.getText());
        ArrayList<Grupo> grupos = (ArrayList<Grupo>) ((org.hibernate.query.Query) query).list();
        for (Grupo grupo : grupos){
            dlmLista.addElement(grupo);
        }
    }

    /**
     * Busca un disco y la muestra en la lista
     */
    private void buscarDisco(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Disco c WHERE c.titulo = :titulo");
        query.setParameter("titulo", textField1.getText());
        ArrayList<Disco> discos = (ArrayList<Disco>) ((org.hibernate.query.Query) query).list();
        for (Disco disco : discos){
            dlmLista.addElement(disco);
        }
    }


    /**
     * Busca una canción y la muestra en la lista
     */
    private void buscarCancion(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Cancion c WHERE c.titulo = :titulo");
        query.setParameter("titulo", textField1.getText());
        ArrayList<Cancion> cancions = (ArrayList<Cancion>) ((org.hibernate.query.Query) query).list();
        for (Cancion cancion : cancions){
            dlmLista.addElement(cancion);
        }
    }

    /**
     * Busca una gira y la muestra en la lista
     */
    private void buscarGira(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Gira c WHERE c.nombre = :nombre");
        query.setParameter("nombre", textField1.getText());
        ArrayList<Gira> giras = (ArrayList<Gira>) ((org.hibernate.query.Query) query).list();
        for (Gira gira : giras){
            dlmLista.addElement(gira);
        }
    }

    /**
     * Busca un concierto y la muestra en la lista
     */
    private void buscarConcierto(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Concierto c WHERE c.nombre = :nombre");
        query.setParameter("nombre", textField1.getText());
        ArrayList<Concierto> conciertos = (ArrayList<Concierto>) ((org.hibernate.query.Query) query).list();
        for (Concierto concierto : conciertos){
            dlmLista.addElement(concierto);
        }
    }

    /**
     * Busca una sala y la muestra en la lista
     */
    private void buscarSala(){
        Query query = HibernateUtil.getCurrentSession().
                createQuery("FROM Sala c WHERE c.nombre = :nombre");
        query.setParameter("nombre", textField1.getText());
        ArrayList<Sala> salas = (ArrayList<Sala>) ((org.hibernate.query.Query) query).list();
        for (Sala sala : salas){
            dlmLista.addElement(sala);
        }
    }

}

