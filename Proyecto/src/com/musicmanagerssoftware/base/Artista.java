package com.musicmanagerssoftware.base;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Artista {
    private int id;
    private String nombreArtistico;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;
    private int numTelefono;
    private String generoMusical;
    private String tipoMusico;
    private byte[] foto;
    private Grupo grupo;
    private String discografica;
    private List<Cancion> canciones;
    private List<Disco> discos;
    private List<Concierto> conciertos;
    private List<Gira> giras;
    private List<Reunion> reuniones;

    public Artista( String nombre, String primerApellido, String dni) {

        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.dni = dni;
    }

    public Artista(){

    }

    @Id
    @Column(name = "id",nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "primerApellido", nullable = false, length = 25)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "segundoApellido", nullable = true, length = 25)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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
    @Column(name = "fechaNacimiento", nullable = true)
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "paisNacimiento", nullable = true, length = 50)
    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    @Basic
    @Column(name = "numTelefono", nullable = true, length = 15)
    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
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
    @Column(name = "tipoMusico", nullable = true, length = 25)
    public String getTipoMusico() {
        return tipoMusico;
    }

    public void setTipoMusico(String tipoMusico) {
        this.tipoMusico = tipoMusico;
    }

    @Basic
    @Column(name = "discografica", length = 25)
    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
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
        Artista artista = (Artista) o;
        return id == artista.id &&
                Objects.equals(nombreArtistico, artista.nombreArtistico) &&
                Objects.equals(nombre, artista.nombre) &&
                Objects.equals(primerApellido, artista.primerApellido) &&
                Objects.equals(segundoApellido, artista.segundoApellido) &&
                Objects.equals(dni, artista.dni) &&
                Objects.equals(fechaNacimiento, artista.fechaNacimiento) &&
                Objects.equals(paisNacimiento, artista.paisNacimiento) &&
                Objects.equals(numTelefono, artista.numTelefono) &&
                Objects.equals(generoMusical, artista.generoMusical) &&
                Objects.equals(tipoMusico, artista.tipoMusico) &&
                Arrays.equals(foto, artista.foto);
    }

    @Override
    public int hashCode() {
         return  Objects.hash(id, nombreArtistico, nombre, primerApellido, segundoApellido, dni,
                 fechaNacimiento, paisNacimiento, numTelefono, generoMusical, tipoMusico);
    }

    @ManyToOne
    @JoinColumn(name = "grupo_id", referencedColumnName = "id")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    @OneToMany(mappedBy = "artista")
    public List<Gira> getGiras() {
        return giras;
    }

    public void setGiras(List<Gira> giras) {
        this.giras = giras;
    }

    @OneToMany(mappedBy = "artista")
    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    @Override
    public String toString() {
        return " - " + nombreArtistico;
    }
}
