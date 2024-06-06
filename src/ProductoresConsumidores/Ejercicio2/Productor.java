package ProductoresConsumidores.Ejercicio2;

public class Productor {
    private Buffer buffer;
    private int aProducir;

    public Productor(Buffer buffer, int aProducir) {
        this.buffer = buffer;
        this.aProducir = aProducir;
    }

    public void run() throws InterruptedException {
        while (aProducir > 0){
            Integer i = 3;
            Thread.sleep(500);
            buffer.almacenar(i);
            aProducir--;
        }
    }
}