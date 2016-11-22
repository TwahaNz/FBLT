package FBLT.service.user;

import FBLT.domain.user.User;
import FBLT.repositories.user.UserRepository;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User readById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Set<User> readAll() {

        Set<User> result = new HashSet<User>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((User) iterator.next());
        }
        return result;
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(User entity) {

        repository.delete(entity);

    }

    @Override
    public List<User> findByUserID(String userId) {
        return findByUserID(userId);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
