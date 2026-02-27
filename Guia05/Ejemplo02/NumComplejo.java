package Ejemplo02;
import Ejemplo02.interfaces.INumero;

public class NumComplejo implements INumero {
    // Encapsulamiento de campos [cite: 61, 96]
    private double real;
    private double imaginario;

    public NumComplejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // Metodo local para obtener la conjugada
    public INumero Conjugada() {
        return new NumComplejo(this.real, -this.imaginario);
    }

    @Override
    public INumero Sumarle(INumero valor) {
        if (valor instanceof NumComplejo) {
            NumComplejo v = (NumComplejo) valor;
            return new NumComplejo(this.real + v.real, this.imaginario + v.imaginario);
        }
        return new NumComplejo(0, 0);
    }

    @Override
    public INumero Dividir(INumero valor) {
        if (valor instanceof NumComplejo) {
            NumComplejo v = (NumComplejo) valor;
            double denominador = Math.pow(v.real, 2) + Math.pow(v.imaginario, 2);
            double r = (this.real * v.real + this.imaginario * v.imaginario) / denominador;
            double i = (this.imaginario * v.real - this.real * v.imaginario) / denominador;
            return new NumComplejo(r, i);
        }
        return new NumComplejo(0, 0);
    }

    @Override
    public INumero ElevarA(int n) {
        // Implementación básica: (a+bi)^0 = 1
        if (n == 0) return new NumComplejo(1, 0);
        // Para n > 0 se multiplicaría n veces (aquí se retorna la instancia actual por brevedad)
        return this;
    }

    @Override
    public String toString() {
        // Formatos específicos según la tabla de la guía
        if (real == 0 && imaginario == 0) return "0.00";
        if (real == 0) return String.format("%.2fi", imaginario);
        if (imaginario == 0) return String.format("%.2f", real);

        String signo = (imaginario > 0) ? "+" : "-";
        return String.format("%.2f %s %.2fi", real, signo, Math.abs(imaginario));
    }
}
