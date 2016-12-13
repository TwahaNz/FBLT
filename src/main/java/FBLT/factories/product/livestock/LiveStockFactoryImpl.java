package FBLT.factories.product.livestock;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.electronics.television.Television;
import FBLT.domain.product.livestock.Livestock;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class LiveStockFactoryImpl implements ILiveStockFactory {

    private static LiveStockFactoryImpl factory = null;

    private LiveStockFactoryImpl() {

    }

    public static LiveStockFactoryImpl getInstance() {
        if (factory == null)
            factory = new LiveStockFactoryImpl();

        return factory;
    }

    @Override
    public Livestock getLivestock(Map<String, String> details) {
        Livestock finalProduct = new Livestock.Builder()
                .build();

        if (details.containsKey("age")) {
            Livestock livestockWithAge = new Livestock.Builder()
                    .copy(finalProduct)
                    .productAge(details.get("age"))
                    .build();
            finalProduct = livestockWithAge;

        }
        if (details.containsKey("grade")) {
            Livestock livestockWithGrade = new Livestock.Builder()
                    .copy(finalProduct)
                    .productGrade(details.get("grade"))
                    .build();
            finalProduct = livestockWithGrade;

        }
        if (details.containsKey("category")) {
            Livestock bookWithAuthor = new Livestock.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("description")) {
            Livestock bookWithAuthor = new Livestock.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("description")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        return finalProduct;

    }
}
