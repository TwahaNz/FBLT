package FBLT.controllers;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kraluk01 on 12/8/2016.
 */
@SessionAttributes("username")
@Controller
public class UserProfileController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/user-profile", method = RequestMethod.POST)
    public ModelAndView userProfile(@ModelAttribute("username") String email) {

        User user = userService.findByEmail(email);
        ModelAndView mv = new ModelAndView("user_profile");
        mv.addObject("user",user);

        return mv;
    }

    @RequestMapping(value = "/user-profile-update", method = RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute("username") String email,
                                      @RequestParam("newname") String newname,
                                      @RequestParam("newcell") String newcell,
                                      @RequestParam("newhandle") String newhandle,
                                      @RequestParam("newsuburb") String newsuburb,
                                      @RequestParam("newcity") String newcity) {

        User user = userService.findByEmail(email);
        user.get_id();

        ContactDetails contactDetails = new ContactDetails.Builder()
                .cellPhoneNumber(newcell)
                .emailAddress(email)
                .telegramHandle(newhandle)
                .build();
        Location location = new Location.Builder()
                .city(newcity)
                .suburb(newsuburb)
                .build();
        user = new User.Builder()
                .copy(user)
                .name(newname)
                .contactDetails(contactDetails)
                .location(location)
                .build();

        user = userService.update(user);


        ModelAndView mv = new ModelAndView("user_profile");
        mv.addObject("user",user);

        return mv;
    }
}
