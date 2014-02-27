/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.ejb.Singleton;
import sun.misc.BASE64Encoder;

/**
 *
 * @author kelto
 */
@Singleton
public class Encrypter {

    private Random random = new Random();
    private final int LENGTH = 25;
    private final String m_characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public synchronized String encrypt(String plaintext) throws Exception {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA"); //step 2
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e.getMessage());
        }
        try {
            md.update(plaintext.getBytes("UTF-8")); //step 3
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e.getMessage());
        }

        byte raw[] = md.digest(); //step 4
        String hash = (new BASE64Encoder()).encode(raw); //step 5
        return hash; //step 6
    }

    public String generateSalt(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    
    public String generateSalt() {
        
        char[] text = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            text[i] = m_characters.charAt(random.nextInt(m_characters.length()));
        }
        return new String(text);
    }
}
