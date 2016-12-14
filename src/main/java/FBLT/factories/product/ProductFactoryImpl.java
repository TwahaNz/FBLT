package FBLT.factories.product;

import FBLT.domain.product.IProduct;
import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.factories.product.book.BookFactoryImpl;
import FBLT.factories.product.clothing.ClothingFactoryImpl;
import FBLT.factories.product.electronics.audio.AudioFactoryImpl;
import FBLT.factories.product.electronics.cellphone.CellphoneFactoryImpl;
import FBLT.factories.product.electronics.computer.ComputerFactoryImpl;
import FBLT.factories.product.electronics.television.TelevisionFactoryImpl;
import FBLT.factories.product.livestock.LiveStockFactoryImpl;
import FBLT.factories.product.shoes.ShoesFactoryImpl;
import FBLT.factories.product.vehicle.VehicleFactoryImpl;

import java.util.Map;


/**
 * Created by lukekramer on 20/09/2016.
 * EDited by Brandon
 * <p>
 * <p>
 * Description: This class Delegates the work to other factories to produce products
 */
public class ProductFactoryImpl implements IProductFactory {


    private static ProductFactoryImpl factory = null;

    private ProductFactoryImpl() {

    }

    public static ProductFactoryImpl getInstance() {
        if (factory == null)
            factory = new ProductFactoryImpl();

        return factory;
    }

    @Override
    public IProduct getProduct(Map<String, String> objectData) {

        switch (objectData.get("category")) {
            case "Books":
                BookFactoryImpl bookFactory = BookFactoryImpl.getInstance();
                return bookFactory.getBook(objectData);

            case "Clothing":
                ClothingFactoryImpl clothingFactory = ClothingFactoryImpl.getInstance();
                return clothingFactory.getClothing(objectData);

            case "Audio":
                AudioFactoryImpl audioFactory = AudioFactoryImpl.getInstance();
                return audioFactory.getAudio(objectData);

            case "Cellphone":
                CellphoneFactoryImpl cellphoneFactory = CellphoneFactoryImpl.getInstance();
                return cellphoneFactory.getCellphone(objectData);

            case "Computer":
                ComputerFactoryImpl computerFactory = ComputerFactoryImpl.getInstance();
                return computerFactory.getComputer(objectData);

            case "Television":
                TelevisionFactoryImpl televisionFactory = TelevisionFactoryImpl.getInstance();
                return televisionFactory.getTelevision(objectData);

            case "Livestock":
                LiveStockFactoryImpl liveStockFactory = LiveStockFactoryImpl.getInstance();
                return liveStockFactory.getLivestock(objectData);

            case "Shoes":
                ShoesFactoryImpl shoesFactory = ShoesFactoryImpl.getInstance();
                return shoesFactory.getShoes(objectData);

            case "Vehicles":
                VehicleFactoryImpl vehicleFactory = VehicleFactoryImpl.getInstance();
                return vehicleFactory.getVehicle(objectData);

            default:
                return null;

        }

    }
}
