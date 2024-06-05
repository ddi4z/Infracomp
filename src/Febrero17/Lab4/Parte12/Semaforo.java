package Febrero17.Lab4.Parte12;
import java.util.LinkedList;

public class Semaforo {
    private int contador ;
    private LinkedList <Object> queue ;

    public Semaforo(int contador){
        this.contador = contador;
        this.queue = new LinkedList<Object> ();
    }

    public void p(){
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

    public void v(){
        contador++;
        while (contador<0){
            Object monitor = queue.poll();
            if (monitor != null){
                try {
                    synchronized (monitor) {
                        monitor.notifyAll();
                    }
                }
                catch (IllegalMonitorStateException e){
                    e.printStackTrace();
                }
            } else {
                // Add else action here if required
            }
        }
    }

    public void esperaAleatoria() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
