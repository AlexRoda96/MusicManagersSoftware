package com.musicmanagerssoftware.gui;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Modelo
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class Model {

    Session sesion;

    /**
     * Devuelve los artístas.
     * @return lista de artistas.
     */
    public ArrayList<Artista> getArtista(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Artista ");
        ArrayList<Artista> listaArtistas= (ArrayList<Artista>)query.getResultList();
        sesion.close();
        return listaArtistas;
    }

    /**
     * Devuelve los grupos.
     * @return listaGrupos
     */
    public ArrayList<Grupo> getGrupo(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Grupo ");
        ArrayList<Grupo> listaGrupos = (ArrayList<Grupo>)query.getResultList();
        sesion.close();
        return listaGrupos;
    }

    /**
     * Devuelve las canciones.
     * @return listaCanciones
     */
    public ArrayList<Cancion> getCancion(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Cancion ");
        ArrayList<Cancion> listaCanciones = (ArrayList<Cancion>)query.getResultList();
        sesion.close();
        return listaCanciones;
    }

    /**
     * Devuelve los discos.
     * @return listaDiscos
     */
    public ArrayList<Disco> getDisco(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Disco ");
        ArrayList<Disco> listaDiscos = (ArrayList<Disco>)query.getResultList();
        sesion.close();
        return listaDiscos;
    }

    /**
     * Devuelve los conciertos.
     * @return listaConciertos
     */
    public ArrayList<Concierto> getConcierto(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Concierto ");
        ArrayList<Concierto> listaConciertos = (ArrayList<Concierto>)query.getResultList();
        sesion.close();
        return listaConciertos;
    }

    /**
     * Devuelve las Giras.
     * @return listaGiras
     */
    public ArrayList<Gira> getGira(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Gira ");
        ArrayList<Gira> listaGiras = (ArrayList<Gira>)query.getResultList();
        sesion.close();
        return listaGiras;
    }

    /**
     * Devuelve las reuniones.
     * @return listaReuniones
     */
    public ArrayList<Reunion> getReunion(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Reunion ");
        ArrayList<Reunion> listaReuniones = (ArrayList<Reunion>)query.getResultList();
        sesion.close();
        return listaReuniones;
    }

    /**
     * Devuelve las salas.
     * @return listaSalas
     */
    public ArrayList<Sala> getSala(){
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM Sala ");
        ArrayList<Sala> listaSalas = (ArrayList<Sala>)query.getResultList();
        sesion.close();
        return listaSalas;
    }

    /**
     * Devuelve los usuarios.
     * @return users
     */
    public ArrayList<User> getUsuario(){
        HibernateUtil.buildSessionFactoryUser();
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM User ");
        ArrayList<User> users = (ArrayList<User>)query.getResultList();
        sesion.close();
        return users;
    }

    /**
     * Añade un nuevo artista.
     * @param nuevoArtista
     */
    public void altaArtista(Artista nuevoArtista) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoArtista);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaArtistaTest(Artista artista){
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(artista);
        System.out.println(sesion.save(artista)+"save");
        sesion.getTransaction().commit();

    }

    /**
     * Añade un nuevo grupo.
     * @param nuevoGrupo
     */
    public void altaGrupo(Grupo nuevoGrupo) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoGrupo);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void altaGrupoTest(Grupo grupo){
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(grupo);
        System.out.println(sesion.save(grupo)+"save");
        sesion.getTransaction().commit();

    }

    /**
     * Añade un anueva canción.
     * @param nuevoCancion
     */
    public void altaCancion(Cancion nuevoCancion) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoCancion);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade un nuevo disco.
     * @param nuevoDisco
     */
    public void altaDisco(Disco nuevoDisco) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoDisco);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade un nuevo concierto.
     * @param nuevoConcierto
     */
    public void altaConcierto(Concierto nuevoConcierto) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoConcierto);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade una nueva gira.
     * @param nuevoGira
     */
    public void altaGira(Gira nuevoGira) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoGira);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade una nueva sala.
     * @param nuevoSala
     */
    public void altaSala(Sala nuevoSala) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoSala);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade un nuevo usuario.
     * @param nuevoUsuario
     */
    public void altaUsuario(User nuevoUsuario) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoUsuario);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Añade una nueva reunión.
     * @param nuevoReunion
     */
    public void altaReunion(Reunion nuevoReunion) {

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(nuevoReunion);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica el artísta seleccionado.
     * @param artistaSeleccionado
     */
    public void modificarArtista(Artista artistaSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(artistaSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }


    public void modificarArtistaTest(Artista artista){
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(artista);
        sesion.getTransaction().commit();
    }

    /**
     * Modifica el grupo seleccionado.
     * @param grupoSeleccionado
     */
    public void modificarGrupo(Grupo grupoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(grupoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica la canción seleccionada.
     * @param cancionSeleccionado
     */
    public void modificarCancion(Cancion cancionSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(cancionSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica el disco seleccionado.
     * @param discoSeleccionado
     */
    public void modificarDisco(Disco discoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(discoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modfica el concierto seleccionado.
     * @param conciertoSeleccionado
     */
    public void modificarConcierto(Concierto conciertoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(conciertoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica la gira seleccionada.
     * @param giraSeleccionado
     */
    public void modificarGira(Gira giraSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(giraSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica la sala seleccionada.
     * @param salaSeleccionado
     */
    public void modificarSala(Sala salaSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(salaSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica la reunion seleccionada.
     * @param reunionSeleccionado
     */
    public void modificarReunion(Reunion reunionSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(reunionSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Modifica el usuario seleccionado.
     * @param usuarioSeleccionado
     */
    public void modificarUsuario(User usuarioSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.saveOrUpdate(usuarioSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina el artista seleccionado.
     * @param artistaEliminada
     */
    public void deleteArtista(Artista artistaEliminada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(artistaEliminada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void eliminarArtistaTest(Artista artista){
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(artista);
        sesion.getTransaction().commit();
    }

    /**
     * Elimina el grupo seleccionado.
     * @param grupoSeleccionado
     */
    public void deleteGrupo(Grupo grupoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(grupoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina el disco seleccionado.
     * @param discoSeleccionado
     */
    public void deleteDisco(Disco discoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(discoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina la canción seleccionada.
     * @param cancionSeleccionada
     */
    public void deleteCancion(Cancion cancionSeleccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        if(cancionSeleccionada !=null){
            sesion.delete(cancionSeleccionada);
        }
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina la gira seleccionada.
     * @param giraSelccionada
     */
    public void deleteGira(Gira giraSelccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(giraSelccionada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina el concierto seleccionado.
     * @param conciertoSeleccionado
     */
    public void deleteConcierto(Concierto conciertoSeleccionado) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(conciertoSeleccionado);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina la sala seleccionada.
     * @param salaSeleccionada
     */
    public void deleteSala(Sala salaSeleccionada) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(salaSeleccionada);
        sesion.getTransaction().commit();
        sesion.close();
    }

    /**
     * Elimina la reunión seleccionada.
     * @param reunionSeleccioanda
     */
    public void deleteReunion(Reunion reunionSeleccioanda) {
        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(reunionSeleccioanda);
        sesion.getTransaction().commit();
        sesion.close();
    }

}
