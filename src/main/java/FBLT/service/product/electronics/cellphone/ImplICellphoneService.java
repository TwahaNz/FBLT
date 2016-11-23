package FBLT.service.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.repositories.product.electronics.cellphone.CellPhoneRepository;
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
public class ImplICellphoneService implements ICellphoneService {

    @Autowired
    CellPhoneRepository repository;

    @Override
    public List<CellPhone> findbymake(String make) {
        return repository.findbymake(make);
    }

    @Override
    public List<CellPhone> findbymodel(String model) {
        return repository.findbymodel(model);
    }

    @Override
    public CellPhone create(CellPhone entity) {
        return repository.save(entity);
    }

    @Override
    public CellPhone readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<CellPhone> readAll() {
        Set<CellPhone> result = new HashSet<CellPhone>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((CellPhone) iterator.next());
        }
        return result;
    }

    @Override
    public CellPhone update(CellPhone entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(CellPhone entity) {
        repository.delete(entity);
    }
}
