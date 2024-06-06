package Semaforos;

public class PersonaMutex extends Thread{
	
	private static Semaforo semaforo = new Semaforo(1);
	private int id;
	
	public PersonaMutex(int pId) {
		this.id = pId;
	}
	
	@Override
	public void run() {
		semaforo.p();
		System.out.println(this.id+": solicita recurso");
		try {
			System.out.println(this.id+": Hace algo");
			sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaforo.v();
		System.out.println(this.id+": Libera recurso");
	}
	
	public static void main(String[] args){
		for (int i = 0; i < 5; i++) {
			new PersonaMutex(i+1).start();
		}
	}
	
	

}
