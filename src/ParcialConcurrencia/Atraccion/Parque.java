package ParcialConcurrencia.Atraccion;

public class Parque {
    private static final int FILAS = 25;
    private static final int SILLAS = 5;


    public static void main(String[] args) {
        Atraccion atraccion = new Atraccion(FILAS, SILLAS);
        for (int i = 0; i < 10; i++) {
            int filasAReservar = (int) (Math.random() * FILAS);
            int sillasAReservar = (int) (Math.random() * SILLAS/2);
            new Familia(i, atraccion, filasAReservar, sillasAReservar).start();
        }
    }
}
