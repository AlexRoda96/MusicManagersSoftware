package com.musicmanagerssoftware.gui;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Clase modelo que contiene los metodos de añadir, modificar, eliminar y buscar en la
 * base de datos
 */
public class Model {

    //Atributos
    boolean conected;
    Session sesion;

    /**
     * Método que devuelve la lista de artistas
     * @return lista de artistas.
     */
    public ArrayList<Artista> getArtista(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Artista ");
        ArrayList<Artista> listaArtistas= (ArrayList<Artista>)query.getResultList();
        sesion.close();
        return listaArtistas;
    }

    public ArrayList<Grupo> getGrupo(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Grupo ");
        ArrayList<Grupo> listaGrupos = (ArrayList<Grupo>)query.getResultList();
        sesion.close();
        return listaGrupos;
    }

    public ArrayList<Cancion> getCancion(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Cancion ");
        ArrayList<Cancion> listaCanciones = (ArrayList<Cancion>)query.getResultList();
        sesion.close();
        return listaCanciones;
    }

    public ArrayList<Disco> getDisco(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Disco ");
        ArrayList<Disco> listaDiscos = (ArrayList<Disco>)query.getResultList();
        sesion.close();
        return listaDiscos;
    }


    public ArrayList<Concierto> getConcierto(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Concierto ");
        ArrayList<Concierto> listaConciertos = (ArrayList<Concierto>)query.getResultList();
        sesion.close();
        return listaConciertos;
    }

    public ArrayList<Gira> getGira(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Gira ");
        ArrayList<Gira> listaGiras = (ArrayList<Gira>)query.getResultList();
        sesion.close();
        return listaGiras;
    }

    public ArrayList<Reunion> getReunion(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Reunion ");
        ArrayList<Reunion> listaReuniones = (ArrayList<Reunion>)query.getResultList();
        sesion.close();
        return listaReuniones;
    }

    public ArrayList<Sala> getSala(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Sala ");
        ArrayList<Sala> listaSalas = (ArrayList<Sala>)query.getResultList();
        sesion.close();
        return listaSalas;
    }

////////

    public void altaArtista(Artista nuevoArtista) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoArtista);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaGrupo(Grupo nuevoGrupo) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoGrupo);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaCancion(Cancion nuevoCancion) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoCancion);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaDisco(Disco nuevoDisco) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoDisco);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaConcierto(Concierto nuevoConcierto) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoConcierto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaGira(Gira nuevoGira) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoGira);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaSala(Sala nuevoSala) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoSala);
        sesion.getTransaction().commit();
        sesion.close();
    }


    public void altaReunion(Reunion nuevoReunion) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoReunion);
        sesion.getTransaction().commit();
        sesion.close();
    }

    ////

    public void modificarArtista(Artista artistaSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(artistaSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarGrupo(Grupo grupoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(grupoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarCancion(Cancion cancionSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(cancionSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarDisco(Disco discoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(discoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarConcierto(Concierto conciertoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(conciertoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarGira(Gira giraSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(giraSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarSala(Sala salaSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(salaSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }


    public void modificarReunion(Reunion reunionSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(reunionSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }


    public void deleteArtista(Artista artistaEliminada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(artistaEliminada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteGrupo(Grupo grupoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(grupoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteDisco(Disco discoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(discoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteCancion(Cancion cancionSeleccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(cancionSeleccionada);
        sesion.getTransaction().commit();
        sesion.close();
    }


    public void deleteGira(Gira giraSelccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(giraSelccionada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteConcierto(Concierto conciertoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(conciertoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteSala(Sala salaSeleccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(salaSeleccionada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void deleteReunion(Reunion reunionSeleccioanda) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(reunionSeleccioanda);
        sesion.getTransaction().commit();
        sesion.close();
    }




}
