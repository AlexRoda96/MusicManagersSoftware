package com.musicmanagerssoftware.base.account;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    private int id;
    private String userName;
    private String userPassword;
    private String email;
    private String typeOfUser;
    private String nombre;
    private String apellidos;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "userName")
    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "contraseña")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "typeUser")
    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User usuario = (User) o;
        return id == usuario.id &&
                Objects.equals(userName, usuario.userName) &&
                Objects.equals(userPassword, usuario.userPassword) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(typeOfUser, usuario.typeOfUser) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellidos, usuario.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPassword, email, typeOfUser);
    }

    @Override
    public String toString() {
        return  userName;
    }
}
