package ProductoresConsumidores.Ejercicio1;

public class Productor extends Thread {
    private Buffer buffer;
    private int aProducir;

    public Productor(Buffer buffer, int aProducir) {
        this.buffer = buffer;
        this.aProducir = aProducir;
    }

    public void run() {
        while (aProducir > 0){
            Integer i = 3;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.almacenar(i);
            aProducir--;
        }
    }
}