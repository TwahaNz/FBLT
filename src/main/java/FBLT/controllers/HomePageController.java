package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * edited by luke
 */

@RestController
public class HomePageController {

    @Autowired
    ImplAdvertService advertService;
    ArrayList<String> list;

    @RequestMapping(value = {"", "/", "index"}, method = {RequestMethod.GET})
    public ModelAndView getIndex() {

        list = new ArrayList<>();

        int total = 0;

        Set<Advert> requests = advertService.readAll();
        ModelAndView result = new ModelAndView("index");

        Iterator<Advert> adverts = requests.iterator();

        while (adverts.hasNext()) {
            total++;
            adverts.next();
        }

        adverts = requests.iterator();

        while (adverts.hasNext()) {
            try {
                Advert ad = adverts.next();
                list.add(ad.getImagepaths().get(0) + "!" + ad.getId());
            } catch (Exception e) {

            }
        }

        result.addObject("total", total);
        result.addObject("advert_paths", list);
        return result;
    }

    @RequestMapping(value = {"/pages{index}"}, method = RequestMethod.GET)
    public ModelAndView insertUser(@PathVariable("index") int index) {

        if (index < 1) {
            return new ModelAndView("redirect:/index");
        }

        ArrayList<String> listNext = new ArrayList<>();

        ModelAndView result = new ModelAndView("index");
        try {
            for (int position = (index * 4); position < list.size(); position++) {
                listNext.add(list.get(position));
            }

            result.addObject("total", listNext.size());
            result.addObject("advert_paths", listNext);
            result.addObject("index", index);
        } catch (Exception e) {
            return new ModelAndView("redirect:/index");
        }

        return result;
    }
}
