package FBLT.service.user;

import FBLT.domain.user.User;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by lukekramer on 16/10/2016.
 */
public interface IUserService extends Service<User,String> {

    List<User> findByUserID(String userId);

    User findByEmail(String email);
}
