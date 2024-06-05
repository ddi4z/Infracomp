package Preparcial1.CDA;
/* 
    Vamos a simular el comportamiento de un Centro de Diagnóstico Automotriz (CDA) 
    para la revisión técnico mecánica de automotores.
    El CDA que vamos a simular tiene una capacidad máxima de 25 vehículos y 25 personas 
    (por simplicidad vamos a suponer que el CDA solo permite el ingreso del conductor, los demás ocupantes deben salir del vehículo). 
    Si llega un vehículo adicional, este y todos los que lleguen después deben hacer fila en la parte exterior, 
    en espera de ser admitidos al CDA. Como es de suponer, si se termina la revisión de su automóvil, otro automóvil puede ser admitido. 
    Adicionalmente, vamos a suponer que: si un conductor al llegar encuentra una fila de espera externa de 15 vehículos entonces no espera, 
    en este caso se va a otro CDA (solo se queda en la fila de espera si hay menos de 15 vehículos).
    Vamos a usar threads en Java para representar el comportamiento de los conductores. 
    Usaremos la clase Conductor que representa a los conductores y la clase CDA que representa el espacio a donde i
    ngresan los conductores con sus vehículos
    @author: ddi4z 
*/

public class CDA {
    private int capacidadMaxima = 25;
    private int conductoresAtendiendose = 0;
    private int capacidadFilaMaxima = 15;
    private int enFila = 0;


    public synchronized boolean entrarConductor() throws InterruptedException{
        if (conductoresAtendiendose == capacidadMaxima){
            if (enFila < capacidadFilaMaxima){
                enFila++;
                System.out.println(enFila + " " + capacidadFilaMaxima);
                wait();
                enFila--;
                System.out.println("Conductor en el CDA");
                conductoresAtendiendose++;
            }
            else{
                System.out.println("Se va a otro CDA");
                return false;
            }
        }
        else{
            System.out.println("Conductor en el CDA");
            conductoresAtendiendose++;
        }
        return true;
    }

    public synchronized void salirConductor() throws InterruptedException{
        conductoresAtendiendose--;
        notify();

    }

    public static void main(String[] args) {
        CDA cda = new CDA();
        for (int i = 0; i < 100; i++){
            Conductor conductor = new Conductor(cda);
            conductor.start();
        }
        
    }
}