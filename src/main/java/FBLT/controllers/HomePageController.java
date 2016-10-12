package FBLT.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by maybra01 on 10/12/2016.
 */
@Controller
@RequestMapping(value = {"","/"})
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(){
        ModelAndView result = new ModelAndView("index");
        return result;
    }
}
