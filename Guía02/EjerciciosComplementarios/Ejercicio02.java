package EjerciciosComplementarios;

import javax.swing.JOptionPane;

public class Ejercicio02 {

    public static void main(String[] args) {

        /* ----------------------------------------------------------- Entrada 1 --------------------------------------------------------------------------------- */
        String entrada1 = JOptionPane.showInputDialog("Ingrese el valor de a: ");

        // Si el usuario presiona cancelar
        if (entrada1 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Si el usuario deja la entrada vacía
        if (entrada1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int a = Integer.parseInt(entrada1);

        /* ----------------------------------------------------------- Entrada 2 --------------------------------------------------------------------------------- */

        String entrada2 = JOptionPane.showInputDialog("Ingrese el valor de b: ");

        // Si el usuario presiona cancelar
        if (entrada2 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Si el usuario deja la entrada vacía
        if (entrada2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int b = Integer.parseInt(entrada2);

        /* ----------------------------------------------------------- Entrada 3 --------------------------------------------------------------------------------- */

        String entrada3 = JOptionPane.showInputDialog("Ingrese el valor de c: ");

        // Si el usuario presiona cancelar
        if (entrada3 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Si el usuario deja la entrada vacía
        if (entrada3.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int c = Integer.parseInt(entrada3);

        // Llamar al método 
        cuadratica(a, b, c);
    }

    static void cuadratica(int a, int b, int c) {
        double d = determinante(a, b, c);

        if (d > 0) {
            // Dos raíces reales y distintas
            double x1 = (-b + Math.sqrt(d)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(d)) / (2.0 * a);
            System.out.println("Las raíces son reales y diferentes: " + String.format("%.2f", x1) + " y " + String.format("%.2f", x2));

        } else if (d == 0) {
            // Una única raíz real (doble)
            double raiz = -b / (2.0 * a);
            System.out.println("Las raíces son reales e iguales: " + String.format("%.2f", raiz));

        } else {
            // Raíces complejas
            double parteReal = -b / (2.0 * a);
            double parteImaginaria = Math.sqrt(-d) / (2.0 * a);
            System.out.println("Las raíces son complejas: "
                    + String.format("%.2f", parteReal) + " + " + String.format("%.2f", parteImaginaria) + "i y "
                    + String.format("%.2f", parteReal) + " - " + String.format("%.2f", parteImaginaria) + "i");
        }
    }

    static double determinante(int a, int b, int c) {
        return (double) b * b - 4.0 * a * c;
    }
}