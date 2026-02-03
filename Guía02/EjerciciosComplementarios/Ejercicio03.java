package EjerciciosComplementarios;

import java.util.Random;
import javax.swing.JOptionPane;

public class Ejercicio03 {
    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Ingrese su nombre: ");
        if (entrada == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (entrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { //Le pedí este código a ChatGPT para que no se admitan números ni caracteres especiales diferentes a los que se permiten en el nombre como tildes
        JOptionPane.showMessageDialog(null, "Error: El nombre ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        return;
}

        String nombre = entrada;

        String entrada2 = JOptionPane.showInputDialog("Ingrese el monto de la compra: ");
        if (entrada2 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (entrada2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si el usuario ingresa un valor negativo o igual a 0
        if (entrada2.charAt(0) == '-' || entrada2.charAt(0) == '0') {
            JOptionPane.showMessageDialog(null, "Error: El monto no puede ser negativo o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double monto = Double.parseDouble(entrada2);
    
        descuento(nombre, monto);
    }

    static void descuento(String nombre, double monto) {

        Random r = new Random();
        int bolita = r.nextInt(4);

        String color;
        double porcentaje;

        switch (bolita) {
            case 0:
                color = "Café";
                porcentaje = 0.10;
                break;
            case 1:
                color = "Roja";
                porcentaje = 0.15;
                break;
            case 2:
                color = "Azul";
                porcentaje = 0.25;
                break;
            default:
                color = "Verde";
                porcentaje = 0.50;
                break;
        }

        double descuento = monto * porcentaje;
        double total = monto - descuento;

        JOptionPane.showMessageDialog(
            null,
            "Cliente: " + nombre +
            "\nMonto de la compra: $" + String.format("%.2f", monto) +
            "\nColor de la bolita: " + color +
            "\nDescuento aplicado: " + porcentaje*100 + "% = $" + String.format("%.2f", descuento) +
            "\nTotal a pagar: $" + String.format("%.2f", total),
            "Resumen de la compra",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
