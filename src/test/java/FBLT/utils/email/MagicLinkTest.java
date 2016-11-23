package FBLT.utils.email;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
public class MagicLinkTest {

    @Test
    public void testMagic_link() {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        passwordEncoder.matches("123456", hashedPassword);


    }

}
