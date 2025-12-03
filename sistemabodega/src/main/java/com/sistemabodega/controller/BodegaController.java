/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.view.BodegaView;
import com.sistemabodega.service.BodegaService;
import com.sistemabodega.service.ProductoService;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class BodegaController {
    private final ProductoService productoService = new ProductoService();
    private final BodegaService bodegaService = new BodegaService();
    private final BodegaView view = new BodegaView();
    
    public void menu() {
        int op;
        do {
            op = view.mostrarMenu();
            switch(op) {
                case 1: registrarProducto();
                    break;
                case 2: ingresarCajas();
                    break;
                case 3: sacarCajas();
                    break;
                case 4: listarConStock();
                    break;
                case 0:
                    break;
                default: view.mostrarMensaje("Opción inválida.");
                    break;
            }
        } while(op != 0);
    }
    
    private void registrarProducto() {
        try {
            String nombre = view.pedirInput("Nombre: ");
            String codigo = view.pedirInput("Código: ");
            double precio = Double.parseDouble(view.pedirInput("Precio por caja: "));
            int edadMin = Integer.parseInt(view.pedirInput("Edad mínima: "));
            productoService.registrarProducto(nombre, codigo, precio, edadMin);
            view.mostrarMensaje("Producto creado.");
        } catch(Exception e) {
            view.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void ingresarCajas() {
        listarConStock();
        int id = Integer.parseInt(view.pedirInput("ID del producto: "));
        int cajas = Integer.parseInt(view.pedirInput("Cajas a ingresar: "));
        try {
            bodegaService.ingresarCajas(id, cajas);
            view.mostrarMensaje("Cajas ingresadas.");
        } catch(Exception e) {
            view.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void sacarCajas() {
        listarConStock();
        int id = Integer.parseInt(view.pedirInput("ID del producto: "));
        int cajas = Integer.parseInt(view.pedirInput("Cajas a retirar: "));
        try {
            bodegaService.sacarCajas(id, cajas);
            view.mostrarMensaje("Cajas retiradas.");
        } catch(Exception e) {
            view.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void listarConStock() {
        productoService.listar().forEach(p -> {
            int stock = bodegaService.obtenerStock(p.getId());
            view.mostrarMensaje("ID:" + p.getId() + ": " + p.getNombre() + " | Código: " + p.getCodigo() + " | Stock: " + stock);
        });
    }
}