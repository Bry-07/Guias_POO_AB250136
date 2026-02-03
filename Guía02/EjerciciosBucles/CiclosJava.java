package EjerciciosBucles;

import javax.swing.JOptionPane;

public class CiclosJava {
    public static void main(String[] args) {
        /* ciclos1(); */
        /* ciclos2(); */
        ciclos3();
    }

    static void factorial(int n) {
        
    long resultado=1;

    for(int i=1; i<=n; i++){
        resultado=resultado*i;
        System.out.printf("%d ", resultado);
    }

    JOptionPane.showMessageDialog(null, "El factorial de " + n + " es: " + resultado, "Resultado",JOptionPane.INFORMATION_MESSAGE);
    System.out.printf("\nValor de %d! es %d", n, resultado);
    }

    static void ciclos1() {
        int numero;
    System.out.println("Programa para calculo del factorial de un numero\n");
    String strnumero = JOptionPane.showInputDialog("Ingrese Numero entero: ");
    numero = Integer.parseInt(strnumero);
    factorial(numero);
    }

    static void ciclos2() {
        String leer;
        double sueldo, mayor=0, menor=0;
        int i=1, contador=0;

        while(i<=5) {
            leer= JOptionPane.showInputDialog("Ingrese el Sueldo del Empleado " +i);
            sueldo= Double.parseDouble(leer);
            if(sueldo>300) contador= contador + 1;
            if(sueldo>mayor) mayor=sueldo;
            if(menor==0) menor = sueldo;
            if(sueldo<menor) menor=sueldo;
            i++;
        }

        JOptionPane.showMessageDialog(null," El sueldo Mayor es de $: " + mayor +"\nEl sueldo Menor es de $: " + menor + "\n"+ contador + " Empleados tienen un sueldo mayor de $300");
    }

    static void ciclos3() {
        //declara e inicializa a un vector
        int Numero[]={1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int Suma=0; //acumulador

        //for clasico
        for(int indice=0; indice<10; indice++){
            //acumula suma de valores
            Suma = Suma + Numero[indice];
        }

        System.out.println("Total con for clasico " + Suma);
        Suma=0; //reinicializa acumulador de suma de valores
        //utilizacion de for mejorado
        for(int valor: Numero){
            Suma += valor;
        }
        System.out.println("Total con for mejorado " + Suma);
    }
}