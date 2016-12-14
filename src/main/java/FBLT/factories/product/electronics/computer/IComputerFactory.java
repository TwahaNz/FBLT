package FBLT.factories.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IComputerFactory {

    Computer getComputer(Map<String, String> details);
}
