package FBLT.service.register;

import FBLT.domain.register.RegisteredUserVerification;
import FBLT.repositories.register.RegisteredUserVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lukekramer on 16/10/2016.
 */
@Service
public class ImplRegisterUserVerificationService implements IRegisterUserVerificationService {
    @Autowired
    RegisteredUserVerificationRepository repository;
    @Override
    public RegisteredUserVerification create(RegisteredUserVerification entity) {
        return repository.save(entity);
    }

    @Override
    public RegisteredUserVerification readById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Set<RegisteredUserVerification> readAll() {

        Set<RegisteredUserVerification> result = new HashSet<RegisteredUserVerification>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((RegisteredUserVerification) iterator.next());
        }
        return result;
    }

    @Override
    public RegisteredUserVerification update(RegisteredUserVerification entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(RegisteredUserVerification entity) {
        repository.delete(entity);
    }
}
