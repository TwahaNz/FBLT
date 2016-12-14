package FBLT.service.advert;

import FBLT.domain.advert.Advert;
import FBLT.repositories.advert.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by maybra01 on 10/12/2016.
 */

@Service
public class ImplAdvertService implements IAdvertService {

    @Autowired
    AdvertRepository repository;

    @Override
    public List<Advert> findAdvertsByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<Advert> findAdvertsByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Advert> findAdvertsByUserEmail(String email) {
        return repository.findByUserEmail(email);
    }

    @Override
    public List<Advert> findAdvertsByUserId(String userId) {
        return repository.findByUserID(userId);
    }

    @Override
    public Advert create(Advert entity) {
        return repository.save(entity);
    }

    @Override
    public Advert readById(String stringId) {
        return repository.findOne(stringId);
    }

    @Override
    public Set<Advert> readAll() {
        Set<Advert> result = new HashSet<Advert>();

        Iterator iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            result.add((Advert) iterator.next());
        }
        return result;
    }

    @Override
    public Advert update(Advert entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Advert entity) {
        repository.delete(entity);

    }

    public  List<Advert> findAdvertsByCategory(String category) {
       return repository.findByCategory(category);
    }
}
