package Mutex.Parte1;
public class MutexThread extends Thread {
    char tipo;

    MutexThread(char c){
        if (c == 'A') this.tipo = c;
        else this.tipo = 'B';
    }

    @Override
    public void run() {
        
    }
}
