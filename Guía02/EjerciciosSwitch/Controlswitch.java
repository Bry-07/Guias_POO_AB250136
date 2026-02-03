package EjerciciosSwitch;

import javax.swing.JOptionPane;

public class Controlswitch {
    public static void main(String[] args) {
        //switch1(3, -9, '+');
        switch2();
    }

    public static void switch1(int a, int b, char op) {
        switch (op) {
            case '+':
                // imprime mensaje como concatenación de varios String
                System.out.println("El resultado de " + a + " " + op + " " + b + " es " + (a + b));
                break;

            case '-':
                // imprime mensaje basado en una cadena String con formato,
                // idéntica a como se hace con C++
                // %n: genera efecto de \n
                System.out.printf("El resultado de %d %c %d es %d %n", a, op, b, a - b);
                break;

            case '*':
                // imprime signo de cada valor numérico
                // el signo se mostrará aunque el valor sea positivo
                System.out.printf("El resultado de %+d %c %+d es %d %n", a, op, b, a * b);
                break;

            case '/':
                // se aplica conversión explícita a variable b,
                // para operar división como resultado decimal
                System.out.printf("El resultado de %d %c %d es %.4f%n", a, op, b, a / (double) b);
                break;

            default:
                System.out.printf("Error, símbolo (%c) no es un operador aritmético", op);
                break;
        }
    }

    static void switch2() {

    String result = "?";
    int botonpresionado = JOptionPane.showConfirmDialog(null, "Quiere reemplazar su seleccion?");

    switch (botonpresionado) {
        case JOptionPane.CANCEL_OPTION:
            result = "Canceled";
        break;
    
        case JOptionPane.CLOSED_OPTION:
            result = "Closed";
        break;
    
        case JOptionPane.NO_OPTION:
            result = "No";
        break;
    
        case JOptionPane.YES_OPTION:
            result = "Yes";
        break;
    }

        System.out.println("Boton elegido del cuadro de dialogo: " + result);
    }

    
}