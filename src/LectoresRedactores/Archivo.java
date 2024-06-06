package LectoresRedactores;

/*
    Ejercicio1. Lectores – redactores debilitado :
    – Resuelva el problema de los lectores-redactores con el
    siguiente ajuste:
    Los lectores pueden estar en compañía de otros lectores o
    de un redactor.
    @author: ddi4z
*/

public class Archivo {
    private int nRedactores = 0 ;


    public synchronized void entrarLeer () {}

    public synchronized void salirLeer () {}

    public synchronized void entrarEscribir () {
    while (nRedactores > 1)
        try {
            wait () ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nRedactores++ ;
    }

    public synchronized void salirEscribir () {
        nRedactores-- ;
        notifyAll () ;
    }
}
