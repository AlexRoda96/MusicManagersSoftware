package com.musicmanagerssoftware.pruebas;

import com.musicmanagerssoftware.base.*;
import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.HibernateUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class PruebasUnitariasModelo extends Model {

    private static User usuario;
    private static Artista artista;
    private static Grupo grupo;
    private static Disco disco;
    private static Sala sala;
    private static Gira gira;

    @BeforeClass
    public static void setUpClass(){
        grupo=new Grupo("nirvana");
        artista = new Artista("alex","roda,","77133017x");
        HibernateUtil.buildSessionFactory();
    }

    @Test
    public void altaArtista() {

        List lista = this.getArtista();
        int cuenta = lista.size();
        this.altaArtistaTest((artista));

        lista = this.getArtista();
        Assert.assertTrue("Se ha añadido", cuenta + 1 == lista.size());
        deleteArtista(artista);
    }

    @Test
    public void altaGrupo() {
        altaArtistaTest(artista);
        List lista = this.getGrupo();
        int cantidad = lista.size();
        this.altaGrupoTest(grupo);

        lista = this.getGrupo();
        Assert.assertTrue("Se ha insertado correctamente", cantidad + 1 == lista.size());
        deleteArtista(artista);
        deleteGrupo(grupo);
    }
    @Test
    public void altaGrupoEquals(){
        List lista = this.getGrupo();
        int cantidad = lista.size();
        altaGrupoTest(grupo);
        lista = this.getGrupo();
        Assert.assertEquals(cantidad+1,lista.size());
        deleteGrupo(grupo);
    }
    @Test
    public void eliminarGrupoNegativo(){
        deleteGrupo(grupo);
        List lista = getGrupo();
        Assert.assertFalse(lista.contains(grupo));
    }

    @Test
    public void eliminarGrupoAfirmativo() {
        altaGrupoTest(grupo);
        int cantidad = getGrupo().size();
        deleteGrupo(grupo);
        Assert.assertTrue(" ha eliminado correctamente",getGrupo().size() == (cantidad-1));
    }

    @Test
    public void eliminarGrupoIgual() {
        int cantidadAntes = getGrupo().size();
        altaGrupoTest(grupo);
        deleteGrupo(grupo);
        int cantidadDespues = getGrupo().size();
        Assert.assertEquals(cantidadAntes,cantidadDespues);
    }


    @Test
    public void modificarArtista() {
        altaArtistaTest(artista);
        artista.setDni("2342r");
        modificarArtistaTest(artista);
        Assert.assertEquals("prueba",artista.getNombre());
        eliminarArtistaTest(artista);
    }



}
