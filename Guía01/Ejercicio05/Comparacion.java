package Ejercicio05;

import javax.swing.JOptionPane;

public class Comparacion {
    public static void main(String[] args) {
        String primernumero, segundonumero, resultado;
        int numero1, numero2;

        primernumero =
                JOptionPane.showInputDialog("Escriba el primer entero:");
        segundonumero =
                JOptionPane.showInputDialog("Escriba el Segundo Entero:");
        numero1= Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);
        resultado= "";
        if (numero1==numero2) {
            resultado= resultado + numero1 + " == " + numero2;
        }
        if (numero1 != numero2) {
            resultado= resultado + numero1 + " != " + numero2;
        }
        if (numero1 < numero2) {
            resultado= resultado + "\n" + numero1 + " < " + numero2;
        }
        if (numero1 > numero2) {
            resultado= resultado + "\n" + numero1 + " > " + numero2;
        }

        if (numero1 <= numero2)
            resultado= resultado + "\n" + numero1 + " <=" + numero2;

        if (numero1 > numero2)
            resultado= resultado + "\n" + numero1 + " >= " + numero2;

        JOptionPane.showConfirmDialog(null, resultado,
                "Resultado de la comparación",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    } //fin metodo main
} /* fin clase comparacion */
