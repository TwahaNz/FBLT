package FBLT.factories.product.shoes;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.shoes.Shoes;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class ShoesFactoryImpl implements IShoeFactory {

    private static ShoesFactoryImpl factory = null;

    private ShoesFactoryImpl() {

    }

    public static ShoesFactoryImpl getInstance() {
        if (factory == null)
            factory = new ShoesFactoryImpl();

        return factory;
    }

    @Override
    public Shoes getShoes(Map<String, String> details) {
        Shoes finalProduct = new Shoes.Builder().build();

        if (details.containsKey("brand")) {
            Shoes ShoesWithMake = new Shoes.Builder()
                    .copy(finalProduct)
                    .productBrand(details.get("brand"))
                    .build();
            finalProduct = ShoesWithMake;

        }
        if (details.containsKey("type")) {
            Shoes ShoesWithModel = new Shoes.Builder()
                    .copy(finalProduct)
                    .productType(details.get("type"))
                    .build();
            finalProduct = ShoesWithModel;
        }
        if (details.containsKey("size")) {
            Shoes ShoesWithType = new Shoes.Builder()
                    .copy(finalProduct)
                    .productSize(details.get("size"))
                    .build();
            finalProduct = ShoesWithType;
        }
        if (details.containsKey("colour")) {
            Shoes ShoesWithWatts = new Shoes.Builder()
                    .copy(finalProduct)
                    .productColor(details.get("colour"))
                    .build();
            finalProduct = ShoesWithWatts;
        }
        if (details.containsKey("category")) {
            Shoes bookWithAuthor = new Shoes.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("ad-description")) {
            Shoes bookWithAuthor = new Shoes.Builder()
                    .copy(finalProduct)
                    .productDescription(details.get("ad-description"))
                    .build();
            finalProduct = bookWithAuthor;
        }

        return finalProduct;
    }
}
