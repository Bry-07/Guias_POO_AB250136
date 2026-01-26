package Ejercicio02;
import java.util.Scanner;

public class LecturaConsola {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String nombre;
        int edad;
        System.out.print("Ingrese su nombre: ");
        nombre = lector.nextLine();
        System.out.print("Ahora ingrese su edad: ");
        edad = lector.nextInt();

        System.out.println("\nNombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
    }
}
