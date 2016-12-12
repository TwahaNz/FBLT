package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * edited by luke
 */
@Controller
@RequestMapping(value = {"", "/", "index"})
public class HomePageController {

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(method = {RequestMethod.GET})
    public ModelAndView getIndex() {

        ArrayList<String> list = new ArrayList<>();
        String[] ad_links = null;

        int total = 0;

        Set<Advert> requests = advertService.readAll();
        ModelAndView result = new ModelAndView("index");

        Iterator<Advert> adverts = requests.iterator();

        while (adverts.hasNext()) {
            total++;
            adverts.next();
        }

        ad_links = new String[total];

        int position = 0;

        adverts = requests.iterator();

        while (adverts.hasNext()) {
            try {
                Advert ad = adverts.next();
                list.add(ad.getImagepaths().get(0));
                ad_links[position] = ad.getId();
                position++;

            } catch (Exception e) {

            }
        }

        result.addObject("advert_paths", list);
        result.addObject("advert_links", ad_links);
        return result;
    }
}
