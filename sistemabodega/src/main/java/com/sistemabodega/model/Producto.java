/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.model;

import jakarta.persistence.*;

/**
 *
 * @author Humberto Gonzalez B.
 */
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(unique = true)
    private String codigo;
    @Column(name = "precio_caja")
    private double precioCaja;
    @Column(name = "edad_minima")
    private int edadMinima;
    
    public Producto() {}

    public Producto(String nombre, String codigo, double precioCaja, int edadMinima) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioCaja = precioCaja;
        this.edadMinima = edadMinima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioCaja() {
        return precioCaja;
    }

    public void setPrecioCaja(double precioCaja) {
        this.precioCaja = precioCaja;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
}