package FBLT.controllers.login;

import FBLT.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

        session.invalidate();
        model.asMap().clear();

        return new ModelAndView("redirect:/");
    }
}
