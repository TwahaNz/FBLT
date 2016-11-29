package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.category.FindProductCatagory;
import FBLT.factories.category.FindProductCatagoryFactory;
import FBLT.service.advert.ImplAdvertService;
import FBLT.utils.genericvalueobjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;


/**
 * Created by nzetwa01 on 11/18/2016.
 */
@SessionAttributes("username")
@Controller
public class PostAdvertController {

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(value = "/post-advert")
    public ModelAndView postAdvert() {

        return new ModelAndView("post_ad");
    }
    
    @RequestMapping(value = "/confirm-advert", method = RequestMethod.POST)
    public ModelAndView submitAdvert(@ModelAttribute("username") String email, @RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("location") String location,
                                     @RequestParam("price") String price,
                                     @RequestParam("bool-is-selling") String isSelling,
                                     @RequestParam("img") MultipartFile[] files) throws Exception {

        System.out.print("Posting With Usr: " + email);

        Advert advert = new Advert.Builder()
                .buyOrSell(true)
                .location(new Location.Builder()
                        .city("Cape Town")
                        .province("Western Cape")
                        .suburb("Cape Town")
                        .build()).build();


        Advert advert1 = advertService.create(advert);

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = "" + i;
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("user.dir");
                File dir = new File(rootPath + File.separator + "adverts" + File.separator + email + File.separator + advert1.getId());
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + ".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            } catch (Exception e) {
                e.getMessage();
            }
        }


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

        return first;
    }


}
