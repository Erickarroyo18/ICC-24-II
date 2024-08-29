package icc.cesar;
import org.junit.jupiter.api.Test;
import java.security.MessageDigest;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTest {

    
    @Test
    public void testAnswerDecryption() throws Exception {

        // Hash SHA-256 del texto cifrado
        String expectedHash ="7s3f1g2scFsLZwNLl8Sib/sfviPJSmnuiOWbKjDv/fY=";

        // Hash SHA-256 del atributo Constants.answer cifrado
        String encryptedAnswerHash = hashSHA256(Constants.ANSWER);


        // Verificar que el hash del texto cifrado coincida con el hash esperado
        assertEquals(expectedHash, encryptedAnswerHash);
    }
    /**
     * Método que calcula el hash SHA-256 de un texto
     * @param data texto a cifrar
     * @return hash SHA-256 del texto
     * @throws Exception si ocurre un error al calcular el hash
     */
    private String hashSHA256(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}
