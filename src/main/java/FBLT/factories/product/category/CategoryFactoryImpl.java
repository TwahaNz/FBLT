package FBLT.factories.product.category;

import FBLT.domain.product.category.Category;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public class CategoryFactoryImpl implements ICategoryFactory {

    private static CategoryFactoryImpl factory = null;

    private CategoryFactoryImpl(){

    }

    public static CategoryFactoryImpl getInstance() {
        if (factory == null)
            factory = new CategoryFactoryImpl();

            return factory;
    }

    public Category getCategory(String name, String description) {
        return new Category.Builder()
                .categoryName(name)
                .categoryDescription(description)
                .build();
    }
}
