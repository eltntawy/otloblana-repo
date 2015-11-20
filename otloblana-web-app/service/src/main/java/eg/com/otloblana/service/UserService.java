package eg.com.otloblana.service;

import eg.com.otloblana.common.Exception.DatabaseException;
import eg.com.otloblana.common.Exception.ServiceException;
import eg.com.otloblana.model.dao.GroupDao;
import eg.com.otloblana.model.dao.UserDao;
import eg.com.otloblana.model.dto.GroupDto;
import eg.com.otloblana.model.dto.UserDto;
import eg.com.otloblana.model.entity.GroupEntity;
import eg.com.otloblana.model.entity.UserEntity;
import eg.com.otloblana.model.util.MappingUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohamed_2 on 11/14/2015.
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    @EJB
    private MappingUtil mappingUtil;

    @EJB(beanName = "GroupDaoImpl")
    GroupDao groupDao ;

    public UserDto authenticateByEmail(String email, String password) throws ServiceException {

        UserEntity userEntity = null;
        try {
            userEntity = userDao.authenticateByEmail(email, password);

            UserDto userDto = mappingUtil.getDto(userEntity, UserDto.class);

            return userDto;

        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public UserDto authenticateByUsername(String username, String password) throws ServiceException {

        UserEntity userEntity = null;
        try {
            userEntity = userDao.authenticateByUsername(username, password);

            UserDto userDto = mappingUtil.getDto(userEntity, UserDto.class);

            return userDto;
        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public UserDto getUserByEmail(String email) throws ServiceException {
        try {
            UserEntity userEntity = userDao.getUserByEmail(email);
            UserDto userDto = mappingUtil.getDto(userEntity, UserDto.class);

            return userDto;
        }catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }


}
