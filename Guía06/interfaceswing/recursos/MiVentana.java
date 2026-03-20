package interfaceswing.recursos;

import javax.swing.*;

public class MiVentana extends JFrame {
    public MiVentana() {

        JLabel lblHola = new JLabel("Hola, soy una etiqueta JLabel ");
        //Metodo add, heredado de clase JFrame para insertar objeto a su coleccion
        //de controles disponibles para presentar en la ventana
        this.add(lblHola);

        //Dimensiones (ancho, alto) de ventana
        this.setSize(500, 200);

        //Titulo de ventana a generar
        this.setTitle("Mi primer ventana con JFrame");

        //Cuando cierre ventana, se finaliza instancia de esta clase
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centra ventana en monitor

        this.setVisible(true);
    }
}
