package FBLT.factories.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface ITelevisionFactory {

    Television getTelevision(Map<String, String> details);
}
