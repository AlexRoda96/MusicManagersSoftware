package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Sala {
    private int id;
    private String nombre;
    private String pais;
    private String ciudad;
    private String direccion;
    private Integer aforoMax;
    private String tipoSala;
    private Integer numeroTelef;
    private Double precioAlquiler;
    private byte[] foto;
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
    @Column(name = "direccion", nullable = true, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "aforoMax", nullable = true)
    public Integer getAforoMax() {
        return aforoMax;
    }

    public void setAforoMax(Integer aforoMax) {
        this.aforoMax = aforoMax;
    }

    @Basic
    @Column(name = "tipoSala", nullable = true, length = 100)
    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }


    @Basic
    @Column(name = "numeroTelef", nullable = true)
    public Integer getNumeroTelef() {
        return numeroTelef;
    }

    public void setNumeroTelef(Integer numeroTelef) {
        this.numeroTelef = numeroTelef;
    }

    @Basic
    @Column(name = "precioAlquiler", nullable = true, precision = 0)
    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
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
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id) &&
                Objects.equals(nombre, sala.nombre) &&
                Objects.equals(pais, sala.pais) &&
                Objects.equals(ciudad, sala.ciudad) &&
                Objects.equals(direccion, sala.direccion) &&
                Objects.equals(aforoMax, sala.aforoMax) &&
                Objects.equals(tipoSala, sala.tipoSala) &&
                Objects.equals(numeroTelef, sala.numeroTelef) &&
                Objects.equals(precioAlquiler, sala.precioAlquiler) &&
                Objects.equals(foto, sala.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pais, ciudad, direccion, aforoMax, tipoSala, numeroTelef, precioAlquiler);
    }

    @OneToMany(mappedBy = "sala")
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    @Override
    public String toString() {
        return nombre + " - " + ciudad;
    }
}
