package Book.Act1p5;

public class Lista {
    private static int suma = 0 ;

    public static synchronized void sumar () {
        suma ++ ;
        System.out.println ("Suma: " + suma) ;
    }
}