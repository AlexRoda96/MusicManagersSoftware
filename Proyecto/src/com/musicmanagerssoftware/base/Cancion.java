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
    private String discografica;
    private String productor;
    private Integer duracion;
    private String colaboraciones;
    private Byte videoclip;
    private String enlaceYoutube;
    private String cuentaSpotify;
    private Artista artista;
    private Grupo grupo;
    private Disco disco;
    private List<Concierto> conciertos;

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
    @Column(name = "discografica", nullable = false, length = 100)
    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    @Basic
    @Column(name = "productor", nullable = false, length = 100)
    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
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
    @Column(name = "colaboraciones", nullable = true, length = 100)
    public String getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(String colaboraciones) {
        this.colaboraciones = colaboraciones;
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
    @Column(name = "enlaceYoutube", nullable = true, length = 100)
    public String getEnlaceYoutube() {
        return enlaceYoutube;
    }

    public void setEnlaceYoutube(String enlaceYoutube) {
        this.enlaceYoutube = enlaceYoutube;
    }

    @Basic
    @Column(name = "cuentaSpotify", nullable = true, length = 100)
    public String getCuentaSpotify() {
        return cuentaSpotify;
    }

    public void setCuentaSpotify(String cuentaSpotify) {
        this.cuentaSpotify = cuentaSpotify;
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
                Objects.equals(discografica, cancion.discografica) &&
                Objects.equals(productor, cancion.productor) &&
                Objects.equals(duracion, cancion.duracion) &&
                Objects.equals(colaboraciones, cancion.colaboraciones) &&
                Objects.equals(videoclip, cancion.videoclip) &&
                Objects.equals(enlaceYoutube, cancion.enlaceYoutube) &&
                Objects.equals(cuentaSpotify, cancion.cuentaSpotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, fechaPublicacion, formato, genero, discografica, productor, duracion, colaboraciones, videoclip, enlaceYoutube, cuentaSpotify);
    }

    @ManyToOne
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToOne
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @ManyToOne
    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @ManyToMany(mappedBy = "canciones")
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }
}
