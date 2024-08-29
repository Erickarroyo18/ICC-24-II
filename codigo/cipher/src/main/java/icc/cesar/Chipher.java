package icc.cesar;

public class Chipher {

    /**
     * Metodo que cifra un caracter
     * @param c caracter a cifrar
     * @param key llave de cifrado
     * @return caracter cifrado
     */
    public static char charCipher(char c, int key){
        return Constants.ALPHABET.charAt((Constants.ALPHABET.indexOf(c) + key) % 
            Constants.ALPHABET_LENGTH);
    }
    /**
     * Metodo que cifra un texto
     * @param text texto a cifrar
     * @param key llave de cifrado
     * @return texto cifrado
     */
    public static String cipher(String text, int key){
        String criptograma = "";
        for (int i = 0; i < text.length(); i++) {
            criptograma += charCipher(text.charAt(i), key);
        }
        return criptograma;
    }
    
}
