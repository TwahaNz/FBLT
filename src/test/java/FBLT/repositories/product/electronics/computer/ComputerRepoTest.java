package FBLT.repositories.product.electronics.computer;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.computer.Computer;
import FBLT.domain.product.electronics.computer.IComputer;
import FBLT.service.product.electronics.computer.IComputerService;
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
public class ComputerRepoTest {

    @Mock
    private IComputerService service;

    private Computer productTest,product;

    @Before
    public void setup()
    {
        ICategory category = new Category.Builder()
                .categoryName("Computer")
                .categoryDescription("Short Description")
                .build();

        productTest = new Computer.Builder()
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Mac Book pro")
                .productType("Laptop")
                .productSize("15")
                .category((Category) category)
                .build();

        product = new Computer.Builder()
                .productMake("Lenovo")
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

        Assert.assertEquals(service.readById("1").getMake(),"Lenovo");

        //Update

        //Make updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getMake(),"Apple");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));


    }
}
