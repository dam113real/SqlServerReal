/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Vista {

    public void mostrarTexto(String texto) {
        System.out.println(texto);
    }
    private Scanner scanner = new Scanner(System.in);
    
    public int leerEntero() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Por favor, introduzca un número válido: ");
                scanner.next(); // Limpia el buffer
            }
        }
    }
}
