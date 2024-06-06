package Semaforos;

public class Semaforo {
	
	private int contador;
	
	public Semaforo(int pContador) {
		this.contador = pContador;
	}
	
	public synchronized void p() {
		contador --;
		if(contador < 0) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void v() {
		contador ++;
		if(contador <= 0) {
			this.notify();
		}
	}
}




