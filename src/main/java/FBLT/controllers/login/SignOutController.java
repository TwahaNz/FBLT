package FBLT.controllers.login;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
@SessionAttributes("username")
public class SignOutController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/sign-out-request", method = RequestMethod.POST)
    public ModelAndView sendEmail(HttpSession session, Model model) {

        ModelAndView view  = new ModelAndView("index");
        session.invalidate();
        model.asMap().clear();
        return view;
    }
}
