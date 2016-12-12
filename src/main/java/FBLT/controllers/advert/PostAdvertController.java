package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.IProduct;
import FBLT.domain.product.category.FindProductCatagory;
import FBLT.domain.user.User;
import FBLT.factories.category.FindProductCatagoryFactory;
import FBLT.factories.product.ProductFactoryImpl;
import FBLT.service.advert.ImplAdvertService;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static java.lang.System.out;


/**
 * Created by nzetwa01 on 11/18/2016.
 */
@SessionAttributes("username")
@Controller
public class PostAdvertController {

    @Value("${images.folder}")
    String imagesFolder;

    @Autowired
    ImplAdvertService advertService;

    @RequestMapping(value = "/post-advert")
    public ModelAndView postAdvert() {
        return new ModelAndView("post_ad");
    }

    @RequestMapping(value = "write")
    public ModelAndView write() {

        out.println(imagesFolder);

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/save-advert", method = RequestMethod.POST)
    public ModelAndView saveAdvert(@RequestParam Map<String, String> allRequestParams, Model model) {
        for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }


        ProductFactoryImpl productFactory = ProductFactoryImpl.getInstance();
        IProduct productToSaveInAdvert = productFactory.getProduct(allRequestParams);


        return new ModelAndView("index");
    }

    @RequestMapping(value = "/confirm-advert", method = RequestMethod.POST)
    public ModelAndView submitAdvert(@ModelAttribute("username") String email,
                                     @RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("location") String location,
                                     @RequestParam("price") String price,
                                     @RequestParam("bool-is-selling") String isSelling,
                                     @RequestParam("img") MultipartFile[] files) throws Exception {

        out.print("Posting With Usr: " + email);

        if (email == null || email.trim().equals("")) {
            return new ModelAndView("invalid");
        }

        ContactDetails contactDetails = new ContactDetails.Builder()
                .cellPhoneNumber("0845465712")
                .emailAddress(email)
                .telegramHandle("@tnz")
                .build();

        Location locations = new Location.Builder()
                .city("Cape Town")
                .latitude(new Double(14566.3))
                .longitude(new Double(7899.3))
                .suburb("Northern Suburbs")
                .build();


        Advert advert = new Advert.Builder()
                .buyOrSell(true)
                .user(new User.Builder()
                        .contactDetails(contactDetails).build())
                .location(locations).build();

        Advert advert1 = advertService.create(advert);

        ArrayList<String> listOfPaths = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = "" + i;
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("user.dir");
                File dir = new File(rootPath + File.separator + "resrc/posted_ads" + File.separator + email + File.separator + advert1.getId());

                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + ".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                listOfPaths.add("posted_ads" + File.separator + email + File.separator + advert1.getId() + File.separator + name + ".jpg");

            } catch (Exception e) {
                e.getMessage();
            }
        }

        Advert advert2 = new Advert.Builder()
                .copy(advert1)
                .imagePaths(listOfPaths)
                .build();

        advertService.update(advert2);

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

        StringReader stringReader = new
                StringReader("Livestock cow cows chickens chicken birds bird sheep sheeps goat goats\n" +
                "Cellphone phones phone samsung android iphone s4 s3 htc mobile smartphone huawei headset\n" +
                "Audio speakers mic mics earphone earphones beats\n" +
                "Computer laptops laptop desktop keyboard mouse graphics card amd radeon lenovo hp dell alienware\n" +
                "Television smart tv television led plasma flat screen flat-screen amoled \n" +
                "Clothes shoes shoe pants jeans top tops shirt shirts vest vests jackets jacket fur jean jeans headband cap caps");

        BufferedReader br = new BufferedReader(stringReader);

        FindProductCatagory findProductCatagory = FindProductCatagoryFactory
                .getFindProductCatagory(br);

        findProductCatagory.processDescription(description.toLowerCase());

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
