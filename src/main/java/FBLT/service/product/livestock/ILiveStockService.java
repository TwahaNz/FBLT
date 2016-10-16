package FBLT.service.product.livestock;

import FBLT.domain.product.livestock.Livestock;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by lukekramer on 16/10/2016.
 */
public interface ILiveStockService extends Service<Livestock,String> {

    List<Livestock> findLiveStockByAge(String age);

    List<Livestock> findLiveStockByGrade(String grade);


}
