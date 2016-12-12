package FBLT.factories.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class TelevisionFactoryImpl implements ITelevisionFactory {
    private static TelevisionFactoryImpl factory = null;

    private TelevisionFactoryImpl() {

    }

    public static TelevisionFactoryImpl getInstance() {
        if (factory == null)
            factory = new TelevisionFactoryImpl();

        return factory;
    }

    @Override
    public Television getTelevision(Map<String, String> details) {
        Television finalProduct = new Television.Builder().build();
        if (details.containsKey("make")) {
            Television TelevisionWithMake = new Television.Builder()
                    .copy(finalProduct)
                    .productMake(details.get("make"))
                    .build();
            finalProduct = TelevisionWithMake;

        }
        if (details.containsKey("model")) {
            Television TelevisionWithModel = new Television.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = TelevisionWithModel;
        }
        if (details.containsKey("type")) {
            Television TelevisionWithType= new Television.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = TelevisionWithType;
        }
        if (details.containsKey("size")) {
            Television TelevisionWithSize = new Television.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = TelevisionWithSize;
        }

        return finalProduct;
    }
}
