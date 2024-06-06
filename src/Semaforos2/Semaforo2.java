package Semaforos2;

public class Semaforo2{
    private int n = 0;
    private String color = "verde";
    private boolean oprimido = false;

    public synchronized void interrupcionReloj(){
        n++;
        if (n > 10 && oprimido){
            color = "amarillo";
            oprimido = false;
            n = 0;
        }
        else if (n==20 && color=="verde"){
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
        if (color=="verde"){
            if (n > 10){
                color = "amarillo";
                n = 0;
            }
            else {
                oprimido = true;
            
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Semaforo2 semaforo2 = new Semaforo2();
        for (int i=0; i<100; i++){
            Thread.sleep(1000);
            semaforo2.interrupcionReloj();
            System.out.println((i+1)+" "+semaforo2.color);
        }
    }
}
