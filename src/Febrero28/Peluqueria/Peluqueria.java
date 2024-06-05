package Febrero28.Peluqueria;

public class Peluqueria {
    private static Semaforo mutex = new Semaforo(1);
    private static Semaforo clientes = new Semaforo(0);
    private static Semaforo peluquero = new Semaforo(0);

    private static int clientesEsperando;
    private static int capacidadPelueria;


    public static void main(String[] args) {
        setClientesEsperando(0);
        capacidadPelueria = 5;

        Peluquero peluquero = new Peluquero();
        peluquero.start();
        for (int i = 0; i < 50; i++){
            Cliente cliente = new Cliente(i);
            cliente.start();
        }
    }


    public static int getClientesEsperando() {
        return clientesEsperando;
    }

    public static void setClientesEsperando(int clientesEsperando) {
        Peluqueria.clientesEsperando = clientesEsperando;
    }

    public static int getCapacidadPelueria() {
        return capacidadPelueria;
    }

    public void setCapacidadPelueria(int capacidadPelueria) {
        Peluqueria.capacidadPelueria = capacidadPelueria;
    }

    public static Semaforo getMutex() {
        return mutex;
    }

    public static Semaforo getClientes() {
        return clientes;
    }

    public static Semaforo getPeluquero() {
        return peluquero;
    }



    

}
