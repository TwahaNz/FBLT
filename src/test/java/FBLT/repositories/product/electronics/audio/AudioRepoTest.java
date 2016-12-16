package FBLT.repositories.product.electronics.audio;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.audio.Audio;
import FBLT.domain.product.electronics.audio.IAudio;
import FBLT.service.product.electronics.audio.IAudioService;
import FBLT.service.product.electronics.audio.ImplIAudioService;
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
public class AudioRepoTest {
    @Mock
    private IAudioService service;

    private Audio productTest,product;

    @Before
    public void setup()
    {
        ICategory category = new Category.Builder()
                .categoryName("Audio")
                .categoryDescription("Short Description")
                .build();

        productTest = new Audio.Builder()
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Beats")
                .productType("headphones")
                .productWatts("")
                .productAmps("")
                .category((Category) category)
                .build();
        product = new Audio.Builder()
                .productMake("Sony")
                .build();

        service = Mockito.mock(ImplIAudioService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getMake(),"Sony");

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
