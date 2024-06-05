package Febrero28.Delegados;

public class Delegado extends Thread{
    

    @Override
    public void run(){

    }

    public static void main(String[] args) throws InterruptedException{
        for(int i=0; i<50; i++){
            Delegado delegado = new Delegado();
            delegado.start();
        }
    }
}
