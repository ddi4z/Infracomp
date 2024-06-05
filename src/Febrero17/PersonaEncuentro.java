package Febrero17;

public class PersonaEncuentro extends Thread{
	
	private static SemaforoEncuentro semaforo = new SemaforoEncuentro(5);
	private int id;
	
	public PersonaEncuentro(int pId) {
		this.id = pId;
	}
	
	@Override
	public void run() {
		System.out.println(this.id+": Llega a la barrera");
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
			new PersonaEncuentro(i+1).start();
		}
	}
	
	

}
