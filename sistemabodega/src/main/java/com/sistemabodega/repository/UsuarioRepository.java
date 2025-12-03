/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.repository;

import com.sistemabodega.model.Usuario;
import com.sistemabodega.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class UsuarioRepository extends BaseRepository<Usuario> {
    public UsuarioRepository() {
        super(Usuario.class);
    }

    public Usuario findByCorreo(String correo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM Usuario WHERE correo = :c", Usuario.class
            ).setParameter("c", correo)
             .uniqueResult();
        }
    }
}
