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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

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

    //-------------------Retrieve All Adverts for search criteria--------------------------------------------------------
    @RequestMapping(value = "/list-adverts", method = RequestMethod.GET)
    public ModelAndView getAdverts(@RequestParam Map<String, String> allRequestParams) {
        String searchRequest = allRequestParams.get("search-bar");
        ModelAndView mv = new ModelAndView("list_ads");
        List<Advert> allAdverts = new ArrayList<>();

        if (searchRequest.trim().length() == 0) {
            allAdverts.addAll(advertService.readAll());
        } else {

            allAdverts.addAll(advertService.findAdvertsByTitle(searchRequest));
            allAdverts.addAll(advertService.findAdvertsByDescription(searchRequest));

        }


        Collections.sort(allAdverts, new Comparator<Advert>() {
            @Override
            public int compare(Advert z1, Advert z2) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                try {
                    Date date1 = formatter.parse(z1.getDate());
                    Date date2 = formatter.parse(z2.getDate());
                    if (date1.after(date2))
                        return 1;
                    if (date1.before(date2))
                        return -1;
                } catch (Exception e) {

                }
                return 0;
            }
        });


        mv.addObject("adverts", allAdverts);
        mv.addObject("hasResults", allAdverts.size() > 0);

        return mv;
    }

    //-------------------Retrieve All Adverts for Category--------------------------------------------------------
    @RequestMapping(value = "/list-adverts/{category}", method = RequestMethod.GET)
    public ModelAndView getAdvertsForCategory(@PathVariable("category") String category) {
        ModelAndView mv = new ModelAndView("list_ads");
        Set<Advert> allAdverts = new HashSet<Advert>();

        allAdverts.addAll(advertService.findAdvertsByCategory(category));

        mv.addObject("adverts", allAdverts);
        mv.addObject("hasResults", allAdverts.size() > 0);

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
                                     @ModelAttribute("save") String save,
                                     @RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("location") String location,
                                     @RequestParam("price") String price,
                                     @RequestParam("bool-is-selling") String isSelling
    ) throws Exception {


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

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        Advert advert = new Advert.Builder()
                .title(title)
                .date(dateFormat.format(date))
                .product(product)
                .buyOrSell(isvalid)
                .user(user)
                .price(Double.parseDouble(price))
                .location(locations)
                .build();

        advertService.create(advert);


        advert = new Advert.Builder()
                .copy(advert)
                .build();
        advertService.update(advert);

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
                                   @RequestParam("img") MultipartFile[] files,
                                   @ModelAttribute("username") String email) {
        System.out.println(files.length);
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

        if (allRequestParams.get("bool-is-selling").equals("true")) {
            isSelling = true;
        } else {
            isSelling = false;
        }

        ArrayList<String> listOfPaths = new ArrayList<>();

        if(allRequestParams.get("save-images").equals("true")) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String name = "" + i;
                try {
                    byte[] bytes = file.getBytes();
                    // Creating the directory to store file
                    String rootPath = System.getProperty("user.dir");
                    File dir = new File(rootPath + File.separator + "resrc/posted_ads" + File.separator + email + File.separator + initialAdvert.getId());

                    if (!dir.exists())
                        dir.mkdirs();

                    // Create the file on server
                    File serverFile = new File(dir.getAbsolutePath()
                            + File.separator + name + ".jpg");
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();

                    listOfPaths.add("posted_ads" + File.separator + email + File.separator + initialAdvert.getId() + File.separator + name + ".jpg");

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }else{

            listOfPaths.add("images" + File.separator + "big_ad.png");

        }


        Advert advert = new Advert.Builder()
                .copy(initialAdvert)
                .title(allRequestParams.get("ad-title"))
                .product(productToSaveInAdvert)
                .buyOrSell(isSelling)
                .user(user)
                .imagePaths(listOfPaths)
                .price(Double.parseDouble(allRequestParams.get("ad-price")))
                .location(locations).build();

        advertService.update(advert);

        System.out.println(advert.getImagepaths());

        return new ModelAndView("redirect");
    }
}
