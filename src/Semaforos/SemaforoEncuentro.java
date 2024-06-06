package Semaforos;

public class SemaforoEncuentro {
	
	private int contador = 0;
	private int avisar;
	
	public SemaforoEncuentro(int pAvisar) {
		this.avisar = -pAvisar;
	}
	
	public synchronized void p() {
		contador --;
		if(contador <= avisar) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.notify();
			contador = 0;
		}
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void v() {
		contador++;
		this.notify();
	}
}




