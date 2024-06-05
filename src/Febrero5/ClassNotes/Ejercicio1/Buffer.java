package Febrero5.ClassNotes.Ejercicio1;
import java.util.ArrayList;

public class Buffer {
    private ArrayList<Integer> buff;
    private int n;
    
    public Buffer(int aProducir, int n) {
        this.n = n;
        this.buff = new ArrayList<Integer>();
    }

    public synchronized void almacenar(Integer i) {
        while (buff.size() == n) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buff.add(i);
        notify();
    }

    public synchronized Integer retirar() {
        while (buff.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer i = (Integer) buff.remove(0);
        notify();
        return i;
    }
}
