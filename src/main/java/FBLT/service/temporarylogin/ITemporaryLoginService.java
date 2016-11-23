package FBLT.service.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.service.Service;

/**
 * Created by tayfer01 on 11/22/2016.
 */
public interface ITemporaryLoginService extends Service<TemporaryLogin, String> {
    TemporaryLogin isValidUser(String email, String code);
}
