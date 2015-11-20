package eg.com.otloblana.model.dao;

import eg.com.otloblana.common.dao.GenericDao;
import eg.com.otloblana.model.entity.GroupEntity;
import eg.com.otloblana.model.entity.UserEntity;

import java.util.Set;

/**
 * Created by Mohamed_2 on 11/20/2015.
 */
public interface GroupDao extends GenericDao<GroupEntity> {

    Set<GroupEntity> getUserGroups(UserEntity userEntity);
}
