/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.view.UsuarioView;
import com.sistemabodega.model.Usuario;
import com.sistemabodega.service.AuthService;
import com.sistemabodega.service.UsuarioService;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class UsuarioController {
    private final UsuarioView view = new UsuarioView();
    private final UsuarioService userService = new UsuarioService();
    private final CompraController compraController = new CompraController();
    
    public void mostrarMenu(Usuario u) {
        int op;
        do {
            op = view.mostrarMenu();
            switch (op) {
                case 1: modificarDatos(u);
                        break;
                case 2: compraController.realizarCompra(u);
                        break;
                case 0: view.mostrarMensaje("Saliendo...");
                        break;
                default: view.mostrarMensaje("Opción inválida.");
                        break;
            }
        } while (op != 0);
    }

    private void modificarDatos(Usuario u) {
        String nuevoNombre = view.pedirInput("Nuevo nombre: ");
        String nuevaPass = view.pedirInput("Nueva contraseña: ");

        u.setNombre(nuevoNombre);
        u.setPassword(AuthService.md5(nuevaPass));

        userService.actualizar(u);
        view.mostrarMensaje("Datos actualizados.");
    }
}