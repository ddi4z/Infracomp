package Febrero17.Lab4.Parte12;
public class Principal {
    public static void main(){
        MutexThread a = new MutexThread('A');
        MutexThread b = new MutexThread('B');

        int orden = (int) (Math.random() * 100) % 2;
        if (orden == 0) {
            System.out.println("Inicia a");
            a.start();
            b.start();
        } else {
            System.out.println("Inicia b");
            b.start();
            a.start();
        }
    }
}

