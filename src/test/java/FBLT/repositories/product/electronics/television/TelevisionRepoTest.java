package FBLT.repositories.product.electronics.television;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.television.ITelevision;
import FBLT.domain.product.electronics.television.Television;
import FBLT.service.product.electronics.television.ITelevisionService;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TelevisionRepoTest {

    @Mock
    private ITelevisionService service;

    private Television productTest,product;

    @Before
    public void setup(){

        ICategory category = new Category.Builder()
                .categoryName("Television")
                .categoryDescription("Short Description")
                .build();

        productTest = new Television.Builder()
                .productDescription("2015 model")
                .productMake("Samsung")
                .productModel("UA40J5200AKXXA")
                .productType("Smart Led Tv")
                .productSize("40-inch")
                .category((Category) category)
                .build();
        product = new Television.Builder()
                .productMake("Sony")
                .build();

    }

    @Test
    public void testCRUD() {


        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getMake(),"Sony");

        //Update

        //Make updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getMake(),"Samsung");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));

    }
}
