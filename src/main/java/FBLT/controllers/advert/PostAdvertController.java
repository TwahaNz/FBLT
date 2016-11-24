package FBLT.controllers.advert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nzetwa01 on 11/18/2016.
 */
@Controller
public class PostAdvertController {

    @RequestMapping(value = "/post-advert")
    public ModelAndView postAdvert() {

        return new ModelAndView("post_ad");
    }

    @RequestMapping(value = "/confirm-advert", method = RequestMethod.POST)
    public ModelAndView submitAdvert(@RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("location") String location,
                                     @RequestParam("price") String price,
                                     @RequestParam("bool-is-selling") String isSelling) {
     /*   System.out.println(title);
        System.out.println(description);
        System.out.println(location);
        System.out.println(price);
        System.out.println(isSelling)*/
        ;

        ModelAndView mv = new ModelAndView("confirm_ad");
        mv.addObject("title", title);
        mv.addObject("description", description);
        mv.addObject("location", location);
        mv.addObject("bool-is-selling", isSelling);
        mv.addObject("price", price);

        return mv;
    }


}
