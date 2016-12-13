package FBLT.controllers.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.IProduct;
import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.FindProductCatagory;
import FBLT.domain.user.User;
import FBLT.factories.category.FindProductCatagoryFactory;
import FBLT.factories.product.ProductFactoryImpl;
import FBLT.service.advert.ImplAdvertService;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.Location;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * edited by luke.
 */
@SessionAttributes("username")
@RestController
public class AdvertController {

    @Autowired
    ImplAdvertService advertService;

    @Autowired
    UserServiceImpl userService;

    @Value("${images.folder}")
    String imagesFolder;

    //-------------------Retrieve Single Advert--------------------------------------------------------
    @RequestMapping(value = "/advert-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advert> getAdvert(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        Advert request = advertService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Advert>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Advert>(request, HttpStatus.OK);
    }

    //-------------------Retrieve Adverts For UserID--------------------------------------------------------
    @RequestMapping(value = "/advert-controller/find-adverts-by-user-id/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Advert>> getAdvertsForUser(@PathVariable("userId") String userId) {
        System.out.println("Fetching adverts with userId: " + userId);
        List<Advert> request = advertService.findAdvertsByUserId(userId);
        if (request == null) {
            System.out.println("Request with id " + userId + "Not Found");
            return new ResponseEntity<List<Advert>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Advert>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Adverts--------------------------------------------------------
    @RequestMapping(value = "/list-adverts/", method = RequestMethod.GET)
    public ModelAndView getAdverts() {
        Set<Advert> requests = advertService.readAll();

        ModelAndView mv = new ModelAndView("list_ads");
        mv.addObject(requests);
        mv.addObject("hasResults", requests.size() > 0);

        return mv;
    }

    //-------------------Update an Advert--------------------------------------------------------
    @RequestMapping(value = "/advert-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Advert> updateAdvert(@PathVariable("id") String id, @RequestBody String advert) {

        Advert currentRequest = (Advert) advertService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<Advert>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        Advert updatedAdvert = new Advert.Builder()
                .copy(currentRequest)
                .price(myGson.fromJson(advert, Advert.class).getPrice())
                .product(myGson.fromJson(advert, Advert.class).getProduct())
                .user(myGson.fromJson(advert, Advert.class).getUser())
                .location(myGson.fromJson(advert, Advert.class).getLocation())
                .buyOrSell(myGson.fromJson(advert, Advert.class).isBuyOrSell())
                .build();


        advertService.update(updatedAdvert);
        return new ResponseEntity<Advert>(updatedAdvert, HttpStatus.OK);
    }

    //-------------------Insert an Advert--------------------------------------------------------
    @RequestMapping(value = "/advert-controller", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdvert(@RequestBody Advert newAdvert, UriComponentsBuilder ucBuilder) {

        advertService.create(newAdvert);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/advert-controller/{id}").buildAndExpand(newAdvert.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete an Advert--------------------------------------------------------
    @RequestMapping(value = "/advert-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Advert> deleteAdvert(@PathVariable("id") String id) {
        Advert advert = advertService.readById(id);

        if (advert == null) {
            return new ResponseEntity<Advert>(HttpStatus.NOT_FOUND);
        }
        advertService.delete(advert);
        return new ResponseEntity<Advert>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/post-advert")
    public ModelAndView postAdvert() {

        return new ModelAndView("post_ad");
    }


    @RequestMapping(value = "/confirm-advert", method = RequestMethod.POST)
    public ModelAndView submitAdvert(@ModelAttribute("username") String email,
                                     @RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("location") String location,
                                     @RequestParam("price") String price,
                                     @RequestParam("bool-is-selling") String isSelling,
                                     @RequestParam("img") MultipartFile[] files) throws Exception {


        String city = "", suburb = "", province = "";

        String[] locationArray = location.split(",");

        if (locationArray.length == 2) {
            suburb = "Not Provided";
            city = locationArray[0];
            province = locationArray[1];
        } else if (locationArray.length == 3) {
            suburb = locationArray[0];
            city = locationArray[1];
            province = locationArray[2];
        }

        out.print("Posting With Usr: " + email);
        boolean isvalid = false;

        if (email == null || email.trim().equals("")) {
            return new ModelAndView("invalid");
        }

        if (!isSelling.equals("true")) {
            isvalid = true;
        } else {
            isvalid = false;
        }

        User user = userService.findByEmail(email);

        Product product = new Product.Builder()
                .productDescription(description)
                .category(new Category.Builder().categoryName(getCategory(description)).build())
                .build();

        Location locations = new Location.Builder()
                .city(city)
                .suburb(suburb)
                .build();

        Advert advert = new Advert.Builder()
                .title(title)
                .product(product)
                .buyOrSell(isvalid)
                .user(user)
                .price(Double.parseDouble(price))
                .location(locations).build();

        advertService.create(advert);
        ArrayList<String> listOfPaths = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = "" + i;
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("user.dir");
                File dir = new File(rootPath + File.separator + "resrc/posted_ads" + File.separator + email + File.separator + advert.getId());

                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + ".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                listOfPaths.add("posted_ads" + File.separator + email + File.separator + advert.getId() + File.separator + name + ".jpg");

            } catch (Exception e) {
                e.getMessage();
            }
        }

        advert = new Advert.Builder()
                .copy(advert)
                .imagePaths(listOfPaths)
                .build();
        advertService.update(advert);

        System.out.println(advert.getImagepaths().get(0));

        System.out.println(advert.isBuyOrSell());
        ModelAndView mv = new ModelAndView("confirm_ad");
        mv.addObject("advert", advert);
        return mv;
    }

    private String getCategory(String description) throws Exception {

        StringReader stringReader = new
                StringReader("Livestock cow cows chickens chicken birds bird sheep sheeps goat goats\n" +
                "Cellphone phones phone samsung android iphone s4 s3 htc mobile smartphone huawei headset\n" +
                "Audio speakers mic mics earphone earphones beats\n" +
                "Computer laptops laptop desktop keyboard mouse graphics card amd radeon lenovo hp dell alienware\n" +
                "Television smart tv television led plasma flat screen flat-screen amoled \n" +
                "Clothing shoes shoe pants jeans top tops shirt shirts vest vests jackets jacket fur jean jeans headband cap caps");

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

    @RequestMapping(value = "/save-advert", method = RequestMethod.POST)
    public ModelAndView saveAdvert(@RequestParam Map<String, String> allRequestParams,
                                   @ModelAttribute("username") String email) {
        for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        Advert initialAdvert = advertService.readById(allRequestParams.get("ad-id"));



        String location = allRequestParams.get("ad-location");
        String city = "", suburb = "", province = "";

        String[] locationArray = location.split(",");

        if (locationArray.length == 2) {
            suburb = "Not Provided";
            city = locationArray[0];
            province = locationArray[1];
        } else if (locationArray.length == 3) {
            suburb = locationArray[0];
            city = locationArray[1];
            province = locationArray[2];
        }

        User user = userService.findByEmail(email);

        ProductFactoryImpl productFactory = ProductFactoryImpl.getInstance();
        IProduct productToSaveInAdvert = productFactory.getProduct(allRequestParams);

        Location locations = new Location.Builder()
                .city(city)
                .suburb(suburb)
                .build();

        boolean isSelling;

        if (allRequestParams.get("ad-description").equals("true")) {
            isSelling = true;
        } else {
            isSelling = false;
        }
        Advert advert = new Advert.Builder()
                .copy(initialAdvert)
                .title(allRequestParams.get("ad-title"))
                .product(productToSaveInAdvert)
                .buyOrSell(isSelling)
                .user(user)
                .price(Double.parseDouble(allRequestParams.get("ad-price")))
                .location(locations).build();

        advertService.update(advert);

        System.out.println(advert.getImagepaths());

        return new ModelAndView("index");
    }
}
