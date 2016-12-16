package FBLT.repositories.product.shoes;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.shoes.IShoes;
import FBLT.domain.product.shoes.Shoes;
import FBLT.service.shoe.IShoeService;
import FBLT.service.shoe.ImplShoesService;
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
 * Created by lukekramer on 09/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ShoesRepoTest {

    @Mock
    private IShoeService service;

    private Shoes productTest,product;

    @Before
    public void setup()
    {
        ICategory category = new Category.Builder()
                .categoryName("Shoes")
                .categoryDescription("Short Description")
                .build();

        productTest = new Shoes.Builder()
                .productDescription("Crocodile")
                .productType("Sandles")
                .productBrand("Crocs")
                .productSize("7")
                .productColor("blue")
                .category((Category) category)
                .build();

        product = new Shoes.Builder()
                .productType("Sneakers")
                .build();

        service = Mockito.mock(ImplShoesService.class);


    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getShoeType(),"Sneakers");

        //Update

        //Updated shoe type

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getShoeType(),"Sandles");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));


    }
}
