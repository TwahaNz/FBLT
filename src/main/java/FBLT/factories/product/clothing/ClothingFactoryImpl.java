package FBLT.factories.product.clothing;

import FBLT.domain.product.book.Book;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.clothing.Clothing;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class ClothingFactoryImpl implements IClothingFactory {
    private static ClothingFactoryImpl factory = null;

    private ClothingFactoryImpl() {

    }

    public static ClothingFactoryImpl getInstance() {
        if (factory == null)
            factory = new ClothingFactoryImpl();

        return factory;
    }

    @Override
    public Clothing getClothing(Map<String, String> details) {
        Clothing finalProduct = new Clothing.Builder().build();

        if (details.containsKey("brand")) {
            Clothing ClothingWithMake = new Clothing.Builder()
                    .copy(finalProduct)
                    .productBrand(details.get("brand"))
                    .build();
            finalProduct = ClothingWithMake;

        }
        if (details.containsKey("gender")) {
            Clothing ClothingWithModel = new Clothing.Builder()
                    .copy(finalProduct)
                    .productGender(details.get("gender"))
                    .build();
            finalProduct = ClothingWithModel;
        }
        if (details.containsKey("type")) {
            Clothing ClothingWithType = new Clothing.Builder()
                    .copy(finalProduct)
                    .productType(details.get("type"))
                    .build();
            finalProduct = ClothingWithType;
        }
        if (details.containsKey("age")) {
            Clothing ClothingWithWatts = new Clothing.Builder()
                    .copy(finalProduct)
                    .productAgeGroup(details.get("age"))
                    .build();
            finalProduct = ClothingWithWatts;
        }
        if (details.containsKey("size")) {
            Clothing ClothingWithWatts = new Clothing.Builder()
                    .copy(finalProduct)
                    .productSize(details.get("size"))
                    .build();
            finalProduct = ClothingWithWatts;
        }
        if (details.containsKey("material")) {
            Clothing ClothingWithWatts = new Clothing.Builder()
                    .copy(finalProduct)
                    .productMaterial(details.get("material"))
                    .build();
            finalProduct = ClothingWithWatts;
        }
        if (details.containsKey("colour")) {
            Clothing ClothingWithWatts = new Clothing.Builder()
                    .copy(finalProduct)
                    .productColor(details.get("colour"))
                    .build();
            finalProduct = ClothingWithWatts;
        }
        if (details.containsKey("category")) {
            Clothing bookWithAuthor = new Clothing.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("ad-description")) {
            Clothing bookWithAuthor = new Clothing.Builder()
                    .copy(finalProduct)
                    .productDescription(details.get("ad-description"))
                    .build();
            finalProduct = bookWithAuthor;
        }

        return finalProduct;
    }
}
