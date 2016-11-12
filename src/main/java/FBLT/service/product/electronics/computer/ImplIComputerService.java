package FBLT.service.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;
import FBLT.repositories.product.electronics.computer.ComputerRepository;
import FBLT.service.product.electronics.cellphone.ICellphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2016/11/12.
 */

@Service
public class ImplIComputerService implements IComputerService{

    @Autowired
    ComputerRepository repository;

    @Override
    public List<Computer> findbymake(String make) {
        return repository.findbymake(make);
    }

    @Override
    public List<Computer> findbymodel(String model) {
        return repository.findbymodel(model);
    }

    @Override
    public Computer create(Computer entity) {
        return repository.save(entity);
    }

    @Override
    public Computer readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Computer> readAll() {
        Set<Computer> result = new HashSet<Computer>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((Computer) iterator.next());
        }
        return result;
    }

    @Override
    public Computer update(Computer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Computer entity) {
        repository.delete(entity);
    }
}
