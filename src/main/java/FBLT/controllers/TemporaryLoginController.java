package FBLT.controllers;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.factories.temporarylogin.TemporaryLoginFactory;
import FBLT.service.temporarylogin.ITemporaryLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by tayfer01 on 11/22/2016.
 */

@Controller
public class TemporaryLoginController {

    @Autowired
    ITemporaryLoginService service;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView getRegisterPage(){
        ModelAndView result = new ModelAndView("index");
        return result;
    }


    @RequestMapping(value = {"/login-request"}, method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam("email") String email,
                                   UriComponentsBuilder ucBuilder){

        System.out.println("User login req email: " + email);
        TemporaryLogin temporaryLogin = TemporaryLoginFactory.createTemporaryLogin(email);

        service.create(temporaryLogin);

        // send an email with the link here
        // http://127.0.0.1:8080/login?email=fer@gmail.com&code=1234


        ModelAndView result = new ModelAndView("index");
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
