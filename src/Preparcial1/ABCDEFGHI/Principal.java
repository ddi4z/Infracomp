package Preparcial1.ABCDEFGHI;

/* 
    Se quiere garantizar:
    • a(), d() y h() se deben ejecutar en exclusión mutua
    • i() se debe ejecutar después de f() y después de h()
    • b() se debe ejecutar antes que e() y antes que i() 
    @Author: ddi4z

    Nota:
    Se podria hacer que b solo libere un recurso, 
    y que tanto E como I al momento de terminar de usarlo lo liberen. 
    Sin embargo, no se menciona que E e I deben ejecutarse en exclusión mutua.
*/


public class Principal {
    private static Semaforo semADH;
    private static Semaforo semBEI;
    private static Semaforo semIFH;

    public static void main(String[] args) {
        Principal.semADH = new Semaforo(1);
        Principal.semBEI = new Semaforo(0);
        Principal.semIFH = new Semaforo(-1);


        A a = new A(Principal.semADH, Principal.semBEI);
        B b = new B(Principal.semADH, Principal.semBEI, Principal.semIFH);
        C c = new C(Principal.semADH, Principal.semBEI, Principal.semIFH);
        a.start();
        b.start();
        c.start();
    }
}
