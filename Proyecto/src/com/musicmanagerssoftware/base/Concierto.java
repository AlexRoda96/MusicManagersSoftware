package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
public class Concierto {
    private Integer id;
    private String nombre;
    private String pais;
    private String ciudad;
    private Date fecha;
    private Date fechaSalidaEntradas;
    private Integer numeroEntradas;
    private Byte merchan;
    private Double precioEntrada;
    private Time horaApertura;
    private Integer edadMinima;
    private Artista artista;
    private List<Cancion> canciones;
    private Grupo grupo;
    private Gira gira;
    private Sala sala;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

        public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "pais", nullable = true, length = 100)
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Basic
    @Column(name = "ciudad", nullable = true, length = 100)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "fecha", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "fechaSalidaEntradas", nullable = true)
    public Date getFechaSalidaEntradas() {
        return fechaSalidaEntradas;
    }

    public void setFechaSalidaEntradas(Date fechaSalidaEntradas) {
        this.fechaSalidaEntradas = fechaSalidaEntradas;
    }

    @Basic
    @Column(name = "numeroEntradas", nullable = true)
    public Integer getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(Integer numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    @Basic
    @Column(name = "merchan", nullable = true)
    public Byte getMerchan() {
        return merchan;
    }

    public void setMerchan(Byte merchan) {
        this.merchan = merchan;
    }

    @Basic
    @Column(name = "precioEntrada", nullable = true, precision = 0)
    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    @Basic
    @Column(name = "horaApertura", nullable = true)
    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    @Basic
    @Column(name = "edadMinima", nullable = true)
    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concierto concierto = (Concierto) o;
        return Objects.equals(id, concierto.id) &&
                Objects.equals(pais, concierto.pais) &&
                Objects.equals(ciudad, concierto.ciudad) &&
                Objects.equals(fecha, concierto.fecha) &&
                Objects.equals(fechaSalidaEntradas, concierto.fechaSalidaEntradas) &&
                Objects.equals(numeroEntradas, concierto.numeroEntradas) &&
                Objects.equals(merchan, concierto.merchan) &&
                Objects.equals(precioEntrada, concierto.precioEntrada) &&
                Objects.equals(horaApertura, concierto.horaApertura) &&
                Objects.equals(edadMinima, concierto.edadMinima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pais, ciudad, fecha, fechaSalidaEntradas, numeroEntradas, merchan, precioEntrada, horaApertura, edadMinima);
    }

    @ManyToOne()
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToMany(mappedBy = "concierto")
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @ManyToOne
    @JoinColumn(name = "id_gira", referencedColumnName = "id")
    public Gira getGira() {
        return gira;
    }

    public void setGira(Gira gira) {
        this.gira = gira;
    }

    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id")
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "- " +ciudad + " " + fecha;
    }
}
