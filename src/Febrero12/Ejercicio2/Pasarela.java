package Febrero12.Ejercicio2;
import java.util.LinkedList;

/* 
    Descripción:
    – No puede haber dos personas hacia direcciones distintas en el
    mismo momento
    – Máximo 10 personas en la pasarela en un momento dado
    – Maximizar el uso de la pasarela, aún a riesgo de generar inanición
    del otro lado de la pasarela
    • Actividad:
    – Escribir el código de los procesos que van a subir a la pasarela (En
    C, con semáforos). 
    @author: sariswis
*/

public class Pasarela extends Thread{
    private int pIzqda = 0;
    private int pDcha = 0;
    private int pIzqdaE = 0;
    private int pDchaE = 0;
    private int semIzq = 0;
    private int semDer = 0;
    private int em = 1;
    private LinkedList <Object> queue;

    public void DI(){
        entrarPasarelaI ();
        // Atravesar pasarela
        salirPasarelaI ();
    }

    public void DD(){
        entrarPasarelaD();
        // Atravesar pasarela
        salirPasarelaD();
    }

    public void P(int contador){
        contador--;
        while (contador < 0){
            Object monitor = new Object();
            queue.addLast(monitor);
            try{
                synchronized (monitor){
                    monitor.wait();
                }
            } catch (IllegalMonitorStateException | InterruptedException e){
                e.printStackTrace();
            }
    
        }
    }
    
    public void V(int contador){
        contador++;
        while (contador<0){
            Object monitor = queue.poll();
            if (monitor != null){
                try {
                    synchronized (monitor) {
                        notify();
                    }
                }
                catch (IllegalMonitorStateException e){
                    e.printStackTrace();
                }
                
            }
    
        }
        }

    public void entrarPasarelaD () {
        P(em);
        if (pIzqda > 0 || pDcha == 10) {
            pDchaE++;
            V(em);
            P(semDer);
        } 
        else {
            pDcha ++;
            V(em);
        }
    }

    public void entrarPasarelaI () {
        P(em);
        if (pDcha > 0 || pIzqda == 10) {
            pIzqdaE++;
            V(em);
            P(semIzq);
        } 
        else {
            pIzqda ++;
            V(em);
        }
    }

    public void salirPasarelaD () {
        P(em);
        pDcha --;
        V(semDer);
        V(em);
    }

    public void salirPasarelaI () {
        P(em);
        pIzqda --;
        V(semIzq);
        V(em);
    }
}
