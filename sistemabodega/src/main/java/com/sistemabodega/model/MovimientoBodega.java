/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author Humberto Gonzalez B.
 */
@Entity
@Table(name = "movimientos_bodega")
public class MovimientoBodega {
    public enum TipoMovimiento { ENTRADA, SALIDA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;
    private int cajas;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    public MovimientoBodega() {}

    public MovimientoBodega(Producto producto, TipoMovimiento tipo, int cajas, Date fecha) {
        this.producto = producto;
        this.tipo = tipo;
        this.cajas = cajas;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getCajas() {
        return cajas;
    }

    public void setCajas(int cajas) {
        this.cajas = cajas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}