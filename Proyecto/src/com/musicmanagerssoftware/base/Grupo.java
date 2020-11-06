package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Grupo {
    private Integer id;
    private String nombre;
    private String annoFormacion;
    private String discografica;
    private String generoMusical;
    private byte[] foto;
    private List<Artista> artistas;
    private List<Cancion> canciones;
    private List<Concierto> conciertos;
    private List<Disco> discos;
    private List<Gira> giras;
    private List<Reunion> reuniones;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "annoFormacion", nullable = true, length = 29)
    public String getAnnoFormacion() {
        return annoFormacion;
    }

    public void setAnnoFormacion(String annoFormacion) {
        this.annoFormacion = annoFormacion;
    }


    @Basic
    @Column(name = "discografica", nullable = true, length = 50)
    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    @Basic
    @Column(name = "generoMusical", nullable = true, length = 100)
    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Basic
    @Column(name = "foto", nullable = true)
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(id, grupo.id) &&
                Objects.equals(nombre, grupo.nombre) &&
                Objects.equals(annoFormacion, grupo.annoFormacion) &&
                Objects.equals(discografica, grupo.discografica) &&
                Objects.equals(generoMusical, grupo.generoMusical) &&
                Arrays.equals(foto, grupo.foto);
    }

    @Override
    public int hashCode() {
         return Objects.hash(id, nombre, annoFormacion, discografica, generoMusical);
    }

    @OneToMany(mappedBy = "grupo",fetch=FetchType.EAGER)
    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    @OneToMany(mappedBy = "grupo")
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @OneToMany(mappedBy = "grupo")
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    @OneToMany(mappedBy = "grupo")
    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    @OneToMany(mappedBy = "grupo")
    public List<Gira> getGiras() {
        return giras;
    }

    public void setGiras(List<Gira> giras) {
        this.giras = giras;
    }

    @OneToMany(mappedBy = "grupo")
    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }
}
