package FBLT.controllers.advert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
/**
 * Created by nzetwa01 on 11/18/2016.
 */
@Controller
public class PostAdvertController {

    @RequestMapping(value = "/post-advert")
    public ModelAndView postAdvert() {

        return new ModelAndView("post_ad");
    }

    @RequestMapping(value = "/confirm-advert")
    public ModelAndView submitAdvert() {

        return new ModelAndView("post_ad");
    }


}
