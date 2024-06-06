public class Cifrado2 {
    private static final String ALGORITMO = "RSA";

    public static byte[] cifrar (Key llave, String algoritmo, String texto) { 
        byte[] textoCifrado;
        try {
            Cipher cifrador = Cipher.getInstance(algoritmo); byte[] textoClaro = texto.getBytes();
            cifrador.init(Cipher. ENCRYPT_MODE, llave); 
            textoCifrado = cifrador.doFinal(textoClaro);
            return textoCifrado;
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    }

    public static byte[] descifrar (Key llave, String algoritmo, byte[] texto) { byte[] textoClaro;
        try {
            Cipher cifrador Cipher.getInstance(algoritmo);
            cifrador.init(Cipher.DECRYPT_MODE, llave);
            textoClaro = cifrador.doFinal(texto);
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
        return textoClaro;
    }
    
    public static void imprimir (byte[] contenido) {
        for (int i = 0; i < contenido.length; i++) { 
            System.out.print(contenido[i] + " ");
        }
    }
    public static void main(String[] args) {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITMO);
        generator.initialize(1024);
        KeyPair keypair = generator.generateKeyPair(); 
        PublicKey llavePublica = keyPair.getPublic(); 
        PrivateKey llavePrivada = keypair.getPrivate();
    }

}