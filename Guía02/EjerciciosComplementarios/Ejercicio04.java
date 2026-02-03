package EjerciciosComplementarios;

import javax.swing.JOptionPane;
import java.util.HashMap;

public class Ejercicio04 {

    static HashMap<String, String> biblioteca = new HashMap<>();

    public static void main(String[] args) {

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "BIBLIOTECA\n\n"
                  + "1. Registrar libro\n"
                  + "2. Mostrar libros\n"
                  + "3. Actualizar libro\n"
                  + "4. Eliminar libro\n"
                  + "5. Salir\n\n"
                  + "Seleccione una opción:"
            ));

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> mostrarLibros();
                case 3 -> actualizarLibro();
                case 4 -> eliminarLibro();
                case 5 -> JOptionPane.showMessageDialog(null, "Programa finalizado");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 5);
    }

    // ---------------- CRUD ----------------

    static void registrarLibro() {

        String isbn = pedirISBN();
        if (isbn == null) return;

        if (biblioteca.containsKey(isbn)) {
            JOptionPane.showMessageDialog(null, "El ISBN ya existe");
            return;
        }

        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        biblioteca.put(isbn, titulo);

        JOptionPane.showMessageDialog(null, "Libro registrado correctamente");
    }

    static void mostrarLibros() {

        if (biblioteca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados");
            return;
        }

        String mensaje = "";
        for (String isbn : biblioteca.keySet()) {
            mensaje += "ISBN: " + isbn + "\nTítulo: " + biblioteca.get(isbn) + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    static void actualizarLibro() {

        String isbn = pedirISBN();
        if (isbn == null) return;

        if (!biblioteca.containsKey(isbn)) {
            JOptionPane.showMessageDialog(null, "El ISBN no existe");
            return;
        }

        String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título:");
        biblioteca.put(isbn, nuevoTitulo);

        JOptionPane.showMessageDialog(null, "Libro actualizado");
    }

    static void eliminarLibro() {

        String isbn = pedirISBN();
        if (isbn == null) return;

        if (biblioteca.remove(isbn) != null) {
            JOptionPane.showMessageDialog(null, "Libro eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "El ISBN no existe");
        }
    }

    // ---------------- VALIDACIÓN ISBN ----------------

    static String pedirISBN() {

        int intentos = 0;

        while (intentos < 3) {
            String isbn = JOptionPane.showInputDialog("Ingrese ISBN:");

            if (isbn != null && isbn.matches("^[0-9-]{10,17}$")) {
                return isbn;
            }

            intentos++;
            JOptionPane.showMessageDialog(null, "ISBN inválido. Intento " + intentos + " de 3");
        }

        JOptionPane.showMessageDialog(null, "Operación cancelada");
        return null;
    }
}
