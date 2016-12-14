package FBLT.factories.product.shoes;

import FBLT.domain.product.shoes.Shoes;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IShoeFactory {

    Shoes getShoes(Map<String, String> details);
}
