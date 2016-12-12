package FBLT.factories.product.livestock;

import FBLT.domain.product.livestock.Livestock;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface ILiveStockFactory {

    Livestock getLivestock(Map<String,String> details);

}
