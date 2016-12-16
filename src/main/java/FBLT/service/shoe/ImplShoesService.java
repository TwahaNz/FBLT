package FBLT.service.shoe;

import FBLT.domain.product.shoes.Shoes;
import FBLT.repositories.product.shoes.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lukekramer on 16/12/2016.
 */
@Service
public class ImplShoesService implements IShoeService {

    @Autowired
    ShoeRepository repository;

    @Override
    public Shoes create(Shoes entity) {
        return repository.save(entity);
    }

    @Override
    public Shoes readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Shoes> readAll() {
        Set<Shoes> result = new HashSet<Shoes>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((Shoes) iterator.next());
        }
        return result;
    }

    @Override
    public Shoes update(Shoes entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Shoes entity) {

        repository.delete(entity);

    }
}
