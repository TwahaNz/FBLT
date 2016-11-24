package FBLT.controllers.advert;

import FBLT.domain.product.category.FindProductCatagory;
import FBLT.factories.category.FindProductCatagoryFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;

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
                                     @RequestParam("bool-is-selling") String isSelling) throws Exception {

        System.out.println(description);
        System.out.println("Catagories Detected: " + getCategory(description));

        ModelAndView mv = new ModelAndView("confirm_ad");
        mv.addObject("title", title);
        mv.addObject("description", description);
        mv.addObject("location", location);
        mv.addObject("bool-is-selling", isSelling);
        mv.addObject("price", price);
        mv.addObject("category", getCategory(description));

        return mv;
    }

    private String getCategory(String description) throws Exception {

        StringReader stringReader = new StringReader("Livestock cow cows chickens chicken birds bird sheep sheeps goat goats\n" +
                "Cellphone phones phone samsung android iphone s4 s3 htc mobile smartphone\n" +
                "Electronics phones phone speakers mic mics earphone earphones beats  laptop laptops\n" +
                "Clothes shoes pants jeans tops shirts vests");

        BufferedReader br = new BufferedReader(stringReader);

        FindProductCatagory findProductCatagory = FindProductCatagoryFactory
                .getFindProductCatagory(br);

        findProductCatagory.processDescription(description);

        findProductCatagory.processCatagoryFile();

        String list = findProductCatagory.getCatagory();

        findProductCatagory.closeConnections();

        String first = "";

        try {
            first = findProductCatagory.getFirstCategory();
        } catch (Exception e) {
            first = "No Category Found";
        }

        return  first;
    }


}
