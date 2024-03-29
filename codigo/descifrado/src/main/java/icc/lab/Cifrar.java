package icc.lab;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * Clase que nos ayudara con el cifrado y descifrado
 * 
 * @author Erick Arroyo
 * @version 1.1
 */
public class Cifrar {
    private static final String FRASE = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";

    /**
     * Metodo constructor
     */
    private Cifrar() {
    }

    /**
     * Metodo que nos ayudara a obtener el cifrado
     * 
     * @param paraCifrar Booleano que nos dira si queremos encriptar o desencriptar
     * @return El cifrador en dicho modo
     * @throws Exception En caso de que falle algo
     */
    private static Cipher obtieneCipher(boolean paraCifrar) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(FRASE.getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }
        return aes;
    }

    /**
     * Metodo que nos permite descifrar una arreglo de bytes
     * 
     * @param cifrado El arreglo que contienen el cifrado
     * @return La cadena en texto plano
     * @throws Exception En caso de que falle
     */
    public static String descifra(byte[] cifrado) throws Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * Metodo que nos permite cifrar una palabra en texto plano
     * 
     * @param sinCifrar El texto plano a cifrar
     * @return El arreglo de bytes ya cifrado
     * @throws Exception En caso de que falle
     */
    public static byte[] cifra(String sinCifrar) throws Exception {
        final byte[] bytes = sinCifrar.getBytes(StandardCharsets.UTF_8);
        final Cipher aes = obtieneCipher(true);
        return aes.doFinal(bytes);
    }

    /**
     * Metodo que convierte un arreglo de bytes a una cadena
     * 
     * @param bytes EL arreglo de bytes
     * @return El arreglo ya convertido en cadena
     */
    private static String byteToString(byte[] bytes) {
        String res = "";
        for (int i = 0; i < bytes.length; ++i) {
            res += bytes[i];
        }
        return res;
    }

    /**
     * metodo magico que nos ayudara a resolver la practica
     * 
     * @param palabraCifrada La llave que aparece en classroom
     * @param contra         La contrasenna que podria ser
     * @return true si es la contrasenna es correcta, false en otro caso
     * @throws Exception En caso de que falle
     */
    public static boolean descifraC(String palabraCifrada, String contra) throws Exception {
        byte[] res = cifra(contra);
        return byteToString(res).equals(palabraCifrada);
    }
}