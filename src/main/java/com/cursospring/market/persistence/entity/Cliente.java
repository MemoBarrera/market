package com.cursospring.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    @Column(name = "apellidos")
    private String apellido;
    private Float celular;
    private String direccion;
    @Column(name = "correo_electronico")
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compra;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Float getCelular() {
        return celular;
    }

    public void setCelular(Float celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
