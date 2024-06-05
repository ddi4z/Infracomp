package Febrero17.Lab4.Parte3;
public class Signaling {
    
    // Clase Signaling. Variable compartida con su valor inicial.
    public static int variableCompartida = 0;

    public synchronized void a(){
        variableCompartida += 100;
    }

    public synchronized void b(){
        variableCompartida += 10;
    }
}


