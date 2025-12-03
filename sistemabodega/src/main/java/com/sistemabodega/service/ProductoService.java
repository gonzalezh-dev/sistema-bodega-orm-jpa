/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.service;

import com.sistemabodega.model.Producto;
import com.sistemabodega.repository.ProductoRepository;
import java.util.List;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class ProductoService {
    
    private final ProductoRepository repo = new ProductoRepository();

    public void registrarProducto(String nombre, String codigo, double precio, int edadMinima) throws Exception {

        if (repo.findByCodigo(codigo) != null)
            throw new Exception("Ya existe un producto con ese código.");

        Producto p = new Producto(nombre, codigo, precio, edadMinima);

        repo.save(p);
    }
    
    public Producto buscarPorCodigo(String codigo) {
        return repo.findByCodigo(codigo);
    }

    public Producto buscarPorId(int id) {
        return repo.findById(id);
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public void actualizar(Producto p) {
        repo.update(p);
    }
}