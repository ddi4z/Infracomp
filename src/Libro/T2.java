package Libro;

/* 
Actividad 1‐5: Corrija el siguiente código para que la salida sea los números del 1 al 10 
ordenados sin repetidos y sin saltos.  
*/
public class T2 extends Thread {
    public void run () {
        Lista.sumar() ;
    }

    public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
        new T2 ().start() ;
    }
}

// Parece que basta con usar un synchronized en el método sumar de la clase Lista

