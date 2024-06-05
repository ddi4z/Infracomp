package Febrero28.Reloj;

public class Reloj extends Thread {
    /* 
        Suponga que un sistema mantiene la hora actualizada de forma local.
        • Escriba la rutina correspondiente (para mantener la hora a lo largo de un día
        en formato 0-23)
        • Suponga que se produce una interrupción de reloj cada 100 milisegundos. 
        @author: ddi4z
    */

    private int hora;

    public synchronized void interrupcionReloj(){
        hora = (hora + 1) % 24;
    }

    public static void main(String[] args) throws InterruptedException {
        Reloj reloj = new Reloj();
        for (int i=0; i<24; i++){
            Thread.sleep(100);
            reloj.interrupcionReloj();
            System.out.println(reloj.hora);
        }
    }
}
