/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemabodega;

import com.sistemabodega.controller.AdminController;
import com.sistemabodega.controller.AuthController;
import com.sistemabodega.controller.UsuarioController;
import com.sistemabodega.model.Usuario;
import com.sistemabodega.service.UsuarioService;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class Sistemabodega {

    public static void main(String[] args) {
        inicializarAdmin();

        AuthController authController = new AuthController();
        AdminController adminController = new AdminController();
        UsuarioController usuarioController = new UsuarioController();

        Usuario usuario;
        
        do {
            usuario = authController.login();
        } while (usuario == null);

        if (usuario.getTipo() == Usuario.TipoUsuario.ADMIN) {
            adminController.mostrarMenu(usuario);
        } else {
            usuarioController.mostrarMenu(usuario);
        }
        
        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
        System.exit(0);
    }
    
    private static void inicializarAdmin() {
        UsuarioService userService = new UsuarioService();

        // Verificar si existe algún admin
        boolean existeAdmin = userService.listar().stream()
                .anyMatch(u -> u.getTipo() == Usuario.TipoUsuario.ADMIN);

        if (!existeAdmin) {
            try {
                userService.crearUsuario(
                        "admin",
                        "admin",
                        "admin",
                        30,
                        Usuario.TipoUsuario.ADMIN,
                        0
                );
                System.out.println("Administrador inicial creado: usuario=admin, password=admin");
            } catch (Exception e) {
                System.out.println("Error al crear admin inicial: " + e.getMessage());
            }
        }
    }
}