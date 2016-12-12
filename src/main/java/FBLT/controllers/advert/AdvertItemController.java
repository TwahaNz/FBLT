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

        ArrayList<String> advert_info = new ArrayList<>();

        int position = 0;

        while (position < 6) {

            try {

                if (position == 0)
                    advert_info.add(advert.getProduct().getDescription());
                if (position == 1)
                    advert_info.add(advert.getUser().getName());
                if (position == 2)
                    advert_info.add(advert.getProduct().getCategory().getCategoryName());
                if (position == 3)
                    advert_info.add("" + advert.getPrice());
                if (position == 4)
                    advert_info.add("" + advert.getLocation().getCity());
                if (position == 5)
                    advert_info.add("" + advert.getLocation().getSuburb());

            } catch (Exception e) {
                advert_info.add("Not Found");
            }

            position++;
        }

        modelAndView.addObject("item", img_path);
        modelAndView.addObject("item_iamges", images);
        modelAndView.addObject("advert_info", advert_info);


        return modelAndView;
    }
}
