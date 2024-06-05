package Preparcial1.Filosofos;

public class Filosofo extends Thread {
    private int id;
    private Mesa mesa;

    public Filosofo(int id, Mesa mesa){
        this.id = id;
        this.mesa = mesa;
    }

    public void pensar(){
        System.out.println("Filosofo " + id + " pensando");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void comer(){
        mesa.tomarPalillos(id);
        System.out.println("Filosofo " + id + " comiendo");
        mesa.dejarPalillos(id);

    }

    @Override
    public void run(){
        for (int i =0; i<5; i++){
            pensar();
            comer();
        }
    }
}