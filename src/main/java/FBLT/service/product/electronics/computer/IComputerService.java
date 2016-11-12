package FBLT.service.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by student on 2016/11/12.
 */
public interface IComputerService extends Service<Computer, String> {

    List<Computer> findbymake(String make);

    List<Computer> findbymodel(String model);
}
