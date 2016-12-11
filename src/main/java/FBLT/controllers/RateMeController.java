package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.domain.user.User;
import FBLT.service.advert.ImplAdvertService;
import FBLT.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by student on 2016/12/11.
 */

@SessionAttributes("username")
@Controller
public class RateMeController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(value = "/rate-me", method = RequestMethod.POST)
    public ModelAndView userProfile(@ModelAttribute("username") String email) {

        User user = userService.findByEmail(email);
        ModelAndView mv = new ModelAndView("rate_me");
        mv.addObject("user",user);

        List<Advert> advert = advertService.findAdvertsByUserEmail(email);
        mv.addObject("adverts",advert);


        return mv;
    }
}
