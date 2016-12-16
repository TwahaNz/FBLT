package FBLT.repositories.product.electronics.cellphone;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.domain.product.electronics.cellphone.ICellPhone;
import FBLT.service.product.electronics.cellphone.ICellphoneService;
import FBLT.service.product.electronics.cellphone.ImplICellphoneService;
import FBLT.service.temporarylogin.ImplITemporaryLoginService;
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
public class CellPhoneRepoTest {
    @Mock
    private ICellphoneService service;

    private CellPhone productTest,product;

    @Before
    public void setup(){
        ICategory category = new Category.Builder()
                .categoryName("CellPhone")
                .categoryDescription("Short Description")
                .build();

        productTest = new CellPhone.Builder()
                .productDescription("2015 model")
                .productMake("Iphone")
                .productModel("S6")
                .productType("SmartPhone")
                .category((Category) category)
                .build();
        product = new CellPhone.Builder()
                .productMake("Samsung")
                .build();

        service = Mockito.mock(ImplICellphoneService.class);

    }


    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getMake(),"Samsung");

        //Update

        //Make updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getMake(),"Iphone");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));



    }
}
