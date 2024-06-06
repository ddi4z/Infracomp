package Concurrencia2.ABC;

/*  
    • Suponga que tiene 3 threads A, B y C:
    • Cada thread tiene dos bloques de código: 1 y 2. El origen de las flechas indica
    que ese bloque de código se debe ejecutar ANTES que el bloque de código
    destino de la flecha. Así A2, solo se puede ejecutar una vez se ha ejecutado
    B1.
    • Escriba pseudocódigo de A, B y C agregando las primitivas de semáforos
    necesarias para asegurar que le ejecución sucede según el diagrama. Indique
    el valor inicial para cada semáforo que utilice 

    B1 -> A2 
    B1 -> C1
    C1 -> B2
    A2 -> C2

*/

public class ABC extends Thread{
    private static Semaforo semA2C1 = new Semaforo(0);
    private static Semaforo semB2 = new Semaforo(0);
    private static Semaforo semC2 = new Semaforo(0);

    private Semaforo mutex = new Semaforo(1);
    private String metodo;

    public ABC(String metodo){
        this.metodo = metodo;
    }

    public void a() throws InterruptedException{
        // A1
        mutex.p();
        System.out.println("a1 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        // A2
        semA2C1.p();
        mutex.p();
        System.out.println("a2 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        semA2C1.v();
        semC2.v();
    }
    
    public void b() throws InterruptedException{
        // B1
        mutex.p();
        System.out.println("b1 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        semA2C1.v();
        // B2
        semB2.p();
        mutex.p();
        System.out.println("b2 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        semB2.v();
    }
    
    public void c() throws InterruptedException{
        // C1
        semA2C1.p();
        mutex.p();
        System.out.println("c1 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        semA2C1.v();
        semB2.v();
        // C2
        semC2.p();
        mutex.p();
        System.out.println("c2 ejecutando");
        Thread.sleep(1000);
        mutex.v();
        semC2.v();
    }

    @Override
    public void run() {
        try {
            if (metodo == "A") a();
            else if (metodo == "B") b();
            else c();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ABC a = new ABC("A");
        ABC b = new ABC("B");
        ABC c = new ABC("C");

        a.start();
        b.start();
        c.start();
    }
    
}
