/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.controller;

import com.sistemabodega.model.Usuario;
import com.sistemabodega.service.AuthService;
import java.util.Scanner;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class AuthController {
    private final AuthService authService = new AuthService();
    private final Scanner sc = new Scanner(System.in);
    
    public Usuario login() {
        System.out.println("=========== INGRESO ===========");

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario u = authService.login(correo, pass);

        if (u == null) {
            System.out.println("Credenciales incorrectas.\n");
            return null;
        }

        System.out.println("Bienvenido " + u.getNombre() + " (" + u.getTipo() + ")");
        return u;
    }
}
