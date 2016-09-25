package FBLT;


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

        MongoOperations mongoOps = new MongoTemplate(new Mongo(),"test");
        mongoOps.insert(
                new CellPhone.Builder()
                .productDescription("average cellphone")
                .build());
    }
}
