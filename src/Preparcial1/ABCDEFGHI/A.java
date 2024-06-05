package Preparcial1.ABCDEFGHI;

public class A extends Thread{
    private Semaforo semADH;
    private Semaforo semBEI;

    public A(Semaforo semADH, Semaforo semBEI){
        this.semADH = semADH;
        this.semBEI = semBEI;
    }

    
    public void a(){
        semADH.p();
        System.out.println("a");
        semADH.v();
    }

    public void b(){
        System.out.println("b");
        semBEI.v();
        semBEI.v();
    }


    

    public void c(){
        System.out.println("c");
    }

    @Override
    public void run(){
        a();
        b();
        c();
    }

}
