import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

public static final int PUERTO = 3400; 
public static final String SERVIDOR ="localhost";

public static void main(String args[]) throws IOException {
    Socket socket = null;
    PrintWriter escritor = null; 
    BufferedReader lector = null;
    System.out.println("Cliente ...");
    try {
        // crea el socket en el lado cliente 
        socket = new Socket (SERVIDOR, PUERTO);
        // se conectan los flujos, tanto de salida como de entrada 
        escritor = new PrintWriter(socket.getOutputStream(), true); 
        lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch (IOException e) {
        e.printStackTrace(); 
        System.exit(-1);
    }

    // crea un flujo para leer lo que escribe el cliente por el teclado 
    BufferedReader stdIn = new BufferedReader(new InputStreamReader( System.in));
    // se ejecuta el protocolo en el lado cliente
    ProtocoloCliente.procesar(stdIn, lector, escritor);
    // se cierran los flujos y el socket
    stdIn.close();
    escritor.close();
    lector.close();
    socket.close();
    }
}