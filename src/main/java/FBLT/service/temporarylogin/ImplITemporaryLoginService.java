package FBLT.service.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.repositories.temporarylogin.TemporaryLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by tayfer01 on 11/22/2016.
 */
@Service
public class ImplITemporaryLoginService implements ITemporaryLoginService {

    @Autowired
    TemporaryLoginRepository repository;

    @Override
    public TemporaryLogin create(TemporaryLogin entity) {
        return repository.save(entity);
    }

    @Override
    public TemporaryLogin readById(String s) {
        return null;
    }

    @Override
    public Set<TemporaryLogin> readAll() {
        return null;
    }

    @Override
    public TemporaryLogin update(TemporaryLogin entity) {
        return null;
    }

    @Override
    public void delete(TemporaryLogin entity) {

        repository.delete(entity);
    }

    @Override
    public TemporaryLogin isValidUser(String email, String code) {
        return repository.isValidUser(email, code);
    }
}
