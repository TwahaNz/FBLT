package FBLT.service.product.livestock;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.livestock.Livestock;
import FBLT.repositories.product.livestock.LivestockRepository;
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
public class ImplLiveStockService implements ILiveStockService {

    @Autowired
    LivestockRepository repository;
    @Override
    public Livestock create(Livestock entity) {
        return repository.save(entity);
    }

    @Override
    public Livestock readById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Livestock> readAll() {

        Set<Livestock> result = new HashSet<Livestock>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((Livestock) iterator.next());
        }
        return result;
    }

    @Override
    public Livestock update(Livestock entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Livestock entity) {

        repository.delete(entity);
    }

    @Override
    public List<Livestock> findLiveStockByAge(String age) {
        return  repository.findbyage(age);
    }

    @Override
    public List<Livestock> findLiveStockByGrade(String grade) {
        return  repository.findbygrade(grade);
    }
}
