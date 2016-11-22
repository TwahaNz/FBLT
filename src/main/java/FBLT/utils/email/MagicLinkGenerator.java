package FBLT.utils.email;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
public class MagicLinkGenerator {

    private final String HEAD_ENCRYPT = "FLBT";
    private final String TAIL_ENCRYPT = "TBLF";
    private BCryptPasswordEncoder encoder;
    private String user_email;
    private String server_url;

    public MagicLinkGenerator(String email, String server_url) {
        user_email = email;
        this.server_url = server_url;
    }

    public void encrypte_email() {
         encoder.encode(HEAD_ENCRYPT);

    }

    public String getGeneratedLink() {
        return server_url + "/" + HEAD_ENCRYPT + user_email + TAIL_ENCRYPT;
    }

}
