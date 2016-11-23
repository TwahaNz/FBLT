package FBLT.controllers;

import FBLT.domain.email.impl.OTPEmail;
import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.domain.user.User;
import FBLT.factories.temporarylogin.TemporaryLoginFactory;
import FBLT.service.temporarylogin.ITemporaryLoginService;
import FBLT.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by tayfer01 on 11/22/2016.
 */

@RestController
@SessionAttributes("username")
public class TemporaryLoginController {

    @Autowired
    ITemporaryLoginService service;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView getRegisterPage(){
        return  new ModelAndView("index");
    }

    @RequestMapping(value = {"/login-request"}, method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam("email") String email,
                                   UriComponentsBuilder ucBuilder){

        ModelAndView result = new ModelAndView("index");

        User user = userService.findByEmail(email);

        if(user.getContactDetails().getEmailAddress().toLowerCase().equals(email.toLowerCase())) {
            result.addObject("username", email);
        }

        System.out.println("User login req email: " + email);

        TemporaryLogin temporaryLogin = TemporaryLoginFactory.createTemporaryLogin(email);

        service.create(temporaryLogin);

        //send an email with the link here
        //http://127.0.0.1:8080/login?email=fer@gmail.com&code=1234

        OTPEmail otpEmail = new OTPEmail.Builder()
                .temporaryLogin(temporaryLogin)
                .build();
        otpEmail.sendEmail();

        return result;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView insertUser(@RequestParam("email")String email,
                                   @RequestParam("code") String code,
                                   UriComponentsBuilder ucBuilder){
        System.out.println(email);

        TemporaryLogin temporaryLogin = service.isValidUser(email, code);

        System.out.println("validating user");

        if(temporaryLogin == null)
            System.out.println("invalid");
        else
            System.out.println("valid login by " + temporaryLogin.getUser().getContactDetails().getEmailAddress());

        ModelAndView result = new ModelAndView("index");
        return result;
    }

}
