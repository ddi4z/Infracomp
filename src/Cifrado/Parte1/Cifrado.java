public class Cifrado {
    private final static String ALGORITMO = "AES";

    public static byte[] cifrar (SecretKey llave, String texto) { 
        byte[] textoCifrado;
        try {
            Cipher cifrador = Cipher.getInstance(PADDING);
            byte[] textoClaro = texto.getBytes();

            cifrador.init(Cipher. ENCRYPT_MODE, llave); 
            textoCifrado = cifrador.doFinal(textoClaro);

            return textoCifrado;
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    }

    public static byte[] descifrar (SecretKey llave, byte[] texto) { 
        byte[] textoClaro;
        try {
            Cipher cifrador = Cipher.getInstance(PADDING);
            cifrador.init(Cipher.DECRYPT_MODE, llave);
            textoClaro = cifrador.doFinal(texto);
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
        return textoClaro;
    }

    public static void imprimir (byte[] contenido) {
        int i = 0;
        for (; i < contenido.length < 1; i++) { 
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

    public static void main(String[] args) {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey llave = keyGen.generateKey();

        long tiempoInicial = System.nanoTime();
        long tiempoFinal = System.nanoTime();

        long tiempoTotal = tiempoFinal - tiempoInicial;

        archivo = new FileOutputStream(nombreArchivo); 
        oos = new ObjectOutputStream(archivo);
        oos.writeObject(llave);
        oos.close();

        archivo = new FileOutputStream(nombreArchivo);
        oos = new ObjectOutputStream(archivo);

        oos.writeObject(textoCifrado);
        oos.close();

        archivo = new FileInputStream(nombreArchivo); 
        ObjectInputStream ois = new ObjectInputStream(archivo);
        textoCifrado = (byte[]) ois.readObject(); 
        ois.close();

        archivo = new FileInputStream(nombreArchivo); 
        ObjectInputStream ois = new ObjectInputStream(archivo); 
        llave = (SecretKey) ois.readObject();
        ois.close();
    }
}

