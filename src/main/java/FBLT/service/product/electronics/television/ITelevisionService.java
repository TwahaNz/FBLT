package FBLT.service.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by student on 2016/11/12.
 */
public interface ITelevisionService extends Service<Television, String> {

    List<Television> findbymake(String make);

    List<Television> findbymodel(String model);

    List<Television> findbysize(String size);

}
