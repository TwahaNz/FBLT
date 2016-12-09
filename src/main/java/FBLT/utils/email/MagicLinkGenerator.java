package FBLT.utils.email;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
public final class MagicLinkGenerator {

    private static Random random;
    private static BCryptPasswordEncoder linkEncoder;
    private static final String PHRASE = "FBLT";

    static {
        linkEncoder = new BCryptPasswordEncoder();
    }

    private MagicLinkGenerator() {

    }

    public static String generateEncryption() {

        String hashedPassword = linkEncoder.encode(PHRASE);

        String temp = "";

        for (int i = 0; i < hashedPassword.length(); i++) {
            if (Character.isAlphabetic(hashedPassword.charAt(i))) {
                temp += hashedPassword.charAt(i);
            }

            if ((Character.isDigit(hashedPassword.charAt(i)))) {
                temp += hashedPassword.charAt(i);
            }
        }

        return temp;
    }
}
