package Febrero10;
public class Pasarela {
    private int personasCaminandoDer;
    private int personasCaminandoIzq;
    
    
    public Pasarela(){
        this.personasCaminandoDer = 0;
        this.personasCaminandoIzq = 0;
    }

    public synchronized void entrar(int id, int direccion) {
        System.out.println("Entra la persona " + id + " en dirección: " + direccion); 
        if (direccion == 1) { // derecha
            while (personasCaminandoIzq > 0) { 
                try {
                    System.out.println("La persona " + id + " en dirección: => se durmió");
                    wait();
                }  catch (InterruptedException e) {
                    
                }
            }
            personasCaminandoDer++;
            System.out.println("Personas caminando: " + personasCaminandoDer);
        } else { // izquierda
            while (personasCaminandoDer > 0) { 
                try {
                    System.out.println("La persona " + id + " en dirección: <= se durmió");
                    wait();
                }   catch (InterruptedException e) {
                    
                }
            }
            personasCaminandoIzq++;
            System.out.println("Personas caminando: " + personasCaminandoIzq);
        }
    }
    
    public void caminar(int id){
            Thread.sleep(500);
    }
    
    public synchronized void salir(int id, int direccion){
        System.out.println("Sale la persona " + id + " en dirección: " + direccion); 
        if (direccion == 1) { // derecha
            personasCaminandoDer--;
        } else { // izquierda
            personasCaminandoIzq--;
        }
        notifyAll();
    }
}



public class Persona extends Thread {
    private int id;
    private int direccion;
    private Pasarela pasarela;
    
    public Persona(int id, int direccion){
        this.id = id;
        this.direccion = direccion;
    }
    
    @Override
    public void run (){
        pasarela.entrar();
    }
    
}


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int personas = 20;
		Pasarela pasarela = new Pasarela();
		for(int i = 0; i < personas; i++){
		    if (i % 2){
		        new Persona(i, 0, pasarela).start();
		    } else {
		        new Persona(i, 1, pasarela).start();
		    }
		}
	}
}