package Febrero17.Lab4.Parte3;

public class SignalingThread extends Thread {
    String tipo;

    SignalingThread(String tipo){
        if (tipo == "A") this.tipo = tipo;
        else this.tipo = "B";
    }

    @Override
    public void run() {
        
    }
}