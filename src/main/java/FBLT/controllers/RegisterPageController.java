package FBLT.controllers;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.ContactDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by maybra01 on 11/17/2016.
 */
@Controller
public class RegisterPageController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView getRegisterPage(){
        ModelAndView result = new ModelAndView("register");
        return result;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam("username")String username,
                                           @RequestParam("email") String email,
                                           UriComponentsBuilder ucBuilder){
        System.out.println(username+ email);


        ContactDetails contactDetails = new ContactDetails.Builder()
                .emailAddress(email)
                .build();

        User newuser = new User.Builder()
                .name(username)
                .contactDetails(contactDetails)
                .build();

        userService.create(newuser);

        ModelAndView result = new ModelAndView("register");
        return result;
    }

}
