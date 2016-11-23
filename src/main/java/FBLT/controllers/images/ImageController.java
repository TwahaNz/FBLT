package FBLT.controllers.images;

import javafx.scene.image.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by nzetwa01 on 11/17/2016.
 */
@RestController
public class ImageController {


    @ResponseBody
    public String helloWorld(@PathVariable String imageId)  {
        return "images/big_ad.png";
    }

}
