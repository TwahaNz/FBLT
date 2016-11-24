package FBLT.utils.email;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
public final class MagicLinkGenerator {

    private static Random random;

    static {
       random = new Random();
    }

    private MagicLinkGenerator() {

    }

    public static String generateEncryption() {

        String alphabet = "1x2y3z";

        String temp = "";

        for (int i = 0; i < 20; i++) {
            temp += alphabet.charAt(random.nextInt(alphabet.length()));
        }

        return temp;
    }
}
