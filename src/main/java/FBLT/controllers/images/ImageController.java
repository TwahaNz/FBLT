package FBLT.controllers.images;

import javafx.scene.image.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by nzetwa01 on 11/17/2016.
 */
public class ImageController {

    @RequestMapping(value = "{imageId}")
    @ResponseBody
    public byte[] helloWorld(@PathVariable String imageId)  {
        
    }

}
