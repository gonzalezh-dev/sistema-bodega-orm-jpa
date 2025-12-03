/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.repository;

import com.sistemabodega.model.Compra;
import com.sistemabodega.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class CompraRepository extends BaseRepository<Compra> {
    public CompraRepository() {
        super(Compra.class);
    }
}
