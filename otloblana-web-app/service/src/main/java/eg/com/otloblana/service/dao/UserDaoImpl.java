package eg.com.otloblana.service.dao;


import eg.com.otloblana.common.Exception.AuthenticationException;
import eg.com.otloblana.service.entity.UserEntity;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mohamed on 2015/07/04.
 */
public class UserDaoImpl extends GenericDaoImpl<UserEntity> implements UserDao  {


    public UserDaoImpl() {
        super(UserEntity.class);
    }

    @Override
    public UserEntity authenticateUser(String email, String password)  {
        Query query = entityManager.createQuery("Select u From UserEntity u where u.email = :email AND u.password = :password");
        query.setParameter("email",email);
        query.setParameter("password",password);
        List<UserEntity> userList = query.getResultList();
        if(userList != null && userList.size() == 1) {
            return userList.get(0);
        } else {
            throw new AuthenticationException("UserEntity with email <"+email+"> Authentication Faild");
        }

    }

    @Override
    public UserEntity getUserByEmail(String email) {
        Query query = entityManager.createQuery("Select u From UserEntity u where u.email = :email");
        query.setParameter("email",email);
        List<UserEntity> userList = query.getResultList();
        if(userList != null && userList.size() == 1) {
            return userList.get(0);
        } else {
            throw new EntityNotFoundException("UserEntity with email <"+email+"> Not Found");
        }
    }
}
