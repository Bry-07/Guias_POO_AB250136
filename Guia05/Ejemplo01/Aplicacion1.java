package Ejemplo01;

import java.util.Scanner;

public class Aplicacion1 {
    public static void main(String[] args) {

        IPago metodopago = null;

        Scanner sc = new Scanner(System.in);
        float monto; //Valor de método para pagar monto
        int tipopago;
        String resultado;

        System.out.println("Tienda de conveniencia\n");
        System.out.println("Ingrese valor del monto a realizar: $ ");
        monto = sc.nextFloat();
        System.out.println("\nMétodos de Pago: ");
        System.out.println("\t1. Tarjeta de Crédito\n\t2. Bitcoins\n\t3. Efectivo");
        System.out.println("Seleccione número con método de pago del monto ingresado: ");
        tipopago = sc.nextInt();
        switch (tipopago) {
            case 1:
                metodopago = new PagoConTarjeta();
                break;
            case 2:
                metodopago = new PagoConBitcoin();
                break;
            case 3:
                metodopago = new PagoConEfectivo();
                break;
        } //fin switch tipo pago

        //ejecuta el pago con método elegido
        if (metodopago == null)
            System.out.println("Error: No eligió un método de pago válido");
        else {
            resultado = metodopago.ProcesarPago(monto);
            System.out.println(resultado);
        }
    }
}
