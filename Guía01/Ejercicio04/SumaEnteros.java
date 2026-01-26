package Ejercicio04;
import javax.swing.JOptionPane;

public class SumaEnteros {
    public static void main(String[] args) {
    /*Primera y segunda cadena de texto brindada por usuario*/ 
    String primernumero;  
    String segundonumero;

    int numero1, numero2;
    int suma;

    primernumero = JOptionPane.showInputDialog("Digite el primer número");
    segundonumero = JOptionPane.showInputDialog("Digite el segundo número");

    numero1 = Integer.parseInt(primernumero);
    numero2 = Integer.parseInt(segundonumero);

    if (numero1 < 0 || numero2 < 0) {
        JOptionPane.showMessageDialog(null, "Error: No se permiten números negativos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    suma = numero1 + numero2;

    JOptionPane.showMessageDialog(null, "La suma es: " + suma, "Resultado", JOptionPane.PLAIN_MESSAGE);

    System.exit(0);
    }
}
