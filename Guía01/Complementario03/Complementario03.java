package Complementario03;
import javax.swing.JOptionPane;

public class Complementario03 {
    //En este ejercicio hay una constante la cual es la densidad de la gasolina
    public static final double DENSIDAD_GASOLINA = 0.74; // en kg/L

    public static double solicitarRadio() {
        String entrada1 = JOptionPane.showInputDialog(null, "Ingrese el radio del cilindro en metros.");

        if (entrada1 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        if (entrada1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        double radio = Double.parseDouble(entrada1);
        if (radio <= 0) {
            JOptionPane.showMessageDialog(null, "Error: El radio debe ser un valor positivo mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return radio;
    }

    public static double solicitarAltura() {
        String entrada2 = JOptionPane.showInputDialog(null, "Ingrese la altura del cilindro en metros.");

        if (entrada2 == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        if (entrada2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: La entrada no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        double altura = Double.parseDouble(entrada2);
        if (altura <= 0) {
            JOptionPane.showMessageDialog(null, "Error: La altura debe ser un valor positivo mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return altura;
    }

    public static double calcularVolumen(double radio, double altura) {
        double volumen = Math.PI * Math.pow(radio, 2) * altura * 1000;
        return volumen;
    }

    public static double calcularMasaGasolina(double volumen) {
        double masa = volumen * DENSIDAD_GASOLINA;
        return masa;
    }

    public static void mostrarResultados(double volumeDiesel, double masaGasolina) {
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Volumen máximo de Diesel (Tanque 1): " + String.format("%.2f", volumeDiesel) + " Litros");
        System.out.println("Cantidad límite de Gasolina (Tanque 2): " + String.format("%.2f", masaGasolina) + " Kilogramos");
    }

    public static void main(String[] args) {
        // Solicitar datos de entrada
        double radio = solicitarRadio();
        double altura = solicitarAltura();
        
        // Calcular volumen y masa
        double volumeDiesel = calcularVolumen(radio, altura);
        double masaGasolina = calcularMasaGasolina(volumeDiesel);
        
        // Mostrar resultados
        mostrarResultados(volumeDiesel, masaGasolina);
    }
}

