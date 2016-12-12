package FBLT.factories.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class ComputerFactoryImpl implements IComputerFactory {
    private static ComputerFactoryImpl factory = null;

    private ComputerFactoryImpl() {

    }

    public static ComputerFactoryImpl getInstance() {
        if (factory == null)
            factory = new ComputerFactoryImpl();

        return factory;
    }


    @Override
    public Computer getComputer(Map<String, String> details) {
        Computer finalProduct = new Computer.Builder().build();
        if (details.containsKey("make")) {
            Computer ComputerWithMake = new Computer.Builder()
                    .copy(finalProduct)
                    .productMake(details.get("make"))
                    .build();
            finalProduct = ComputerWithMake;

        }
        if (details.containsKey("model")) {
            Computer ComputerWithModel = new Computer.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = ComputerWithModel;
        }
        if (details.containsKey("type")) {
            Computer ComputerWithType= new Computer.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = ComputerWithType;
        }
        if (details.containsKey("size")) {
            Computer ComputerWithSize = new Computer.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = ComputerWithSize;
        }

        return finalProduct;
    }
}
