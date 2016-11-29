package FBLT.utils.email;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
public class MagicLinkTest {

    @Test
    public void testMagic_link() {
        String password = "FBLT";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        String temp = "";

        for (int i = 0; i < hashedPassword.length(); i++) {
            if (Character.isAlphabetic(hashedPassword.charAt(i))) {
                temp += hashedPassword.charAt(i);
            }

            if ((Character.isDigit(hashedPassword.charAt(i)))) {
                temp += hashedPassword.charAt(i);
            }
        }

        passwordEncoder.matches("FBLT", hashedPassword);

        System.out.println(hashedPassword);
        System.out.println(temp);


    }

    @Test
    public void testResource() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(".").getFile() + "/test.xml");
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
    }

}
