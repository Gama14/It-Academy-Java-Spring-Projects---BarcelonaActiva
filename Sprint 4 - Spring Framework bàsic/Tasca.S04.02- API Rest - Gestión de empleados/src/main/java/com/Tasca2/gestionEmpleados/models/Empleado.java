package com.Tasca2.gestionEmpleados.models;

import javax.persistence.*;

@Entity
@Table (name = "empleados")
public class Empleado { //contiene todas las variables propias de empleado

    @Id //indicamos que será la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    @Column (name = "id") //para indicar a hibarnate a que columna pertenece en la base de datos
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "cargo")
    private String cargo;

    @Column (name = "salario")
    private String salario;

//getters i setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
}