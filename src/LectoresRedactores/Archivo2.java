package LectoresRedactores;

/*
    • Ejercicio 2. Lectores – redactores sin inanición (más o
    menos):
    – Modificar el programa anterior para que no se presente esa
    situación; en lugar de esto, cuando un redactor se encuentra
    en espera, no se permite la entrada de más lectores (quedan
    en espera en las mismas condiciones de los redactores).
    @author: ddi4z
*/

public class Archivo2 {
    private int nRedactores = 0 ;
    private int nLectores = 0 ;

    public synchronized void entrarLeer () {
        while (nRedactores == 1)
        try {
            wait () ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nLectores++ ;
    }

    public synchronized void entrarEscribir () {
        while (nRedactores != 0 || nLectores != 0)
        try {
            wait () ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nRedactores++ ;
    }

    public synchronized void salirLeer () {
        nLectores-- ;
        if (nLectores == 0)
        notify () ;
    }

    public synchronized void salirEscribir () {
        nRedactores-- ;
        notifyAll () ;
    }

}
