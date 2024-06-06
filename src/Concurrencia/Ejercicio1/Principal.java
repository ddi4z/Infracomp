package Concurrencia.Ejercicio1;

/* 
    1. Se crean tres hilos de manera que uno
    ejecuta escribirA, otro escribirB y el tercero
    escribirC.
    2. Introduzca los semáforos necesarios para que
    la salida sea ABCABCABCABCABCABC….
    @author: ddi4z
*/


public class Principal extends Thread{
    private char letra;
    private static Semaforo sA;
    private static Semaforo sB;
    private static Semaforo sC;


    public Principal(char letra){
        this.letra = letra;
    }

    public void escribirA (int num) throws InterruptedException{
        for(int i=0;i< num;i++){
            sA.p();
            System.out.print("A");
            Thread.sleep(500);
            sB.v();
        }
    }
    
    public void escribirB (int num) throws InterruptedException{
        for(int i=0;i< num;i++){
            sB.p();
            System.out.print("B");
            Thread.sleep(500);
            sC.v();
        }
    }

    public void escribirC (int num) throws InterruptedException{
        for(int i=0;i< num;i++){
            sC.p();
            System.out.print("C");
            Thread.sleep(500);
            sA.v();
        }
    }

    @Override
    public void run(){
        try {
            if (letra == 'A') {
                escribirA(10);
            } else if (letra == 'B') {
                escribirB(10);
            } else if (letra == 'C') {
                escribirC(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Principal.sA = new Semaforo(1);
        Principal.sB = new Semaforo(0);
        Principal.sC = new Semaforo(0);

        Principal threadA = new Principal('A');
        Principal threadB = new Principal('B');
        Principal threadC = new Principal('C');


        threadA.start();
        threadB.start();
        threadC.start();
    }


}
