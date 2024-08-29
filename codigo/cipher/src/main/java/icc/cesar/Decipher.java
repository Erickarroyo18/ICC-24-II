package icc.cesar;

public class Decipher {

    /**
     * Metodo que cifra un caracter
     * @param c caracter a cifrar
     * @param key llave de cifrado
     * @return caracter cifrado
     */
    public static char charDecipher(char c, int key){
        return Constants.ALPHABET.charAt((Constants.ALPHABET.indexOf(c) - key + Constants.ALPHABET_LENGTH) % 
            Constants.ALPHABET_LENGTH);
    }
    /**
     * Metodo que cifra un texto
     * @param text texto a cifrar
     * @param key llave de cifrado
     * @return texto cifrado
     */
    public static String decipher(String text, int key){
        String criptograma = "";
        for (int i = 0; i < text.length(); i++) {
            criptograma += charDecipher(text.charAt(i), key);
        }
        return criptograma;
    }
    
}
