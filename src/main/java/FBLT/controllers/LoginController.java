package FBLT.controllers;

import FBLT.domain.email.impl.OTPEmail;
import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.domain.user.User;
import FBLT.factories.temporarylogin.TemporaryLoginFactory;
import FBLT.service.temporarylogin.ITemporaryLoginService;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static java.lang.System.out;

/**
 * Created by tayfer01 on 11/22/2016.
 */

@RestController
@SessionAttributes({"username", "login", "verification-code"})
public class LoginController {

    @Autowired
    ITemporaryLoginService service;

    @Autowired
    UserServiceImpl userService;

/*    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("index");
    }*/

    @RequestMapping(value = {"/login-request"}, method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam("verify_email") String email) {

        ModelAndView result = new ModelAndView("index");

        try {

            User user = userService.findByEmail(email);

            if (user.getContactDetails().getEmailAddress().toLowerCase().equals(email.toLowerCase())) {

                TemporaryLogin temporaryLogin = TemporaryLoginFactory.createTemporaryLogin(email);

                service.create(temporaryLogin);

                OTPEmail otpEmail = new OTPEmail.Builder()
                        .temporaryLogin(temporaryLogin)
                        .magicLink(temporaryLogin.getCode())
                        .build();
                otpEmail.sendEmail();

                result.addObject("username", email);
                result.addObject("login", "out");
                result.addObject("verification-code", temporaryLogin.getCode());

                out.println("Generated Link: " + Constants.PROTOCOL + "://" + Constants.URL + ":" + Constants.PORT + "/v" + temporaryLogin.getCode());
            }

        } catch (Exception e) {
            result.setViewName("invalid");
        }

        return result;
    }


    @RequestMapping(value = {"/v{code}"}, method = RequestMethod.GET)
    public ModelAndView insertUser(@ModelAttribute("verification-code") String code, @PathVariable("code") String userCode,
                                   @ModelAttribute("login") String status) {

        ModelAndView result = new ModelAndView("index");

        if (code.equals(userCode)) {
            result.addObject("login", "in");
        }

        return result;
    }

}
