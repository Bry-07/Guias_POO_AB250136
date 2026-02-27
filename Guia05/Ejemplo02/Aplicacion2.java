package Ejemplo02;

import java.util.ArrayList;

public class Aplicacion2 {

    public static void main(String[] args) {
        //Instancias de clase NumFraccionario
        NumFraccionario f0, f1, f2, f3, f4;
        NumFraccionario r1, r2, r3;

        //Para almacenar cálculos
        int mcm, mcd;

        System.out.println("Operaciones con Fracciones");
        //Inicializa instancias

        f0 = new NumFraccionario();
        f1 = new NumFraccionario(2,5); // 2/5
        f2 = new NumFraccionario(3, 8); // 3/8
        f3 = new NumFraccionario(-168, 210); // -168/210
        f4 = new NumFraccionario(3); // 3/1

        System.out.format("Las fracciones para las pruebas serán %s, %s, %s, %s y %s\n\n",
                f0, f1, f2, f3, f4);

        mcm = f0.calcularMCM(630, 1050);
        mcd = f0.calcularMCD(630, 1050);
        System.out.format("El mcm de 630 y 1050 es %d, el mcd es %d\n", mcm, mcd);

        mcm = f0.calcularMCM(f1, f2);
        mcd = f0.calcularMCD(f1, f2);
        System.out.format("El mcm de los denominadores de %s y %s es %d, el mcd es %d\n",
                f1, f2, mcm, mcd);

        System.out.format("La fraccion equivalente y simplificada de %s", f3);
        r1 = f3.Simplificar();
        System.out.format(" es %s\n", r1);

        System.out.format("La fraccion equivalente y simplificada de 300/270 es %s\n",
                f0.Simplificar(300, 270));

        f0 = new NumFraccionario(-23, 125);
        System.out.format("El valor decimal de la fraccion %s es %.4f\n",
                f0, f0.aDecimal());

        r2 = (NumFraccionario) f1.Sumarle(f2); //calcula suma de 3er numero con 4to numero
        System.out.format("\nLa suma de %s con %s es %s\n", f1,f2,r2);

        //suma un entero con la fraccion
        f0 = (NumFraccionario) f1.Sumarle(f4);
        System.out.format("Suma de %s y %s es %s\n", f1,f4,f0);
        if(f1.EsMayorQue(f4)) //compara fraccion f1 con f4
            System.out.format("La fraccion * %s es mayor que %s\n",f1,f4);
        else
            System.out.format("La fraccion %s es mayor que %s\n",f4,f1);


        // DIVIDIR
        NumFraccionario base = new NumFraccionario(2, 3);
        System.out.println("\n--- Pruebas de División (Base 2/3) ---");

        // Ejemplo 1: (2/3) / (4/9)
        r1 = (NumFraccionario) base.Dividir(new NumFraccionario(4, 9));
        System.out.format("%s / 4/9 = %s\n", base, r1);

        // Ejemplo 2: (2/3) / (-3/7)
        r1 = (NumFraccionario) base.Dividir(new NumFraccionario(-3, 7));
        System.out.format("%s / -3/7 = %s\n", base, r1);

        // ELEVAR
        System.out.println("\n--- Pruebas de Potencia ---");

        // Ejemplo 1: (1/3)^2 = 1/9
        NumFraccionario fPotencia = new NumFraccionario(1, 3);
        System.out.format("(%s)^2 = %s\n", fPotencia, fPotencia.ElevarA(2));

        // Ejemplo 2: (1/2)^-3 = 8
        fPotencia = new NumFraccionario(1, 2);
        System.out.format("(%s)^-3 = %s\n", fPotencia, fPotencia.ElevarA(-3));

        // Ejemplo 3: (-6/10)^-3 = -125/27
        fPotencia = new NumFraccionario(-6, 10);
        System.out.format("(%s)^-3 = %s\n", fPotencia, fPotencia.ElevarA(-3));

        // NÚMEROS COMPLEJOS
        System.out.println("\n--- Pruebas de Números Complejos ---");

        NumComplejo c1 = new NumComplejo(5, -3);
        NumComplejo c2 = new NumComplejo(0, 6.27);
        NumComplejo c3 = new NumComplejo(-8.4, 0);
        NumComplejo c4 = new NumComplejo(6.1, 4);

        System.out.println("Complejo 1 (5, -3i): " + c1);
        System.out.println("Complejo 2 (0, 6.27i): " + c2);
        System.out.println("Complejo 3 (-8.4, 0i): " + c3);
        System.out.println("Suma (c1 + c4): " + c1.Sumarle(c4));
        System.out.println("Conjugada de c1: " + c1.Conjugada());
    }

    public static void procesarFracciones(java.util.ArrayList<NumFraccionario> lista) {
        if  (lista == null || lista.isEmpty()) {
            System.out.println("Datos recibidos son incompletos, fin de ejecución del método");
            return;
        }

        NumFraccionario sumaTotal = new NumFraccionario(0,1);
        System.out.println("Listado de fracciones");

        for (NumFraccionario f : lista) {
            System.out.println("- " + f.toString());
            sumaTotal = (NumFraccionario) sumaTotal.Sumarle(f); // uso de sumarle
        }

        System.out.println("La suma de todos los valores es: " + sumaTotal);
    }
}