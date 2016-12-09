package FBLT.domain.product.livestock;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public interface ILivestock extends IProduct {

    /**
     * @return returns a String with the age of the live stock
     */

    String getAge();

    /**
     * @return returns a String with the grade of the live stock
     */
    String getGrade();

}
