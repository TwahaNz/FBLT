package FBLT;

import FBLT.domain.product.ProductTest;
import FBLT.domain.product.category.CategoryTest;
import FBLT.domain.product.category.FindProductCatagory;
import FBLT.domain.product.category.FindProductCatagoryTest;
import FBLT.domain.register.RegisteredUserVerificationTest;
import FBLT.factories.product.ProductFactoryTest;
import FBLT.factories.product.category.CategoryFactoryTest;
import FBLT.factories.register.RegisteredUserVerificationFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by nzetwa01 on 9/21/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CategoryTest.class,
        FindProductCatagoryTest.class,
        ProductTest.class,
        RegisteredUserVerificationTest.class,
        CategoryFactoryTest.class,
        ProductFactoryTest.class,
        RegisteredUserVerificationFactoryTest.class
})

public class FBLTTestSuite {

}
