package Libro;
/*
Actividad 1‐4: Ejecute varias veces el siguiente código y explique el resultado. Asegúrese de entender bien la
sintaxis y la estructura. ¿Es necesario el static en la declaración de oMax? ¿Cuál es el propósito de
synchronized en el método anotar? Pruébelo con y sin ese synchronized.
*/

public class T1 extends Thread {
    private static Maximo oMax = new Maximo () ;
    private int num = 0 ;

    public T1 (int n) {
        num = n ;
    }

    public void run () {
        oMax.anotar(num) ;
    }

    public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
        new T1 (i).start();

    System.out.println ("El máximo es: " +  oMax.darMaximo()) ;
    }
}

// Es necesario el static, ya que no se esta guardando ninguno de los Threads creados
// El propósito de synchronized en el método anotar es que no se pueda acceder a la variable maximo de manera concurrente
// El codigo falla ya que puede imprimir antes de terminar de ejecutar los Threads
