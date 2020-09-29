package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Artista {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String nombreArtistico;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String discografica;
    private String generoMusical;
    private String paginaWeb;
    private String cuentaInstagram;
    private String canalYoutube;
    private String cuentaSpotify;
    private List<Cancion> canciones;
    private List<Disco> discos;
    private List<Gira> giras;
    private List<Concierto> conciertos;
    private Grupo grupo;

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
    @Column(name = "apellidos", nullable = false, length = 100)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "dni", nullable = false, length = 50)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "nombreArtistico", nullable = true, length = 50)
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    @Basic
    @Column(name = "fechaNacimiento", nullable = true)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "nacionalidad", nullable = true, length = 50)
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Basic
    @Column(name = "discografica", nullable = true, length = 100)
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
    @Column(name = "paginaWeb", nullable = true, length = 100)
    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Basic
    @Column(name = "cuentaInstagram", nullable = true, length = 100)
    public String getCuentaInstagram() {
        return cuentaInstagram;
    }

    public void setCuentaInstagram(String cuentaInstagram) {
        this.cuentaInstagram = cuentaInstagram;
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
        Artista artista = (Artista) o;
        return Objects.equals(id, artista.id) &&
                Objects.equals(nombre, artista.nombre) &&
                Objects.equals(apellidos, artista.apellidos) &&
                Objects.equals(dni, artista.dni) &&
                Objects.equals(nombreArtistico, artista.nombreArtistico) &&
                Objects.equals(fechaNacimiento, artista.fechaNacimiento) &&
                Objects.equals(nacionalidad, artista.nacionalidad) &&
                Objects.equals(discografica, artista.discografica) &&
                Objects.equals(generoMusical, artista.generoMusical) &&
                Objects.equals(paginaWeb, artista.paginaWeb) &&
                Objects.equals(cuentaInstagram, artista.cuentaInstagram) &&
                Objects.equals(canalYoutube, artista.canalYoutube) &&
                Objects.equals(cuentaSpotify, artista.cuentaSpotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, dni, nombreArtistico, fechaNacimiento, nacionalidad, discografica, generoMusical, paginaWeb, cuentaInstagram, canalYoutube, cuentaSpotify);
    }

    @OneToMany(mappedBy = "artista")
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @OneToMany(mappedBy = "artista")
    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    @OneToMany(mappedBy = "artista")
    public List<Gira> getGiras() {
        return giras;
    }

    public void setGiras(List<Gira> giras) {
        this.giras = giras;
    }

    @OneToMany(mappedBy = "artista")
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    @ManyToOne
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
