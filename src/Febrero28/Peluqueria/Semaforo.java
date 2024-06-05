package Febrero28.Peluqueria;

public class Semaforo {
    private int sem;

    public Semaforo(int num){
        sem = num;
    }

    public synchronized void p(){
        sem--;
        if (sem < 0) {
            try {
                wait();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void v(){
        sem++;
        if (sem <= 0) {
            notify();
        }

    }
}
