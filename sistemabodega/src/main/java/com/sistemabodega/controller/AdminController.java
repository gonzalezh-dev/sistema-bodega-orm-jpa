/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.view.AdminView;
import com.sistemabodega.controller.GestionUsuariosController;
import com.sistemabodega.controller.BodegaController;
import com.sistemabodega.model.Usuario;
import java.util.Scanner;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class AdminController {
    private final AdminView view = new AdminView();
    private final GestionUsuariosController gestionUsuarios = new GestionUsuariosController();
    private final BodegaController bodegaController = new BodegaController();

    
    public void mostrarMenu(Usuario admin) {
        int op;
        do {
            op = view.mostrarMenu();
            switch (op) {
                case 1: gestionUsuarios.menu();
                        break;
                case 2: bodegaController.menu();
                        break;
                case 0: view.mostrarMensaje("Saliendo...");
                        break;
                default: view.mostrarMensaje("Opción inválida.");
                        break;
            }
        } while (op != 0);
    }
}
