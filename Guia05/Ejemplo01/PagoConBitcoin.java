package Ejemplo01;

public class PagoConBitcoin implements IPago {

    @Override
    public String ProcesarPago(float monto) {
        String resultado =
                String.format("Pago con Bitcoin del monto recibido es $ %.2f",
                        monto);
        return resultado;
    }
}
