package Febrero26;

public class Semaforo{
    private int n = 0;
    private String color = "verde";

    public synchronized void interrupcionReloj(){
        n++;
        if (n==20 && color=="verde"){
            color = "amarillo";
            n = 0;
        }
        else if (n==20 && color=="rojo"){
            color = "verde";
            n = 0;
        }
        else if (n==5 && color=="amarillo"){
            color = "rojo";
            n = 0;
        }
    }

    public synchronized void interrupcionBoton(){
        if (n > 10 && color=="verde"){
            color = "amarillo";
            n = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Semaforo semaforo = new Semaforo();
        for (int i=0; i<100; i++){
            Thread.sleep(1000);
            semaforo.interrupcionReloj();
            System.out.println((i+1)+" "+semaforo.color);
        }
    }
}