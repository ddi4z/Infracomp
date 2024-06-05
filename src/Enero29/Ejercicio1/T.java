package Enero29.Ejercicio1;
import java.util.Random;

/* 
    Java – ejercicio . Encontrar
    el máximo de la matriz:
    – Thread por fila
    – El último en ejecutar
    imprime el resultado
    – anotar actualiza e informa
    si es el último
    @author: ddi4z
 */

public class T extends Thread {
    private int id;
    private int maximoLocal = 0;
    private static int[][] mat;
    private static Maximo oMax = new Maximo () ;
    static int nThreads;
    
    public T (int n) {
        id = n ;
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
        new T(i).start() ;
    }
}