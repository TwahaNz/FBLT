package FBLT.service.advert;

import FBLT.domain.advert.Advert;
import FBLT.service.Service;

import java.util.List;


/**
 * Created by maybra01 on 10/12/2016.
 */
public interface IAdvertService extends Service<Advert, String> {
    List<Advert> findAdvertsByUserId(String userId);
}
