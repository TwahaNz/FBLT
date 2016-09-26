package FBLT;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
/*
        MongoOperations mongoOps = new MongoTemplate(new Mongo(),"test");

        ICategory category = new Category.Builder()
                .categoryName("Clothing")
                .categoryDescription("Short Description")
                .build();

        IClothing productTest = new Clothing.Builder()
                .id((long) 1)
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



        mongoOps.insert(
                productTest
        );*/
    }
}
