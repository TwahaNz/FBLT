package FBLT.factories.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class CellphoneFactoryImpl implements ICellphoneFactory {
    private static CellphoneFactoryImpl factory = null;

    private CellphoneFactoryImpl() {

    }

    public static CellphoneFactoryImpl getInstance() {
        if (factory == null)
            factory = new CellphoneFactoryImpl();

        return factory;
    }

    @Override
    public CellPhone getCellphone(Map<String, String> details) {
        CellPhone finalProduct = new CellPhone.Builder().build();

        if (details.containsKey("make")) {
            CellPhone cellphoneWithMake = new CellPhone.Builder()
                    .copy(finalProduct)
                    .productMake(details.get("make"))
                    .build();
            finalProduct = cellphoneWithMake;

        }
        if (details.containsKey("model")) {
            CellPhone cellphoneWithModel = new CellPhone.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = cellphoneWithModel;
        }


        return finalProduct;
    }
}
