package FBLT.service.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;
import FBLT.repositories.product.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by lukekramer on 16/10/2016.
 */

@Service
public class ImplVehicleService implements IVehicleService {

    @Autowired
    VehicleRepository repository;

    @Override
    public Vehicle create(Vehicle entity) {
        return repository.save(entity);
    }

    @Override
    public Vehicle readById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Vehicle> readAll() {

        Set<Vehicle> result = new HashSet<Vehicle>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((Vehicle) iterator.next());
        }
        return result;

    }

    @Override
    public Vehicle update(Vehicle entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Vehicle entity) {
        repository.delete(entity);
    }

    @Override
    public List<Vehicle> findbytype(String type) {
        return repository.findbytype(type);
    }

    @Override
    public List<Vehicle> findbymake(String make) {
        return repository.findbymake(make);
    }

    @Override
    public List<Vehicle> findbymodel(String model) {
        return repository.findbymodel(model);
    }
}
