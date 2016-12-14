package FBLT.factories.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface ICellphoneFactory {

    CellPhone getCellphone(Map<String, String> details);
}
