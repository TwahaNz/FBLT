package FBLT.controllers;

import FBLT.domain.advert.Advert;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * edited by luke
 */
@Controller
@RequestMapping(value = {"","/"})
public class HomePageController {

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(){

        Set<Advert> requests = advertService.readAll();
        ModelAndView result = new ModelAndView("index");
        result.addObject("adverts", requests);
        return result;
    }
}
