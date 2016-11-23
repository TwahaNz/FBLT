package FBLT.factories.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.ContactDetails;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by tayfer01 on 11/22/2016.
 */
public class TemporaryLoginFactory {


    public static TemporaryLogin createTemporaryLogin(String email){
        ContactDetails contactDetails = new ContactDetails.Builder()
                .emailAddress(email)
                .build();

        User user = new User.Builder()
                .contactDetails(contactDetails)
                .build();

        TemporaryLogin temporaryLogin = new TemporaryLogin.Builder()
                .code(generateOTP())
                .user(user)
                .timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()))
                .build();

        return temporaryLogin;
    }


    private static String generateOTP() {
        String chars = "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";


        final int PW_LENGTH = 20;
        Random rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < PW_LENGTH; i++)
            pass.append(chars.charAt(rnd.nextInt(chars.length())));
        return pass.toString();
    }
}
