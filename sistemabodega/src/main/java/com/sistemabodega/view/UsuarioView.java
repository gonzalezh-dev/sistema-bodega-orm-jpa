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
public class UsuarioView {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n==== MENÚ USUARIO ====");
        System.out.println("1. Modificar mis datos");
        System.out.println("2. Realizar compra");
        System.out.println("0. Salir");
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