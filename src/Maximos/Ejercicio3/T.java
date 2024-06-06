package Maximos.Ejercicio3;

import java.util.ArrayList;
import java.util.Random;

/*
    Java – ejercicio . Resolver de nuevo el ejercicio del máximo,
    pero con las siguientes características:
    – Se quiere encontrar el máximo, pero de un vector de M posiciones .
    – Se quiere generar una cierta cantidad de threads tal, que a cada
    uno le toque procesar N elementos del vector.
    – M no necesariamente es divisible por N, luego a uno de los thread
    le pueden tocar menos elementos
    @author: ddi4z
*/

public class T extends Thread {
    private int id;
    private int maximoLocal = 0;
    private static ArrayList<Integer> vec;
    private static Maximo oMax = new Maximo () ;
    private static int n;
    private static int m;
    static int nThreads;

    
    public T (int n) {
        id = n ;
    }


    public static void inicializar(){
        n = 23;
        m = 5;
        nThreads = (int) Math.ceil( (double) n/m);
        vec = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < n; i++)
            vec.add(r.nextInt(100));
    }

    @Override
    public void run() {
        int ini = id * m;
        int fin = Math.min(n, (id + 1) * m);
        for (int i = ini; i < fin; i++)
            if (vec.get(i) > maximoLocal)
                maximoLocal = vec.get(i);
        if (oMax.anotar(maximoLocal))
            System.out.println("El máximo es: " + oMax.darMaximo());
    }

    public static void main(String[] args) {
    inicializar();
    for (int i = 0; i < n; i++){
        System.out.print(vec.get(i) + " ");
    }
    System.out.println();

    for ( int i = 0; i < nThreads; i++)
        new T(i).start() ;
    }
}