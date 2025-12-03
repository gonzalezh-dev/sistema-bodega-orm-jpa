/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemabodega.view;

import java.util.Scanner;

/**
 *
 * @author Humberto Gonzalez B.
 */
public class GestionUsuariosView {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n==== GESTIÓN DE USUARIOS ====");
        System.out.println("1. Crear usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Editar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirInput(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}