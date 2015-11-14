package eg.com.otloblana.service;

import eg.com.otloblana.common.Exception.DatabaseException;
import eg.com.otloblana.common.Exception.ServiceException;
import eg.com.otloblana.model.dao.UserDao;
import eg.com.otloblana.model.dto.UserDto;
import eg.com.otloblana.model.entity.UserEntity;
import eg.com.otloblana.model.util.MappingUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Mohamed_2 on 11/14/2015.
 */
@Stateless
public class UserService {

    @EJB(beanName = "UserDaoImpl", beanInterface = UserDao.class)
    private UserDao userDaoImplRef;

    @EJB(beanName = "MappingUtil", beanInterface = MappingUtil.class)
    private MappingUtil mappingUtilRef;


    public UserDto authenticateByEmail(String email, String password) throws ServiceException {

        UserEntity userEntity = null;
        try {
            userEntity = userDaoImplRef.authenticateByEmail(email, password);

            UserDto userDto = mappingUtilRef.getDto(userEntity, UserDto.class);

            return userDto;

        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public UserDto authenticateByUsername(String username, String password) throws ServiceException {

        UserEntity userEntity = null;
        try {
            userEntity = userDaoImplRef.authenticateByUsername(username, password);

            UserDto userDto = mappingUtilRef.getDto(userEntity, UserDto.class);

            return userDto;
        } catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

    public UserDto getUserByEmail(String email) throws ServiceException {
        try {
            UserEntity userEntity = userDaoImplRef.getUserByEmail(email);
            UserDto userDto = mappingUtilRef.getDto(userEntity, UserDto.class);

            return userDto;
        }catch (DatabaseException e) {
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }


}
