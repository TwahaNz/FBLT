package FBLT;

import FBLT.domain.product.ProductTest;
import FBLT.domain.product.book.BookTest;
import FBLT.domain.product.category.CategoryTest;
import FBLT.domain.product.category.FindProductCatagoryTest;
import FBLT.domain.product.electronics.cellphone.CellPhoneTest;
import FBLT.domain.product.clothing.ClothingTest;
import FBLT.domain.product.livestock.LivestockTest;
import FBLT.domain.product.vehicle.VehicleTest;
import FBLT.domain.register.RegisteredUserVerificationTest;
import FBLT.domain.user.UserTest;
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
        CellPhoneTest.class,
        LivestockTest.class,
        ProductTest.class,
        BookTest.class,
        VehicleTest.class,
        ClothingTest.class,
        RegisteredUserVerificationTest.class,
        CategoryFactoryTest.class,
        ProductFactoryTest.class,
        RegisteredUserVerificationFactoryTest.class,
        UserTest.class
})

public class FBLTTestSuite {

}