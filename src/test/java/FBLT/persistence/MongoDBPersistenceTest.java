package FBLT.persistence;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.utils.genericvalueobjects.Location;
import com.google.gson.Gson;
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
    @Test
    public void testPost(){
        PersistenceTestClass person = new PersistenceTestClass("Brandon",34);

        Location newLocation = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();

        Product mynewProduct = new Product.Builder()
                .category(
                        new Category.Builder()
                                .categoryName("Kids Toys")
                                .categoryDescription("things for kids")
                                .build())
                .productDescription("Barbie Doll")
                .build();

        Advert myTestAdvert = new Advert.Builder()

                .buyOrSell(false)
                .price(789.44)
                .product(mynewProduct)
                .location(newLocation)
                .build();



        Gson myGson = new Gson();
        System.out.println(myGson.toJson(myTestAdvert));
    }


}
