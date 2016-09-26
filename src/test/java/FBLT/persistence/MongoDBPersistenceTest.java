package FBLT.persistence;

import FBLT.domain.PersistenceTestClass;
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

        PersistenceTestClass person = new PersistenceTestClass("Brandon",34);

        //INSERT
       mongoOps.insert(person);


        System.out.println(person.getId());

        //RETRIEVE
        person = mongoOps.findById(person.getId(), PersistenceTestClass.class);
        System.out.println(person.getId() + " " +person.getName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(person.getId())), Update.update("name","Twaha") ,PersistenceTestClass.class);
        person = mongoOps.findById(person.getId(), PersistenceTestClass.class);
        System.out.println(person.getId() + " " + person.getName());


        //DELETE
        mongoOps.remove(person);

    }


}
