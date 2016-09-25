package FBLT.persistence;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import com.mongodb.Mongo;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Brandonhome on 2016/09/25.
 */
public class MongoDBPersistenceTest {


    @Test
    public void testCRUD() {
        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        CellPhone newCelly =  new CellPhone.Builder()
                .productDescription("latest cellphone")
                .build();

        //INSERT
        mongoOps.insert(newCelly);


        System.out.println(newCelly.getId());
/*
        //RETRIEVE
        newCelly = mongoOps.findById(newCelly.getId(), CellPhone.class);
        System.out.println(newCelly.getProductDescription());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(newCelly.getId())), Update.update("description","newDescription") ,CellPhone.class);

        //DELETE
       // mongoOps.remove(b);*/

    }


}
