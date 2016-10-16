package FBLT.service.product.clothing;

import FBLT.domain.product.clothing.Clothing;
import FBLT.repositories.product.clothing.ClothingRepository;
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
public class ImplClothingService implements IClothingService {

    @Autowired
    ClothingRepository repository;
    @Override
    public Clothing create(Clothing entity) {
        return repository.save(entity);
    }

    @Override
    public Clothing readById(String id) {
        return readById(id);
    }

    @Override
    public Set<Clothing> readAll() {

        Set<Clothing> result = new HashSet<Clothing>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((Clothing) iterator.next());
        }
        return result;
    }

    @Override
    public Clothing update(Clothing entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Clothing entity) {

        repository.delete(entity);
    }

    @Override
    public List<Clothing> findbysize(String size) {
        return repository.findbysize(size);
    }

    @Override
    public List<Clothing> findbybrand(String brand) {
        return repository.findbybrand(brand);
    }

    @Override
    public List<Clothing> findbygender(String gender) {
        return repository.findbygender(gender);
    }
}
