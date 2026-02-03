package EjerciciosIF;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControlIF {
    public static void main(String[] args) {
        //ejemplo1();
        //ejemplo2();
        //ejemplo3();
        ejemplo4();
    }

    static void ejemplo1() {
        Scanner reader = new Scanner(System.in);
        int Var1, Var2;
        System.out.println("Ingrese número 01: ");
        Var1 = reader.nextInt();
        System.out.println("Ingrese número 02: ");
        Var2 = reader.nextInt();
        if(Var1==Var2)
            System.out.println("Los números ingresados son iguales ");
        else
            System.out.println("Los números ingresados no son iguales ");
    }

    static void ejemplo2() {
        String v1 = "";
        v1 = JOptionPane.showInputDialog("Ingrese un valor: ");
        if(v1 == null)
            JOptionPane.showMessageDialog(null,"Presionaste cancelar");
        else{
            if(v1.equals(""))
                JOptionPane.showMessageDialog(null, "No ingresaste nada");
            else
                JOptionPane.showMessageDialog(null, "El valor de V1 es: "+v1);
        }
        System.exit(0);
    }

    static void ejemplo3(){
        int result = JOptionPane.showConfirmDialog(null, "Replace existing selection?");
        System.out.println("El numero devuelto por showConfirmDialog es: "+result);
        if (result == JOptionPane.YES_OPTION)
            System.out.println("Yes");
        else if (result == JOptionPane.NO_OPTION)
            System.out.println("No");
        else if (result == JOptionPane.CANCEL_OPTION)
            System.out.println("Cancel");
        else if (result == JOptionPane.CLOSED_OPTION)
            System.out.println("Closed");

        System.exit(0);
    }

    static void ejemplo4() {
        String datos;
        double sueldo, afp=0, isss, totalre, nsueldo, renta;
        datos = JOptionPane.showInputDialog(" Ingrese el sueldo del empleado (a) ");
                sueldo = Double.parseDouble(datos);

        Object[] sexoOpciones = { "M", "F" };
        datos = (String) JOptionPane.showInputDialog(
        null,
        "Ingrese el Sexo:\nSi es Masculino (M)\nSi es Femenino (F)",
        "Sexo del Empleado",
        JOptionPane.QUESTION_MESSAGE,
        null,
        sexoOpciones,
        "F");

        if(datos == "M")//Si es de sexo Masculino
        {
            isss = sueldo*0.03;
            renta=sueldo*0.10;
            totalre = afp+isss+renta;
            nsueldo = sueldo - totalre;
            JOptionPane.showMessageDialog(null, "A este empleado se le detiene " + isss + " en concepto de ISSS\nAdemas se le retiene: " + renta + " En concepto de Renta Lo que hace un total de " + totalre + "\nY su nuevo Sueldo es de: "+ nsueldo);
        }
    }
}
