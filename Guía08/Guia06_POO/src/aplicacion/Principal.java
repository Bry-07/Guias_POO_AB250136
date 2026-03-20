package aplicacion;

import interfaceswing.recursos.MiVentana;
import interfaceswing.recursos.frmPersona;
import interfaceswing.recursos.frmBotonesRadio;

public class Principal {
    public static void main(String[] args) {
        /*new MiVentana()*/;

        frmPersona formpersona = new frmPersona(
                "Ingreso de datos de una persona");
        formpersona.setVisible(true);

        /*frmBotonesRadio frame = new frmBotonesRadio(
                "Seleccion de imágenes con radiobutton");
        frame.setVisible(true);*/
    }
}
