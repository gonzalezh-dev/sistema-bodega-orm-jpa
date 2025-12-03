/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.view.GestionUsuariosView;
import com.sistemabodega.model.Usuario;
import com.sistemabodega.service.AuthService;
import com.sistemabodega.service.UsuarioService;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class GestionUsuariosController {
    private final UsuarioService userService = new UsuarioService();
    private final GestionUsuariosView view = new GestionUsuariosView();

    public void menu() {
        int op;
        do {
            op = view.mostrarMenu();
            switch(op) {
                case 1: crear();
                    break;
                case 2: listar();
                    break;
                case 3: editar();
                    break;
                case 4: eliminar();
                    break;
                case 0: 
                    break;
                default: view.mostrarMensaje("Opción inválida.");
                    break;
            }
        } while (op != 0);
    }
    
    private void crear() {
        try {
            String nombre = view.pedirInput("Nombre: ");
            String correo = view.pedirInput("Correo: ");
            String pass = view.pedirInput("Contraseña: ");
            int edad = Integer.parseInt(view.pedirInput("Edad: "));
            Usuario.TipoUsuario tipo = Usuario.TipoUsuario.valueOf(view.pedirInput("Tipo (ADMIN/USER): ").toUpperCase());
            double dinero = Double.parseDouble(view.pedirInput("Dinero: "));

            userService.crearUsuario(nombre, correo, pass, edad, tipo, dinero);
            view.mostrarMensaje("Usuario creado correctamente.");
        } catch (Exception e) {
            view.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void listar() {
        userService.listar().forEach(u ->
            view.mostrarMensaje(u.getId() + ": " + u.getNombre() + " (" + u.getTipo() + ") - " + u.getCorreo())
        );
    }

    private void editar() {
        listar();
        int id = Integer.parseInt(view.pedirInput("ID del usuario a editar: "));
        Usuario u = userService.buscarPorId(id);
        if (u == null) {
            view.mostrarMensaje("Usuario no encontrado.");
            return;
        }
        u.setNombre(view.pedirInput("Nuevo nombre: "));
        u.setPassword(AuthService.md5(view.pedirInput("Nueva contraseña: ")));
        u.setEdad(Integer.parseInt(view.pedirInput("Nueva edad: ")));
        u.setDinero(Double.parseDouble(view.pedirInput("Nuevo dinero: ")));
        userService.actualizar(u);
        view.mostrarMensaje("Usuario actualizado.");
    }

    private void eliminar() {
        listar();
        int id = Integer.parseInt(view.pedirInput("ID del usuario a eliminar: "));
        Usuario u = userService.buscarPorId(id);
        if (u == null) {
            view.mostrarMensaje("Usuario no encontrado.");
            return;
        }
        userService.eliminar(u);
        view.mostrarMensaje("Usuario eliminado.");
    }
}