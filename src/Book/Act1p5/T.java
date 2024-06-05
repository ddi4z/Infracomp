package Book.Act1p5;

/* 
Actividad 1‐5: Corrija el siguiente código para que la salida sea los números del 1 al 10 
ordenados sin repetidos y sin saltos.  
*/
public class T extends Thread {
    public void run () {
        Lista.sumar() ;
    }

    public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
        new T ().start() ;
    }
}

// Parece que basta con usar un synchronized en el método sumar de la clase Lista

