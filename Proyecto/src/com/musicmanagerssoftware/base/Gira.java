package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Gira {
    private int id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Artista artista;
    private byte[] cartel;
    private List<Concierto> conciertos;
    private Grupo grupo;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "fechaFin", nullable = true)
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "cartel", nullable = true)
    public byte[] getCartel() {
        return cartel;
    }

    public void setCartel(byte[] cartel) {
        this.cartel = cartel;
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
                Objects.equals(cartel,gira.cartel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaInicio, fechaFin);
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
    @JoinColumn(name = "grupo_id", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return " - " + nombre + "   " + fechaInicio;
    }
}
