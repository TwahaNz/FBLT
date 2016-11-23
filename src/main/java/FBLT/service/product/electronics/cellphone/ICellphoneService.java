package FBLT.service.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by student on 2016/11/12.
 */
public interface ICellphoneService extends Service<CellPhone, String> {

    List<CellPhone> findbymake(String make);

    List<CellPhone> findbymodel(String model);

}
