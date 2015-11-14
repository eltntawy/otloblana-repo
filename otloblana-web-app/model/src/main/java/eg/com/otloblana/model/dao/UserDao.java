package eg.com.otloblana.model.dao;

import eg.com.otloblana.common.Exception.AuthenticationException;
import eg.com.otloblana.common.Exception.DatabaseRollbackException;
import eg.com.otloblana.model.entity.UserEntity;
import eg.com.otloblana.common.dao.GenericDao;
/**
 * Created by Mohamed on 2015/07/04.
 */
public interface UserDao extends GenericDao<UserEntity> {

    public UserEntity authenticateByUsername(String email, String password) throws  DatabaseRollbackException;
    public UserEntity authenticateByEmail(String email, String password) throws  DatabaseRollbackException;
    public UserEntity getUserByEmail(String email) throws DatabaseRollbackException;
}
