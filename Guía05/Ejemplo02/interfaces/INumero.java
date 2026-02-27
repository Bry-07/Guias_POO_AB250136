package Ejemplo02.interfaces;

public interface INumero {
    INumero Sumarle(INumero valor);
    //INumero Multiplicarle(INumero valor);
    //INumero Dividir(INumero valor);
    //INumero ElevarA(int n);

    INumero Dividir(INumero valor);
    INumero ElevarA(int n);
}
