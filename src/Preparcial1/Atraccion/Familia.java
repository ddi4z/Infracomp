package Preparcial1.Atraccion;

public class Familia extends Thread{
    private int id;
    private Atraccion atraccion;
    private int filasAReservar;
    private int sillasAReservar;

    public Familia(int id, Atraccion atraccion, int filasAReservar, int sillasAReservar){
        this.id = id;
        this.atraccion = atraccion;
        this.filasAReservar = filasAReservar;
        this.sillasAReservar = sillasAReservar;
    }

    @Override
    public void run(){
        atraccion.reservar(id, filasAReservar, sillasAReservar);
        System.out.println("Familia " + id + " reservo " + filasAReservar + " filas y " + sillasAReservar + " sillas");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atraccion.liberar(filasAReservar, sillasAReservar);
        System.out.println("Familia " + id + " libero " + filasAReservar + " filas y " + sillasAReservar + " sillas");
    }


}
