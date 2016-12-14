package FBLT.repositories.product.electronics.cellphone;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.domain.product.electronics.cellphone.ICellPhone;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer on 09/10/2016.
 */
public class CellPhoneRepoTest {

    private static final String TAG = "cellPhoneTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("CellPhone")
                .categoryDescription("Short Description")
                .build();

        ICellPhone productTest = new CellPhone.Builder()
                .productDescription("2015 model")
                .productMake("Iphone")
                .productModel("S6")
                .productType("SmartPhone")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        CellPhone cellPhone = mongoOps.findById(productTest.get_id(), CellPhone.class);

        Assert.assertEquals(TAG, productTest.getDescription(), cellPhone.getDescription());
        Assert.assertEquals(TAG, productTest.getMake(), cellPhone.getMake());
        Assert.assertEquals(TAG, productTest.getModel(), cellPhone.getModel());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(), cellPhone.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("model", "IPad6"), CellPhone.class);

        cellPhone = mongoOps.findById(productTest.get_id(), CellPhone.class);

        Assert.assertEquals(TAG, "IPad6", cellPhone.getModel());

        //DELETE
        mongoOps.remove(cellPhone);


    }
}
