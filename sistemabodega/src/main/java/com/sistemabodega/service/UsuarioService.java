/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.service;

import com.sistemabodega.model.Usuario;
import com.sistemabodega.repository.UsuarioRepository;
import java.util.List;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class UsuarioService {
    
    private final UsuarioRepository repo = new UsuarioRepository();

    public void crearUsuario(String nombre, String correo, String password, int edad,
                             Usuario.TipoUsuario tipo, double dinero) throws Exception {

        if (repo.findByCorreo(correo) != null)
            throw new Exception("Ya existe un usuario con ese correo.");

        Usuario nuevo = new Usuario(
            nombre,
            correo,
            AuthService.md5(password),
            edad,
            tipo,
            dinero
        );

        repo.save(nuevo);
    }
    
    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario buscarPorCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    public Usuario buscarPorId(int id) {
        return repo.findById(id);
    }

    public void actualizar(Usuario u) {
        repo.update(u);
    }

    public void eliminar(Usuario u) {
        repo.delete(u);
    }
}
