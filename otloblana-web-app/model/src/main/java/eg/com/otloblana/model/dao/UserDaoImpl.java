package eg.com.otloblana.model.dao;



import eg.com.otloblana.common.Exception.DatabaseRollbackException;
import eg.com.otloblana.model.entity.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mohamed on 2015/07/04.
 */
@Stateless(mappedName = "userDao")
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao {


    public UserDaoImpl() {
        super(UserEntity.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public UserEntity authenticateByEmail(String email, String password) throws DatabaseRollbackException {
        Query query = entityManager.createQuery("Select u From UserEntity u where u.email = :email AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            List<UserEntity> userList = query.getResultList();
            if (userList != null && userList.size() == 1) {
                return userList.get(0);
            } else {
                throw new DatabaseRollbackException("UserEntity with email <" + email + "> Authentication Faild");
            }
        } catch (PersistenceException ex) {
            throw new DatabaseRollbackException(ex.getMessage());
        }

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public UserEntity authenticateByUsername(String username, String password) throws DatabaseRollbackException {
        Query query = entityManager.createQuery("Select u From UserEntity u where u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            List<UserEntity> userList = query.getResultList();


            if (userList != null && userList.size() == 1) {
                return userList.get(0);
            } else {
                throw new DatabaseRollbackException("UserEntity with username <" + username + "> Authentication Faild");
            }

        } catch (PersistenceException ex) {
            throw new DatabaseRollbackException(ex.getMessage());
        }
    }

    @Override
    public UserEntity getUserByEmail(String email) throws DatabaseRollbackException {
        Query query = entityManager.createQuery("Select u From UserEntity u where u.email = :email");
        query.setParameter("email", email);

        try {
            List<UserEntity> userList = query.getResultList();
            if (userList != null && userList.size() == 1) {
                return userList.get(0);
            } else {
                throw new DatabaseRollbackException("UserEntity with email <" + email + "> Not Found");
            }
        } catch (PersistenceException ex) {
            throw new DatabaseRollbackException(ex.getMessage());
        }
    }
}
