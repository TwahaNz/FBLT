package FBLT.controllers;

import FBLT.domain.user.User;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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

        System.out.println(user.getName() + "Hellllllll000");
        System.out.println(user.get_id());

        ContactDetails contactDetails = new ContactDetails.Builder()
                .cellPhoneNumber("0808808080")
                .emailAddress("name@gmail.com")
                .telegramHandle("@NAme")
                .build();

        Location location = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();

        user = new User.Builder()
                .copy(user)
                .contactDetails(contactDetails)
                .location(location)
                .ranking("10")
                .build();

        ModelAndView mv = new ModelAndView("user_profile");
        mv.addObject("user", user);

        return mv;
    }
}
