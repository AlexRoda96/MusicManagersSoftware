package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Cancion {
    private Integer id;
    private String titulo;
    private Date fechaPublicacion;
    private String formato;
    private String genero;
    private Integer duracion;
    private Byte videoclip;
    private Artista artista;
    private byte[] imagen;
    private Disco disco;
    private Grupo grupo;
    private List<Concierto> concierto;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
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
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "videoclip", nullable = true)
    public Byte getVideoclip() {
        return videoclip;
    }

    public void setVideoclip(Byte videoclip) {
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
    @JoinColumn(name = "id_disco", referencedColumnName = "id")
    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @ManyToMany
    @JoinTable(name = "concierto_cancion", catalog = "", schema = "musicdb", joinColumns = @JoinColumn(name = "id_concierto", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_cancion", referencedColumnName = "id", nullable = false))
    public List<Concierto> getConcierto() {
        return concierto;
    }

    public void setConcierto(List<Concierto> concierto) {
        this.concierto = concierto;
    }

    @Override
    public String toString() {
        return " - " + titulo;
    }
}
