package FBLT;


import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import com.mongodb.Mongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
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
                .productID((long) 1)
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
