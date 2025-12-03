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
public class CompraView {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenuProducto() {
        System.out.print("ID del producto a comprar: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int pedirCantidad() {
        System.out.print("Cantidad de cajas: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}