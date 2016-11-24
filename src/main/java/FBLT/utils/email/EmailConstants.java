package FBLT.utils.email;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by student on 2016/09/24.
 */
public class EmailConstants {

    // Sender's email ID needs to be mentioned
    private final String from = "textbookbs@gmail.com";
    private final String username = "textbookbs@gmail.com";
    private final String password = "";
    private final String host = "smtp.gmail.com";


    public String getFrom() {
        return from;
    }

    public Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }


}
