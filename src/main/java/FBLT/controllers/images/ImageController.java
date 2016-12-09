package FBLT.controllers.images;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nzetwa01 on 11/17/2016.
 */
@RestController
public class ImageController {


    @ResponseBody
    public String helloWorld(@PathVariable String imageId) {
        return "images/big_ad.png";
    }

}
