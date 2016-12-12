package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by nzetwa01 on 11/29/2016.
 */

@RestController
public class AdvertItemController {

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(value = {"/item{advertId}"}, method = RequestMethod.GET)
    public ModelAndView items(@PathVariable("advertId") String advertId) {

        ModelAndView modelAndView = new ModelAndView("item");

        Advert advert = advertService.readById(advertId);

        ArrayList<String> images = new ArrayList<>();

        String img_path = advert.getImagepaths().get(0);

        if (advert.getImagepaths().size() > 1) {
            for (String path : advert.getImagepaths())
                images.add(path);
        }

        modelAndView.addObject("item", img_path);
        modelAndView.addObject("advert", advert);


        return modelAndView;
    }
}