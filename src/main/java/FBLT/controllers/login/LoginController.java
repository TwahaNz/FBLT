package FBLT.controllers.login;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Created by nzetwa01 on 11/22/2016.
 */
@RestController
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "code", method = RequestMethod.POST)
    public ModelAndView sendEmail(@RequestParam("email") String email) {

        boolean isValid = false;
        ModelAndView view  = new ModelAndView("post_ad");

        User user = userService.findByEmail(email);

        if(user.getContactDetails().getEmailAddress().toLowerCase().equals(email.toLowerCase())) {
            view.addObject("username", email);
            isValid = true;
        }

        view.addObject("valid", isValid);
        return view;
    }

          /*  Set<User> users =  userService.readAll();

        Iterator<User> user = users.iterator();

        while (user.hasNext()) {
            String temp =  user.next().getContactDetails().getEmailAddress();

            if(temp.toLowerCase().equals(email.toLowerCase())) {
                System.out.println("SUCCESS");
                System.out.println("Email Sent To: " + email);
            }
        }*/

}
