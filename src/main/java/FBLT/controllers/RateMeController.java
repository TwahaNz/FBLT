package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.domain.email.impl.RatingEmail;
import FBLT.domain.rating.Comment;
import FBLT.domain.rating.Rating;
import FBLT.domain.user.User;
import FBLT.service.advert.ImplAdvertService;
import FBLT.service.rating.ImplIRatingService;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.Constants;
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

    @Autowired
    ImplIRatingService ratingService;

    // populate users adverts
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
                                   @RequestParam("advertId") String advertId,
                                   UriComponentsBuilder ucBuilder) {

        User userBuyer = userService.findByEmail(buyerEmail);
        User userSeller = userService.findByEmail(sellerEmail);
        Rating ratingValidate = ratingService.findRatingByAdvertId(advertId);

        ModelAndView mv = new ModelAndView("user_profile");

        if(userBuyer == null || userBuyer.getContactDetails().getEmailAddress().equals(sellerEmail) || ratingValidate == null){
            mv.addObject("isValidBuyerEmail","false");
            System.out.println("invalid buyer email");
            mv.addObject("advertId", advertId);
        }
        else {
            mv.addObject("isValidBuyerEmail", "true");


            Rating rating = new Rating.Builder()
                    .advertID(advertId)
                    .userID(userService.findByEmail(sellerEmail).get_id())
                    .userIDBuyer(userBuyer.get_id())
                    .build();

            System.out.println("Generated Link: " + Constants.PROTOCOL + "://" + Constants.URL + ":" + Constants.PORT + "/rate-user-request?userBuyerId=" +userBuyer.get_id()
                                + "&userSellerId=" + userSeller.get_id()
                                + "&advertId=" + advertId);

           // RatingEmail ratingEmail = new RatingEmail(rating, buyerEmail, advertService.readById(advertId));
           // ratingEmail.sendEmail();

        }

        return mv;
    }

    // performs the actual rating
    @RequestMapping(value = {"/rate-user"}, method = RequestMethod.POST)
    public ModelAndView rateUser(@RequestParam("userBuyerId") String buyerId,
                                 @RequestParam("userSellerId") String sellerId,
                                 @RequestParam("commentText") String commentText,
                                 @RequestParam("rateNumber") String rate,
                                 @RequestParam("advertId") String advertId) {


        // first see if a rating for that advertId exists
        // create object and insert

        Rating rating = ratingService.findRatingByAdvertId(advertId);

        if(rating == null){

            Comment comment = new Comment.Builder()
                    .comment(commentText)
                    .build();

            Rating savedRating = new Rating.Builder()
                    .advertID(advertId)
                    .rating(rate)
                    .userID(sellerId)
                    .userIDBuyer(buyerId)
                    .comment(comment)
                    .build();

            ratingService.create(savedRating);
        }


        ModelAndView mv = new ModelAndView("index");

        return mv;
    }

    // once a user clicks on the link to rate a user
    @RequestMapping(value = "/rate-user-request", method = RequestMethod.GET)
    public ModelAndView rateUserRequest(@RequestParam("userBuyerId") String buyerId,
                                        @RequestParam("userSellerId") String sellerId,
                                        @RequestParam("advertId") String advertId) {

        Advert advert = advertService.readById(advertId);

        ModelAndView mv = new ModelAndView("rate_user");
        mv.addObject("userBuyerId", buyerId);
        mv.addObject("userSellerId", sellerId);
        //mv.addObject("advertId", advertId);
        mv.addObject("advert", advert);



        return mv;
    }



}
