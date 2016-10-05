package FBLT;

import FBLT.domain.PersistenceTestClass;
import FBLT.domain.email.impl.InterestedEmail;
import FBLT.domain.email.impl.SendVerificationEmail;
import FBLT.domain.product.ProductTest;
import FBLT.domain.product.book.BookTest;
import FBLT.domain.product.category.CategoryTest;
import FBLT.domain.product.category.FindProductCatagoryTest;
import FBLT.domain.product.electronics.audio.AudioTest;
import FBLT.domain.product.electronics.cellphone.CellPhoneTest;
import FBLT.domain.product.clothing.ClothingTest;
import FBLT.domain.product.electronics.computer.ComputerTest;
import FBLT.domain.product.electronics.television.TelevisionTest;
import FBLT.domain.product.livestock.LivestockTest;
import FBLT.domain.product.shoes.ShoesTest;
import FBLT.domain.product.vehicle.VehicleTest;
import FBLT.domain.rank.RankTest;
import FBLT.domain.register.RegisteredUserVerificationTest;
import FBLT.domain.user.UserTest;
import FBLT.factories.product.ProductFactoryTest;
import FBLT.factories.product.category.CategoryFactoryTest;
import FBLT.factories.register.RegisteredUserVerificationFactoryTest;
import FBLT.persistence.MongoDBPersistenceTest;
import FBLT.repositories.product.BookRepoTest;
import FBLT.repositories.product.ClothingRepoTest;
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
        TelevisionTest.class,
        ComputerTest.class,
        LivestockTest.class,
        AudioTest.class,
        ShoesTest.class,
        ProductTest.class,
        BookTest.class,
        BookRepoTest.class,
        ClothingRepoTest.class,
        VehicleTest.class,
        ClothingTest.class,
        RegisteredUserVerificationTest.class,
        CategoryFactoryTest.class,
        ProductFactoryTest.class,
        RegisteredUserVerificationFactoryTest.class,
        UserTest.class,
        RankTest.class,
        MongoDBPersistenceTest.class,
        RegisteredUserVerificationFactoryTest.class
})

public class FBLTTestSuite {

}