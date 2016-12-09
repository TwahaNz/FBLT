package FBLT.service.product.clothing;

import FBLT.domain.product.clothing.Clothing;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by lukekramer on 16/10/2016.
 */
public interface IClothingService extends Service<Clothing, String> {


    List<Clothing> findbysize(String size);


    List<Clothing> findbybrand(String brand);


    List<Clothing> findbygender(String gender);

}
