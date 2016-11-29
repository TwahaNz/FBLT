package FBLT.controllers.advert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nzetwa01 on 11/29/2016.
 */
@RestController
public class AdvertItemController {

    @RequestMapping(value = {"/item{advertId}"}, method = RequestMethod.GET)
    public ModelAndView items(@PathVariable("advertId") String advertId) {
        return new ModelAndView("item");
    }
}
