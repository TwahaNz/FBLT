package FBLT.factories.category;

import FBLT.domain.category.Category;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public interface ICategoryFactory {

    Category getCategory(String name, String description);
}
