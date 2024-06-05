package Preparcial1.ServicioMedico;

/* 
    Vamos a simular el comportamiento de la oficina del servicio médico en la
    universidad. Para garantizar que se respeta la máxima capacidad de la sala de
    espera, la oficina del servicio médico debe controlar el número de pacientes
    que ingresan: solo puede recibir hasta 15 pacientes en un momento dado. Si
    llega un paciente adicional, ese paciente, y todos los que lleguen después
    tendrán que hacer una cola de espera. Como es lógico, si un paciente sale,
    otro paciente puede entrar.
    Cuando hay más de 5 pacientes en la cola de espera, se llama a un médico
    adicional y se empiezan a recibir en el servicio médico hasta 20 pacientes. De
    igual forma, cuando ya no hay pacientes en la cola de espera, el médico
    adicional se retira del consultorio y se vuelven a admitir hasta 15 pacientes en
    sala,
    Vamos a usar threads en Java para representar el comportamiento de los
    pacientes. Usaremos la clase Paciente que representa a los pacientes y la clase
    SalaEspera que representa la sala donde deben esperar los pacientes:
    @author: ddi4z 
*/



public class SalaDeEspera {
    private static int capacidad = 15;
    private static int pacientesEnSala = 0;
    private static int enFila = 0;

    public synchronized void entrarPaciente() throws InterruptedException {
        while (pacientesEnSala == capacidad) {
            if (enFila>5) {
                capacidad = 20;
            }
            else {
                capacidad = 15;
            }

            enFila++;
            wait();
            enFila--;
        }
        pacientesEnSala++;
    }

    public synchronized void salirPaciente() throws InterruptedException{
        pacientesEnSala--;
        if (enFila > 0) {
            notifyAll();
        }
    }


    public static void main(String[] args) {
        SalaDeEspera sala = new SalaDeEspera();
        for (int i = 0; i < 40; i++) {
            Paciente p = new Paciente(sala);
            p.start();
        }
    }    

}
