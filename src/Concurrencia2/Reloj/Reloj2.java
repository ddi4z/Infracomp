package Concurrencia2.Reloj;

public class Reloj2 extends Thread {
    /* 
        Suponga que un sistema mantiene la hora actualizada de forma local.
        • Escriba la rutina correspondiente (para mantener la hora a lo largo de un día
        en formato 0-23)
        • Se debe poder interrumpir el reloj con una probabilidad de 0.5.
        • Suponga que se produce una interrupción de reloj cada 100 milisegundos. 
        @author: sariswis
    */

    private int hora;
    private double probabilidadInterrupcion = 0.5;

    public synchronized void interrupcionReloj(){
        hora = (hora + 1) % 24;
    }

    public void run(){
        for (int i=0; i<24; i++){
            try {
                Thread.sleep(100);
                if(Math.random() > probabilidadInterrupcion) {
                    interrupcionReloj();
                    System.out.println("!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Reloj2 reloj = new Reloj2();
        reloj.start();
        for (int i=0; i<24; i++){
            Thread.sleep(100);
            reloj.interrupcionReloj();
            System.out.println(reloj.hora);
        }
    }
}
