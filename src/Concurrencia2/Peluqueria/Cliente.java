package Concurrencia2.Peluqueria;

public class Cliente extends Thread{
    private int i;
    private static Semaforo mutex = Peluqueria.getMutex();
    private static Semaforo clientes = Peluqueria.getClientes();
    private static Semaforo peluquero = Peluqueria.getPeluquero();

    private static int clientesEsperados = 50;
    private static int clientesAtendidos = 0;


    public Cliente(int i){
        this.i = i;
    }

    public static int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public static int getClientesEsperados() {
        return clientesEsperados;
    }

    @Override
    public void run () {
        mutex.p();
        if (Peluqueria.getClientesEsperando() < Peluqueria.getCapacidadPelueria()  ) {
            Peluqueria.setClientesEsperando(Peluqueria.getClientesEsperando() + 1);
            clientes.v();
            mutex.v();
            peluquero.p();
            System.out.println("El cliente " + i + " está cortándose el pelo");
        }
        else {
            System.out.println("El cliente " + i + " dijo vemos");
            mutex.v();
        }
        Cliente.clientesAtendidos++;
    }

}
