package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.domain.rating.Rating;
import FBLT.domain.user.User;
import FBLT.service.advert.ImplAdvertService;
import FBLT.service.rating.ImplIRatingService;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by kraluk01 on 12/8/2016.
 */
@SessionAttributes("username")
@Controller
public class UserProfileController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ImplAdvertService advertService;

    @Autowired
    ImplIRatingService ratingService;

    private int calcRating(String userId) {
        int total = 0;

        List<Rating> ratingList = ratingService.findRatingByUserId(userId);

        for (Rating r : ratingList)
            total += Integer.parseInt(r.getRating());
        if (ratingList.size() != 0)
            return total / ratingList.size();
        else
            return 0;
    }


    @RequestMapping(value = "/user-profile", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView userProfile(@ModelAttribute("username") String email) {

        User user = userService.findByEmail(email);

        System.out.println(user.get_id());

        List<Advert> adverts = advertService.findAdvertsByUserEmail(email);

        if (adverts == null) {
            System.out.println("Request with id " + user.get_id() + "Not Found");
        }

        User userWithRating = new User.Builder()
                .copy(user)
                .rating(calcRating(user.get_id()))
                .build();

        System.out.println(adverts.size());
        ModelAndView mv = new ModelAndView("user_profile");
        mv.addObject("user", userWithRating);
        mv.addObject("adverts", adverts);

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
        mv.addObject("user", user);

        return mv;
    }

}
