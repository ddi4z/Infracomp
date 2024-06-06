package Concurrencia2.Delegados;

/* 
    Vamos a implementar servidores concurrentes con threads delegados. Para garantizar que no vamos a
    exceder los recursos disponibles en la máquina, controlaremos el número de threads delegados que
    pueden atender clientes: el número máximo de delegados que pueden ejecutar sus tareas son 20. Si llega
    un delegado adicional (el número 21 en un momento dado) dicho delegado, y todos los que lleguen
    después, tendrán que esperar. Como es de esperar, si un delegado termina de atender un cliente, otro
    delegado puede comenzar la atención.
    Usaremos threads en Java para representar el comportamiento de los delegados.
    Tendremos dos clases: una representará a los delegados y una para manejar la sincronización:
    Nota: Para simplificar el problema no hay que garantizar que el orden de atención sea igual al orden de
    creación de los delegados. 
*/

public class Principal {
    private int n = 0;

    public synchronized void empezar_delegado() throws InterruptedException {
        if (n == 20){
            wait();
        }
        n++;
        System.out.println("Ejecutando");
        Thread.sleep(1000);

    }

    public synchronized void terminar_delegado() {
        n--;
        if (n>0) {
            notify();
        }
    }
}
