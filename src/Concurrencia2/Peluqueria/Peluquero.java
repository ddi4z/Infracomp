package Concurrencia2.Peluqueria;

public class Peluquero extends Thread{
    private static Semaforo mutex = Peluqueria.getMutex();
    private static Semaforo clientes = Peluqueria.getClientes();
    private static Semaforo peluquero = Peluqueria.getPeluquero();


    @Override
    public void run () {
        while (Cliente.getClientesAtendidos() < Cliente.getClientesEsperados()){
            clientes.p();
            mutex.p();
            Peluqueria.setClientesEsperando(Peluqueria.getClientesEsperando() - 1);
            mutex.v();
            peluquero.v();
            System.out.println("Cortando el pelo");
            System.out.println("Clientes atendidos :" + Cliente.getClientesAtendidos());
        }

        
    }
}
