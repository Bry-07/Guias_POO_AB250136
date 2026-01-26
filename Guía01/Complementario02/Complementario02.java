package Complementario02;
import javax.swing.JOptionPane;

public class Complementario02 {
    //Método estático para los capacitores en serie y luego llamarlos en el main
    public static double capacitorEnSerie(double C1, double C2, double C3) {
        return 1 / ((1 / C1) + (1 / C2) + (1 / C3));
    }

    //Método estático para los capacitores en paralelo y luego llamarlos en el main
    public static double capacitorEnParalelo(double C1, double C2, double C3) {
        return C1 + C2 + C3;
    }

    public static void main(String[] args) {

        // JOptionPane para solicitar los valores con un cuadro de diálogo
        // Validaciones para entradas nulas, vacías, negativas o iguales a 0

        /* ----------------------------------------------------------- Entrada 1 --------------------------------------------------------------------------------- */
        String entrada1 = JOptionPane.showInputDialog("Ingrese el valor del capacitor 1 (en microfaradios):");

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
        
        //Conversión de la entrada a tipo double para validación de valor positivo
        double C1 = Double.parseDouble(entrada1);

        // Si el usuario ingresa un valor negativo o igual a 0
        if (C1 <= 0) {
            JOptionPane.showMessageDialog(null, "Error: Los valores de los capacitores deben ser positivos y mayores a cero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* ----------------------------------------------------------- Entrada 2 --------------------------------------------------------------------------------- */
        String entrada2 = JOptionPane.showInputDialog("Ingrese el valor del capacitor 2 (en microfaradios):");

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

        //Conversión de la entrada a tipo double para validación de valor positivo
        double C2 = Double.parseDouble(entrada2);
        if (C2 <= 0) {
            JOptionPane.showMessageDialog(null, "Error: Los valores de los capacitores deben ser positivos y mayores a cero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /* ----------------------------------------------------------- Entrada 3 --------------------------------------------------------------------------------- */
        String entrada3 = JOptionPane.showInputDialog("Ingrese el valor del capacitor 3 (en microfaradios):");

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

        //Conversión de la entrada a tipo double para validación de valor positivo
        double C3 = Double.parseDouble(entrada3);
        if (C3 <= 0) {
            JOptionPane.showMessageDialog(null, "Error: Los valores de los capacitores deben ser positivos y mayores a cero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Salidas de datos ingresados y resultados en la consola
        System.out.println("\n=== DATOS INGRESADOS ===");
        System.out.println("Capacitor 1: " + C1 + " Microfaradios");
        System.out.println("Capacitor 2: " + C2 + " Microfaradios");
        System.out.println("Capacitor 3: " + C3 + " Microfaradios");

        // Calcula las entradas y llama el método correspondiente
        double CeqSerie = capacitorEnSerie(C1, C2, C3);
        double CeqParalelo = capacitorEnParalelo(C1, C2, C3);

        // Muestra los resultados de los métodos en la consola
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Capacitor equivalente en serie: " + String.format("%.2f", CeqSerie) + " Microfaradios"); /* "%.2f" formatea el número a 2 decimales, no lo sabía pero me lo recomendó la IA*/
        System.out.println("Capacitor equivalente en paralelo: " + String.format("%.2f", CeqParalelo) + " Microfaradios");
    }
}