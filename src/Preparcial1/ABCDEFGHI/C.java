package Preparcial1.ABCDEFGHI;

public class C extends Thread{
    private Semaforo semADH;
    private Semaforo semBEI;
    private Semaforo semIFH;

    public C(Semaforo semADH, Semaforo semBEI, Semaforo semIFH){
        this.semADH = semADH;
        this.semBEI = semBEI;
        this.semIFH = semIFH;
    }

    public void g(){
        semADH.p();
        System.out.println("g");
        semADH.v();
    }

    public void h(){
        System.out.println("h");
        semIFH.v();
    }

    public void i(){
        semIFH.p();
        semBEI.p();
        System.out.println("i");

    }

    @Override
    public void run(){
        g();
        h();
        i();
    }
}
