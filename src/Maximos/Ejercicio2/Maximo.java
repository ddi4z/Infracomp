package Maximos.Ejercicio2;

public class Maximo {
    private int maximo = 0 ;
    private int count = 0;
    
    public synchronized boolean anotar (int n) {
    if (n > maximo)
        maximo = n ;
    count++;
    return count == T.nThreads;
    }


    public synchronized int darMaximo () {
        return maximo ;
    }
}