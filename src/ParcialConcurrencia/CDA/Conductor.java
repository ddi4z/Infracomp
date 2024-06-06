package ParcialConcurrencia.CDA;

public class Conductor extends Thread{
    CDA cda;

    public Conductor(CDA cda){
        this.cda = cda;
    }


    @Override
    public void run(){
        try {
            if (!cda.entrarConductor()) cda = new CDA();
            else {
                System.out.println("Conductor en el CDA");
                // eL tiempo de revision es aleatorio entre 3 y 12 segundos
                Thread.sleep((long) (Math.random() * 9000 + 3000));
                System.out.println("Conductor sale del CDA");
                cda.salirConductor();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}