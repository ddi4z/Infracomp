package ParcialConcurrencia.ABCDEFGHI;

public class B extends Thread{
    private Semaforo semADH;
    private Semaforo semBEI;
    private Semaforo semIFH;

    public B(Semaforo semADH, Semaforo semBEI, Semaforo semIFH){
        this.semADH = semADH;
        this.semBEI = semBEI;
        this.semIFH = semIFH;
    }
    
    public void d(){
        semADH.p();
        System.out.println("d");
        semADH.v();
    }

    public void e(){
        semBEI.p();
        System.out.println("e");
    }

    public void f(){
        System.out.println("f");
        semIFH.v();
    }

    @Override
    public void run(){
        d();
        e();
        f();
    }


}
