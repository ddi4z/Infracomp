package Febrero17.Lab4.Parte12;
import java.util.LinkedList;

public class SemaforoExpected {
    private int counter;
    private LinkedList<Object> queue;

    public SemaforoExpected(int pCounter) {
        this.counter = pCounter;
        this.queue = new LinkedList<>();
    }
    public void p() {
    // Disminuir el número de recursos disponibles
    this.counter--;
    // Si no hay recursos disponibles, realizar una espera
    while (this.counter < 0) {
        String message = "El semaforo se ha quedado sin recursos, su contador actual es %d\n" +
        "A continuacion, se muestra el identificador del Thread que quedara\n" +
        "bloqueado\n";
        System.out.println(String.format(message, this.counter));
        // Almacenar en un monitor diferente
        Object monitor = new Object();
        // Almacenar la referencia del monitor en la cola de espera
        this.queue.addLast(monitor);
        // Realizar exclusion mutua
        try {
            synchronized (monitor) {
                monitor.wait();
            }
        }
        catch (IllegalMonitorStateException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Si hay recursos, dejamos ejecutar la actividad normalmente
    }

    public void v() {
    this.counter++;
    Object monitor = this.queue.poll();
    if (monitor != null) {
        try {
            synchronized (monitor) {
            // Se notifican a todos los Threads que realizan espera sobre el monitor
            // que continuen su actividad. Debido a nuestra implementación siempre
            // deberia haber solo un Thread realizando espera sobre un monitor.
            monitor.notifyAll();
            }
        }
        catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        }
    }
    }

public static void esperaAleatoria(int tiempoMaximo, String mensaje) {
    long espera = (long) (Math.random() * tiempoMaximo);
    System.out.println("Esperando " + espera + " milisegundos " + mensaje);
    try {
        Thread.sleep(espera);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}


   

    