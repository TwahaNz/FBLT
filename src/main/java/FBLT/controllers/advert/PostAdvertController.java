package FBLT.controllers.advert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nzetwa01 on 11/18/2016.
 */
@RestController
public class PostAdvertController {

    @RequestMapping(value = "/post_advert")
    public ModelAndView postAdvert() {
        return new ModelAndView("post_ad");
    }
}
