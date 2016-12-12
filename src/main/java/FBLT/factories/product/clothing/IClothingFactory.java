package FBLT.factories.product.clothing;

import FBLT.domain.product.clothing.Clothing;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IClothingFactory {

    Clothing getClothing(Map<String, String> details);
}
