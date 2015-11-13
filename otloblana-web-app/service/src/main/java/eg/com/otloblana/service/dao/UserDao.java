package eg.com.otloblana.service.dao;

import eg.com.otloblana.service.entity.UserEntity;
import eg.com.otloblana.common.dao.GenericDao;
/**
 * Created by Mohamed on 2015/07/04.
 */
public interface UserDao extends GenericDao<UserEntity> {

    UserEntity authenticateUser(String email, String password);
    UserEntity getUserByEmail(String email);
}
