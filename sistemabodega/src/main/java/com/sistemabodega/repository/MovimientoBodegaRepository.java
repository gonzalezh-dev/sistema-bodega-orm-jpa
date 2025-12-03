/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.repository;

import com.sistemabodega.model.MovimientoBodega;
import com.sistemabodega.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class MovimientoBodegaRepository extends BaseRepository<MovimientoBodega> {
    public MovimientoBodegaRepository() {
        super(MovimientoBodega.class);
    }

    public int getStockByProducto(int idProducto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long entradas = session.createQuery(
                "SELECT COALESCE(SUM(m.cajas),0) FROM MovimientoBodega m WHERE m.producto.id = :id AND m.tipo = 'ENTRADA'",
                Long.class
            ).setParameter("id", idProducto).uniqueResult();

            Long salidas = session.createQuery(
                "SELECT COALESCE(SUM(m.cajas),0) FROM MovimientoBodega m WHERE m.producto.id = :id AND m.tipo = 'SALIDA'",
                Long.class
            ).setParameter("id", idProducto).uniqueResult();

            return (int)(entradas - salidas);
        }
    }
}
