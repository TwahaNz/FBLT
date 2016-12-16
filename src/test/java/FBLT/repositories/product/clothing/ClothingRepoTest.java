package FBLT.repositories.product.clothing;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
import FBLT.service.product.clothing.IClothingService;
import FBLT.service.product.clothing.ImplClothingService;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer on 05/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClothingRepoTest {
    @Mock
    private IClothingService service;

    private Clothing productTest,product;

    @Before
    public void setup(){

        ICategory category = new Category.Builder()
                .categoryName("Clothing")
                .categoryDescription("Short Description")
                .build();

        productTest = new Clothing.Builder()
                .productDescription("Coach Jacket")
                .productType("Jacket")
                .productBrand("Sol Sol")
                .productGender("male")
                .productAgeGroup("Adult")
                .productSize("medium")
                .productColor("blue")
                .productMaterial("nylon")
                .category((Category) category)
                .build();

        product = new Clothing.Builder()
                .productBrand("Nike")
                .build();

        service = Mockito.mock(ImplClothingService.class);


    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getBrand(),"Nike");

        //Update

        //Grade Updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getBrand(),"Sol Sol");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));

    }


}
