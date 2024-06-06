package Semaforos;

public class PersonaSenal extends Thread{
	
	private static Semaforo sem1 = new Semaforo(0);
	private static Semaforo sem2 = new Semaforo(1);
	private int id;
	
	public PersonaSenal(int pId) {
		this.id = pId;
	}
	
	@Override
	public void run() {
		System.out.println(id+": Entra");
		if(id == 1) {
			sem1.p();
			sem2.p();
			//sem2.p();
			//sem1.p();
			System.out.println(id+": Hace algo");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem1.v();
			sem2.v();
		}
		else {
			sem2.p();
			System.out.println(id+": Hace algo");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem1.v();
			sem2.v();
		}
		System.out.println(id+": Sale");
	}
	
	public static void main(String[] args) throws InterruptedException{
			new PersonaSenal(1).start();
			new PersonaSenal(2).start();
	}
	
	

}
