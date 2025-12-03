/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.service;

import com.sistemabodega.model.Compra;
import com.sistemabodega.model.Producto;
import com.sistemabodega.model.Usuario;
import com.sistemabodega.model.MovimientoBodega;
import com.sistemabodega.repository.CompraRepository;
import com.sistemabodega.repository.MovimientoBodegaRepository;
import com.sistemabodega.repository.ProductoRepository;
import java.util.Date;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class CompraService {
    private final CompraRepository compraRepo = new CompraRepository();
    private final ProductoRepository prodRepo = new ProductoRepository();
    private final MovimientoBodegaRepository movRepo = new MovimientoBodegaRepository();
    
    public void comprar(Usuario u, int productoId, int cajas) throws Exception {

        Producto p = prodRepo.findById(productoId);

        if (p == null)
            throw new Exception("El producto no existe.");

        if (u.getEdad() < p.getEdadMinima())
            throw new Exception("No tiene la edad mínima para comprar este producto.");

        int stock = movRepo.getStockByProducto(productoId);
        if (cajas > stock)
            throw new Exception("Stock insuficiente. Disponible: " + stock);

        double total = p.getPrecioCaja() * cajas;

        if (u.getDinero() < total)
            throw new Exception("Dinero insuficiente.");

        // Registrar compra
        Compra compra = new Compra(u, p, cajas, total, new Date());
        compraRepo.save(compra);

        // Registrar salida de bodega
        MovimientoBodega mov = new MovimientoBodega(
                p,
                MovimientoBodega.TipoMovimiento.SALIDA,
                cajas,
                new Date()
        );

        movRepo.save(mov);

        // Descontar dinero
        u.setDinero(u.getDinero() - total);
    }
}
