package ParcialConcurrencia.Atraccion;

public class Atraccion {
    private int filas;
    private int sillas;

    public Atraccion(int filas, int sillas){
        this.filas = filas;
        this.sillas = sillas;
    }

    public synchronized void reservar (int id, int filasAReservar, int sillasAReservar){
        while (filas < filasAReservar || sillas < sillasAReservar){
            try {
                System.out.println("Familia " + id + " esperando por " + filasAReservar + " filas y " + sillasAReservar + " sillas");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        filas -= filasAReservar;
        sillas -= sillasAReservar;
    }

    public synchronized void liberar (int filasALiberar, int sillasALiberar){
        filas += filasALiberar;
        sillas += sillasALiberar;
        notifyAll();
    }
    
}
