package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.Product;
import FBLT.domain.product.book.Book;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.electronics.audio.Audio;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.domain.product.electronics.computer.Computer;
import FBLT.domain.product.electronics.television.Television;
import FBLT.domain.product.livestock.Livestock;
import FBLT.domain.product.shoes.Shoes;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.service.advert.ImplAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        if (advert.getProduct() != null) {
            String product = advert.getProduct().getClass().getName();
            if (product.toLowerCase().contains("book")) {
                modelAndView.addObject("type", "book");
                Book book = (Book) advert.getProduct();
                modelAndView.addObject("book", book);
            } else if (product.toLowerCase().contains("clothing")) {
                modelAndView.addObject("type", "clothing");
                Clothing entity = (Clothing) advert.getProduct();
                modelAndView.addObject("clothing", entity);
            } else if (product.toLowerCase().contains("livestock")) {
                modelAndView.addObject("type", "livestock");
                Livestock entity = (Livestock) advert.getProduct();
                modelAndView.addObject("livestock", entity);
            } else if (product.toLowerCase().contains("vehicle")) {
                modelAndView.addObject("type", "vehicle");
                Vehicle entity = (Vehicle) advert.getProduct();
                modelAndView.addObject("vehicle", entity);
            } else if (product.toLowerCase().contains("shoes")) {
                modelAndView.addObject("type", "shoes");
                Shoes entity = (Shoes) advert.getProduct();
                modelAndView.addObject("shoes", entity);
            } else if (product.toLowerCase().contains("television")) {
                modelAndView.addObject("type", "television");
                Television entity = (Television) advert.getProduct();
                modelAndView.addObject("television", entity);
            } else if (product.toLowerCase().contains("computer")) {
                modelAndView.addObject("type", "computer");
                Computer entity = (Computer) advert.getProduct();
                modelAndView.addObject("computer", entity);
            } else if (product.toLowerCase().contains("audio")) {
                modelAndView.addObject("type", "audio");
                Audio entity = (Audio) advert.getProduct();
                modelAndView.addObject("audio", entity);
            } else if (product.toLowerCase().contains("cellphone")) {
                modelAndView.addObject("type", "cellphone");
                CellPhone entity = (CellPhone) advert.getProduct();
                modelAndView.addObject("cellphone", entity);
            } else if (product.toLowerCase().contains("product")) {
                modelAndView.addObject("type", "product");
                Product entity = (Product) advert.getProduct();
                modelAndView.addObject("product", entity);
            }
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