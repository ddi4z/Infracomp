package Book.Act1p4;


public class Maximo {
    private int maximo = 0 ;

    public int darMaximo () {
        return maximo ;
    }
    public synchronized void anotar (int n) {
    if (n > maximo)
        maximo = n ;
    }
}