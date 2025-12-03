/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.view.CompraView;
import com.sistemabodega.model.Usuario;
import com.sistemabodega.service.BodegaService;
import com.sistemabodega.service.CompraService;
import com.sistemabodega.service.ProductoService;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class CompraController {
    private final ProductoService productoService = new ProductoService();
    private final BodegaService bodegaService = new BodegaService();
    private final CompraService compraService = new CompraService();
    private final CompraView view = new CompraView(); 
    
    public void realizarCompra(Usuario u) {
        productoService.listar().forEach(p -> {
            int stock = bodegaService.obtenerStock(p.getId());
            view.mostrarMensaje("ID: " + p.getId() + ": " + p.getNombre() +
                    " | Precio: " + p.getPrecioCaja() +
                    " | Edad mínima: " + p.getEdadMinima() +
                    " | Stock: " + stock);
        });

        try {
            int id = view.mostrarMenuProducto();
            int cajas = view.pedirCantidad();
            compraService.comprar(u, id, cajas);
            view.mostrarMensaje("Compra realizada correctamente.");
        } catch(Exception e) {
            view.mostrarMensaje("Error: " + e.getMessage());
        }
    }
}