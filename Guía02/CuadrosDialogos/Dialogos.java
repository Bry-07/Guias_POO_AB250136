package CuadrosDialogos;

import javax.swing.JOptionPane;

public class Dialogos {
    public static void main(String[] args) {
        /* dialogo1(); */
        dialogo2();
    }

    static void dialogo1() {
        while (true) {
            try {
                String nombre = JOptionPane.showInputDialog("Como te llamas?");
                String entrada = JOptionPane.showInputDialog("Cuántos años tienes");
                int edad = Integer.parseInt(entrada);

                JOptionPane.showMessageDialog(null, "Hola, " + nombre + ". El año que viene tendrás " + (edad + 1) + " años", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println("Error en edad ingresada");
                JOptionPane.showMessageDialog(null, "Error en algun dato de entrada", "Error",JOptionPane.ERROR_MESSAGE);
                String seleccion = (String) JOptionPane.showInputDialog(null, "Desea Salir", "Seleccione una opcion",JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
                    new Object[]{"Si", "No"}, "Si");
                if (seleccion.equals("Si")) {
                    System.exit(0);
                    break;
                }
            } // fin de catch
        } // fin de while
    } // fin de dialogo1

    static void dialogo2() {
    //Prueba de uso de titulo e icono por defecto en un cuadro de dialogo
    JOptionPane.showMessageDialog(null,"Informacion", "Mensaje De Informacion",JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,"Advertencia", "Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE);
    JOptionPane.showMessageDialog(null,"Error", "Mensaje de Error",JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null,"Sin Icono", "Mensaje de Texto Plano",JOptionPane.PLAIN_MESSAGE);
    } // fin de dialogo2

} // fin de class