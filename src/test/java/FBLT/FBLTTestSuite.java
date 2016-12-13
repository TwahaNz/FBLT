package FBLT;

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
import FBLT.factories.register.RegisteredUserVerificationFactoryTest;
import FBLT.repositories.product.ProductRepoTest;
import FBLT.repositories.product.book.BookRepoTest;
import FBLT.repositories.product.clothing.ClothingRepoTest;
import FBLT.repositories.product.electronics.cellphone.CellPhoneRepoTest;
import FBLT.repositories.product.electronics.computer.ComputerRepoTest;
import FBLT.repositories.product.electronics.television.TelevisionRepoTest;
import FBLT.repositories.product.livestock.LivestockRepoTest;
import FBLT.repositories.product.shoes.ShoesRepoTest;
import FBLT.repositories.product.vehicle.VehicleRepoTest;
import FBLT.utils.geolocation.GeolocationFinderTest;
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
        LivestockRepoTest.class,
        VehicleRepoTest.class,
        ShoesRepoTest.class,
        ProductRepoTest.class,
        CellPhoneRepoTest.class,
        ComputerRepoTest.class,
        TelevisionRepoTest.class,
        VehicleTest.class,
        ClothingTest.class,
        RegisteredUserVerificationTest.class,
        RegisteredUserVerificationFactoryTest.class,
        UserTest.class,
        RankTest.class,
        RegisteredUserVerificationFactoryTest.class,
        GeolocationFinderTest.class
})

public class FBLTTestSuite {

}