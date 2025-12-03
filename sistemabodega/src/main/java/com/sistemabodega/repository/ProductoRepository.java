/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.repository;

import com.sistemabodega.model.Producto;
import com.sistemabodega.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class ProductoRepository extends BaseRepository<Producto> {
    public ProductoRepository() {
        super(Producto.class);
    }

    public Producto findByCodigo(String codigo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM Producto WHERE codigo = :cod", Producto.class
            ).setParameter("cod", codigo)
             .uniqueResult();
        }
    }
}
