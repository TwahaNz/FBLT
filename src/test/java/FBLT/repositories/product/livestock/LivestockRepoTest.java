package FBLT.repositories.product.livestock;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.livestock.ILivestock;
import FBLT.domain.product.livestock.Livestock;
import FBLT.service.product.livestock.ILiveStockService;
import FBLT.service.product.livestock.ImplLiveStockService;
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
public class LivestockRepoTest {

    @Mock
    private ILiveStockService service;

    private Livestock productTest,product;

    @Before
    public void setup(){

        ICategory category = new Category.Builder()
                .categoryName("LiveStock")
                .categoryDescription("Short Description")
                .build();

        productTest = new Livestock.Builder()
                .productDescription("Cow")
                .productAge("4")
                .productGrade("A")
                .category((Category) category)
                .build();

        product = new Livestock.Builder()
                .productGrade("B")
                .build();
        service = Mockito.mock(ImplLiveStockService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getGrade(),"B");

        //Update

        //Grade Updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getGrade(),"A");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));


    }
}
