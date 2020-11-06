package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Reunion {
    private Integer id;
    private String lugar;
    private Time hora;
    private String descripcion;
    private Artista artista;
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
    @Column(name = "lugar", nullable = true, length = 50)
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Basic
    @Column(name = "hora", nullable = true)
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reunion reunion = (Reunion) o;
        return Objects.equals(id, reunion.id) &&
                Objects.equals(lugar, reunion.lugar) &&
                Objects.equals(hora, reunion.hora) &&
                Objects.equals(descripcion, reunion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lugar, hora, descripcion);
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
}
