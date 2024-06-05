package Preparcial1.ServicioMedico;

public class Paciente extends Thread{
    SalaDeEspera salaDeEspera;

    public Paciente(SalaDeEspera salaDeEspera){
        this.salaDeEspera = salaDeEspera;
    }


    @Override
    public void run(){
        try {
            salaDeEspera.entrarPaciente();
            System.out.println("Paciente en la sala");
            Thread.sleep(1000);
            salaDeEspera.salirPaciente();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
