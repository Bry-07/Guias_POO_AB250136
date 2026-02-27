package Ejemplo02;

import Ejemplo02.interfaces.IComparable;
import Ejemplo02.interfaces.INumero;

public class NumFraccionario implements INumero, IComparable {

    private int num;
    private int deno;

    public int getNum() {
        return num;
    }

    public int getDeno() {
        return deno;
    }

    public void setDeno(int deno) {
        // para evitar una fracción don denominador cero, ej: 8/0, -4/0 etc.
        if(deno!=0) {
            this.deno = deno;
        }
    }

    public void setNum(int num) {
        this.num = num;
    }

    public NumFraccionario() {
        setNum(0);
        setDeno(1);
    }

    public NumFraccionario(int num, int deno) { //Sobrecarga 1
        setDeno(1); //evitar fracción con denominador 0

        setNum(num);
        setDeno(deno);
    }

    public NumFraccionario(int entero) { // Sobrecarga 2
        //Para almacenar un entero como una fracción, ej: 3 se expresará como 3/1
        setNum(entero);
        setDeno(1);
    }

    // reemplaza metodo toString heredado de clase Object,
    // para retornar como String a vista de la fraccion almacenada
    @Override
    public String toString() {
        // Si es un entero (denominador es 1)
        if(deno==1)
            return String.valueOf(num);

        //Identifica si es impropia (numerador absoluto > denominador)
        if (Math.abs(num) > deno) {
            int parteEntera = num / deno;
            int residuo = Math.abs(num % deno);

            if (residuo == 0) return String.valueOf(parteEntera);

            //Formato: Entero(Numerador/Denominador)
            return String.format("%d(%d/%d)", parteEntera, residuo, deno);
        }
        //Fracción propia normal
        return num + "/" + deno;
    }

    // Operaciones propias sobre solamente fracciones (a/b)
    // metodo para calcular el Máximo Común Divisor (algoritmo de euclides)
    public int calcularMCD(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // metodo para calcular el MCM usando el MCD
    public int calcularMCM(int a, int b) {
        int mcm;
        if (a == 0 || b == 0) {
            return 0;
        }
        mcm = (a * b) / calcularMCD(a, b);
        return mcm;
    }

    public int calcularMCM(NumFraccionario a, NumFraccionario b) { // (sobrecarga)
        //Extrae denominadores para invocar a sobrecarga que recibe solo denominadores
        return calcularMCM(a.getDeno(), b.getDeno());
    }

    public int calcularMCD(NumFraccionario a, NumFraccionario b) { // (sobrecarga)
        // extrae denominadores para invocar a sobrecarga que recibe solo denominadores
        return calcularMCD(a.getDeno(), b.getDeno());
    }

    // simplificar valor de fraccion interna de esta instancia
    public NumFraccionario Simplificar (){
        int mcd = calcularMCD(getNum(), getDeno());
        setNum(getNum()/mcd);
        setDeno(getDeno()/mcd);
        // de manera opcional, retorna nueva instancia de fraccion simplificada
        return new NumFraccionario(getNum(), getDeno());
    }

    //(sobrecarga)
    // simplifica fraccion recibida con numerador y denominador recibidos
    public NumFraccionario Simplificar(int num, int deno) {
        NumFraccionario r = new NumFraccionario();
        int mcd = calcularMCD(num, deno);

        r.setNum(num/mcd);
        r.setDeno(deno/mcd);
        return r;
    }

    private boolean EsNegativa() {
        //retorna true si numerador de fraccion interna es negativa
        if(this.getNum()<0) return true;
        return false;
    }

    public double aDecimal() {
        // retorna valor de cociente de dividir numerador y dneominador
        return (double)this.getNum() / (double)this.getDeno();
    }

    @Override
    public boolean EsMayorQue(IComparable valor) {

        if(valor instanceof NumFraccionario){
            //compara fraccion interna con fraccion recibida en objeto
            NumFraccionario p1, p2;
            p1 = new NumFraccionario(getNum(), getDeno());
            p2 = (NumFraccionario) valor;
            if(!p1.EsNegativa() && !p2.EsNegativa())//Si ambas son positivas
            {
                if(p1.aDecimal()>p2.aDecimal()) return true;
            }
            else
            if(p1.EsNegativa() && p2.EsNegativa()) //si ambas son negativas
            {
                //cambia sentido de prueba
                if(p2.aDecimal()>p1.aDecimal()) return true;
            }
            else
        //tienen signos distintos, si fraccion interna tiene signo positivo, sera mayor
                if(!this.EsNegativa()) return true;
        }
        return false; //fraccion local es menor que fraccion recibida
    }

    @Override
    public INumero Sumarle(INumero valor) {
        // define fraccion con valor cero (0/1), en caso de que no pueda hacer la operacion
        NumFraccionario s = new NumFraccionario();

        // prueba si instancia recibida es del mismo tipo
        if (valor instanceof NumFraccionario) {

            NumFraccionario a, b;

            a = new NumFraccionario(getNum(), getDeno()); // fraccion interna
            b = (NumFraccionario) valor; // convertir parametro

            // Calcula MCM de denominadores
            int mcm = calcularMCM(a.getDeno(), b.getDeno());

            // aplica formula de suma de fracciones
            s.setNum(mcm / a.getDeno() * a.getNum()
                    + mcm / b.getDeno() * b.getNum());

            s.setDeno(mcm);

            // simplifica resultado
            s = s.Simplificar(s.getNum(), s.getDeno());
        }

        return s;
    }

    @Override
    public INumero Dividir(INumero valor) {
        //Definimos la fracción resultado inicializada en cero (0/1)
        NumFraccionario resultado = new NumFraccionario();

        // se verifica si el parámetro que se recibió es una fracción
        if  (valor instanceof NumFraccionario) {
            NumFraccionario b = (NumFraccionario) valor;

            int nuevoNum = this.getNum() * b.getDeno();
            int nuevoDeno = this.getDeno() * b.getNum();

            if (nuevoDeno < 0) {
                nuevoNum *= -1;
                nuevoDeno *= -1;
            }

            resultado.setNum(nuevoNum);
            resultado.setDeno(nuevoDeno);
            resultado = resultado.Simplificar();
        }
        return resultado;
    }

    @Override
    public INumero ElevarA(int n) {
        int nuevoNum, nuevoDeno;

        if (n >= 0) {
            nuevoNum = (int) Math.pow(this.getNum(), n);
            nuevoDeno = (int) Math.pow(this.getDeno(), n);
        } else {
            //exponente negativo
            nuevoNum = (int) Math.pow(this.getDeno(), Math.abs(n));
            nuevoDeno = (int) Math.pow(this.getNum(), Math.abs(n));
        }
        //ajusta el signo si el denominador quedó negativo
        if (nuevoDeno < 0) {
            nuevoNum *= -1;
            nuevoDeno *= -1;
        }

        NumFraccionario resultado = new NumFraccionario(nuevoNum, nuevoDeno);
        return resultado.Simplificar();
    }
}
