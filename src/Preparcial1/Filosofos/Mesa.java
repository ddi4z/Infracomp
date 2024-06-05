package Preparcial1.Filosofos;

public class Mesa {
    private boolean[] palillos;
    private int cantidadPalillos = 5;

    public Mesa(){
        palillos = new boolean[5];
        for(int i = 0; i<5; i++){
            palillos[i] = false;
        }
    }

    public synchronized void tomarPalillos(int id){
        int palilloIzquierdo = id;
        int palilloDerecho = (id+1)%cantidadPalillos;
        while(palillos[palilloIzquierdo] || palillos[palilloDerecho]){
            try {
                wait();
                System.out.println("Filosofo " + id + " esperando palillos");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        palillos[palilloIzquierdo] = true;
        palillos[palilloDerecho] = true;
    }


    public synchronized void dejarPalillos(int id){
        int palilloIzquierdo = id;
        int palilloDerecho = (id+1)%cantidadPalillos;
        palillos[palilloIzquierdo] = false;
        palillos[palilloDerecho] = false;
        notifyAll();
    }

}