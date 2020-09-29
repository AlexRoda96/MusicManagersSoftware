package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Disco {
    private Integer id;
    private String titulo;
    private Date fechaPublicacion;
    private String generoMusical;
    private String formato;
    private String discografica;
    private String colaboraciones;
    private Double precio;
    private String canalYoutube;
    private String cuentaSpotify;
    private Artista artista;
    private Grupo grupo;
    private List<Cancion> canciones;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "titulo", nullable = false, length = 50)
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
    @Column(name = "generoMusical", nullable = true, length = 50)
    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
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
    @Column(name = "discografica", nullable = false, length = 50)
    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
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
    @Column(name = "precio", nullable = true, precision = 0)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "canalYoutube", nullable = true, length = 100)
    public String getCanalYoutube() {
        return canalYoutube;
    }

    public void setCanalYoutube(String canalYoutube) {
        this.canalYoutube = canalYoutube;
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
        Disco disco = (Disco) o;
        return Objects.equals(id, disco.id) &&
                Objects.equals(titulo, disco.titulo) &&
                Objects.equals(fechaPublicacion, disco.fechaPublicacion) &&
                Objects.equals(generoMusical, disco.generoMusical) &&
                Objects.equals(formato, disco.formato) &&
                Objects.equals(discografica, disco.discografica) &&
                Objects.equals(colaboraciones, disco.colaboraciones) &&
                Objects.equals(precio, disco.precio) &&
                Objects.equals(canalYoutube, disco.canalYoutube) &&
                Objects.equals(cuentaSpotify, disco.cuentaSpotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, fechaPublicacion, generoMusical, formato, discografica, colaboraciones, precio, canalYoutube, cuentaSpotify);
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

    @OneToMany(mappedBy = "disco")
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
