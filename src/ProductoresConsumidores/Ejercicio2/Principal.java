package ProductoresConsumidores.Ejercicio2;

//Ejercicio 2 – los productores informan que terminaron

public class Principal {
    public static void main(String[] args) {
    
    Buffer buffer = new Buffer(4,20) ;
    
    Productor p1 = new Productor (8, buffer) ;
    Productor p2 = new Productor (12, buffer) ;
    Consumidor c1 = new Consumidor (buffer) ;
    Consumidor c2 = new Consumidor (buffer) ;
    p1.start () ;
    p2.start();
    c1.start () ;
    c2.start () ; 
    }
}