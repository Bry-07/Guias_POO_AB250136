package aplicacion;
import modelos.*;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        /*new VerPersonas();*/

        /*System.out.println("Número de teléfono: ");
        if (Testing.compareTelephone("2526-1485"))
            System.out.println("Es válido");
        else
            System.out.println("Es Incorrecto");
        System.out.println("Fecha ");
        if (Testing.compareDate("2021-06-14")) System.out.println("Es válido ");
        else System.out.println("Es Incorrecto");*/

        //declara e instancia a objeto ing de clase IngresoDatos
        /*IngresoDatos ing = new IngresoDatos();

        //invoca a metodos
        ing.IngresoDatos();
        ing.mostrardatos();
        ing.cierreconexion();*/


        new VerificarNulos();

    }
}
