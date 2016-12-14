package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.IProduct;
import FBLT.domain.product.book.Book;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.electronics.computer.Computer;
import FBLT.domain.product.electronics.television.Television;
import FBLT.domain.product.livestock.Livestock;
import FBLT.domain.product.shoes.Shoes;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.service.advert.ImplAdvertService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

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
        String product = advert.getProduct().getClass().getName();

        if (product.toLowerCase().contains("book")) {
            modelAndView.addObject("type", "book");
            Book book = (Book) advert.getProduct();
            modelAndView.addObject("book", book);
        }

        if (product.toLowerCase().contains("clothing")) {
            modelAndView.addObject("type", "clothing");
            Clothing entity = (Clothing) advert.getProduct();
            modelAndView.addObject("clothing", entity);
        }
        if (product.toLowerCase().contains("livestock")) {
            modelAndView.addObject("type", "livestock");
            Livestock entity = (Livestock) advert.getProduct();
            modelAndView.addObject("livestock", entity);
        }
        if (product.toLowerCase().contains("vehicle")) {
            modelAndView.addObject("type", "vehicle");
            Vehicle entity = (Vehicle) advert.getProduct();
            modelAndView.addObject("vehicle", entity);
        }
        if (product.toLowerCase().contains("shoes")) {
            modelAndView.addObject("type", "shoes");
            Shoes entity = (Shoes) advert.getProduct();
            modelAndView.addObject("shoes", entity);
        }
        if (product.toLowerCase().contains("television")) {
            modelAndView.addObject("type", "television");
            Television entity = (Television) advert.getProduct();
            modelAndView.addObject("television", entity);
        }
        if (product.toLowerCase().contains("computer")) {
            modelAndView.addObject("type", "computer");
            Computer entity = (Computer) advert.getProduct();
            modelAndView.addObject("computer", entity);
        }

        ArrayList<String> images = new ArrayList<>();

        ArrayList<String> img_path = advert.getImagepaths();

        if (advert.getImagepaths().size() > 1) {
            for (String path : advert.getImagepaths())
                images.add(path);
        }

        modelAndView.addObject("size", img_path.size());
        modelAndView.addObject("items", img_path);
        modelAndView.addObject("advert", advert);

        return modelAndView;
    }
}