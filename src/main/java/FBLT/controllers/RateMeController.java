package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.domain.user.User;
import FBLT.service.advert.ImplAdvertService;
import FBLT.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by student on 2016/12/11.
 */

@SessionAttributes({"username", "isValidBuyerEmail"})
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


    // email address of the buyer to validate that they exist
    @RequestMapping(value = {"/validate-buyer-email"}, method = RequestMethod.POST)
    public ModelAndView isValidBuyerEmail(@ModelAttribute("username") String sellerEmail,
                                   @RequestParam("email") String buyerEmail,
                                   UriComponentsBuilder ucBuilder) {

        User user = userService.findByEmail(buyerEmail);

        ModelAndView mv = new ModelAndView("rate_me");

        if(user == null || user.getContactDetails().getEmailAddress().equals(sellerEmail)){
            mv.addObject("isValidBuyerEmail","false");
            System.out.println("invalid buyer email");
        }
        else
            mv.addObject("isValidBuyerEmail","true");


        return mv;
    }
}
