/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.service;

import com.sistemabodega.model.MovimientoBodega;
import com.sistemabodega.model.Producto;
import com.sistemabodega.repository.MovimientoBodegaRepository;
import com.sistemabodega.repository.ProductoRepository;
import java.util.Date;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class BodegaService {
    private final MovimientoBodegaRepository movRepo = new MovimientoBodegaRepository();
    private final ProductoRepository prodRepo = new ProductoRepository();
    
    public void ingresarCajas(int productoId, int cajas) throws Exception {
        Producto p = prodRepo.findById(productoId);

        if (p == null)
            throw new Exception("El producto no existe.");

        if (cajas <= 0)
            throw new Exception("Cantidad inválida.");

        MovimientoBodega mov = new MovimientoBodega(
                p,
                MovimientoBodega.TipoMovimiento.ENTRADA,
                cajas,
                new Date()
        );

        movRepo.save(mov);
    }

    public void sacarCajas(int productoId, int cajas) throws Exception {
        Producto p = prodRepo.findById(productoId);

        if (p == null)
            throw new Exception("El producto no existe.");

        int stock = movRepo.getStockByProducto(productoId);

        if (cajas <= 0 || cajas > stock)
            throw new Exception("No puede sacar más cajas de las disponibles (" + stock + ").");

        MovimientoBodega mov = new MovimientoBodega(
                p,
                MovimientoBodega.TipoMovimiento.SALIDA,
                cajas,
                new Date()
        );

        movRepo.save(mov);
    }

    public int obtenerStock(int productoId) {
        return movRepo.getStockByProducto(productoId);
    }    
}
