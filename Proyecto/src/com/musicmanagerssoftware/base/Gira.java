package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Gira {
    private Integer id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private Double presupuesto;
    private Double coste;
    private Double ganancia;
    private Artista artista;
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
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fechaInicio", nullable = true)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "fechaFin", nullable = true)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "presupuesto", nullable = true, precision = 0)
    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Basic
    @Column(name = "coste", nullable = true, precision = 0)
    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    @Basic
    @Column(name = "ganancia", nullable = true, precision = 0)
    public Double getGanancia() {
        return ganancia;
    }

    public void setGanancia(Double ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gira gira = (Gira) o;
        return Objects.equals(id, gira.id) &&
                Objects.equals(nombre, gira.nombre) &&
                Objects.equals(fechaInicio, gira.fechaInicio) &&
                Objects.equals(fechaFin, gira.fechaFin) &&
                Objects.equals(presupuesto, gira.presupuesto) &&
                Objects.equals(coste, gira.coste) &&
                Objects.equals(ganancia, gira.ganancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaInicio, fechaFin, presupuesto, coste, ganancia);
    }

    @ManyToOne
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @OneToMany(mappedBy = "gira")
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "- " + nombre + "   " + fechaInicio;
    }
}
