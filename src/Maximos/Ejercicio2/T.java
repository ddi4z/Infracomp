package Maximos.Ejercicio2;
import java.util.Random;

/* 
    Java – ejercicio . Repetir ejercicio anterior, pero ahora el main
    no pasa el identificador entero como parámetro. En lugar de
    esto:
    – Se tiene un objeto id que reparte identificadores. Este objeto tiene
    un método darId() que retorna los números de 0 a n-1 en
    secuencia.
    – Cuando el main() crea los threads, les pasa como parámetro una
    referencia a id.
    – Cada thread invoca darId() para tener su identificador (el número
    de fila que le toca a él). Después, proceden igual que en el caso
    anterior. 
    @author: ddi4z
*/

public class T extends Thread {
    private int id;
    private int maximoLocal = 0;
    private static int[][] mat;
    private static Maximo oMax = new Maximo () ;
    private static Id oId = new Id();
    static int nThreads;
    
    public T (Id oid) {
        id = oid.darId() ;
    }

    public static void inicializar(){
        T.nThreads = 5;
        mat = new int[nThreads][nThreads];
        Random r = new Random();
        for (int i = 0; i < nThreads; i++)
            for (int j = 0; j < nThreads; j++)
                mat[i][j] = r.nextInt(100);
    }

    @Override
    public void run() {

        for (int i = 0; i < nThreads; i++)
           if (mat[id][i] > maximoLocal)
               maximoLocal = mat[id][i];
        if (oMax.anotar(maximoLocal))
            System.out.println("El máximo es: " +  oMax.darMaximo()) ;
    }

    public static void main(String[] args) {
    inicializar();

    for (int i = 0; i < nThreads; i++){
        for (int j = 0; j < nThreads; j++)
            System.out.print(mat[i][j] + " ");
        System.out.println();
    }
    for ( int i = 0; i < nThreads; i++)
        new T(oId).start() ;
    }
}