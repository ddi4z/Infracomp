package ProductoresConsumidores.Ejercicio2;

public class Consumidor {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Integer i = buffer.retirar();
        while (i != null) { 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = buffer.retirar();
        }
    }
}