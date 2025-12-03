/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.service;

import com.sistemabodega.model.Usuario;
import com.sistemabodega.repository.UsuarioRepository;
import java.security.MessageDigest;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class AuthService {
    
    private final UsuarioRepository usuarioRepo = new UsuarioRepository();

    public Usuario login(String correo, String password) {
        Usuario u = usuarioRepo.findByCorreo(correo);

        if (u == null) return null;

        String passMd5 = md5(password);

        if (u.getPassword().equals(passMd5)) {
            return u; // Login exitoso
        }

        return null; // Contraseña incorrecta
    }
    
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
