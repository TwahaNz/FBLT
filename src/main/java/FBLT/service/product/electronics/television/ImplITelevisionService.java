package FBLT.service.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;
import FBLT.repositories.product.electronics.television.TelevisionRepository;
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
public class ImplITelevisionService implements ITelevisionService {

    @Autowired
    TelevisionRepository repository;

    @Override
    public List<Television> findbymake(String make) {
        return repository.findbymake(make);
    }

    @Override
    public List<Television> findbymodel(String model) {
        return repository.findbymodel(model);
    }

    @Override
    public List<Television> findbysize(String size) {
        return repository.findbysize(size);
    }

    @Override
    public Television create(Television entity) {
        return repository.save(entity);
    }

    @Override
    public Television readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Television> readAll() {
        Set<Television> result = new HashSet<Television>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((Television) iterator.next());
        }
        return result;
    }

    @Override
    public Television update(Television entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Television entity) {
        repository.delete(entity);
    }
}
