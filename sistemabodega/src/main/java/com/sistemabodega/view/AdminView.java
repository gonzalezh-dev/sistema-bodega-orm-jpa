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
public class AdminView {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n==== MENÚ ADMINISTRADOR ====");
        System.out.println("1. Gestión de Usuarios");
        System.out.println("2. Gestión de Bodega");
        System.out.println("0. Salir");
        System.out.print("Seleccione: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
