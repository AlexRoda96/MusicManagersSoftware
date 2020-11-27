package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Cancion {
    private int id;
    private String titulo;
    private LocalDate fechaPublicacion;
    private String formato;
    private String genero;
    private float duracion;
    private String videoclip;
    private Artista artista;
    private byte[] imagen;
    private Disco disco;
    private Grupo grupo;
    private List<Concierto> conciertos;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "titulo", nullable = false, length = 100)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "fechaPublicacion", nullable = true)
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Basic
    @Column(name = "formato", nullable = true, length = 100)
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Basic
    @Column(name = "genero", nullable = true, length = 100)
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Basic
    @Column(name = "duracion", nullable = true)
    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "videoclip", nullable = true)
    public String getVideoclip() {
        return videoclip;
    }

    public void setVideoclip(String videoclip) {
        this.videoclip = videoclip;
    }

    @Basic
    @Column(name = "imagen", nullable = true)
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(id, cancion.id) &&
                Objects.equals(titulo, cancion.titulo) &&
                Objects.equals(fechaPublicacion, cancion.fechaPublicacion) &&
                Objects.equals(formato, cancion.formato) &&
                Objects.equals(genero, cancion.genero) &&
                Objects.equals(duracion, cancion.duracion) &&
                Objects.equals(videoclip, cancion.videoclip) &&
                Objects.equals(imagen,cancion.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, fechaPublicacion, formato, genero, duracion, videoclip);
    }

    @ManyToOne
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToOne
    @JoinColumn(name = "disco_id", referencedColumnName = "id")
    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @ManyToOne
    @JoinColumn(name = "grupo_id", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @ManyToMany
    @JoinTable(name = "concierto_cancion",schema = "musicDb", joinColumns = @JoinColumn(name = "cancion_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "concierto_id", referencedColumnName = "id", nullable = false))
    public List<Concierto> getConcierto() {
        return conciertos;
    }

    public void setConcierto(List<Concierto> concierto) {
        this.conciertos = concierto;
    }

    @Override
    public String toString() {
        return " - " + titulo;
    }

}
